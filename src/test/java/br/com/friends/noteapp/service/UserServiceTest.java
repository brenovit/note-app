package br.com.friends.noteapp.service;

import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.validation.BindingResult;

import br.com.friends.noteapp.persistence.user.User;
import lombok.extern.log4j.Log4j2;

@Log4j2
@SpringBootTest
@RunWith(SpringRunner.class)
public class UserServiceTest {
	
	@Autowired
	private UserService service;
	
	@Test
	public void testValidateUser() {
		BindingResult bindingResult = null;
		User user = new User();
		user.setType(1);
		
		String message = service.validate(user, bindingResult);
		log.info(message);
		
		assertNull(message);
	}
	
	@Test
	public void testValidateAdmin() {
		BindingResult bindingResult = null;
		User user = new User();
		user.setType(0);
		
		String message = service.validate(user, bindingResult);
		log.info(message);
		
		assertNull(message);
	}

}
