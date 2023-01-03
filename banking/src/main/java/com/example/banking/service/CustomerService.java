package com.example.banking.service;

import com.example.banking.model.Customer;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerService extends DatabaseContent implements ICustomerService{

    private int noOfRecords;
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
    public void addCustomer(Customer customer) {
        try{
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("insert into customers(full_name, email, phone, address, balance) values (?,?,?,?,?);");
            preparedStatement.setString(1,customer.getFullName());
            preparedStatement.setString(2,customer.getEmail());
            preparedStatement.setString(3,customer.getPhone());
            preparedStatement.setString(4,customer.getAddress());
            preparedStatement.setBigDecimal(5,customer.getBalance());

            preparedStatement.executeUpdate();
            connection.close();
        }catch (SQLException e){
            printSQLException(e);
        }
    }

    @Override
    public Customer findCustomerById(long id) {
        try {
            Connection connection = getConnection();
            Statement statement = connection.createStatement();
            String query = "select * from customers where id = ?;" + id;
            ResultSet rs = statement.executeQuery(query);
                while (rs.next()){
                    Customer customer = getCustomerFromResultSet(rs);
                    return customer;
                }
                connection.close();
        }catch (SQLException e){
            printSQLException(e);
        }
        return null;
    }

    @Override
    public void updateCustomer(Customer customer) {
        try {
            
        }
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
