package poly.util;

import javax.mail.internet.MimeMessage;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.ui.Model;

public class MailUtil {

	public static void sendMail(String from, String to, String subject, String body, JavaMailSender mailer, Model model) {
		try {
			MimeMessage mail = mailer.createMimeMessage();
			
			MimeMessageHelper helper = new MimeMessageHelper(mail);
			
			helper.setFrom(from, from);
			helper.setTo(to);
			helper.setReplyTo(from, from);
			helper.setSubject(subject);
			helper.setText(body, true);
			
			mailer.send(mail);
			
			model.addAttribute("message_mail", "record_mail_message_success");
			model.addAttribute("alert_mail", "success");
		} catch (Exception e) {
			model.addAttribute("message_mail", "record_mail_message_fail");
			model.addAttribute("alert_mail", "danger");
		}
	}
	
}
