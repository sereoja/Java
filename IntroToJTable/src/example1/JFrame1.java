/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package example1;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

/**
 *
 * @author sungureanu
 */
public class JFrame1 extends javax.swing.JFrame implements ListSelectionListener{

    /**
     * Creates new form JFrame1
     */
    public JFrame1() {
        initComponents();
        myinitComponents();
    }
public void myinitComponents(){
    //register listselectionlistener with the jTable1
    jTable1.getSelectionModel().addListSelectionListener(this);
    
jTable1.setShowGrid(true);
    //change the header in the table
    //Set a reference to the table header and change its look
    JTableHeader tblheader = jTable1.getTableHeader();
    tblheader.setFont(new Font("Arial", Font.BOLD, 16));
    tblheader.setOpaque(true);
    tblheader.setBackground(Color.yellow);
    tblheader.setForeground(Color.red);
    
    //========================================================================
    //add rows to the jtable
    //1. get a reference to the DefaultTableModel associated with the JTable1
    DefaultTableModel tmodel = (DefaultTableModel)jTable1.getModel();
    //2. Apply the addRow method that takes an array of objects
    //   the array should contain the values in the columns
    Object[] row = new Object[]{"William", "John", new Integer(12345), new Double(15000), new Boolean(true)};
    tmodel.addRow(row);
    
             row = new Object[]{"Ungureanu", "Sergiu", new Integer(321654), new Double(300000), new Boolean(false)};
    tmodel.addRow(row);
}
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnDisplaySelection = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Last Name", "First Name", "ID", "Income", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Double.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        btnDisplaySelection.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnDisplaySelection.setText("Display Selection");
        btnDisplaySelection.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDisplaySelectionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnDisplaySelection, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 593, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnDisplaySelection)
                .addGap(0, 8, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDisplaySelectionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDisplaySelectionActionPerformed
        // TODO add your handling code here:
        //get selected row and col
        int srow = jTable1.getSelectedRow();
        int scol = jTable1.getSelectedColumn();
        //get lastname
        String lastName = jTable1.getValueAt(srow, 0).toString();
        int id = Integer.parseInt(jTable1.getValueAt(srow, 2).toString());
        JOptionPane.showMessageDialog(this, 
                "Last Name: " + lastName + "\n" + 
                 "ID: " + id + "\n" + 
                        "cell ["+ srow + ", "+ scol+"]");
        
    }//GEN-LAST:event_btnDisplaySelectionActionPerformed

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
            java.util.logging.Logger.getLogger(JFrame1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFrame1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFrame1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFrame1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFrame1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDisplaySelection;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables

    @Override
    public void valueChanged(ListSelectionEvent lse) {
        //get the cell that has changed
        //get selected row and col
        int srow = jTable1.getSelectedRow();
        int scol = jTable1.getSelectedColumn();
        if ( scol == 3) {
            double income = Double.parseDouble(jTable1.getValueAt(srow, scol).toString());
            JOptionPane.showMessageDialog(this, "income was updated!\n" + 
                    "New Income value: " + income);
            
        }else if (scol == 4) {
            
        }
    }
}
///Assignment
//New project: add JTable to hold car information:
// make, model, year, mileage, price
//deifne a class car, add setPrice to allow you to change the price later
// define an arraylist of cars
// preload arraylist and populate jtable with at least 7 cars
// provide gui to allow user to change price of the selected car
// (hint: may first find tow index, use this index as index to the arrayList
//to get the car object related to the selected cat
//provide textbox to enter new price and reflect that in the car