package br.com.friends.noteapp.domain.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="T_USER")
@AllArgsConstructor
@NoArgsConstructor
public class User {
	
	@Id
	@GeneratedValue
	@Column(name="IDUSER")
	private Long id;
	
	private String name;
	private String login;
	private String password;
	private String email;
	private String avatar;
	
	public User id(long id) {
		this.id = id;
		return this;
	}
	
}
