package com.project.micro1.services;

import com.project.micro1.entities.Role;
import com.project.micro1.entities.User;

public interface AccountService {
public User saveUser(User user);
public Role save(Role role);
public void  addRoleToUser(String login,String roleName);
public User findUserByLogin(String login) ;
}
