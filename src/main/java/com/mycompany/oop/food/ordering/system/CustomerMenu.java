/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.oop.food.ordering.system;

import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.text.DecimalFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.SpinnerNumberModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public class CustomerMenu extends javax.swing.JFrame {

    public FoodController controller = new FoodController();
    public CustomerController ccontroller = new CustomerController();
    public int userId;
    public Customer loginCus;
    /**
     * Creates new form CustomerMenu
     */
    
    public CustomerMenu() {
        initComponents();
        loadTable();
    }

    public CustomerMenu(int userId) {
        this.userId = userId;
        loginCus = ccontroller.getCustomerDetailByid(userId);
        initComponents();
        selectedFoodId.setVisible(false);
        selectedFoodPrice.setVisible(false);
        customerUsername.setText(String.valueOf(loginCus.getCustomerUsername()));
        loadTable();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        foodTable = new javax.swing.JTable();
        selectedFood = new javax.swing.JLabel();
        qtyLabel = new javax.swing.JLabel();
        foodQuantity = new javax.swing.JSpinner();
        addButton = new javax.swing.JButton();
        resetButton = new javax.swing.JButton();
        customerUsername = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        foodLabel1 = new javax.swing.JLabel();
        selectedFoodPrice = new javax.swing.JLabel();
        selectedFoodId = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        cartItemMenu = new javax.swing.JMenuItem();
        logOutItemMenu = new javax.swing.JMenuItem();

        jTextField1.setEditable(false);
        jTextField1.setText("jTextField1");

        jTextField2.setText("jTextField2");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("MENU");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, -1, -1));

        foodTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "#", "Food Name", "Food Type", "Food Price", "Quantity"
            }
        ));
        foodTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                foodTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(foodTable);
        if (foodTable.getColumnModel().getColumnCount() > 0) {
            foodTable.getColumnModel().getColumn(0).setMinWidth(0);
            foodTable.getColumnModel().getColumn(0).setPreferredWidth(0);
            foodTable.getColumnModel().getColumn(0).setMaxWidth(0);
            foodTable.getColumnModel().getColumn(1).setMinWidth(30);
            foodTable.getColumnModel().getColumn(1).setMaxWidth(30);
        }

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 54, -1, 311));

        selectedFood.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        selectedFood.setForeground(new java.awt.Color(255, 255, 255));
        selectedFood.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        selectedFood.setText("No Food Selected");
        selectedFood.setMaximumSize(new java.awt.Dimension(78, 20));
        selectedFood.setMinimumSize(new java.awt.Dimension(78, 20));
        selectedFood.setPreferredSize(new java.awt.Dimension(78, 20));
        getContentPane().add(selectedFood, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 80, 160, 41));

        qtyLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        qtyLabel.setForeground(new java.awt.Color(255, 255, 255));
        qtyLabel.setText("Quantity:");
        qtyLabel.setMaximumSize(new java.awt.Dimension(78, 20));
        qtyLabel.setMinimumSize(new java.awt.Dimension(78, 20));
        qtyLabel.setPreferredSize(new java.awt.Dimension(78, 20));
        getContentPane().add(qtyLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 130, -1, 41));
        getContentPane().add(foodQuantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 140, 130, -1));

        addButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Cart.png"))); // NOI18N
        addButton.setText("Add to Cart");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });
        getContentPane().add(addButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 190, 130, 40));

        resetButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Reset.png"))); // NOI18N
        resetButton.setText("Reset");
        resetButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetButtonActionPerformed(evt);
            }
        });
        getContentPane().add(resetButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 190, 130, 40));

        customerUsername.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(customerUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 0, 110, 20));

<<<<<<< HEAD
        customerUsername.setForeground(new java.awt.Color(255, 255, 255));
<<<<<<< HEAD
        getContentPane().add(customerUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 20, 190, 20));
=======
        getContentPane().add(customerUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 20, 130, 20));
>>>>>>> master
=======
        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Welcome!");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 0, -1, -1));
