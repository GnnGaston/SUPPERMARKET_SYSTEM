/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Component;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;
import suppermarket.DatabaseConnection;

/**
 *
 * @author asha
 */
public class Menu_Panel extends javax.swing.JPanel {

    /**
     * Creates new form Menu_Panel
     */
        Connection conn;
   Statement st;
   ResultSet rs;
    Statement st1;
   ResultSet rs1;
   DatabaseConnection db;
    public Menu_Panel() {
        initComponents();
        db=new DatabaseConnection();
        conn=db.ConnectDB();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        select_txt = new javax.swing.JTextField();
        select_combo = new javax.swing.JComboBox<>();
        search_button = new javax.swing.JButton();
        view_all_button = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        search_table = new javax.swing.JTable();

        select_txt.setPreferredSize(new java.awt.Dimension(59, 25));

        select_combo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SearchByProductName", "SearchByProducBarcode" }));
        select_combo.setPreferredSize(new java.awt.Dimension(142, 25));

        search_button.setText("Search");
        search_button.setPreferredSize(new java.awt.Dimension(65, 25));
        search_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                search_buttonActionPerformed(evt);
            }
        });

        view_all_button.setText("View All");
        view_all_button.setPreferredSize(new java.awt.Dimension(69, 25));
        view_all_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                view_all_buttonActionPerformed(evt);
            }
        });

        search_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Product Name", "Product Category", "Cost", "Quantity Remain"
            }
        ));
        jScrollPane1.setViewportView(search_table);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(select_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(select_combo, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(80, 80, 80)
                        .addComponent(search_button, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(72, 72, 72)
                        .addComponent(view_all_button, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(45, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(select_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(select_combo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(search_button, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(view_all_button, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(42, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void search_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_search_buttonActionPerformed
        // TODO add your handling code here:
        if((String)select_combo.getSelectedItem()==("SearchByProductName") && select_txt.getText().length()!=0){
        String sql="select Product_Name,Product_Category,Selling_Price as Price,Quantity as Quantity_Remain from Purchased_Registration  where Product_Name='"+select_txt.getText()+"'";
        try{
           st=conn.createStatement();
          rs= st.executeQuery(sql);
          search_table.setModel(DbUtils.resultSetToTableModel(rs));
        }catch(Exception m){
            System.out.println(m);
        }
       
        }else if((String)select_combo.getSelectedItem()==("SearchByProducBarcode")&& select_txt.getText().length()!=0){
        
        try{
         String sql2="select Product_Name,Product_Category,Selling_Price as Price,Quantity as Quantity_Remain from Purchased_Registration  where Product_Barcode='"+select_txt.getText()+"'";
         st1=conn.createStatement();
          rs1= st1.executeQuery(sql2);
          search_table.setModel(DbUtils.resultSetToTableModel(rs1));
        }catch(Exception m2){
              System.out.println(m2);
        }
        }else
         JOptionPane.showMessageDialog(null,"Please, Choose Appropriate Choice and/or \n  TextEditer Should not be Empty ","Choice",JOptionPane.ERROR_MESSAGE);
    }//GEN-LAST:event_search_buttonActionPerformed

    private void view_all_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_view_all_buttonActionPerformed
        // TODO add your handling code here:
          String sql="select Product_Name,Product_Category,Selling_Price as Price,Quantity as Quantity_Remain from Purchased_Registration ";
        try{
           st=conn.createStatement();
          rs= st.executeQuery(sql);
          search_table.setModel(DbUtils.resultSetToTableModel(rs));
        }catch(Exception m){
            System.out.println(m);
        }
    }//GEN-LAST:event_view_all_buttonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton search_button;
    private javax.swing.JTable search_table;
    private javax.swing.JComboBox<String> select_combo;
    private javax.swing.JTextField select_txt;
    private javax.swing.JButton view_all_button;
    // End of variables declaration//GEN-END:variables
}
