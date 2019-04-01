package br.com.friends.noteapp.util.session;

import lombok.Getter;

public enum SessionAttribute {
	USER_KEY("userKey"),
	NOTE_KEY("noteKey");
	
	@Getter
	private String attribute;
	
	SessionAttribute(String attribute){
		this.attribute = attribute;
	}
	
	@Override
	public String toString() {
		return getAttribute();
	}
}
