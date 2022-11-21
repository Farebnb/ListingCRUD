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

    public List<Listing> getByLocationId(int locationId){
        return lr.findByLocationId(locationId);
    }

    public Listing createListing(String address, String type, int locationId,String image, double price, int guests, int cap){
        Listing l = new Listing(0,address,type,locationId,image,price,guests,cap);
        return lr.save(l);
    }

}
