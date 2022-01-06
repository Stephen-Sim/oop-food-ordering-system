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
 * @author USER
 */
public class OrderController extends Controller{
    public void connectToDatabase() {
        try{
            this.conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/food_ordering_system", "root", "");
        }
        catch (SQLException err){
            JOptionPane.showMessageDialog(null, err.getMessage());
        }
    }
    
    public ArrayList<Order> fetchAll()
    {
        ArrayList <Order> orderList = new ArrayList();
        try
        {
            OrderController controller = new OrderController();
            controller.connectToDatabase();
            String sql = "SELECT orders.*, users.username FROM orders Left JOIN users ON orders.customer_id = users.id;";
           
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next())
            {
                Order order = new Order();
                order.setOrderId(rs.getInt("id"));
                order.setCustomerName(rs.getString("username"));
                order.setOrderTotalPrice(rs.getFloat("total_Price"));
                order.setOrderTime(rs.getTimestamp("transaction_time").toString());
                
                orderList.add(order);
            }
        }catch (SQLException err){
            JOptionPane.showMessageDialog(null, err.getMessage());
        }
        
        return orderList;
    }

    public String getFoodOrderByOrderId(int orderId) {
        String info = "";
        int i = 0;
        
        System.out.println(orderId);
        try
        {
            OrderController controller = new OrderController();
            controller.connectToDatabase();
            String sql = "SELECT foods.name, food_order.quantity, food_order.total_price FROM orders LEFT JOIN food_order ON orders.id = food_order.order_id LEFT JOIN foods ON foods.id = food_order.food_id WHERE orders.id = ?";
           
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, orderId);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next())
            {
                i++;
                info += (i + ". " + rs.getString("name")); 
                info += ("\n    Quantity: " + rs.getString("quantity"));
                info += ("\n    Total Price(RM): " + rs.getString("total_price") + "\n\n"); 
            }
        }catch (SQLException err){
            JOptionPane.showMessageDialog(null, err.getMessage());
        }
        
        return info;
    }
}
