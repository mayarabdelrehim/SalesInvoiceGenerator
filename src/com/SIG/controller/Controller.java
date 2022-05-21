
package com.SIG.controller;

import com.SIG.modelling.ItemLine;
import com.SIG.modelling.ItemLinesTableModel;
import com.SIG.modelling.SalesInvoice;
import com.SIG.modelling.SalesInvoiceTableModel;
import com.SIG.view.ItemLineDialog;
import com.SIG.view.SIGframe;
import com.SIG.view.SalesInvoiceDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
//import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;


public class Controller implements ActionListener, ListSelectionListener {
    private SIGframe frame;
    private SalesInvoiceDialog salesInvoiceDialog;
    private ItemLineDialog itemLineDialog;
            
    public Controller(SIGframe frame){
        this.frame = frame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String actioncommand = e.getActionCommand();
        System.out.println("Action"+":"+" "+actioncommand);
        switch (actioncommand){
            case"Create New Invoice":
                creatnewinvoice();
                break;
                
             case"Delete Current Invoive":
                 deletecurrentinvoice();
                break;
                
             case"Add Item":
                 additem();
                break; 
                
             case"Remove Item":
                 removeitem();
                break; 
                
             case"Load Data":
                 loaddata();
                break;
                
             case"Save Data":
                 savedata();
                break; 
                
             case"createSalesInvoiceOK":
                 createSalesInvoiceOK();
                break;
                
             case"createSalesInvoiceCancel":
                 createSalesInvoiceCancel();
                break;
                
             case"createItemLineOK":
                 createItemLineOK();
                 break;
                 
            case"createItemLineCancel":
                createItemLineCancel();
                break;
                
                
        }
       
    }
    
    
     @Override
    public void valueChanged(ListSelectionEvent e) {
        int selectedIndex = frame.getSalesinvoicetable().getSelectedRow();
        if (selectedIndex != -1){
            System.out.println("YOU HAVE SELECTED ROW :" + selectedIndex);
            SalesInvoice currentSalesInvoice = frame.getInvoices().get(selectedIndex);
            frame.getSalesinvoicenoLabel().setText(""+currentSalesInvoice.getNumber());
            frame.getSalesinvoicedateLabel().setText(currentSalesInvoice.getDate());
            frame.getClientnameLabel().setText(currentSalesInvoice.getClient());
            frame.getTotalpaymentLabel().setText(""+currentSalesInvoice.getSalesInvoiceTotal());
            ItemLinesTableModel itemlinetableModel = new ItemLinesTableModel(currentSalesInvoice.getLines());
            frame.getItemlInetable().setModel(itemlinetableModel);
            itemlinetableModel.fireTableDataChanged();
        }
         
    }
   
    

    private void creatnewinvoice() {
        salesInvoiceDialog = new SalesInvoiceDialog(frame);
        salesInvoiceDialog.setVisible(true);
        }

    private void deletecurrentinvoice() {
         int selectedRow = frame.getSalesinvoicetable().getSelectedRow();
         if (selectedRow != -1){
             frame.getInvoices().remove(selectedRow);
             frame.getSalesInvoiceTableModel().fireTableDataChanged();
             
         }
        
        }

    private void additem() {
        itemLineDialog = new ItemLineDialog(frame);
        itemLineDialog.setVisible(true);
        }

    private void removeitem() {
        int selectedInv = frame.getSalesinvoicetable().getSelectedRow();
        int selectedRow = frame.getItemlInetable().getSelectedRow();
         if (selectedInv != -1 && selectedRow != -1){
             SalesInvoice salesInvoice = frame.getInvoices().get(selectedInv);
             salesInvoice.getLines().remove(selectedRow);
             ItemLinesTableModel itemLinesTableModel = new ItemLinesTableModel(salesInvoice.getLines());
             frame.getItemlInetable().setModel(itemLinesTableModel);
             itemLinesTableModel.fireTableDataChanged();
             frame.getSalesInvoiceTableModel().fireTableDataChanged();
        }
    }
    
    
    

