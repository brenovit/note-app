package br.com.friends.noteapp.repository;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

import br.com.friends.noteapp.entity.User;

public interface UserRepository extends CrudRepository<User, UUID>{

}
