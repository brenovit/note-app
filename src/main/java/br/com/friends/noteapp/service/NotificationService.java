package br.com.friends.noteapp.service;

import br.com.friends.noteapp.bean.email.NotificationRequest;
import br.com.friends.noteapp.bean.email.NotificationResponse;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface NotificationService {
	
	@POST("api/send")
	public Call<NotificationResponse> send(@Body NotificationRequest request);
}
