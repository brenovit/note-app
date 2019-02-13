package br.com.friends.noteapp.service;

import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.friends.noteapp.bean.email.EmailRequest;
import br.com.friends.noteapp.bean.properties.MailSMTPProperties;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class EmailSenderService {
	
	@Autowired
	private MailSMTPProperties mailSMTPProperties;

	public void sendMail(String subject, String message, String to) throws MessagingException {
		Properties props = new Properties();
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", mailSMTPProperties.getHost());
		props.put("mail.smtp.port", mailSMTPProperties.getPort());
		props.put("mail.smtp.auth", mailSMTPProperties.getAuth());
		
		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(mailSMTPProperties.getUsername(), mailSMTPProperties.getPassword());
			}
		});
		
		MimeMessage msg = new MimeMessage(session);
		
		InternetAddress[] replyTo = InternetAddress.parse("notaaqui@noreply.com", true);
		InternetAddress[] recipientsTo = InternetAddress.parse(to, true);
		
		msg.setRecipients(Message.RecipientType.TO, recipientsTo);
		msg.setFrom("notaaqui@noreply.com");
		msg.setReplyTo(replyTo);
		msg.setSubject(subject);
		msg.setSentDate(new Date());		
		msg.setContent(message, "text/html");
		msg.setHeader("XPriority", "1");
		Transport.send(msg);
		log.info("Email sended");
	}

	public void sendMail(EmailRequest request) throws MessagingException {
		sendMail(request.getSubject(), request.getMessage(), request.getTo());		
	}
}
