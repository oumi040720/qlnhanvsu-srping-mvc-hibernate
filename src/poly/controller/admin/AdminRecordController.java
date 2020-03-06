package poly.controller.admin;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import poly.entity.Record;
import poly.model.PageModel;
import poly.service.IRecordService;
import poly.service.IStaffService;
import poly.util.MailUtil;
import poly.util.PagingUtil;

@Controller
@RequestMapping(value = "/admin/record")
public class AdminRecordController {

	@Autowired
	IRecordService recordService;
	
	@Autowired
	IStaffService staffService;
		
	@Autowired
	JavaMailSender mailer;
	
	@RequestMapping(value = "/list")
	public String showList(HttpServletRequest request) {
		try {
			String message = request.getParameter("message");
			String alert = request.getParameter("alert");
			String messageMail = request.getParameter("message_mail");
			String alertMail = request.getParameter("alert_mail");
			
			PageModel paging = PagingUtil.setPagging(request, recordService.getTotalItems());
			
			request.setAttribute("records", recordService.findAll(paging.getOffset(), paging.getMaxPageItems()));
			request.setAttribute("years", recordService.getAllYear());
			
			if (message != null) {
				request.setAttribute("message", message.replaceAll("_", "."));
				request.setAttribute("alert", alert);
			}
			if (messageMail != null) {
				request.setAttribute("messageMail", messageMail.replaceAll("_", "."));
				request.setAttribute("alertMail", alertMail);
			}
		} catch (Exception e) {
		}
		
		return "admin/record/list";
	}
	
	@RequestMapping(value = "/list/search")
	public String showListByYear(HttpServletRequest request) {
		try {
			int year = Integer.parseInt(request.getParameter("year"));
			
			if (year == 0) {
				return "redirect:/record/list?page=1&maxPageItems=7";
			}

			PageModel paging = PagingUtil.setPagging(request, recordService.getTotalItemsByYear(year));
			
			request.setAttribute("records", recordService.findAllByYear(year, paging.getOffset(), paging.getMaxPageItems()));
			request.setAttribute("year", year);
			
			request.setAttribute("years", recordService.getAllYear());
		} catch (Exception e) {
		}
		
		return "admin/record/search";
	}
	
	@RequestMapping(value = "/search")
	public String getYear(Model model, @RequestParam(value = "year") String year) {
		model.addAttribute("year", year);
		model.addAttribute("page", 1);
		model.addAttribute("maxPageItems", 7);
		
		return "redirect:/admin/record/list/search";
	}
	
	@RequestMapping(value = "/report/staff")
	public String showStaffReport(HttpServletRequest request) {
		try {
			PageModel paging = PagingUtil.setPagging(request, recordService.getTotalStaffReportItems());
			
			request.setAttribute("list", recordService.findAllStaffReport(paging.getOffset(), paging.getMaxPageItems()));
			request.setAttribute("years", recordService.getAllYear());
		} catch (Exception e) {
		}
		
		return "admin/record/report/staff/list";
	}
	
	@RequestMapping(value = "/report/staff/search", method = RequestMethod.GET)
	public String showListStaffReportByYear(HttpServletRequest request) {
		try {
			int year = Integer.parseInt(request.getParameter("year"));
			
			if (year == 0) {
				return "redirect:/record/report/staff?page=1&maxPageItems=3";
			}
			PageModel paging = PagingUtil.setPagging(request, recordService.getTotalStaffReportItemsByYear(year));
			
			request.setAttribute("list", recordService.findAllStaffReportByYear(year, paging.getOffset(), paging.getMaxPageItems()));
			request.setAttribute("year", year);
			request.setAttribute("years", recordService.getAllYear());
		} catch (Exception e) {
		}
		
		return "admin/record/report/staff/search";
	}
	
	@RequestMapping(value = "/report/staff/search", method = RequestMethod.POST)
	public String getYearForStaffReport(Model model, @RequestParam(value = "year") String year) {
		model.addAttribute("year", year);
		model.addAttribute("page", 1);
		model.addAttribute("maxPageItems", 3);
		
		return "redirect:/admin/record/report/staff/search";
	}
	
	@RequestMapping(value = "/report/depart")
	public String showDepartReport(HttpServletRequest request) {
		try {
			PageModel paging = PagingUtil.setPagging(request, recordService.getTotalDepartReportItems());
			
			request.setAttribute("list", recordService.findAllDepartReport(paging.getOffset(), paging.getMaxPageItems()));
			request.setAttribute("years", recordService.getAllYear());
		} catch (Exception e) {
		}
		
		return "admin/record/report/depart/list";
	}
	