    private void loaddata() {
        JFileChooser fc = new JFileChooser ();
        try{
           int result = fc.showOpenDialog(frame);
           if (result == JFileChooser.APPROVE_OPTION){
           File salesinvoiceheaderFile = fc.getSelectedFile();
           Path headerpath = Paths.get(salesinvoiceheaderFile.getAbsolutePath());
           List<String> headerLines = Files.readAllLines(headerpath);
           System.out.println("Sales Invoices have been read !");
           //1,22-11-2020,Ali
            //2,13-10-2021,Saleh
           ArrayList<SalesInvoice> invoicesArray = new ArrayList<>();
           for (String headerline : headerLines){
               String[] headercomponets = headerline.split(",");
               int salesinvoiceno = Integer.parseInt(headercomponets[0]);
               String salesinvoicedate = headercomponets[1];
               String clientname = headercomponets[2];
               
               SalesInvoice salesinvoice = new SalesInvoice(salesinvoiceno, salesinvoicedate, clientname);
               invoicesArray.add(salesinvoice);
               }
           System.out.println("Sales Invoice Check Point");
           
           result = fc.showOpenDialog(frame);
           if (result == JFileChooser.APPROVE_OPTION){
               File itemlineFile = fc.getSelectedFile();
               Path linepath = Paths.get(itemlineFile.getAbsolutePath());
               List<String> lineLines = Files.readAllLines(linepath);
               System.out.println("Item Lines have been read !");
               for (String lineLine : lineLines){
                   String[] linecomponets = lineLine.split(",");
                   int salesinvoiceno = Integer.parseInt(linecomponets[0]);
                   String itemNumber = linecomponets[1];
                   double itempayment = Double.parseDouble(linecomponets[2]);
                   int QTY = Integer.parseInt(linecomponets[3]);
                   SalesInvoice inv = null;
                   for (SalesInvoice salesinvoice : invoicesArray){
                       if (salesinvoice.getNumber()== salesinvoiceno){
                           inv = salesinvoice;
                           break;
                       }
                   }
                   ItemLine itemline = new ItemLine(itemNumber, itempayment, QTY, inv);
                   inv.getLines().add(itemline);
                  }
                System.out.println("Item Lines check Point");
                }
           
           frame.setInvoices(invoicesArray);
           SalesInvoiceTableModel salesInvoiceTableModel = new SalesInvoiceTableModel(invoicesArray);
          frame.setSalesInvoiceTableModel(salesInvoiceTableModel);
          frame.getSalesinvoicetable().setModel(salesInvoiceTableModel);
          frame.getSalesInvoiceTableModel().fireTableDataChanged();
            }
        } catch (IOException ex){
            ex.printStackTrace();
            }
           

    }{
    
}
    
   
    private void savedata() {
        ArrayList<SalesInvoice>salesInvoices = frame.getInvoices();
        String invoiceheader="";
        String itemlines="";
        for (SalesInvoice salesInvoice :salesInvoices ){
          String invcsv = salesInvoice.getAsCSV();
          invoiceheader += invcsv;
          invoiceheader += "/n";
          
          
         for (ItemLine itemLine : salesInvoice.getLines()) {
          String lineCSV = itemLine.getAsCSV();
          itemlines += lineCSV;
          itemlines += "\n";
         } 
          
        }
          System.out.println("Save Data Check");
        try{
         JFileChooser fc = new JFileChooser();
         int result = fc.showSaveDialog(frame);
         if (result == JFileChooser.APPROVE_OPTION){
             File headerFile = fc.getSelectedFile();
             FileWriter hfw = new FileWriter(headerFile);
                    hfw.write(invoiceheader);
                    hfw.flush();
                    hfw.close();
             
             result = fc.showSaveDialog(frame);
             if (result == JFileChooser.APPROVE_OPTION){
             File lineFile = fc.getSelectedFile();
             FileWriter lfw = new FileWriter(lineFile);
                    lfw.write(itemlines);
                    lfw.flush();
                    lfw.close();
             }
         }
        } catch (Exception ex){
            
        }
        }
    

    private void createSalesInvoiceOK() {
    String date = salesInvoiceDialog.getInvDateField().getText();
     String customer = salesInvoiceDialog.getCustNameField().getText();
     int number = frame.getNextInvoiceNumber();
     
     SalesInvoice salesInvoice = new SalesInvoice(number, date, customer);
     frame.getInvoices().add(salesInvoice);
     frame.getSalesInvoiceTableModel().fireTableDataChanged();
    salesInvoiceDialog.setVisible(false);
    salesInvoiceDialog.dispose();
    salesInvoiceDialog = null;
        
       
    }

    private void createSalesInvoiceCancel() {
        salesInvoiceDialog.setVisible(false);
        salesInvoiceDialog.dispose();
        salesInvoiceDialog= null;
        
    }

    private void createItemLineOK() {
    String item = itemLineDialog.getItemNameField().getText();
    String QtyStr = itemLineDialog.getItemCountField().getText();
    String paymentStr = itemLineDialog.getItemPriceField().getText();
     int qty = Integer.parseInt(QtyStr);
     double payment = Double.parseDouble(paymentStr);
     int selectedInvoice = frame.getSalesinvoicetable().getSelectedRow();
     if (selectedInvoice != -1){
     SalesInvoice salesInvoice = frame.getInvoices().get(selectedInvoice);
     ItemLine itemLine = new ItemLine(item, payment, qty, salesInvoice);
     salesInvoice.getLines().add(itemLine);
     ItemLinesTableModel linesTableModel = (ItemLinesTableModel) frame.getItemlInetable().getModel();
     //linesTableModel.getItemLines.add(line);
     linesTableModel.fireTableDataChanged();
     frame.getSalesInvoiceTableModel().fireTableDataChanged();
     }  
        
        
    itemLineDialog.setVisible(false);
     itemLineDialog.dispose();
     itemLineDialog = null;    
    }

    private void createItemLineCancel() {
     itemLineDialog.setVisible(false);
     itemLineDialog.dispose();
     itemLineDialog = null;
    }

    
    


   
    
}
