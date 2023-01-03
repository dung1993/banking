package com.example.banking.service;

import com.example.banking.model.Customer;

import java.util.ArrayList;
import java.util.List;

public interface ICustomerService {
    List<Customer> getAllCustomer();

    List<Customer> getAllCustomersByKw(String kw);
    List<Customer> getAllCustomersByKwAndIdPaging(String kw, long id, int page, int numberOfPage);
    void addCustomer(Customer customer);
    Customer findCustomerById(long id);
    void updateCustomer(Customer customer);
    void deleteCustomer(long id);

    List<Customer> getAllCustomerByIdBrand(long id);

    int getNoOfRecords();

}
