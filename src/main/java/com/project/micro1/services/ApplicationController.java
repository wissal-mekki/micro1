package com.project.micro1.services;

import com.project.micro1.entities.Application;
import com.project.micro1.repositories.ApplicationRepository;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
@RequestMapping("/api")
@RestController
public class ApplicationController  {

    //private EntityManagerFactory entityManagerFactory;

    private SessionFactory sessionFactory;
    @Autowired
    private ApplicationRepository applicationRepository ;



    public  ApplicationController(ApplicationRepository applicationRepository){
        this.applicationRepository=applicationRepository;

        //this.entityManagerFactory=entityManagerFactory;

    }

    @PostMapping("/applications")
    public ResponseEntity<Application> CreateApplication(Application application ) throws URISyntaxException {
        if(application.getID() != null) {

            System.out.println("eeee");

        }

        Application result = applicationRepository.save(application);
        return  ResponseEntity.created(new URI("/api/applications"+ result.getID())).header("ok!").body(result);
    }

     @GetMapping("/applications")
    public List<Application> GetAll(){
        return applicationRepository.findAll();
     }
}

