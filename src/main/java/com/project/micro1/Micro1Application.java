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

@SpringBootApplication
public class Micro1Application implements CommandLineRunner {
	@Autowired
	private ObjectMapper objectMapper;
	@Autowired
	private AccountService accountService ;

	public static void main(String[] args) {
		SpringApplication.run(Micro1Application.class, args);
	}

	@Bean
	BCryptPasswordEncoder getBce() {
	    return  new BCryptPasswordEncoder() ;
    }
	@Override
	public void run(String... arg0) throws Exception {

	}

	@PostConstruct
	public void setUp() {
		objectMapper.registerModule(new JavaTimeModule());
	}
}
