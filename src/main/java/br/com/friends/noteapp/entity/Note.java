package br.com.friends.noteapp.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@Table(name="T_NOTE")
@NoArgsConstructor
public class Note {
	@Id
	@GeneratedValue
	private long id;
	
	@NotNull(message="The ")
	@NotBlank
	private String title;
	
	@NotNull
	@NotBlank
	private String body;

	@NotNull
	@NotBlank
	private String color;
	
	@Temporal(TemporalType.DATE)
	@Column(columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP", insertable=true, updatable=true)
	private Date lastModificatedDate;
	
	@ManyToOne
	@NotNull(message="Usuário Obrigatório")
	private User user;
	
	public Note(String title, String body, String color) {
		this.title = title;
		this.body = body;
		this.color =  color;
	}
	
}