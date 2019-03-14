package br.com.friends.noteapp.log4j2;

import org.junit.Test;

public class LogTest {
	
	@Test
	public void writeDifferentsFile() {
		File1.print("Testando o arquivo 1");
		File2.print("Testando o arquivo 2");
	}
	
}
