package poly.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import poly.service.IUserService;

@Controller
public class LoginController {

	@Autowired
	IUserService userService;
	
	@Autowired
	HttpSession session;
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String showLogin(HttpServletRequest request) {
		String message = request.getParameter("message");
		
		if (message != null) {
			request.setAttribute("message", message);
		}
		
		return "login/login";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String checkLogin(HttpServletRequest request, Model model) {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		if (userService.checkLogin(username, password)) {
			session.setAttribute("USER", username);
			
			return "redirect:/admin/home";
		} else {
			model.addAttribute("message", "Username or password incorrect");
			
			return "redirect:/login";
		}

	}
	
	@RequestMapping(value = "/logout")
	public String logout() {
		session.removeAttribute("USER");
		
		return "redirect:/home";
	}
	
}
