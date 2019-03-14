package br.com.friends.noteapp.log4j2;

import lombok.experimental.UtilityClass;
import lombok.extern.log4j.Log4j2;

@Log4j2
@UtilityClass
public class File1 {
	
	public void print(String mensagem) {
		log.info(mensagem);
	}	
}
