package com.example.banking.service;

import com.example.banking.model.Customer;

import java.util.ArrayList;
import java.util.List;

public interface ICustomerService {
    List<Customer> getAllCustomer();

    List<Customer> getAllProductsByKwAndId(String kw, long id);
    List<Customer> getAllProductsByKwAndIdBrandPaging(String kw, long id, int page, int numberOfPage);
    void addProduct(Customer customer);
    Customer findProductById(long id);
    void updateProduct(Customer customer);
    void deleteProduct(long id);

    List<Customer> getAllProductByIdBrand(long id);

    int getNoOfRecords();

}
