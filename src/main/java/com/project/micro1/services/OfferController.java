package com.project.micro1.services;


import com.project.micro1.entities.Offer;
import com.project.micro1.repositories.OfferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
@CrossOrigin(origins = "*")
@RequestMapping("/api")
@RestController
public class OfferController {

    @Autowired
    private OfferRepository offerRepository ;

    public OfferController(OfferRepository offerRepository){

        this.offerRepository=offerRepository;

    }


    @PostMapping("/offer")
    public ResponseEntity<Offer> CreateApplication(@Valid @RequestBody Offer offer) throws URISyntaxException {


        Offer result = offerRepository.save(offer);
        return  ResponseEntity.created(new URI("/api/offers"+ result.getId())).header("ok!").body(result);
    }

@GetMapping("/offers")
 public List<Offer> GetOffers(){

        return offerRepository.findAll();
}

}
