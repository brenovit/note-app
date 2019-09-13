package br.com.friends.noteapp.service;

import java.io.IOException;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import br.com.friends.noteapp.bean.email.NotificationRequest;
import br.com.friends.noteapp.bean.email.NotificationResponse;
import lombok.extern.log4j.Log4j2;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

@Service
@Log4j2
public class NotificationSenderService {

	@Value("${sendmail.url}")
	private String url;

	public void sendNotificationUnirest(String subject, String message, String email, String number) throws MessagingException, UnirestException, JsonParseException, JsonMappingException, IOException {
		long startTime = System.currentTimeMillis();
		ObjectMapper mapper = new ObjectMapper();
		String requestBody = mapper.writeValueAsString(new NotificationRequest(subject, message, email, number));
		
		log.debug("Message JSON: {}", requestBody);

		HttpResponse<JsonNode> jsonResponse = Unirest.post(url + "api/send")
				.header("Accept", "application/json;charset=UTF-8")
				.header("Content-Type", "application/json")
				.body(requestBody).asJson();
		
		NotificationResponse response = mapper.readValue(jsonResponse.getBody().toString(), NotificationResponse.class);
		log.info(response.toString());

		long finishTime = System.currentTimeMillis() - startTime;
		log.info("Duration: {} - Unirest", finishTime);		
	}

	public void sendNotificationRetrofit(String subject, String message, String email, String number) throws MessagingException, UnirestException, IOException {
		long startTime = System.currentTimeMillis();
		
		OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
		
		Retrofit retrofit = new Retrofit.Builder()
		  .baseUrl(url)
		  .addConverterFactory(JacksonConverterFactory.create())
		  .client(httpClient.build())
		  .build();
		
		NotificationService service = retrofit.create(NotificationService.class);
		Call<NotificationResponse> callSync = service.send(new NotificationRequest(subject, message, email, number));
		Response<NotificationResponse> response = callSync.execute();
		NotificationResponse notific = response.body();
		
		log.info(notific.toString());
		long finishTime = System.currentTimeMillis() - startTime;
		log.info("Duration: {} - Retrofit", finishTime);
		
	}
}