	@RequestMapping(value = "/report/depart/search", method = RequestMethod.GET)
	public String showListStaffDepartByYear(HttpServletRequest request) {
		try {
			int year = Integer.parseInt(request.getParameter("year"));
			
			if (year == 0) {
				return "redirect:/record/report/depart?page=1&maxPageItems=7";
			}
			
			PageModel paging = PagingUtil.setPagging(request, recordService.getTotalDepartReportItemsByYear(year));
			
			request.setAttribute("list", recordService.findAllDepartReportByYear(year, paging.getOffset(), paging.getMaxPageItems()));
			request.setAttribute("year", year);
			request.setAttribute("years", recordService.getAllYear());
		} catch (Exception e) {
		}
		
		return "admin/record/report/depart/search";
	}
	
	@RequestMapping(value = "/report/depart/search", method = RequestMethod.POST)
	public String getYearForDepartReport(Model model, @RequestParam(value = "year") String year) {
		model.addAttribute("year", year);
		model.addAttribute("page", 1);
		model.addAttribute("maxPageItems", 7);
		
		return "redirect:/admin/record/report/depart/search";
	}
	
	@RequestMapping(value = "/add")
	public String showAddForm(Model model) {
		model.addAttribute("staffs", staffService.findAll());
		model.addAttribute("record", new Record());
		
		return "admin/record/edit";
	}
	
	@RequestMapping(value = "/edit")
	public String showEditForm(Model model, @ModelAttribute("id") Long id) {
		model.addAttribute("staffs", staffService.findAll());
		model.addAttribute("record", recordService.findOne(id));
		
		return "admin/record/edit";
	}
	
	@RequestMapping(value = "/save")
	public String save(Model model, @ModelAttribute("record") Record record, BindingResult bindingResult) {
		try {
			if (record.getStaff().getId().length() == 0) {
				bindingResult.rejectValue("staff", "record.validation.notempty.staff");
			}
		} catch (Exception e) {
		}

		if (bindingResult.hasErrors()) {
			model.addAttribute("staffs", staffService.findAll());
			
			return "admin/record/edit";
		} else {
			if (recordService.saveOrUpdate(record)) {
				model.addAttribute("message", "record_edit_message_success");
				model.addAttribute("alert", "success");

				String subject = "";
				String body = "";
				
				if (record.getType() == 1) {
					subject = "Bạn được điểm cộng";
					body = "Chúc mừng bạn được 1 điểm cộng  \n";
				} else {
					subject = "Bạn bị bị nhận điểm trừ";
					body = "Bạn đã bị nhận 1 điểm trừ";
				}
				body += "Lý do:" + record.getReason();
				body += "Ngày: " + record.getDate();
				
				MailUtil.sendMail("hoangnhps10180@fpt.edu.vn", staffService.findOne(record.getStaff().getId()).getEmail(), subject, body, mailer, model);
			} else {
				model.addAttribute("message", "record_edit_message_fail");
				model.addAttribute("alert", "danger");
			}

			model.addAttribute("page", 1);
			model.addAttribute("maxPageItems", 7);
			
			return "redirect:/admin/record/list";
		}
	}
	
	@RequestMapping(value = "/delete")
	public String delete(Model model, @ModelAttribute("id") Long id) {
		Record record = recordService.findOne(id);

		String subject = "";
		String body = "";
		
		if (record.getType() == 1) {
			subject = "Bạn bị xóa điểm cộng";
			body = "Bạn đã bị xóa mất 1 điểm cộng vào lúc " + new Date(System.currentTimeMillis());
		} else {
			subject = "Bạn đã được xóa điểm trừ";
			body = "Bạn đã được xóa mất 1 điểm trừ vào lúc " + new Date(System.currentTimeMillis());
		}
		
		if (recordService.delete(id)) {
			model.addAttribute("message", "record_delete_message_success");
			model.addAttribute("alert", "success");
			
			MailUtil.sendMail("hoangnhps10180@fpt.edu.vn", record.getStaff().getEmail(), subject, body, mailer, model);
		} else {
			model.addAttribute("message", "record_delete_message_fail");
			model.addAttribute("alert", "danger");
		}
		
		model.addAttribute("page", 1);
		model.addAttribute("maxPageItems", 7);
		
		return "redirect:/admin/record/list";
	}
	
}
