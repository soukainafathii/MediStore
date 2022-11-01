package com.example.medistore.service.impl;
import com.example.medistore.dao.CustomerRepository;
import com.example.medistore.model.Customer;
import com.example.medistore.service.CustomerService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;



//initialize and close the mockito
@RunWith(SpringRunner.class)
@SpringBootTest
//@Rollback(false)
class CustomerServiceImplTest {

    @MockBean
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerService underTest;

    @Mock
    private Customer customer;


    @Test
    void canGetCustomers() {
        //Given
        //When
        underTest.getCustomers();
        //Then
        verify(customerRepository).findAll();
    }

    @Test
    void canGetCustomerById() {
        //Given
        long id=1;
        //When
        underTest.getCustomerById(id);
        //Then
        verify(customerRepository).findById(id);
    }


    @Test
    void canGetCustomerByName() {
        //Given
        String name="soukaina";
        //When
        underTest.getCustomerByName(name);
        //Then
        verify(customerRepository).findByName(name);
    }

    @Test
    void canAddCustomer() {
        //given
        /*
        Customer customer1= new Customer();
        customer.setId(1);
        customer.setName("lina");
        customer.setAddress("sect A rabat");
        customer.setPhone(0676537366);
        customer.setUsername("lina fathi");
        customer.setPassword("iamlina");*/

        //when
        underTest.addCustomer(customer);
        ArgumentCaptor<Customer> customerArgumentCaptor = ArgumentCaptor.forClass(Customer.class);

        //then
        verify(customerRepository).save(customerArgumentCaptor.capture());
        Customer capturedCustomer = customerArgumentCaptor.getValue();
        assertThat(capturedCustomer).isEqualTo(customer);
    }

    @Captor
    private ArgumentCaptor<List<Customer>> customersCaptor;

    @Test
    void canAddCustomers() {
        //given
        Customer customer1= new Customer();
        /*
        customer1.setId(1);
        customer1.setName("lina");
        customer1.setAddress("sect A rabat");
        customer1.setPhone(0676537366);
        customer1.setUsername("lina fathi");
        customer1.setPassword("iamlina");
        */

        Customer customer2= new Customer();
        /*
        customer2.setId(2);
        customer2.setName("halla");
        customer2.setAddress("sect B sale");
        customer2.setPhone(0676537366);
        customer2.setUsername("halla fathi");
        customer2.setPassword("iamhalla");
        */

        List<Customer> customers = new ArrayList<>();
        customers.add(customer1);
        customers.add(customer2);

        //when
        underTest.addCustomers(customers);

        //then
        verify(customerRepository).saveAll(customersCaptor.capture());
        List<Customer> capturedCustomer = customersCaptor.getValue();
        assertThat(capturedCustomer).isEqualTo(customers);
    }



    @Test
    void canDeleteCustomer() {
        //Given
        long id=1;

        //When
        underTest.deleteCustomer(id);

        //Then
        verify(customerRepository).deleteById(id);

    }

    @Captor
    ArgumentCaptor CustomerCaptorForUpdate;

    @Test
    void canUpdateCustomer() {

        underTest.updateCustomer(customer);

        //then
        verify(customerRepository, times(1)).save(customer);
    }
}