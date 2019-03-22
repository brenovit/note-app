package br.com.friends.noteapp.bean.modelview;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class NoteColorView {
	private String value;
	private String name;
	
	public NoteColorView(String color) {
		this.value = color;
		this.name = color.substring(0, 1).toUpperCase() + color.substring(1);
	}
}
