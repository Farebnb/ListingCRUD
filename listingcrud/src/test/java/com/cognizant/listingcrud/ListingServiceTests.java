package com.cognizant.listingcrud;

import com.cognizant.listingcrud.model.Listing;
import com.cognizant.listingcrud.repo.ListingRepo;
import com.cognizant.listingcrud.service.ListingService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest(classes = ListingcrudApplication.class)
@AutoConfigureMockMvc
public class ListingServiceTests {

    @MockBean
    ListingRepo lr;

    @Autowired
    ListingService ls = new ListingService(lr);

    @Test
    public void getByIdTest() {

        Listing testList = new Listing(1, "abcd", "h", 2, 100.00, 4, 5);
        when((lr).findById(anyInt())).thenReturn(testList);
        Listing result = ls.getById(1);
        assertEquals(testList.getId(),result.getId(),"pass");

    }
    @Test
    public void getAllTest(){
        List<Listing> listings = new ArrayList<>();
        Listing testList = new Listing(1, "abcd", "h", 2, 100.00, 4, 5);
        listings.add(testList);
        when((lr).findAll()).thenReturn(listings);
        List<Listing> result = ls.getAll();
        assertEquals(testList.getId(), result.get(0).getId(),"pass");
    }

    @Test
    public void getByLocationIdTest() {
        List<Listing> listings = new ArrayList<>();
        Listing testList = new Listing(1, "abcd", "h", 2, 100.00, 4, 5);
        listings.add(testList);
        when((lr).findByLocationId(anyInt())).thenReturn(listings);
        List<Listing> result = ls.getByLocationId(2);
        assertEquals(testList.getLocationId(),result.get(0).getLocationId(), "pass");
    }
    @Test
    public void createListingTest() {

        Listing testList = new Listing(1, "abcd", "h", 2, 100.00, 4, 5);
        when(lr.save(any())).thenReturn(testList);
        Listing result = ls.createListing("abcd","h",2,100.00,4,5);
        assertEquals(testList.getId(), result.getId(), "pass");
    }

    @Test
    public void deleteListingTest(){
        doNothing().when(lr).deleteById(anyInt());
        ls.delete(1);
        verify(lr).deleteById(anyInt());

    }

    @Test
    public void updateListingTest(){
        Listing testList = new Listing(1, "abcd", "h", 2, 100.00, 4, 5);
        when((lr).saveAndFlush(any())).thenReturn(testList);
        Listing result = ls.update(testList);
        assertEquals(testList.getId(),result.getId(),"pass");
        assertEquals(testList.getAddress(),result.getAddress(),"pass");
    }
}


