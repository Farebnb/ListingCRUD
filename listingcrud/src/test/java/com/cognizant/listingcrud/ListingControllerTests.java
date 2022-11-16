package com.cognizant.listingcrud;


import com.cognizant.listingcrud.model.Listing;
import com.cognizant.listingcrud.repo.ListingRepo;
import com.cognizant.listingcrud.service.ListingService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import javax.transaction.Transactional;

import java.util.LinkedHashMap;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = ListingcrudApplication.class)
@AutoConfigureMockMvc
@AutoConfigureTestDatabase
public class ListingControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ListingService ls;

    @Autowired
    private ListingRepo lr;

    private ObjectMapper om = new ObjectMapper();

    @Test
    @Transactional
    public void getByIdTest() throws Exception {
        mockMvc.perform(get("/listing/?id=1"))
                .andDo(print())
                .andExpect(status().isAccepted())
                .andExpect(jsonPath("$.id").value(1));

    }

    @Test
    @Transactional
    public void getAllTest() throws Exception {

        mockMvc.perform(get("/listing/all"))
                .andDo(print())
                .andExpect(status().isAccepted());
    }

    @Test
    @Transactional
    public void getByLocationIdTest() throws Exception{

        mockMvc.perform(get("/listing/locationId/?locationId=2"))
                .andDo(print())
                .andExpect(status().isAccepted());



    }
    @Test
    @Transactional
    public void createListingTest() throws Exception{

        LinkedHashMap<String,String> listingBody = new LinkedHashMap<>();
        listingBody.put("address","abcd");
        listingBody.put("type","h");
        listingBody.put("locationId","2");
        listingBody.put("price","100.00");
        listingBody.put("guests","4");
        listingBody.put("cap","5");
        mockMvc.perform(post("/listing/create").contentType(MediaType.APPLICATION_JSON)
                .content(om.writeValueAsString(listingBody)))
                .andDo(print())
                .andExpect(status().isAccepted());
    }

    @Test
    @Transactional
    public void deleteListingTest() throws Exception{
        mockMvc.perform(delete("/listing/delete/?id=1"))
                .andDo(print())
                .andExpect(status().isAccepted());
    }

    @Test
    @Transactional
    public void updateListingTest() throws Exception{
      Listing l = new Listing(1,"a","a",3,100.00,2,5);

      mockMvc.perform(put("/listing/update").contentType(MediaType.APPLICATION_JSON)
              .content(om.writeValueAsString(l)))
              .andDo(print())
              .andExpect(status().isAccepted());
    }


}
