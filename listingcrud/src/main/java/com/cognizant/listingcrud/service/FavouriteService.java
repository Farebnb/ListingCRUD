package com.cognizant.listingcrud.service;


import com.cognizant.listingcrud.model.Favourites;
import com.cognizant.listingcrud.repo.FavouriteRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FavouriteService {

    private final FavouriteRepo fr;

    public FavouriteService(FavouriteRepo fr){
        this.fr = fr;
    }

    public List<Favourites> getByUserId(int userId){
        return fr.findByUserId(userId);
    }

    public List<Favourites> getByListingId(int listingId){
        return fr.findByListingId(listingId);
    }

    public Favourites createFavourite(int userId, int listingId){
        Favourites f = new Favourites(0, userId,listingId);
        return fr.save(f);
    }

}
