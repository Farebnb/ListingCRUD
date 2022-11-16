package com.cognizant.listingcrud.repo;

import com.cognizant.listingcrud.model.Listing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ListingRepo extends JpaRepository<Listing, Integer> {

    Listing findById(int id);

    List<Listing> findAll();



}
