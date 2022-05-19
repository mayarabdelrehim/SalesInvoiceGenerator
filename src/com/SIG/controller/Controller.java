
package com.SIG.controller;

import com.SIG.modelling.ItemLine;
import com.SIG.modelling.SalesInvoice;
import com.SIG.modelling.SalesInvoiceTableModel;
import com.SIG.view.SIGframe;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
//import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFileChooser;


public class Controller implements ActionListener {
    private SIGframe frame;
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
                
                
        }
       
    }

    private void creatnewinvoice() {
        }

    private void deletecurrentinvoice() {
        }

    private void additem() {
        }

    private void removeitem() {
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
                   ItemLine itemline = new ItemLine(salesinvoiceno, itemNumber, itempayment, QTY, inv);
                   inv.getLines().add(itemline);
                  }
                System.out.println("Item Lines check Point");
                }
           
           frame.setInvoices(invoicesArray);
           SalesInvoiceTableModel salesInvoiceTableModel = new SalesInvoiceTableModel(invoicesArray);
            }
        } catch (IOException ex){
            ex.printStackTrace();
            }
           

    }
    
    
    
    
    
    
    private void savedata() {
        }

   
    
}
