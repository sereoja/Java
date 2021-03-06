/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package example1;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.util.Enumeration;
import java.util.Locale;
import javax.swing.AbstractButton;
import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToggleButton;


/**
 *
 * @author sungureanu
 */
public class JFrame2 extends javax.swing.JFrame implements ActionListener  {

    /**
     * Creates new form JFrame2
     */
   //code
public JFrame2() {
        initComponents();
        
        myInitComponents();
    }

    private void myInitComponents(){
        horizontalBox = Box.createHorizontalBox();
        verticalBox = Box.createVerticalBox();
        
        rad1 = new JRadioButton("0% Discount");
        rad1.setSelected(true);//preset it
        rad2 = new JRadioButton("70% Discount");
        rad3 = new JRadioButton("40% Discount");
        rad4 = new JRadioButton("30% Discount");
        //group them
        group1 = new ButtonGroup();
        group1.add(rad1);
        group1.add(rad2);
        group1.add(rad3);
        group1.add(rad4);
        //box them
        horizontalBox.add(rad1);
        horizontalBox.add(rad2);
        horizontalBox.add(rad3);
        horizontalBox.add(rad4);
        
        label1 = new JLabel("Original price: $149.99", JLabel.CENTER);
        txtPrice = new JTextField();
        txtPrice.setPreferredSize(new Dimension(150,25));
        panelTop = new JPanel(new FlowLayout());
        panelTop.add(label1);
        panelTop.add(txtPrice);
        //add to verticalbox
        verticalBox.add(panelTop);
        verticalBox.add(horizontalBox);
        
        btnDiscount = new JButton("Display Cost & Saving");
        btnDiscount.addActionListener(this);
        
        textarea = new JTextArea();
        scrollpane = new JScrollPane(textarea,
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                                    JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        
        //add to frame
        this.setLayout(new BorderLayout());
        this.add(verticalBox,BorderLayout.PAGE_START);
        this.add(scrollpane,BorderLayout.CENTER);
        this.add(btnDiscount,BorderLayout.PAGE_END);
        
        
        this.pack();
        //resize the frame
        Dimension size = this.getSize();
        int height = size.height + textarea.getSize().height * 2;
        int width = size.width;
        this.setSize(new Dimension(width,height));
    }
    
    @Override
    public void actionPerformed(ActionEvent ae){
        if(btnDiscount ==(JButton)ae.getSource()){
            //get the string of the selected radio button
            //using the getSelectedButtonText()
            String text = getSelectedButtonText(group1);
            //extract the value without the % sign
            
            //get the index of the percent sign
            int index = text.indexOf("%");
            //extract the value and convert it to a double
            String discount = text.substring(0, index);
            //convert string to double
            double percentDiscount = Double.parseDouble(discount) /100;
            //get original price from textbox
            double price = Double.parseDouble(txtPrice.getText());
            double savings = price*percentDiscount;
            double tax = (price - savings) * 0.1;
            double total = (price-savings) + tax;
            
            //format to currency
            NumberFormat currencyFormater = NumberFormat.getCurrencyInstance();
            NumberFormat percentFormater = NumberFormat.getPercentInstance();
            
            textarea.setText("total = " + currencyFormater.format(total));
        }
    }
    private String getSelectedButtonText(ButtonGroup group){
        Enumeration<AbstractButton> buttons = 
                group.getElements();
        while(buttons.hasMoreElements()){
            AbstractButton radbutton = buttons.nextElement();
            //check if selected
            if (radbutton.isSelected()) {
                //returning the text property of the selected radio button
                return radbutton.getActionCommand();
            }
        }
         return "";
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
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
            java.util.logging.Logger.getLogger(JFrame2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFrame2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFrame2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFrame2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFrame2().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
// Variables declaration - do not modify                     
    // End of variables declaration                   

JRadioButton rad1,rad2,rad3,rad4;
Box horizontalBox,verticalBox;
JTextArea textarea;
JScrollPane scrollpane;
JButton btnDiscount;
JLabel label1;
ButtonGroup group1;
 JTextField txtPrice;
 JPanel panelTop;

}
