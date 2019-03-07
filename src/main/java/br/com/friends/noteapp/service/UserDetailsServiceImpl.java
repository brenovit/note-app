package br.com.friends.noteapp.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.friends.noteapp.persistence.role.Role;
import br.com.friends.noteapp.persistence.user.User;

@Service
public class UserDetailsServiceImpl extends FacadeService implements UserDetailsService {
    
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String login) {
        User user = getUser().findByLogin(login);
        if (user == null) throw new UsernameNotFoundException(login);

        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        for (Role role : user.getRoles()){
            grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
        }
        

        return new org.springframework.security.core.userdetails.User(user.getLogin(), user.getPassword(), grantedAuthorities);

    }
}
