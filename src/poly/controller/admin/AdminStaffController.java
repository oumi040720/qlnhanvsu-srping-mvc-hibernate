package poly.controller.admin;

import java.io.File;
import java.text.SimpleDateFormat;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import poly.entity.Staff;
import poly.model.PageModel;
import poly.service.IDepartService;
import poly.service.IStaffService;
import poly.util.PagingUtil;

@Controller
@RequestMapping(value = "/admin/staff")
public class AdminStaffController {

	@Autowired
	ServletContext context;

	@Autowired
	IStaffService staffService;

	@Autowired
	IDepartService departService;

	@RequestMapping(value = "/list")
	public String showList(HttpServletRequest request) {
		try {
			String message = request.getParameter("message");
			String alert = request.getParameter("alert");

			PageModel paging = PagingUtil.setPagging(request, staffService.getTotalItems());
			
			request.setAttribute("staffs", staffService.findAll(paging.getOffset(), paging.getMaxPageItems()));

			if (message != null) {
				request.setAttribute("message", message.replaceAll("_", "."));
				request.setAttribute("alert", alert);
			}
		} catch (Exception e) {
		}

		return "admin/staff/list";
	}
	
	@RequestMapping(value = "search", method = RequestMethod.GET)
	public String search(HttpServletRequest request) {
		try {
			String key = request.getParameter("k");
			
			PageModel paging = PagingUtil.setPagging(request, staffService.getTotalItemsByKey(key));
			
			request.setAttribute("staffs", staffService.searchStaff(key, paging.getOffset(), paging.getMaxPageItems()));

			request.setAttribute("k", key);
		} catch (Exception e) {
		}
		
		return "admin/staff/search";
	}
	
	@RequestMapping(value = "search", method = RequestMethod.POST)
	public String getKey(Model model, @RequestParam(value = "k") String k) {
		model.addAttribute("k", k);
		model.addAttribute("page", 1);
		model.addAttribute("maxPageItems", 3);
		
		return "redirect:/admin/staff/search";
	}
	
	@RequestMapping(value = "/add")
	public String showAddForm(Model model) {
		model.addAttribute("check", false);
		model.addAttribute("departs", departService.findAll());
		model.addAttribute("staff", new Staff());

		return "admin/staff/edit";
	}

	@RequestMapping(value = "/edit")
	public String showEditForm(Model model, @ModelAttribute("id") String id) {
		model.addAttribute("check", true);
		model.addAttribute("departs", departService.findAll());
		model.addAttribute("staff", staffService.findOne(id));

		return "admin/staff/edit";
	}

	@RequestMapping(value = "/save")
	public String save(Model model, @ModelAttribute("staff") Staff staff, @RequestParam("fichier") MultipartFile photo,
			BindingResult bindingResult) {
		check(staff, bindingResult);

		if (bindingResult.hasErrors()) {
			model.addAttribute("departs", departService.findAll());

			return "admin/staff/edit";
		} else {
			try {
				String photoPath = context.getRealPath("/template/admin/img/staff/" + photo.getOriginalFilename());
				photo.transferTo(new File(photoPath));
			} catch (Exception e) {
			}

			if (staffService.saveOrUpdate(staff)) {
				model.addAttribute("message", "staff_edit_message_success");
				model.addAttribute("alert", "success");
			} else {
				model.addAttribute("message", "staff_edit_message_fail");
				model.addAttribute("alert", "danger");
			}

			model.addAttribute("page", 1);
			model.addAttribute("maxPageItems", 3);

			return "redirect:/admin/staff/list";
		}
	}

	@RequestMapping(value = "/delete")
	public String delete(Model model, @ModelAttribute("id") String id) {
		if (staffService.delete(id)) {
			model.addAttribute("message", "staff_delete_message_success");
			model.addAttribute("alert", "success");
		} else {
			model.addAttribute("message", "staff_delete_message_fail");
			model.addAttribute("alert", "danger");
		}

		model.addAttribute("page", 1);
		model.addAttribute("maxPageItems", 3);

		return "redirect:/admin/staff/list";
	}

	private void check(Staff staff, BindingResult bindingResult) {
		try {
			if (staff.getId().trim().length() == 0) {
				bindingResult.rejectValue("id", "staff.validation.notempty.id");
			}

			if (staff.getName().trim().length() == 0) {
				bindingResult.rejectValue("name", "staff.validation.notempty.name");
			}

			if (staff.getGender() == null) {
				bindingResult.rejectValue("gender", "staff.validation.notempty.gender");
			}

			if (staff.getBirthDay().trim().length() == 0) {
				bindingResult.rejectValue("birthDay", "staff.validation.notempty.birthday");
			} else {
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
				try {
					format.parse(staff.getBirthDay());
					
					String [] birthday = staff.getBirthDay().split("-");
					
					if (Integer.parseInt(birthday[1]) > 12) {
						bindingResult.rejectValue("birthDay", "staff.validation.format.birthday");
					} else if (Integer.parseInt(birthday[2]) > 31) {
						bindingResult.rejectValue("birthDay", "staff.validation.format.birthday");
					}
				} catch (Exception e) {
					bindingResult.rejectValue("birthDay", "staff.validation.format.birthday");
				}
			}

			if (staff.getPhoto().trim().length() == 0) {
				bindingResult.rejectValue("photo", "staff.validation.notempty.photo");
			}

			if (staff.getEmail().trim().length() == 0) {
				bindingResult.rejectValue("email", "staff.validation.notempty.email");
			} else if (!staff.getEmail().matches("^\\w+[0-9a-z]*@\\w+(\\.\\w+){1,3}")) {
				bindingResult.rejectValue("email", "staff.validation.format.email");
			}

			if (staff.getPhone().trim().length() == 0) {
				bindingResult.rejectValue("phone", "staff.validation.notempty.phone");
			} else if (!staff.getPhone().matches("\\d*")) {
				bindingResult.rejectValue("phone", "staff.validation.format.phone");
			}

			if (staff.getDepart().getId().length() == 0) {
				bindingResult.rejectValue("depart", "staff.validation.notempty.depart");
			}

			if (staff.getSalary() == null) {
				bindingResult.rejectValue("salary", "staff.validation.notempty.salary");
			} else if (staff.getSalary() < 0) {
				bindingResult.rejectValue("salary", "staff.validation.format.salary");
			}
		} catch (Exception e) {
		}
	}

}
