package br.com.friends.noteapp.repository;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.friends.noteapp.persistence.user.User;
import br.com.friends.noteapp.persistence.user.UserRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepositoryTest {
	
	@Autowired
	private UserRepository repository;
	
	@Test
	public void test() {
		User user = repository.save(new User(1L,"Breno Nunes", "brenovit", "breno.arantes97@gmail.com", "5571987654321","Breno.png", "12345", "12345",null, 1));

		assertThat(user).isNotNull();
		assertThat(repository.count()).isEqualTo(1L);
	}

}
