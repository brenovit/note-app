package br.com.friends.noteapp.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.ColumnDefault;

import lombok.Data;

@Data
@Entity
@Table(name="T_TASK")
public class Task {
	
	@Id
	@GeneratedValue
	private int id;
	
	@NotNull
	private String description;
	private Date time;
	
	@NotNull
	@ColumnDefault(value="false")
	private boolean done;
}
