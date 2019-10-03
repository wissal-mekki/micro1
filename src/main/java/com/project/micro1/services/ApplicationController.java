package com.project.micro1.services;

import com.project.micro1.entities.Application;
import com.project.micro1.repositories.ApplicationRepository;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
@RestController
public class ApplicationController  {


    private SessionFactory sessionFactory;
    @Autowired
    private ApplicationRepository applicationRepository ;



    public  ApplicationController(ApplicationRepository applicationRepository){
        this.applicationRepository=applicationRepository;


    }

    @GetMapping("/lastapp")
    public Application Getlastapp() {
        return applicationRepository.findTopByOrderByIdDesc() ;
    }

    @RequestMapping(value = "/application", method =RequestMethod.POST)
    public ResponseEntity<Application> CreateApplication( @Valid @RequestBody Application application ) throws URISyntaxException {
        if(application.getId() != null) {

            System.out.println("already exist !");

        }

        Application result = applicationRepository.save(application);
        return  ResponseEntity.created(new URI("/api/applications"+ result.getId())).header("ok!").body(result);
    }
    @PutMapping(value = "/updateapp/{id}")
    public Application UpdateApplication( @PathVariable(name = "id") Long id, @RequestBody  Application application) throws URISyntaxException {

        Optional<Application> appOptional = applicationRepository.findById(id);

        if (appOptional.isPresent()) {

            System.out.println(" exist !");

            application.setId(id);

            System.out.println(id);
        }

        return applicationRepository.save(application);
    }
    @GetMapping("/detail-app/{id}")
    public Application GetApp(@PathVariable(name ="id") Long id){
        return applicationRepository.findApplicationById(id)  ;}
     @GetMapping("/applications")
    public List<Application> GetAll(){
        return applicationRepository.findAll();
     }
}

