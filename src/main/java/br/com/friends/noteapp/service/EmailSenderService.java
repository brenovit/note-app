package br.com.friends.noteapp.service;

import javax.mail.MessagingException;

import org.apache.http.HttpStatus;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import br.com.friends.noteapp.bean.email.EmailRequest;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class EmailSenderService {

	@Value("${sendmail.url}")
	private String url;

	public void sendMail(EmailRequest request) throws MessagingException, UnirestException {
		JSONObject email = new JSONObject(request);

		log.debug("Message JSON: {}", email.toString());

		HttpResponse<JsonNode> jsonResponse = Unirest.post(url + "/send")
				.header("Accept", "application/json;charset=UTF-8")
				.header("Content-Type", "application/json")
				.body(email.toString()).asJson();

		if (jsonResponse.getStatus() == HttpStatus.SC_OK) {
			return;
		}
	}

	public void sendMail(String subject, String body, String to) throws MessagingException, UnirestException {
		sendMail(new EmailRequest(subject, body, to));
	}
}
