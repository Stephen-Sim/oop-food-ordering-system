/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.oop.food.ordering.system;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Admin
 */
public class CustomerController extends Controller {
    public void connectToDatabase() {
        try{
            this.conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/food_ordering_system", "root", "");
        }
        catch (SQLException err){
            JOptionPane.showMessageDialog(null, err.getMessage());
        }
    }
    
    public ArrayList<Customer> fetchAll()
    {
        ArrayList <Customer> customerList = new ArrayList();
        try
        {
            CustomerController controller = new CustomerController();
            controller.connectToDatabase();
            String sql = "SELECT * FROM users";
           
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next())
            {
                Customer customer = new Customer();
                customer.setCustomerId(rs.getInt("id"));
                customer.setCustomerUsername(rs.getString("username"));
                customer.setCustomerPassword(rs.getString("password"));

                
                customerList.add(customer);
            }
        }catch (SQLException err){
            JOptionPane.showMessageDialog(null, err.getMessage());
        }
        
        return customerList;
    }
}
