package com.cognizant.listingcrud.repo;

import com.cognizant.listingcrud.model.Favourites;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FavouriteRepo extends JpaRepository<Favourites, Integer> {

    List<Favourites> findByUserId(int userId);

    List<Favourites> findByListingId(int listingId);





}