>>>>>>> master

        foodLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        foodLabel1.setForeground(new java.awt.Color(255, 255, 255));
        foodLabel1.setText("Food Name:");
        foodLabel1.setMaximumSize(new java.awt.Dimension(78, 20));
        foodLabel1.setMinimumSize(new java.awt.Dimension(78, 20));
        foodLabel1.setPreferredSize(new java.awt.Dimension(78, 20));
        getContentPane().add(foodLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 80, 90, 41));

        selectedFoodPrice.setText("NULL");
        getContentPane().add(selectedFoodPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 310, -1, 20));

        selectedFoodId.setText("NULL");
        getContentPane().add(selectedFoodId, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 10, -1, 20));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Menu.jpg"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jMenu1.setText("Cutomer");

        cartItemMenu.setText("Cart");
        cartItemMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cartItemMenuActionPerformed(evt);
            }
        });
        jMenu1.add(cartItemMenu);

        logOutItemMenu.setText("Log Out");
        logOutItemMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logOutItemMenuActionPerformed(evt);
            }
        });
        jMenu1.add(logOutItemMenu);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    public void close()
    {
        WindowEvent winClosingEvent = new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);
    }
    
    private void resetButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetButtonActionPerformed
        // TODO add your handling code here:
        clearForm();
    }//GEN-LAST:event_resetButtonActionPerformed

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        // TODO add your handling code here:
        
        if(selectedFood.getText().equals("NULL") || selectedFoodPrice.getText().equals("NULL"))
        {
            JOptionPane.showMessageDialog(null, "Please choose an Item !!!");
        }
        else
        {
            DecimalFormat df = new DecimalFormat("0.00");
        
            int food_Id = Integer.parseInt(selectedFoodId.getText());
            int food_quantity = (Integer) foodQuantity.getValue();
            String total_price = df.format(Float.parseFloat(selectedFoodPrice.getText()) * food_quantity);
            ccontroller.addCart(this.userId, food_Id, food_quantity, total_price);
            clearForm();
            loadTable();
        }
    }//GEN-LAST:event_addButtonActionPerformed

    private void cartItemMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cartItemMenuActionPerformed
        // TODO add your handling code here:
        this.dispose();
        new CustomerCart(this.userId).setVisible(true);
    }//GEN-LAST:event_cartItemMenuActionPerformed

    private void logOutItemMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logOutItemMenuActionPerformed
        // TODO add your handling code here:
        close();
        new Menu().setVisible(true);
    }//GEN-LAST:event_logOutItemMenuActionPerformed

    private void foodTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_foodTableMouseClicked
        // TODO add your handling code here:
        DefaultTableModel tableContent = (DefaultTableModel) foodTable.getModel();
        selectedFoodId.setText(tableContent.getValueAt(foodTable.getSelectedRow(), 0).toString());
        selectedFood.setText(tableContent.getValueAt(foodTable.getSelectedRow(), 2).toString());
        foodQuantity.setModel(new SpinnerNumberModel(0, 0, Integer.parseInt(tableContent.getValueAt(foodTable.getSelectedRow(), 5).toString()), 1));
        selectedFoodPrice.setText(tableContent.getValueAt(foodTable.getSelectedRow(), 4).toString());
    }//GEN-LAST:event_foodTableMouseClicked

    public void clearForm()
    {
        selectedFoodId.setText("NULL");
        selectedFood.setText("No Food Selected");
        selectedFoodPrice.setText("NULL");
        foodQuantity.setValue(0);
    }
    
    private void loadTable(){
        ((DefaultTableModel) foodTable.getModel()).setNumRows(0);
        ArrayList <Food> foodList = new ArrayList();
        
        DecimalFormat df = new DecimalFormat("0.00");
       
        foodList = controller.fetchAllWhereIsNotZero();
        
        DefaultTableModel tableContent = (DefaultTableModel) foodTable.getModel();
        
        Object rowData[] = new Object[6];
        
        for(int i = 0; i < foodList.size(); i++)
        {
            rowData[0] = foodList.get(i).getFoodId();
            rowData[1] = i + 1;
            rowData[2] = foodList.get(i).getFoodName();
            rowData[3] = foodList.get(i).getFoodType();
            rowData[4] = df.format(foodList.get(i).getFoodPrice());
            rowData[5] = foodList.get(i).getFoodQuantity();
            
            tableContent.addRow(rowData);
        }
        
        selectedFoodId.setText("NULL");
        selectedFoodPrice.setText("NULL");
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CustomerMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CustomerMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CustomerMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CustomerMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CustomerMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JMenuItem cartItemMenu;
    private javax.swing.JLabel customerUsername;
    private javax.swing.JLabel foodLabel1;
    private javax.swing.JSpinner foodQuantity;
    private javax.swing.JTable foodTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JMenuItem logOutItemMenu;
    private javax.swing.JLabel qtyLabel;
    private javax.swing.JButton resetButton;
    private javax.swing.JLabel selectedFood;
    private javax.swing.JLabel selectedFoodId;
    private javax.swing.JLabel selectedFoodPrice;
    // End of variables declaration//GEN-END:variables
}
