package br.com.friends.noteapp.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.UUID;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.friends.noteapp.entity.User;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepositoryTest {
	
	@Autowired
	private UserRepository repository;
	
	@Test
	public void test() {
		User user = repository.save(new User(UUID.randomUUID(),"Breno Nunes", "brenovit", "12345","breno.arantes97@gmail.com","Breno.png"));

		assertThat(user).isNotNull();
		assertThat(repository.count()).isEqualTo(1L);
	}

}
