package br.com.friends.noteapp.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.friends.noteapp.entity.Note;

public interface NoteRepository extends CrudRepository<Note, Long>{

}
