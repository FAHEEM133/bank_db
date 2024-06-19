package com.ilp04.service;

import java.util.ArrayList;

import com.ilp04.entity.Customer;

public interface CustomerService {
	public ArrayList<Customer> getAllCustomers();
	public int insertIntoCustomer(Customer customer);
 	int updateCustomerFirstName(int customerCode, String customerFirstName);
    int updateCustomerLastName(int customerCode, String customerLastName);
    int updateCustomerAddress(int customerCode, String address);
    int updateCustomerPhNumber(int customerCode, long phNumber);
    int updateCustomerAadharNo(int customerCode, long aadharNo);
}
