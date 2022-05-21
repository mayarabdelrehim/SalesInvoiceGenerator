
package com.SIG.view;

import com.SIG.controller.Controller;
import com.SIG.modelling.SalesInvoice;
import com.SIG.modelling.SalesInvoiceTableModel;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JTable;


public class SIGframe extends javax.swing.JFrame {

    
    public SIGframe() {
        initComponents();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        salesinvoicetable = new javax.swing.JTable();
        salesinvoicetable.getSelectionModel().addListSelectionListener(controller);
        createnewinvoiceButton = new javax.swing.JButton();
        createnewinvoiceButton.addActionListener(controller);
        deletecurrentinvoiceButton = new javax.swing.JButton();
        deletecurrentinvoiceButton.addActionListener(controller);
        salesinvoicenoLabel = new javax.swing.JLabel();
        salesinvoicedateLabel = new javax.swing.JLabel();
        clientnameLabel = new javax.swing.JLabel();
        totalpaymentLabel = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        itemlInetable = new javax.swing.JTable();
        additemlineButton = new javax.swing.JButton();
        additemlineButton.addActionListener(controller);
        removeitemlineButton = new javax.swing.JButton();
        removeitemlineButton.addActionListener(controller);
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        loaddataMenuItem = new javax.swing.JMenuItem();
        loaddataMenuItem.addActionListener(controller);
        savedataMenuItem = new javax.swing.JMenuItem();
        savedataMenuItem.addActionListener(controller);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        salesinvoicetable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(salesinvoicetable);

        createnewinvoiceButton.setText("Create New Invoice");

        deletecurrentinvoiceButton.setText("Delete Current Invoive");
        deletecurrentinvoiceButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deletecurrentinvoiceButtonActionPerformed(evt);
            }
        });

        salesinvoicenoLabel.setText(".");

        salesinvoicedateLabel.setText(".");

        clientnameLabel.setText(".");

        totalpaymentLabel.setText(".");

        itemlInetable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(itemlInetable);

        additemlineButton.setText("Add Item");

        removeitemlineButton.setText("Remove Item");

        jLabel1.setText("Sales Invoice Number:");

        jLabel2.setText("Sales Invoice Date:");

        jLabel3.setText("Client Name:");

        jLabel4.setText("Total Payment");

        jMenu1.setText("File");

        loaddataMenuItem.setText("Load Data");
        jMenu1.add(loaddataMenuItem);

        savedataMenuItem.setText("Save Data");
        jMenu1.add(savedataMenuItem);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(createnewinvoiceButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(deletecurrentinvoiceButton)
                        .addGap(48, 48, 48)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 43, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 428, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(additemlineButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(removeitemlineButton)
                                .addGap(22, 22, 22))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(22, 22, 22)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(salesinvoicenoLabel)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3))
                                .addGap(41, 41, 41)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(clientnameLabel))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(salesinvoicedateLabel))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(totalpaymentLabel)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel8))))
                            .addComponent(jLabel4))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(salesinvoicenoLabel)
                            .addComponent(jLabel5)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(salesinvoicedateLabel)
                            .addComponent(jLabel6)
                            .addComponent(jLabel2))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(clientnameLabel)
                                    .addComponent(jLabel3)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jLabel7)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(totalpaymentLabel)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(deletecurrentinvoiceButton)
                        .addComponent(additemlineButton)
                        .addComponent(removeitemlineButton))
                    .addComponent(createnewinvoiceButton))
                .addContainerGap(128, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void deletecurrentinvoiceButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deletecurrentinvoiceButtonActionPerformed
       
    }//GEN-LAST:event_deletecurrentinvoiceButtonActionPerformed

    
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SIGframe().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton additemlineButton;
    private javax.swing.JLabel clientnameLabel;
    private javax.swing.JButton createnewinvoiceButton;
    private javax.swing.JButton deletecurrentinvoiceButton;
    private javax.swing.JTable itemlInetable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JMenuItem loaddataMenuItem;
    private javax.swing.JButton removeitemlineButton;
    private javax.swing.JLabel salesinvoicedateLabel;
    private javax.swing.JLabel salesinvoicenoLabel;
    private javax.swing.JTable salesinvoicetable;
    private javax.swing.JMenuItem savedataMenuItem;
    private javax.swing.JLabel totalpaymentLabel;
    // End of variables declaration//GEN-END:variables
   private ArrayList<SalesInvoice>invoices;
   private Controller controller = new Controller(this);
   private SalesInvoiceTableModel salesInvoiceTableModel;

    public ArrayList<SalesInvoice> getInvoices() {
        return invoices;
    }

    public void setInvoices(ArrayList<SalesInvoice> invoices) {
        this.invoices = invoices;
    }

    public SalesInvoiceTableModel getSalesInvoiceTableModel() {
        return salesInvoiceTableModel;
    }

    public void setSalesInvoiceTableModel(SalesInvoiceTableModel salesInvoiceTableModel) {
        this.salesInvoiceTableModel = salesInvoiceTableModel;
    }

    public JTable getItemlInetable() {
        return itemlInetable;
    }

    public JLabel getSalesinvoicedateLabel() {
        return salesinvoicedateLabel;
    }

    public JLabel getSalesinvoicenoLabel() {
        return salesinvoicenoLabel;
    }

    public JTable getSalesinvoicetable() {
        return salesinvoicetable;
    }

    public JLabel getTotalpaymentLabel() {
        return totalpaymentLabel;
    }

    public Controller getController() {
        return controller;
    }

    public JLabel getClientnameLabel() {
        return clientnameLabel;
    }
   
   public int getNextInvoiceNumber(){
    int number = 0;
    
    for (SalesInvoice salesInvoice : invoices){
      if(salesInvoice.getNumber() > number)
          number = salesInvoice.getNumber();
    }
    
    return ++number;
   }

    
    
    
    
    
    
}
