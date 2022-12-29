package com.example.banking.service;

import com.example.banking.model.Customer;

import java.util.List;

public class CustomerService extends DatabaseContent implements ICustomerService{

    @Override
    public List<Customer> getAllCustomer() {
        return null;
    }

    @Override
    public List<Customer> getAllProductsByKwAndId(String kw, long id) {
        return null;
    }

    @Override
    public List<Customer> getAllProductsByKwAndIdBrandPaging(String kw, long id, int page, int numberOfPage) {
        return null;
    }

    @Override
    public void addProduct(Customer customer) {

    }

    @Override
    public Customer findProductById(long id) {
        return null;
    }

    @Override
    public void updateProduct(Customer customer) {

    }

    @Override
    public void deleteProduct(long id) {

    }

    @Override
    public List<Customer> getAllProductByIdBrand(long id) {
        return null;
    }

    @Override
    public int getNoOfRecords() {
        return 0;
    }
}
