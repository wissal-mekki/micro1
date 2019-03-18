package com.project.micro1.repositories;

import com.project.micro1.entities.Offer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OfferRepository extends JpaRepository<Offer,Long> {
}
