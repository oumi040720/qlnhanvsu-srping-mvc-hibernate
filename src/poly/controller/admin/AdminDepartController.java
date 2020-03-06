package poly.controller.admin;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import poly.entity.Depart;
import poly.model.PageModel;
import poly.service.IDepartService;
import poly.util.PagingUtil;

@Controller
@RequestMapping(value = "/admin/depart")
public class AdminDepartController {

	@Autowired
	IDepartService departService;
	
	@RequestMapping(value = "/list")
	public String showList(HttpServletRequest request) {
		try {
			String message = request.getParameter("message");
			String alert = request.getParameter("alert");
			
			PageModel paging = PagingUtil.setPagging(request, departService.getTotalItems());
			
			request.setAttribute("departs", departService.findAll(paging.getOffset(), paging.getMaxPageItems()));

			if (message != null) {
				request.setAttribute("message", message.replaceAll("_", "."));
				request.setAttribute("alert", alert);
			}
		} catch (Exception e) {
		}
		
		return "admin/depart/list";
	}
	
	@RequestMapping(value = "/add")
	public String showAddForm(Model model) {
		model.addAttribute("check", false);
		model.addAttribute("depart", new Depart());
		
		return "admin/depart/edit";
	}
	
	@RequestMapping(value = "/edit")
	public String showEditForm(Model model, @ModelAttribute("id") String id) {
		model.addAttribute("check", true);
		model.addAttribute("depart", departService.findOne(id));
		
		return "admin/depart/edit";
	}
	
	@RequestMapping(value = "/save")
	public String save(Model model, @ModelAttribute("depart") Depart depart, BindingResult bindingResult) {
		check(depart, bindingResult);
		
		if (bindingResult.hasErrors()) {
			return "admin/depart/edit";
		} else {
			if (departService.saveOrUpdate(depart)) {
				model.addAttribute("message", "depart_edit_message_success");
				model.addAttribute("alert", "success");
			} else {
				model.addAttribute("message", "depart_edit_message_fail");
				model.addAttribute("alert", "danger");
			}
			
			model.addAttribute("page", 1);
			model.addAttribute("maxPageItems", 7);
			
			return "redirect:/admin/depart/list";
		}
	}
	
	@RequestMapping(value = "/delete")
	public String delete(Model model, @ModelAttribute("id") String id) {
		if (departService.delete(id)) {
			model.addAttribute("message", "depart_delete_message_success");
			model.addAttribute("alert", "success");
		} else {
			model.addAttribute("message", "depart_delete_message_fail");
			model.addAttribute("alert", "danger");
		}
		
		model.addAttribute("page", 1);
		model.addAttribute("maxPageItems", 7);
		
		return "redirect:/admin/depart/list";
	}
	
	private void check(Depart depart, BindingResult bindingResult) {
		try {
			if (depart.getId().trim().length() == 0) {
				bindingResult.rejectValue("id", "depart.validation.notempty.id");
			}
			
			if (depart.getName().trim().length() == 0) {
				bindingResult.rejectValue("name", "depart.validation.notempty.name");
			}
		} catch (Exception e) {
		}
	}

}
