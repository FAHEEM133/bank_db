package com.ilp04.service;

import java.sql.Connection;
import java.util.ArrayList;

import com.ilp04.dao.CustomerDAO;
import com.ilp04.entity.Customer;

public class CustomerServiceImpl implements CustomerService {
    @Override
    public ArrayList<Customer> getAllCustomers() {
        ArrayList<Customer> customerList = new ArrayList<>();
        CustomerDAO customerDAO = new CustomerDAO();
        Connection connection = customerDAO.getConnection();
        customerList = customerDAO.getAllCustomers(connection);
        customerDAO.closeConnection(connection);
        return customerList;
    }

    @Override
    public int insertIntoCustomer(Customer customer) {
        CustomerDAO customerDAO = new CustomerDAO();
        Connection connection = customerDAO.getConnection();
        int result = customerDAO.insertIntoCustomer(connection, customer);
        customerDAO.closeConnection(connection);
        return result;
    }

    @Override
    public int updateCustomerFirstName(int customerCode, String customerFirstName) {
        CustomerDAO customerDAO = new CustomerDAO();
        Connection connection = customerDAO.getConnection();
        int result = customerDAO.updateCustomerFirstName(connection, customerCode, customerFirstName);
        customerDAO.closeConnection(connection);
        return result;
    }

    @Override
    public int updateCustomerLastName(int customerCode, String customerLastName) {
        CustomerDAO customerDAO = new CustomerDAO();
        Connection connection = customerDAO.getConnection();
        int result = customerDAO.updateCustomerLastName(connection, customerCode, customerLastName);
        customerDAO.closeConnection(connection);
        return result;
    }

    @Override
    public int updateCustomerAddress(int customerCode, String address) {
        CustomerDAO customerDAO = new CustomerDAO();
        Connection connection = customerDAO.getConnection();
        int result = customerDAO.updateCustomerAddress(connection, customerCode, address);
        customerDAO.closeConnection(connection);
        return result;
    }

    @Override
    public int updateCustomerPhNumber(int customerCode, long phNumber) {
        CustomerDAO customerDAO = new CustomerDAO();
        Connection connection = customerDAO.getConnection();
        int result = customerDAO.updateCustomerPhNumber(connection, customerCode, phNumber);
        customerDAO.closeConnection(connection);
        return result;
    }

    @Override
    public int updateCustomerAadharNo(int customerCode, long aadharNo) {
        CustomerDAO customerDAO = new CustomerDAO();
        Connection connection = customerDAO.getConnection();
        int result = customerDAO.updateCustomerAadharNo(connection, customerCode, aadharNo);
        customerDAO.closeConnection(connection);
        return result;
    }
}
