package com.example.banking.controller;

import com.example.banking.model.Customer;
import com.example.banking.service.CustomerService;
import com.example.banking.service.ICustomerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/customers")
public class CustomerController {
    private final ICustomerService customerService = new CustomerService();

    @GetMapping("")
    public String index(Model model) {

        List<Customer> customerList = customerService.getAllCustomer();
        model.addAttribute("customers", customerList);
        return "/index";
    }
}
