package poly.controller.admin;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import poly.service.IRecordService;

@Controller
@RequestMapping(value = "/admin")
public class AdminHomeController {

	@Autowired
	IRecordService recordService;
	
	@RequestMapping(value = "/home")
	public String showHome(HttpServletRequest request) {
		String year = request.getParameter("year");

		if (year == null || year.length() == 0) {
			request.setAttribute("list", recordService.findExcellentStaff());
		} else {
			if (Integer.parseInt(year) > 0) {
				request.setAttribute("list", recordService.findExcellentStaffByYear(Integer.parseInt(year)));
				request.setAttribute("year", year);
			} else {
				request.setAttribute("list", recordService.findExcellentStaff());
			}
		}

		request.setAttribute("years", recordService.getAllYear());
		
		return "admin/home";
	}
	
	@RequestMapping(value = "/home/search")
	public String getYear(Model model, @RequestParam(value = "year") String year) {
		model.addAttribute("year", year);
		
		return "redirect:/admin/home";
	}
	
}
