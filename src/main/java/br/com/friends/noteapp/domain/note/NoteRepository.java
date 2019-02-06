package br.com.friends.noteapp.domain.note;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface NoteRepository extends JpaRepository<Note, Long>{
	
	@Query(nativeQuery= true, value ="SELECT * FROM Note n "
			+"WHERE n.IDUSER = :userId")	
	Note findByUserId(@Param("userId") String id);

}
