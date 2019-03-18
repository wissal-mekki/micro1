package com.project.micro1.services;


import com.project.micro1.entities.Offer;
import com.project.micro1.repositories.OfferRepository;
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
public class OfferController {

    @Autowired
    private OfferRepository offerRepository ;

    public OfferController(OfferRepository offerRepository){

        this.offerRepository=offerRepository;

    }


    @PostMapping("/offers")
    public ResponseEntity<Offer> CreateApplication(Offer offer ) throws URISyntaxException {
        if(offer.getId() != null) {

            System.out.println("eeee");

        }

        Offer result = offerRepository.save(offer);
        return  ResponseEntity.created(new URI("/api/offers"+ result.getId())).header("ok!").body(result);
    }

@GetMapping("/offers")
 public List<Offer> GetOffers(){

        return offerRepository.findAll();
}

}
