package com.project.micro1.services;

import com.project.micro1.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {


    @Autowired
    private  AccountService accountService ;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        User user=accountService.findUserByLogin(login);
        if(user==null) throw  new UsernameNotFoundException(login) ;
        Collection<GrantedAuthority> authorities = new ArrayList<>() ;
        user.getRoles().forEach(r -> {
            authorities.add(new SimpleGrantedAuthority(r.getRoleName()));
                }
                );
        return new org.springframework.security.core.userdetails.User(user.getLogin(),user.getMdp(),authorities);

    }
}
