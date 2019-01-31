package br.com.friends.noteapp.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@AllArgsConstructor
@EqualsAndHashCode(callSuper=false)
public abstract class GenericException extends Exception {

	private static final long serialVersionUID = 1L;

	private final String code;
	private final String message;
	
	public GenericException(String code, String message, Throwable e) {
		super(message, e);
		this.code = code;
		this.message = message;
	}	
}
