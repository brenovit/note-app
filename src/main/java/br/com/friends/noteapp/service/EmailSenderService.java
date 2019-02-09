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

@Service
public class EmailSenderService {
	
	@Autowired
	private MailSMTPProperties mailSMTPProperties;

	public void sendMail(String subject, String message, String to) throws MessagingException {
		// Setting up configurations for the email connection to the Google SMTP server
		// using TLS
		Properties props = new Properties();
		//props.put("mail.smtp.host", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", mailSMTPProperties.getHost());
		props.put("mail.smtp.port", mailSMTPProperties.getPort());
		props.put("mail.smtp.auth", mailSMTPProperties.getAuth());
		// Establishing a session with required user details
		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(mailSMTPProperties.getUsername(), mailSMTPProperties.getPassword());
			}
		});
		// Creating a Message object to set the email content
		MimeMessage msg = new MimeMessage(session);
		// Storing the comma seperated values to email addresses
		/*
		 * Parsing the String with defualt delimiter as a comma by marking the boolean
		 * as true and storing the email addresses in an array of InternetAddress
		 * objects
		 */
		InternetAddress[] address = InternetAddress.parse(to, true);
		// Setting the recepients from the address variable
		msg.setRecipients(Message.RecipientType.TO, address);

		msg.setSubject(subject);
		msg.setSentDate(new Date());
		msg.setText(message);
		msg.setHeader("XPriority", "1");
		Transport.send(msg);

	}

	public void sendMail(EmailRequest request) throws MessagingException {
		sendMail(request.getSubject(), request.getMessage(), request.getTo());		
	}
}
