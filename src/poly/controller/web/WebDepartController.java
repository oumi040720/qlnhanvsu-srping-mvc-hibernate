package poly.controller.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import poly.model.PageModel;
import poly.service.IDepartService;
import poly.util.PagingUtil;

@Controller
@RequestMapping(value = "/depart")
public class WebDepartController {

	@Autowired
	IDepartService departService;
	
	@RequestMapping(value = "/list")
	public String showList(HttpServletRequest request) {
		try {
			PageModel paging = PagingUtil.setPagging(request, departService.getTotalItems());
			
			request.setAttribute("departs", departService.findAll(paging.getOffset(), paging.getMaxPageItems()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "web/depart";
	}
	
}
