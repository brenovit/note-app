package br.com.friends.noteapp.bean.email;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NotificationRequest {	
	private String subject;
	private String message;
	private String email;
	private String number;
}