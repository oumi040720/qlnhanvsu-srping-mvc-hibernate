package poly.controller.admin;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import poly.util.MailUtil;

@Controller
@RequestMapping(value = "/admin")
public class AdminEmailController {

	@Autowired
	JavaMailSender mailer;
	
	@RequestMapping(value = "/email")
	public String showPage (HttpServletRequest request) {
		String messageMail = request.getParameter("message_mail");
		String alertMail = request.getParameter("alert_mail");
		
		if (messageMail != null) {
			request.setAttribute("messageMail", messageMail.replaceAll("_", "."));
			request.setAttribute("alertMail", alertMail);
		}
		
		return "admin/email";
	}
	
	@RequestMapping(value = "/email/send")
	public String sendEmail(Model model, HttpServletRequest request) {
		String from = request.getParameter("from");
		String to = request.getParameter("to");
		String subject = request.getParameter("subject");
		String body = request.getParameter("content");
		
		MailUtil.sendMail(from, to, subject, body, mailer, model);
		
		return "redirect:/admin/email";
	}
	
}
