package com.example.medistore.controller;

import com.example.medistore.model.Customer;
import com.example.medistore.service.CustomerService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.*;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.ServletContext;
import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


/*@WebAppConfiguration*
@RunWith(SpringRunner.class)*/
@SpringBootTest
@AutoConfigureMockMvc
//@WebMvcTest
class CustomerControllerTest {

    @Autowired
    CustomerController customerController;

    @Autowired
    private MockMvc mockMvc;

   /* @Mock
    private CustomerService customerService;*/

    @Autowired
    ObjectMapper objectMapper;



    @Test
    void canGetCustomerById() throws Exception {

        this.mockMvc
                .perform(get("/customers/id-{id}", "1").contentType(MediaType.APPLICATION_JSON))
                .andDo(print()).andExpect(status().isOk())
                //.andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.name").value("nawal"));

    }
/*
    @Test
    void shouldAddCustomer() throws Exception{
        String addURI = "https://localhost:8080/customers/";
        HttpHeaders headers = new HttpHeaders();
        headers.add("Accept", "application/json");
        headers.add("Content-Type", "application/json");
        String jsonBody = "{\"name\":\"siham\",\"address\":\"sect C fes\",\"phone\":\"0676537366\",\"phone\":\"0676537366\"" +
                ",\"username\":\"nawal fathi\",\"password\":\"iamnawal\"}";
        HttpEntity<String> entity = new HttpEntity<String>(jsonBody, headers);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response =restTemplate.postForEntity(addURI, entity, String.class);
        Assert.assertEquals(response.getStatusCode(), HttpStatus.OK);
    }*/


    @Test
    void addCustomer() throws Exception {
        // mock the user data that we have to save
        Customer customer= new Customer();
        //customer.setId(3);
        customer.setName("siham");
        customer.setAddress("sect C fes");
        customer.setPhone(0676537366);
        customer.setUsername("nawal fathi");
        customer.setPassword("iamnawal");

       // when(customerController.addCustomer(customer)).thenReturn(customer);

        //mock request "/"
         mockMvc.perform(post("/customers/")
                         .contentType(MediaType.APPLICATION_JSON)
                    .content(objectMapper.writeValueAsString(customer))
                 )
                 .andDo(print()).andExpect(status().isOk())
                 .andExpect(jsonPath("$.name").value("siham"));
    }


    @Test
    @Disabled
    void addCustomers() {
    }

    @Test
    @Disabled
    void getCustomers() {
    }



    @Test
    @Disabled
    void getCustomerByName() {
    }

    @Test
    @Disabled
    void updateCustomer() {
    }

    @Test
    @Disabled
    void deleteCustomer() {
    }
}