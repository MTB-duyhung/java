/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sp0119;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author PC
 */
public class SP0119 extends javax.swing.JFrame {
    
    DefaultTableModel dftb;
    HashSet hs;
    
    public SP0119() {
        initComponents();
        dftb = new DefaultTableModel();
        hs = new HashSet();
        try {
            String sql = "use [FU_DB];\n"
                    + "SELECT * FROM dbo.Stocks";
            DBInfo dbContext = new DBInfo();
            Connection connection = dbContext.getConnection();
            Statement statement = connection.createStatement();
            statement.execute(sql);
            ResultSet rs = statement.getResultSet();
            Object[] title = {"StockID", "StockName", "Address", "DateAvailable", "Note"};
            dftb.setColumnIdentifiers(title);
            dftb.setRowCount(0);
            hs.clear();
            while (rs.next()) {
                Vector vector = new Vector();
                vector.add(rs.getString(1));
                hs.add(rs.getString(1));
                vector.add(rs.getString(2));
                vector.add(rs.getString(3));
                vector.add(rs.getString(4));
                vector.add(rs.getString(5));
                dftb.addRow(vector);
            }
            Table.setModel(dftb);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void insertData() {        
        String sql = "use[FU_DB];\n"
                + "BEGIN\n"
                + "Update dbo.Stocks\n"
                + "SET StockName=?,Address =?,DateAvailable =?,Note =?\n"
                + "Where StockID = ?;"
                + "\n end";        
        try {
            DBInfo dbContext = new DBInfo();
            Connection connection = dbContext.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, (String) Table.getValueAt(0, 1));
            preparedStatement.setString(2, (String) Table.getValueAt(0, 2));
            preparedStatement.setString(3, (String) Table.getValueAt(0, 3));
            preparedStatement.setString(4, (String) Table.getValueAt(0, 4));
            preparedStatement.setString(5, (String) Table.getValueAt(0, 0));
            preparedStatement.executeUpdate();
            preparedStatement.setString(1, (String) Table.getValueAt(1, 1));
            preparedStatement.setString(2, (String) Table.getValueAt(1, 2));
            preparedStatement.setString(3, (String) Table.getValueAt(1, 3));
            preparedStatement.setString(4, (String) Table.getValueAt(1, 4));
            preparedStatement.setString(5, (String) Table.getValueAt(1, 0));
            preparedStatement.executeUpdate();
            preparedStatement.setString(1, (String) Table.getValueAt(2, 1));
            preparedStatement.setString(2, (String) Table.getValueAt(2, 2));
            preparedStatement.setString(3, (String) Table.getValueAt(2, 3));
            preparedStatement.setString(4, (String) Table.getValueAt(2, 4));
            preparedStatement.setString(5, (String) Table.getValueAt(2, 0));
            preparedStatement.executeUpdate();
            preparedStatement.setString(1, (String) Table.getValueAt(3, 1));
            preparedStatement.setString(2, (String) Table.getValueAt(3, 2));
            preparedStatement.setString(3, (String) Table.getValueAt(3, 3));
            preparedStatement.setString(4, (String) Table.getValueAt(3, 4));
            preparedStatement.setString(5, (String) Table.getValueAt(3, 0));
            preparedStatement.executeUpdate();
            preparedStatement.setString(1, (String) Table.getValueAt(4, 1));
            preparedStatement.setString(2, (String) Table.getValueAt(4, 2));
            preparedStatement.setString(3, (String) Table.getValueAt(4, 3));
            preparedStatement.setString(4, (String) Table.getValueAt(4, 4));
            preparedStatement.setString(5, (String) Table.getValueAt(4, 0));
            preparedStatement.executeUpdate();
            connection.close();
            jLabel1.setText("Update Success");
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        Table = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(Table);

        jButton1.setText("Insert to DB");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setForeground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton1)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        insertData();
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(SP0119.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SP0119.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SP0119.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SP0119.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SP0119().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Table;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
