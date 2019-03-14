package br.com.friends.noteapp.exception;

public class ApplicationException extends GenericException{

	private static final long serialVersionUID = 1L;
		
	public ApplicationException(String code, String message) {
		super(code, message);		
	}
	
	public ApplicationException(String code, String message, Throwable e) {
		super(code, message, e);		
	}
}
