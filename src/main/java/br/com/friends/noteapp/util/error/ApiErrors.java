package br.com.friends.noteapp.util.error;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;

import lombok.Data;

@Data
public class ApiErrors {
	
	private Date timestamp;
	private int status;
	private String error;
	private String path;
	private List<Error> errors;
	
	public ApiErrors(String code, String message) {
		errors = new ArrayList<>();
		errors.add(new Error(code, message));
		timestamp = new Date();
	}	

	public ApiErrors(Errors errs) {
		this.errors = new ArrayList<>();
		for (ObjectError obj : errs.getAllErrors()) {
			this.errors.add(new Error("99",obj.getDefaultMessage()));
		}
	}	
	
	public void add(Error error) {
		if(this.errors == null) {
			this.errors = new ArrayList<>();	
		}
		errors.add(error);
	}
	
	public void add(String code, String message) {
		add(new Error(code, message));
	}
}
