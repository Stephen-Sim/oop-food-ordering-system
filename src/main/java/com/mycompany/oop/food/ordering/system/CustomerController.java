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
    
    public void checkOrderExist(int userid){
        try
        {
            CustomerController controller = new CustomerController();
            controller.connectToDatabase();
            String sql = "SELECT COUNT(*) as 'row' FROM orders where customer_id = ? AND status = 0";
            
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, userid);
            ResultSet rs = ps.executeQuery();
            
            if(rs.next())
            {
                if(rs.getInt("row") == 0)
                {
                    String sql1 = "INSERT INTO orders (customer_id) VALUES(?)";
                    PreparedStatement ps1 = this.conn.prepareStatement(sql1);
                    ps1.setInt(1, userid);
                    ps1.execute();
                }
            }
            
        }catch (SQLException err){
            JOptionPane.showMessageDialog(null, err.getMessage());
        }
    }
    
    public Customer getCustomerDetailByid(int userid)
    {
        checkOrderExist(userid);
        Customer cus = new Customer();
        try
        {
            CustomerController controller = new CustomerController();
            controller.connectToDatabase();
            String sql = "SELECT * FROM users where id = ? limit 1";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, userid);
            ResultSet rs = ps.executeQuery();
            
            if(rs.next())
            {
                cus.setCustomerId(rs.getInt("id"));
                cus.setCustomerUsername(rs.getString("username"));
                cus.setCustomerPassword(rs.getString("password"));
            }
                
        }catch (SQLException err){
            JOptionPane.showMessageDialog(null, err.getMessage());
        }
        
        return cus;
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

    public void addCart(int userId, int food_Id, int food_quantity, String total_price) {
        try
        {
            CustomerController controller = new CustomerController();
            controller.connectToDatabase();
            String sql = "SELECT * FROM orders where customer_id = ?  and status = 0 limit 1";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, userId);
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()){
                int orderId = rs.getInt("id");
                
                String sql1 = "INSERT INTO food_order (food_id, order_id, quantity, total_price) VALUES(?, ?, ?, ?)";
                
                PreparedStatement ps1 = this.conn.prepareStatement(sql1);
                
                ps1.setInt(1, food_Id);
                ps1.setInt(2, orderId);
                ps1.setInt(3, food_quantity);
                ps1.setString(4, total_price);
                ps1.execute();
                
                JOptionPane.showMessageDialog(null, "Order Successfully Added to Cart\nTotal Price : " + total_price);
                
                // update stock
                String sql2 = "UPDATE foods f, (SELECT stock FROM foods WHERE id = ? ) fd SET f.stock = fd.stock - ? WHERE f.id = ?";
                PreparedStatement ps2 = this.conn.prepareStatement(sql2);
                ps2.setInt(1, food_Id);
                ps2.setInt(2, food_quantity);
                ps2.setInt(3, food_Id);
                ps2.execute();
            }
                
        }catch (SQLException err){
            JOptionPane.showMessageDialog(null, err.getMessage());
        }
    }
}
