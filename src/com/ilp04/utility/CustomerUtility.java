package com.ilp04.utility;

import java.util.ArrayList;
import java.util.Scanner;

import com.ilp04.entity.Customer;
import com.ilp04.service.CustomerService;
import com.ilp04.service.CustomerServiceImpl;

public class CustomerUtility {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CustomerService customerService = new CustomerServiceImpl();
        char continueChoice;
        
        do {
            System.out.println("1. Display All Customers\n2. Insert New Customer\n3. Update Existing Customer");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline
            
            switch (choice) {
                case 1:
                    getAllCustomers(customerService);
                    break;
                case 2:
                    insertNewCustomer(customerService, scanner);
                    break;
                case 3:
                    updateExistingCustomer(customerService, scanner);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
            
            System.out.println("Do you want to continue? (y/n)");
            continueChoice = scanner.next().charAt(0);
        } while (continueChoice == 'y');
        
        scanner.close();
    }

    private static void getAllCustomers(CustomerService customerService) {
        ArrayList<Customer> customerList = customerService.getAllCustomers();
        // Print the details of customer list
        for (Customer customer : customerList) {
            System.out.println("Customer Code : " + customer.getCustomerCode());
            System.out.println("First Name : " + customer.getCustomerFirstName());
            System.out.println("Last Name : " + customer.getCustomerLastName());
            System.out.println("Address : " + customer.getAddress());
            System.out.println("Phone Number : " + customer.getPhNumber());
            System.out.println("Aadhar Number : " + customer.getAadharNo() + "\n");
        }
    }

    private static void insertNewCustomer(CustomerService customerService, Scanner scanner) {
        System.out.println("Enter Customer Code: ");
        int customerCode = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        System.out.println("Enter Customer First Name: ");
        String customerFirstName = scanner.nextLine();

        System.out.println("Enter Customer Last Name: ");
        String customerLastName = scanner.nextLine();

        System.out.println("Enter Address: ");
        String address = scanner.nextLine();

        System.out.println("Enter Phone Number: ");
        long phNumber = scanner.nextLong();
        scanner.nextLine();  // Consume newline

        System.out.println("Enter Aadhar Number: ");
        long aadharNo = scanner.nextLong();
        scanner.nextLine();  // Consume newline

        Customer customer = new Customer(customerCode, customerFirstName, customerLastName, address, phNumber, aadharNo);
        int result = customerService.insertIntoCustomer(customer);
        
        if (result > 0) {
            System.out.println("Customer inserted successfully.");
        } else {
            System.out.println("Failed to insert customer.");
        }
    }
    
    private static void updateExistingCustomer(CustomerService customerService, Scanner scanner) {
        System.out.println("Enter Customer Code of the customer to update: ");
        int customerCode = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        char continueUpdate;
        do {
            System.out.println("Select the field to update:\n1. First Name\n2. Last Name\n3. Address\n4. Phone Number\n5. Aadhar Number");
            int fieldChoice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (fieldChoice) {
                case 1:
                    System.out.println("Enter Updated First Name: ");
                    String customerFirstName = scanner.nextLine();
                    customerService.updateCustomerFirstName(customerCode, customerFirstName);
                    break;
                case 2:
                    System.out.println("Enter Updated Last Name: ");
                    String customerLastName = scanner.nextLine();
                    customerService.updateCustomerLastName(customerCode, customerLastName);
                    break;
                case 3:
                    System.out.println("Enter Updated Address: ");
                    String address = scanner.nextLine();
                    customerService.updateCustomerAddress(customerCode, address);
                    break;
                case 4:
                    System.out.println("Enter Updated Phone Number: ");
                    long phNumber = scanner.nextLong();
                    scanner.nextLine();  // Consume newline
                    customerService.updateCustomerPhNumber(customerCode, phNumber);
                    break;
                case 5:
                    System.out.println("Enter Updated Aadhar Number: ");
                    long aadharNo = scanner.nextLong();
                    scanner.nextLine();  // Consume newline
                    customerService.updateCustomerAadharNo(customerCode, aadharNo);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }

            System.out.println("Do you want to update another field? (y/n)");
            continueUpdate = scanner.next().charAt(0);
            scanner.nextLine();  // Consume newline
        } while (continueUpdate == 'y');
    }
}
