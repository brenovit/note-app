package br.com.friends.noteapp.exception;

public class ValidationException extends GenericException {

	private static final long serialVersionUID = 1L;

	public ValidationException(String code, String message) {
		super(code, message);		
	}
	
	public ValidationException(String code, String message, Throwable e) {
		super(code, message, e);		
	}


}
