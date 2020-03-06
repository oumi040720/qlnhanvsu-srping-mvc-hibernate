package poly.controller.admin;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import poly.entity.User;
import poly.model.PageModel;
import poly.service.IUserService;
import poly.util.PagingUtil;

@Controller
@RequestMapping(value = "/admin/user")
public class AdminUserController {

	@Autowired
	IUserService userService;
	
	@RequestMapping(value = "/list")
	public String showList(HttpServletRequest request) {
		try {
			String message = request.getParameter("message");
			String alert = request.getParameter("alert");
			
			PageModel paging = PagingUtil.setPagging(request, userService.getTotalItems());
			
			request.setAttribute("users", userService.findAll(paging.getOffset(), paging.getMaxPageItems()));

			if (message != null) {
				request.setAttribute("message", message.replaceAll("_", "."));
				request.setAttribute("alert", alert);
			}
		} catch (Exception e) {
		}
		
		return "admin/user/list";
	}
	
	@RequestMapping(value = "/add")
	public String showAddForm(Model model) {
		model.addAttribute("check", false);
		model.addAttribute("user", new User());
		
		return "admin/user/edit";
	}
	
	@RequestMapping(value = "/edit")
	public String showEditForm(Model model, @ModelAttribute("username") String username) {
		model.addAttribute("check", true);
		model.addAttribute("user", userService.findOne(username));
		
		return "admin/user/edit";
	}
	
	@RequestMapping(value = "/save")
	public String save(Model model, @ModelAttribute("user") User user, BindingResult bindingResult) {
		check(user, bindingResult);
		
		if (bindingResult.hasErrors()) {
			return "admin/user/edit";
		} else {
			if (userService.saveOrUpdate(user)) {
				model.addAttribute("message", "user_edit_message_success");
				model.addAttribute("alert", "success");
			} else {
				model.addAttribute("message", "user_edit_message_fail");
				model.addAttribute("alert", "danger");
			}
			
			model.addAttribute("page", 1);
			model.addAttribute("maxPageItems", 7);
			
			return "redirect:/admin/user/list";
		}
	}
	
	@RequestMapping(value = "/delete")
	public String delete(Model model, @ModelAttribute("username") String username) {
		if (userService.delete(username)) {
			model.addAttribute("message", "user_delete_message_success");
			model.addAttribute("alert", "success");
		} else {
			model.addAttribute("message", "user_delete_message_fail");
			model.addAttribute("alert", "danger");
		}
		
		model.addAttribute("page", 1);
		model.addAttribute("maxPageItems", 7);
		
		return "redirect:/admin/user/list";
	}
	
	private void check(User user, BindingResult bindingResult) {
		try {
			if (user.getUsername().trim().length() == 0) {
				bindingResult.rejectValue("username", "user.validation.notempty.username");
			}
			
			if (user.getPassword().trim().length() == 0) {
				bindingResult.rejectValue("password", "user.validation.notempty.password");
			}
		
			if (user.getFullname().trim().length() == 0) {
				bindingResult.rejectValue("fullname", "user.validation.notempty.fullname");
			}
		} catch (Exception e) {
		}
	}
	
}
