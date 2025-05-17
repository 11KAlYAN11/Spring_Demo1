package com.example.controller;

import com.example.entity.Customer;
import com.example.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping
    public String listCustomers(Model model) {
        model.addAttribute("customers", customerService.getAllCustomers());
        model.addAttribute("customer", new Customer());
        return "customers";
    }

    @PostMapping
    public String addCustomer(@RequestParam String name, @RequestParam int age) {
        Customer customer = new Customer(name, age);
        customerService.saveCustomer(customer);
        return "redirect:/customers";
    }

    @PutMapping("/{id}")
    public String updateCustomer(@PathVariable int id, @RequestParam String name, @RequestParam int age) {
        Customer updatedCustomer = new Customer(name, age);
        customerService.updateCustomer(id, updatedCustomer);
        return "redirect:/customers";
    }

    @DeleteMapping("/{id}")
    public String deleteCustomer(@PathVariable int id) {
        customerService.deleteCustomer(id);
        return "redirect:/customers";
    }
}

@Controller
class HomeController {

    @GetMapping("/")
    public String home() {
        return "home";
    }
}