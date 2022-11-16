package com.cognizant.listingcrud.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Listing {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String address;

    private String type;

    @Column(name = "LOCATIONID")
    private int locationId;

    private double price;

    private int guests;

    private int cap;


}
