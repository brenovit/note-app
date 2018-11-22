package br.com.friends.noteapp.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class User {
	
	@Id
	@GeneratedValue
	private long id;
	
	private String name;
	private String login;
	private String password;
	private String email;
	private String avatar;
	
}
