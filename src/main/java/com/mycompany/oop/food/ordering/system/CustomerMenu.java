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
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public class CustomerMenu extends javax.swing.JFrame {

    public FoodController controller = new FoodController();
    public CustomerController ccontroller = new CustomerController();
    /**
     * Creates new form CustomerMenu
     */
    public CustomerMenu() {
        initComponents();
        display();
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
        foodLabel = new javax.swing.JLabel();
        qtyLabel = new javax.swing.JLabel();
        foodQuantity = new javax.swing.JSpinner();
        addButton = new javax.swing.JButton();
        resetButton = new javax.swing.JButton();
        foodNo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        customerUsername = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        cartMenuItem = new javax.swing.JMenuItem();
        logoutMenuItem = new javax.swing.JMenuItem();

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
                "id", "Food No", "Food Name", "Food Type", "Food Price"
            }
        ));
        jScrollPane1.setViewportView(foodTable);
        if (foodTable.getColumnModel().getColumnCount() > 0) {
            foodTable.getColumnModel().getColumn(0).setMinWidth(0);
            foodTable.getColumnModel().getColumn(0).setPreferredWidth(0);
            foodTable.getColumnModel().getColumn(0).setMaxWidth(0);
            foodTable.getColumnModel().getColumn(1).setPreferredWidth(10);
        }

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 54, -1, 311));

        foodLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        foodLabel.setForeground(new java.awt.Color(255, 255, 255));
        foodLabel.setText("Food No:");
        foodLabel.setMaximumSize(new java.awt.Dimension(78, 20));
        foodLabel.setMinimumSize(new java.awt.Dimension(78, 20));
        foodLabel.setPreferredSize(new java.awt.Dimension(78, 20));
        getContentPane().add(foodLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 54, -1, 41));

        qtyLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        qtyLabel.setForeground(new java.awt.Color(255, 255, 255));
        qtyLabel.setText("Quantity:");
        qtyLabel.setMaximumSize(new java.awt.Dimension(78, 20));
        qtyLabel.setMinimumSize(new java.awt.Dimension(78, 20));
        qtyLabel.setPreferredSize(new java.awt.Dimension(78, 20));
        getContentPane().add(qtyLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 101, -1, 41));
        getContentPane().add(foodQuantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(568, 113, 130, -1));

        addButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Cart.png"))); // NOI18N
        addButton.setText("Add to Cart");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });
        getContentPane().add(addButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(568, 160, 130, 40));

        resetButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Reset.png"))); // NOI18N
        resetButton.setText("Reset");
        resetButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetButtonActionPerformed(evt);
            }
        });
        getContentPane().add(resetButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(568, 211, 130, 40));
        getContentPane().add(foodNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(568, 66, 130, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Welcome!");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 16, -1, -1));

        customerUsername.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(customerUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 20, 130, 20));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Menu.jpg"))); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jMenu1.setText("File");

        cartMenuItem.setText("Cart");
        cartMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cartMenuItemActionPerformed(evt);
            }
        });
        jMenu1.add(cartMenuItem);

        logoutMenuItem.setText("Logout");
        logoutMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutMenuItemActionPerformed(evt);
            }
        });
        jMenu1.add(logoutMenuItem);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    public void close()
    {
        WindowEvent winClosingEvent = new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);
    }
    
    private void cartMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cartMenuItemActionPerformed
        // TODO add your handling code here:
        new CustomerCart().setVisible(true);
    }//GEN-LAST:event_cartMenuItemActionPerformed

    private void logoutMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutMenuItemActionPerformed
        // TODO add your handling code here:
        close();
        new Menu().setVisible(true);
    }//GEN-LAST:event_logoutMenuItemActionPerformed

    private void resetButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetButtonActionPerformed
        // TODO add your handling code here:
        clearForm();
    }//GEN-LAST:event_resetButtonActionPerformed

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        // TODO add your handling code here:
        Customer customer = new Customer();
        if(foodNo.getText().isEmpty()) 
            JOptionPane.showMessageDialog(null, "All Field are Required!!!"); 
        else
        {
            int food_id = Integer.parseInt(foodNo.getText());
            String food_name = "0";
            String food_type = "0";
            float food_price = 0;
            int food_quantity = (Integer) foodQuantity.getValue();
            
            controller.addToCart(new Food(food_id, food_name, food_type, food_price, food_quantity));
        }
        
        clearForm();
    }//GEN-LAST:event_addButtonActionPerformed
   
    public void display(){
        Customer customer = new Customer();
        
        customerUsername.setText(String.valueOf(customer.getCustomerUsername()));
    }
    
    public void clearForm()
    {
        foodNo.setText("");
        foodQuantity.setValue(0);
    }
    
    private void loadTable(){
        ((DefaultTableModel) foodTable.getModel()).setNumRows(0);
        ArrayList <Food> foodList = new ArrayList();
        
        DecimalFormat df = new DecimalFormat("0.00");
       
        foodList = controller.fetchAll();
        
        DefaultTableModel tableContent = (DefaultTableModel) foodTable.getModel();
        
        Object rowData[] = new Object[5];
        
        for(int i = 0; i < foodList.size(); i++)
        {
            rowData[0] = foodList.get(i).getFoodId();
            rowData[1] = foodList.get(i).getFoodId();
            rowData[2] = foodList.get(i).getFoodName();
            rowData[3] = foodList.get(i).getFoodType();
            rowData[4] = df.format(foodList.get(i).getFoodPrice());
            
            tableContent.addRow(rowData);
        }
        
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
    private javax.swing.JMenuItem cartMenuItem;
    private javax.swing.JLabel customerUsername;
    private javax.swing.JLabel foodLabel;
    private javax.swing.JTextField foodNo;
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
    private javax.swing.JMenuItem logoutMenuItem;
    private javax.swing.JLabel qtyLabel;
    private javax.swing.JButton resetButton;
    // End of variables declaration//GEN-END:variables
}
