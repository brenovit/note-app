package br.com.friends.noteapp.persistence.user;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import br.com.friends.noteapp.persistence.role.Role;
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
	private String username;
	private String email;
	private String avatar;
	
	private String password;
	@Transient
    private String passwordConfirm;

    @ManyToMany
    private Set<Role> roles;
	
	
	public User id(long id) {
		this.id = id;
		return this;
	}
	
}
