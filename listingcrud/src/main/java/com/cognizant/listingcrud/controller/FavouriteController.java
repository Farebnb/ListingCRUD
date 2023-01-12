package com.cognizant.listingcrud.controller;


import com.cognizant.listingcrud.model.Favourites;
import com.cognizant.listingcrud.repo.FavouriteRepo;
import com.cognizant.listingcrud.service.FavouriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/favourite")
@CrossOrigin(origins = "*")
public class FavouriteController {

    @Autowired
    private FavouriteRepo fr;

    @Autowired
    private FavouriteService fs;

    @Autowired
    private FavouriteController(FavouriteRepo fr, FavouriteService fs){
        this.fr = fr;
        this.fs = fs;
    }

    @GetMapping("/user")
    public ResponseEntity<List<Favourites>> getByUserId(@RequestParam int userId){
        return new ResponseEntity<>(fs.getByUserId(userId), HttpStatus.ACCEPTED);

    }

    @GetMapping("/listing")
    public ResponseEntity<List<Favourites>> getByListingId(@RequestParam int listingId){
        return new ResponseEntity<>(fs.getByListingId(listingId), HttpStatus.ACCEPTED);

    }

    @PostMapping("/create")
    public ResponseEntity<Favourites> createFavourite(@RequestParam int userId, @RequestParam int listingId){
        return new ResponseEntity<>(fs.createFavourite(userId,listingId), HttpStatus.CREATED);
    }


}
