/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.oop.food.ordering.system;

import java.sql.Connection;

/**
 *
 * @author USER
 */
abstract class Controller {
    public abstract void connectToDatabase();
    public static Connection conn;
}
