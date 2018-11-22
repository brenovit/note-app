package br.com.friends.noteapp.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Note {
	@Id
	@GeneratedValue
	private long id;
	
	private String title;
	private String body;
	private String color;
	
	@Temporal(TemporalType.DATE)
	@Column(columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP", insertable=true, updatable=true)
	private Date lastModificatedDate;
	//private User user;
	
	public Note(String title, String body, String color) {
		this.title = title;
		this.body = body;
		this.color =  color;
	}
	
}
