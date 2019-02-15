package br.com.friends.noteapp.domain.note;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface NoteRepository extends JpaRepository<Note, Long>{
	
	@Query(nativeQuery= true, value ="SELECT * FROM T_NOTE n WHERE n.IDUSER = :idUser")	
	List<Note> findByUserId(@Param("idUser") Long id);

	List<Note> findBySended(@Param("sended") boolean sended);
}