package com.example.service;

import com.example.entity.Customer;
import java.util.List;
import java.util.Optional;

public interface CustomerService {
    List<Customer> getAllCustomers();
    Optional<Customer> getCustomerById(int id);
    void saveCustomer(Customer customer);
    void updateCustomer(int id, Customer customer);
    void deleteCustomer(int id);
}