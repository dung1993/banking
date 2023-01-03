package com.example.banking.service;

import com.example.banking.model.Customer;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerService extends DatabaseContent implements ICustomerService{

    @Override
    public List<Customer> getAllCustomer() {
        List<Customer> customers = new ArrayList<>();
        try{
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("Select * from customers;");
            ResultSet rs = preparedStatement.executeQuery();

                while (rs.next()){
                    Customer customer = getCustomerFromResultSet(rs);
                    customers.add(customer);
                }
                connection.close();
        }catch (SQLException e){
            printSQLException(e);
        }
        return customers;
    }

    private Customer getCustomerFromResultSet(ResultSet rs) throws SQLException {

        long id = rs.getLong("id");
        String name = rs.getString("name");
        String email = rs.getString("email");
        String phone = rs.getString("phone");
        String address = rs.getString("address");
        BigDecimal balance = rs.getBigDecimal("price");


        Customer customer = new Customer(id, name, email, phone, address, balance);
        return customer;
    }

    @Override
    public List<Customer> getAllCustomersByKw(String kw) {
        List<Customer> customers = new ArrayList<>();
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select * from customers where full_name like ?;");
            preparedStatement.setString(1,"%" + kw + "%");

            System.out.println(this.getClass() + "getAllCustomerByKw" + preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                Customer customer = getCustomerFromResultSet(rs);
                customers.add(customer);
            }
            connection.close();
        }catch (SQLException e){
            printSQLException(e);
        }
        return customers;
    }

    @Override
    public List<Customer> getAllCustomersByKwAndIdPaging(String kw, long id, int page, int numberOfPage) {

        return null;
    }

    @Override
    public void addCustomer(Customer customer) {

    }

    @Override
    public Customer findCustomerById(long id) {
        return null;
    }

    @Override
    public void updateCustomer(Customer customer) {

    }

    @Override
    public void deleteCustomer(long id) {

    }

    @Override
    public List<Customer> getAllCustomerByIdBrand(long id) {
        return null;
    }

    @Override
    public int getNoOfRecords() {
        return 0;
    }
}
