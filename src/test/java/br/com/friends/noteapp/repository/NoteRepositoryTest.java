package br.com.friends.noteapp.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

import br.com.friends.noteapp.entity.Note;

@RunWith(SpringRunner.class)
@DataJpaTest
public class NoteRepositoryTest {
	
	@Autowired
	private NoteRepository repository;
	
	@Test
	public void test() {
		Note note = repository.save(new Note("Note 1","Write Here","Blue"));

		assertThat(note).isNotNull();
		assertThat(repository.count()).isEqualTo(1L);
	}

}
