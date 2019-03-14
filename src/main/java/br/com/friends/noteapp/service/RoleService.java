package br.com.friends.noteapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.friends.noteapp.persistence.role.Role;
import br.com.friends.noteapp.persistence.role.RoleRepository;

@Service
public class RoleService {
	@Autowired
    private RoleRepository roleRepository;
	
	public List<Role> findAll() {
		return roleRepository.findAll();
	}
	
}
