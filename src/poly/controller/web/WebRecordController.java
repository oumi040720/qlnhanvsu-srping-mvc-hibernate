package poly.controller.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import poly.model.PageModel;
import poly.service.IRecordService;
import poly.util.PagingUtil;

@Controller
@RequestMapping(value = "/record")
public class WebRecordController {

	@Autowired
	IRecordService recordService;
	
	@RequestMapping(value = "/list")
	public String showList(HttpServletRequest request) {
		try {
			PageModel paging = PagingUtil.setPagging(request, recordService.getTotalItems());
			
			request.setAttribute("records", recordService.findAll(paging.getOffset(), paging.getMaxPageItems()));
			
			request.setAttribute("years", recordService.getAllYear());
		} catch (Exception e) {
		}
		
		return "web/record/list";
	}
	
	@RequestMapping(value = "/list/search")
	public String showListByYear(HttpServletRequest request) {
		try {
			String year = request.getParameter("year");
			
			if (year == null || year.length() == 0) {
				return "redirect:/record/list?page=1&maxPageItems=5";
			}
			
			PageModel paging = PagingUtil.setPagging(request, recordService.getTotalItemsByYear(Integer.parseInt(year)));
			
			request.setAttribute("records", recordService.findAllByYear(Integer.parseInt(year), paging.getOffset(), paging.getMaxPageItems()));
			request.setAttribute("year", year);
			
			request.setAttribute("years", recordService.getAllYear());
		} catch (Exception e) {
		}
		
		return "web/record/search";
	}
	
	@RequestMapping(value = "/search")
	public String getYear(Model model, @RequestParam(value = "year") String year) {
		model.addAttribute("year", year);
		model.addAttribute("page", 1);
		model.addAttribute("maxPageItems", 5);
		
		return "redirect:/record/list/search";
	}
	
	@RequestMapping(value = "/report/staff/list")
	public String showStaffReport(HttpServletRequest request) {
		try {
			PageModel paging = PagingUtil.setPagging(request, recordService.getTotalStaffReportItems());
			
			request.setAttribute("list", recordService.findAllStaffReport(paging.getOffset(), paging.getMaxPageItems()));
			request.setAttribute("years", recordService.getAllYear());
		} catch (Exception e) {
		}
		
		return "web/record/report/staff/list";
	}
	
	@RequestMapping(value = "/report/staff/search", method = RequestMethod.GET)
	public String showListStaffReportByYear(HttpServletRequest request) {
		try {
			int year = Integer.parseInt(request.getParameter("year"));
			
			if (year == 0) {
				return "redirect:/record/report/staff/list?page=1&maxPageItems=5";
			}
			
			PageModel paging = PagingUtil.setPagging(request, recordService.getTotalStaffReportItemsByYear(year));
			
			request.setAttribute("list", recordService.findAllStaffReportByYear(year, paging.getOffset(), paging.getMaxPageItems()));
			request.setAttribute("year", year);
			request.setAttribute("years", recordService.getAllYear());
		} catch (Exception e) {
		}
		
		return "web/record/report/staff/search";
	}
	
	@RequestMapping(value = "/report/staff/search", method = RequestMethod.POST)
	public String getYearForStaffReport(Model model, @RequestParam(value = "year") String year) {
		model.addAttribute("year", year);
		model.addAttribute("page", 1);
		model.addAttribute("maxPageItems", 5);
		
		return "redirect:/record/report/staff/search";
	}
	
	@RequestMapping(value = "/report/depart/list")
	public String showDepartReport(HttpServletRequest request) {
		try {
			PageModel paging = PagingUtil.setPagging(request, recordService.getTotalDepartReportItems());
			
			request.setAttribute("list", recordService.findAllDepartReport(paging.getOffset(), paging.getMaxPageItems()));
			request.setAttribute("years", recordService.getAllYear());
		} catch (Exception e) {
		}
		
		return "web/record/report/depart/list";
	}
	
	@RequestMapping(value = "/report/depart/search", method = RequestMethod.GET)
	public String showListStaffDepartByYear(HttpServletRequest request) {
		try {
			int year = Integer.parseInt(request.getParameter("year"));
			
			if (year == 0) {
				return "redirect:/record/report/depart/list?page=1&maxPageItems=10";
			}
			
			PageModel paging = PagingUtil.setPagging(request, recordService.getTotalDepartReportItemsByYear(year));
			
			request.setAttribute("list", recordService.findAllDepartReportByYear(year, paging.getOffset(), paging.getMaxPageItems()));
			request.setAttribute("year", year);
			request.setAttribute("years", recordService.getAllYear());
		} catch (Exception e) {
		}
		
		return "web/record/report/depart/search";
	}
	
	@RequestMapping(value = "/report/depart/search", method = RequestMethod.POST)
	public String getYearForDepartReport(Model model, @RequestParam(value = "year") String year) {
		model.addAttribute("year", year);
		model.addAttribute("page", 1);
		model.addAttribute("maxPageItems", 10);
		
		return "redirect:/record/report/depart/search";
	}
	
}
