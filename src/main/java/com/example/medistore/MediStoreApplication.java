package com.example.medistore;

import com.example.medistore.controller.MedicineController;
import com.example.medistore.model.Customer;
import com.example.medistore.service.CustomerService;
import com.example.medistore.service.impl.CustomerServiceImpl;
import com.example.medistore.service.impl.MedicineServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Arrays;
import java.util.Map;


@SpringBootApplication
@EnableAspectJAutoProxy
@EntityScan({"com.example.medistore.model"})
public class MediStoreApplication {

    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(MediStoreApplication.class, args);


        CustomerServiceImpl customerServiceImpl = applicationContext.getBean(CustomerServiceImpl.class);
        //System.out.println(customerServiceImpl.getData());
        //customerServiceImpl.setData("customer data");


        MedicineServiceImpl medicineServiceImpl = applicationContext.getBean(MedicineServiceImpl.class);
        medicineServiceImpl.setData("medicine data");


        //consommer api using rest template
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8080/customers/id-{id}";
        long id= 1;
        Customer customer = restTemplate.getForObject(url, Customer.class, id);
        System.out.println("cstomer is : " +customer);



        //call du method getMedicine by id du medicine controller
        /*
        MedicineController medicineController = applicationContext.getBean(MedicineController.class);
        long medicineId=1;
        System.out.println("medicine is : "+medicineController.getMedicineById(medicineId));
         */


    }

    //consommer api using WebClient
    @Bean
    public WebClient.Builder webClientBuilder(){
        return WebClient.builder();
    }
}