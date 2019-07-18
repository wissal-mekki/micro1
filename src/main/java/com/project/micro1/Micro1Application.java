package com.project.micro1;

import com.project.micro1.entities.Role;
import com.project.micro1.entities.User;
import com.project.micro1.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import javax.annotation.PostConstruct;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import sun.java2d.pipe.hw.AccelDeviceEventListener;

@SpringBootApplication
public class Micro1Application implements CommandLineRunner {
	@Autowired
	private ObjectMapper objectMapper;
	@Autowired
	private AccountService accountService ;
 // private  BCryptPasswordEncoder bCryptPasswordEncoder ;
	public static void main(String[] args) {
		SpringApplication.run(Micro1Application.class, args);
	}

	@Bean
	BCryptPasswordEncoder getBce() {
	    return  new BCryptPasswordEncoder() ;
    }
	@Override
	public void run(String... arg0) throws Exception {
/*		accountService.save(new Role(null,"USER"));
		accountService.save(new Role(null,"ADMIN"));
	//
	//	accountService.saveUser(new User(null,null,null,null,null,null,null,"admin","1234", null));
		accountService.addRoleToUser("user", "USER");
		accountService.addRoleToUser("admin", "USER");
		accountService.addRoleToUser("admin", "ADMIN");*/
	//	accountService.saveUser(new User("wass","mk","22/22/22",12345678,"mmlkk","p@p.p",12345678,"wass","1234", null));
	//	accountService.addRoleToUser("wass", "USER");
	}

	@PostConstruct
	public void setUp() {
		objectMapper.registerModule(new JavaTimeModule());
	}
}
