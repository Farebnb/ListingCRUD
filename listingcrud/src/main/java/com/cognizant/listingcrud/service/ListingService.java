package com.cognizant.listingcrud.service;

import com.cognizant.listingcrud.model.Listing;
import com.cognizant.listingcrud.repo.ListingRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListingService {

    private final ListingRepo lr;

    public ListingService(ListingRepo lr){
        this.lr = lr;
    }

    public Listing getById(int id){
        return lr.findById(id);
    }

    public List<Listing> getAll() {return lr.findAll();}

    public void delete(int id) {

        lr.deleteById(id);
    }

    public Listing update(Listing l){
        return lr.saveAndFlush(l);
    }

}
