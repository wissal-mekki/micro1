package com.project.micro1.services;

import com.project.micro1.entities.Role;
import com.project.micro1.entities.User;
import com.project.micro1.repositories.RoleRepository;
import com.project.micro1.repositories.UserRepository;
import org.hibernate.validator.constraints.UniqueElements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AccountServiceImpl implements AccountService{

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder ;
 @Autowired
    private UserRepository userRepository ;
 @Autowired
 private RoleRepository roleRepository ;
    @Override
    public User saveUser(User user) {
        String hashmdp = bCryptPasswordEncoder.encode(user.getMdp());
        user.setMdp(hashmdp);
        return userRepository.save(user);
    }

    @Override
    public Role save(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public void addRoleToUser(String login, String roleName) {
      Role role = roleRepository.findRoleByRoleName(roleName);
      User user = userRepository.findDistinctByLogin(login);
      user.getRoles().add(role);
    }

    @Override
    public User findUserByLogin(String login) {
        return  userRepository.findDistinctByLogin(login);
    }
}
