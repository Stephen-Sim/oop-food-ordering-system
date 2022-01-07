/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.oop.food.ordering.system;

import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class Customer {
    private int customerId;
    private String customerUsername;
    private String customerPassword;

    public Customer() {
        
    }
    
    public Customer(int customerId, String customerUsername, String customerPassword) {
        this.customerId = customerId;
        this.customerUsername = customerUsername;
        this.customerPassword = customerPassword;
    }
    
    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int foodId) {
        this.customerId = customerId;
    }

    public String getCustomerUsername() {
        return customerUsername;
    }

    public void setCustomerUsername(String customerUsername) {
        this.customerUsername = customerUsername;
    }

    public String getCustomerPassword() {
        return customerPassword;
    }

    public void setCustomerPassword(String customerPassword) {
        this.customerPassword = customerPassword;
    }
}
