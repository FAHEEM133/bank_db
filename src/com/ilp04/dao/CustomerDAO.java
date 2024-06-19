package com.ilp04.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.ilp04.entity.Customer;

public class CustomerDAO {
    // get connection
    public Connection getConnection() {
        String connectionURL = "jdbc:mysql://localhost:3306/bankdb?useSSL=false";
        String userName = "root";
        String password = "experion@123";
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(connectionURL, userName, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    // close connection
    public void closeConnection(Connection connection) {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // get all customer details
    public ArrayList<Customer> getAllCustomers(Connection connection) {
        ArrayList<Customer> customerList = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM customer");
            while (resultSet.next()) {
                int customerCode = resultSet.getInt(1);
                String customerFirstname = resultSet.getString(2);
                String customerLastname = resultSet.getString(3);
                String address = resultSet.getString(4);
                long phNumber = resultSet.getLong(5);
                long aadharNo = resultSet.getLong(6);
                Customer customer = new Customer(customerCode, customerFirstname, customerLastname, address, phNumber, aadharNo);
                customerList.add(customer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customerList;
    }

    // insert new customer
    public int insertIntoCustomer(Connection connection, Customer customer) {
        int result = 0;
        try {
            String query = "INSERT INTO customer (customer_code, customer_firstname, customer_lastname, address, phonenum, aadhar_card_no) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, customer.getCustomerCode());
            preparedStatement.setString(2, customer.getCustomerFirstName());
            preparedStatement.setString(3, customer.getCustomerLastName());
            preparedStatement.setString(4, customer.getAddress());
            preparedStatement.setLong(5, customer.getPhNumber());
            preparedStatement.setLong(6, customer.getAadharNo());
            result = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
    
    //Updating specific fields of customer table.
    public int updateCustomerFirstName(Connection connection, int customerCode, String customerFirstName) {
        return updateCustomerField(connection, customerCode, "customer_firstname", customerFirstName);
    }

    public int updateCustomerLastName(Connection connection, int customerCode, String customerLastName) {
        return updateCustomerField(connection, customerCode, "customer_lastname", customerLastName);
    }

    public int updateCustomerAddress(Connection connection, int customerCode, String address) {
        return updateCustomerField(connection, customerCode, "address", address);
    }

    public int updateCustomerPhNumber(Connection connection, int customerCode, long phNumber) {
        return updateCustomerField(connection, customerCode, "phonenum", phNumber);
    }

    public int updateCustomerAadharNo(Connection connection, int customerCode, long aadharNo) {
        return updateCustomerField(connection, customerCode, "aadhar_card_no", aadharNo);
    }

    private int updateCustomerField(Connection connection, int customerCode, String fieldName, Object fieldValue) {
        int result = 0;
        String query = "UPDATE customer SET " + fieldName + " = ? WHERE customer_code = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setObject(1, fieldValue);
            preparedStatement.setInt(2, customerCode);
            result = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}
