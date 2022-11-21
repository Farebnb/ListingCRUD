package com.cognizant.listingcrud.controller;


import com.cognizant.listingcrud.model.Listing;
import com.cognizant.listingcrud.repo.ListingRepo;
import com.cognizant.listingcrud.service.ListingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/listing")
@CrossOrigin(origins = "*")
public class ListingController {

    @Autowired
    private ListingRepo lr;

    @Autowired
    private ListingService ls;

    @Autowired
    private ListingController(ListingRepo lr, ListingService ls){
        this.lr = lr;
        this.ls = ls;
    }

    @GetMapping("/")
    public ResponseEntity<Listing> getById(@RequestParam int id){
        return new ResponseEntity<>(ls.getById(id), HttpStatus.ACCEPTED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Listing>> getAll(){
        return new ResponseEntity<>(ls.getAll(),HttpStatus.ACCEPTED);
    }


    @PutMapping("/update")
    public ResponseEntity<Listing> update(@RequestBody Listing listing){
        return new ResponseEntity<Listing>(ls.update(listing), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Listing> deleteListing(@RequestParam int id ){
        Listing list = ls.getById(id);
        if (list == null) {
            return ResponseEntity.notFound().build();
        }
        ls.delete(id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @GetMapping("/locationId")
    public ResponseEntity<List<Listing>> getByLocationId(@RequestParam int locationId){
        return new ResponseEntity<>(ls.getByLocationId(locationId), HttpStatus.ACCEPTED);
    }

    @PostMapping("/create")
    public ResponseEntity<Listing> createListing(@RequestBody LinkedHashMap<String, String> body){
        double p = Double.parseDouble(body.get("price"));
        int guest = Integer.parseInt(body.get("guests"));
        int caps = Integer.parseInt(body.get("cap"));
        int lId = Integer.parseInt(body.get("locationId"));
        return new ResponseEntity<>(ls.createListing(body.get("title"),body.get("address"),body.get("type"),lId, body.get("image"), p, guest, caps, Integer.parseInt(body.get("rating"))  ), HttpStatus.ACCEPTED);
    }
}
