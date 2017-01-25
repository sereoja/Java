/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package readwritebinaryfiles;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.Random;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

/**
 *
 * @author sungureanu
 */
public class JFrame1 extends javax.swing.JFrame {

    /**
     * Creates new form JFrame1
     */
    public JFrame1() {
        initComponents();
        myInitComponents();
    }

    private void myInitComponents(){
    //add action event to jbtnSave
    jBtnSave.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent ae) {
           DataOutputStream dos = null;
           //Create DataOutputStream object
           try{
               dos = new DataOutputStream(
               new FileOutputStream(jTxtFileName.getText(), true));
               
            //save account
           Account account = GetRandomAccount();
           //use appropriate writeXXX method to save the different types of data
           dos.writeInt(account.getAccountNumber());
           dos.writeDouble(account.getBalance());
           dos.writeUTF(account.getType());
           dos.writeUTF(account.getBank());
           JOptionPane.showMessageDialog(null, "new account has been saved");           
           }
           catch(FileNotFoundException fe){}
           catch(IOException ioe){}
           finally{
               if (dos!=null) {
                   try {
                       dos.close();
                   } catch (IOException ex) {
                   }
               }
           }
        }
    });
    //----------------------------------------------------
    jBtnRead.addActionListener(new ActionListener() {
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        @Override
        public void actionPerformed(ActionEvent ae) {
            //use DataInputStream with FileInputStream
            jTxtDisplay.setText("");
            DataInputStream dis = null;
           try{
               dis = new DataInputStream(new FileInputStream(jTxtFileName.getText()));
            while(true){
                //when end of file is reached, an EOFException is thrown
                //need to add a catch(EOFExeption to signal the end of reading file)
                int accountNumber = dis.readInt();
                double balance = dis.readDouble();
                String type = dis.readUTF();
                String bank = dis.readUTF();
                //display to the jTextArea1
                jTxtDisplay.append(accountNumber + " " + currency.format(balance) + 
                        " " + type + " " + bank + "\br");
            }
           }catch(FileNotFoundException fe){
           }catch(EOFException eof){
           JOptionPane.showMessageDialog(null, eof.getMessage());
           }catch(IOException ioe){
           }finally{
               
               if (dis!=null) {
                   try{
                   dis.close();} catch (IOException ex) {
                   }
               }
           }
            
        }
    });
    //----------------------------------------------------
    
    //end myInitComponents
    }
    
    //helper method to return a random account
    Random rand = new Random();
    private Account GetRandomAccount(){
        String[] types = new String[] {"Checking", "Savings", "CD"};
        int accountNumber = rand.nextInt(199999) + 111111;
        double balance = rand.nextInt(33999)+1000;
        String type = types[rand.nextInt(types.length)];
        String bank = "Chase";
        return new Account(accountNumber, balance, type, bank);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLbl = new javax.swing.JLabel();
        jTxtFileName = new javax.swing.JTextField();
        jBtnSave = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTxtDisplay = new javax.swing.JTextArea();
        jBtnRead = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLbl.setText("FileName");

        jTxtFileName.setText("accounts.dat");

        jBtnSave.setText("Save a Random Account");

        jTxtDisplay.setColumns(20);
        jTxtDisplay.setRows(5);
        jScrollPane1.setViewportView(jTxtDisplay);

        jBtnRead.setText("Read Account File");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLbl)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jBtnRead, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 285, Short.MAX_VALUE)
                    .addComponent(jBtnSave, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTxtFileName))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLbl)
                    .addComponent(jTxtFileName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jBtnSave)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jBtnRead)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
    private javax.swing.JButton jBtnRead;
    private javax.swing.JButton jBtnSave;
    private javax.swing.JLabel jLbl;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTxtDisplay;
    private javax.swing.JTextField jTxtFileName;
    // End of variables declaration//GEN-END:variables
}
