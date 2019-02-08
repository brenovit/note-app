package br.com.friends.noteapp.controller;

import java.text.MessageFormat;
import java.text.ParseException;

import javax.validation.ConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.friends.noteapp.exception.ApplicationException;
import br.com.friends.noteapp.exception.ValidationException;
import br.com.friends.noteapp.util.error.ApiErrors;
import lombok.extern.log4j.Log4j2;

@ControllerAdvice
@Log4j2
public class ExceptionHandleControlller {

	@Autowired
	private MessageSource bundle;

	@ExceptionHandler(ApplicationException.class)
	public ResponseEntity<ApiErrors> processValidationError(MethodArgumentNotValidException ex) {
		BindingResult result = ex.getBindingResult();
		log.error(result.getFieldError().getDefaultMessage());
		return new ResponseEntity<ApiErrors>(new ApiErrors(result), HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ApiErrors> processValidationError(Exception ex) {
		log.error(ex.getMessage(), ex);
		ApiErrors apiErrors = new ApiErrors("99", "ERRO INTERNO DE PROCESSAMENTO");
		apiErrors.add("99", ex.getMessage());
		apiErrors.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
		return new ResponseEntity<ApiErrors>(apiErrors, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<ApiErrors> processConstraintViolationException(ConstraintViolationException ex) {
		log.error(ex.getMessage(), ex);
		ApiErrors apiErrors = new ApiErrors("99", "VALIDATION FAIL");
		apiErrors.add("99", ex.getMessage());
		apiErrors.setStatus(HttpStatus.BAD_REQUEST.value());
		return new ResponseEntity<ApiErrors>(apiErrors, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(ValidationException.class)
	public ResponseEntity<ApiErrors> processValidationError(ValidationException ex) {
		log.error(ex.getMessage(), ex);
		return new ResponseEntity<ApiErrors>(sanitizeApiError(ex.getCode(), ex.getMessage()), HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(ParseException.class)
	public ResponseEntity<ApiErrors> processParseException(ParseException ex) {
		log.error(ex.getMessage(), ex);
		ApiErrors apiErrors = new ApiErrors("98", "ERRO NOS DADOS INFORMADOS");
		apiErrors.add("99", ex.getMessage());
		apiErrors.setStatus(HttpStatus.BAD_REQUEST.value());
		return new ResponseEntity<ApiErrors>(apiErrors, HttpStatus.BAD_REQUEST);
	}

	private ApiErrors sanitizeApiError(String code, String extraMsg) {
		String errorMessage = bundle.getMessage(code, null, LocaleContextHolder.getLocale());
		if (extraMsg != null) {
			errorMessage = MessageFormat.format(errorMessage, extraMsg);
		}

		log.error(MessageFormat.format("Erro logico, Codigo: {0} - Traducao: {1}", code, errorMessage));
		return new ApiErrors(code, errorMessage);
	}
}
