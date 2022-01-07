/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.oop.food.ordering.system;

import java.sql.Connection;
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
public class FoodController extends Controller{

    public void connectToDatabase() {
        try{
            this.conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/food_ordering_system", "root", "");
        }
        catch (SQLException err){
            JOptionPane.showMessageDialog(null, err.getMessage());
        }
    }
    
    public ArrayList<Food> fetchAll()
    {
        ArrayList <Food> foodList = new ArrayList();
        try
        {
            FoodController controller = new FoodController();
            controller.connectToDatabase();
            String sql = "SELECT * FROM foods";
           
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next())
            {
                Food food = new Food();
                food.setFoodId(rs.getInt("id"));
                food.setFoodName(rs.getString("name"));
                food.setFoodPrice(rs.getFloat("price"));
                food.setFoodType(rs.getString("food_type"));
                food.setFoodQuantity(rs.getInt("stock"));
                
                foodList.add(food);
            }
        }catch (SQLException err){
            JOptionPane.showMessageDialog(null, err.getMessage());
        }
        
        return foodList;
    }
    
    public void create(Food food) {
        try
        {
            FoodController controller = new FoodController();
            controller.connectToDatabase();
            String sql = "INSERT INTO foods (name, food_type, price, stock) VALUES(?, ?, ?, ?)";
           
            PreparedStatement ps = this.conn.prepareStatement(sql);
            
            ps.setString(1, food.getFoodName());
            ps.setString(2, food.getFoodType());
            ps.setFloat(3, food.getFoodPrice());
            ps.setInt(4, food.getFoodQuantity());
            ps.execute();
            
            JOptionPane.showMessageDialog(null, "Food Successfully Saved");
        }catch (SQLException err){
            JOptionPane.showMessageDialog(null, err.getMessage());
        }
    }
    
    public void update(Food food) {
        try
        {
            FoodController controller = new FoodController();
            controller.connectToDatabase();
            String sql = "UPDATE foods SET name = ?, food_type = ?, price = ?, stock = ? WHERE id = ?";
           
            PreparedStatement ps = this.conn.prepareStatement(sql);
            
            ps.setString(1, food.getFoodName());
            ps.setString(2, food.getFoodType());
            ps.setFloat(3, food.getFoodPrice());
            ps.setInt(4, food.getFoodQuantity());
            ps.setInt(5, food.getFoodId());
            ps.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Food Successfully Updated");
        }catch (SQLException err){
            JOptionPane.showMessageDialog(null, err.getMessage());
        }
    }
    
    public void destroy(int id) {
        try
        {
            FoodController controller = new FoodController();
            controller.connectToDatabase();
            String sql = "DELETE FROM foods WHERE id = ?";
           
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Food Successfully Deleted");
        }catch (SQLException err){
            JOptionPane.showMessageDialog(null, err.getMessage());
        }
    }

    public ArrayList<Food> fetchAllWhereIsNotZero() {
        ArrayList <Food> foodList = new ArrayList();
        try
        {
            FoodController controller = new FoodController();
            controller.connectToDatabase();
            String sql = "SELECT * FROM foods where stock > 0";
           
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next())
            {
                Food food = new Food();
                food.setFoodId(rs.getInt("id"));
                food.setFoodName(rs.getString("name"));
                food.setFoodPrice(rs.getFloat("price"));
                food.setFoodType(rs.getString("food_type"));
                food.setFoodQuantity(rs.getInt("stock"));
                
                foodList.add(food);
            }
        }catch (SQLException err){
            JOptionPane.showMessageDialog(null, err.getMessage());
        }
        
        return foodList;
    }
}
