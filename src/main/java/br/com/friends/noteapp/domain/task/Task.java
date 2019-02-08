package br.com.friends.noteapp.domain.task;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
	@Column(name="IDTASK")
	private int id;
	
	@NotNull
	private String description;
	private Date time;
	
	@NotNull
	@ColumnDefault(value="false")
	private boolean done;
	
	@JoinColumn(name = "IDNOTE", referencedColumnName = "IDNOTE")
	private int noteId;
}
