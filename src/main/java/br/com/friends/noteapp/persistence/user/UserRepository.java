package br.com.friends.noteapp.persistence.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Long>{
    User findByUsername(@Param("username") String username);

	User findByEmail(@Param("email") String email);


}
