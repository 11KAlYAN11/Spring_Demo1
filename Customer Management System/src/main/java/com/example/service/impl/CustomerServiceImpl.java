package com.example.service.impl;

import com.example.entity.Customer;
import com.example.repository.CustomerRepository;
import com.example.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Optional<Customer> getCustomerById(int id) {
        return customerRepository.findById(id);
    }

    @Override
    public void saveCustomer(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public void updateCustomer(int id, Customer customer) {
        customerRepository.findById(id).ifPresent(existingCustomer -> {
            existingCustomer.setName(customer.getName());
            existingCustomer.setAge(customer.getAge());
            customerRepository.save(existingCustomer);
        });
    }

    @Override
    public void deleteCustomer(int id) {
        customerRepository.deleteById(id);
    }
}