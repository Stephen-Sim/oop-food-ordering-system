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
            String sql = "SELECT orders.*, users.username FROM orders Left JOIN users ON orders.customer_id = users.id where orders.status = 1";
           
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
    
     public ArrayList<Order> fetchCart(int userId)
    {
        ArrayList <Order> orderList = new ArrayList();
        try
        {
            FoodController controller = new FoodController();
            controller.connectToDatabase();
            String sql = "SELECT fo.food_id, fo.order_id, f.NAME, fo.total_price, fo.quantity FROM food_order fo LEFT JOIN foods f ON fo.food_id = f.id LEFT JOIN orders o ON fo.order_id = o.id WHERE o.customer_id = ? AND o.status = 0;";
           
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, userId);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next())
            {
                Order order = new Order();
                order.setFoodId(rs.getInt("food_id"));
                order.setOrderId(rs.getInt("order_id"));
                order.setFoodName(rs.getString("NAME"));
                order.setOrderTotalPrice(rs.getInt("total_price"));
                order.setOrderQuantity(rs.getInt("quantity"));
                orderList.add(order);
            }
        }catch (SQLException err){
            JOptionPane.showMessageDialog(null, err.getMessage());
        }
        
        return orderList;
    }

    public void deleteOrderFromCart(int orderId, int foodId) {
        try
        {
            FoodController controller = new FoodController();
            controller.connectToDatabase();
            
            // update stock
            String sql = "UPDATE foods f, (SELECT quantity FROM food_order WHERE food_id = ? AND order_id = ?) fo SET f.stock = fo.quantity + f.stock WHERE f.id = ?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, foodId);
            ps.setInt(2, orderId);
            ps.setInt(3, foodId);
            ps.execute();
            
            String sql1 = "DELETE FROM food_order WHERE food_id = ? AND order_id = ?";
           
            PreparedStatement ps1 = this.conn.prepareStatement(sql1);
            ps1.setInt(1, foodId);
            ps1.setInt(2, orderId);
            ps1.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Food has deleted from cart!!!");
           
        }catch (SQLException err){
            JOptionPane.showMessageDialog(null, err.getMessage());
        }
    }

    public void confirmOrder(int userId) {
        try
        {
            FoodController controller = new FoodController();
            controller.connectToDatabase();
            
            // update stock
            String sql = "UPDATE orders SET status = 1 Where customer_id = ?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, userId);
            ps.execute();

            JOptionPane.showMessageDialog(null, "Thank You !!!");
            
            String sql1 = "INSERT INTO orders (customer_id) VALUES(?)";
            PreparedStatement ps1 = this.conn.prepareStatement(sql1);
            ps1.setInt(1, userId);
            ps1.execute();
           
        }catch (SQLException err){
            JOptionPane.showMessageDialog(null, err.getMessage());
        }
    }
}
