
package com.SIG.modelling;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;


public class SalesInvoiceTableModel extends AbstractTableModel {
    private ArrayList<SalesInvoice>invoices;
    private String[] columns = {"Number","Date","Clinet","Total"};
    

    public SalesInvoiceTableModel(ArrayList<SalesInvoice> invoices) {
        this.invoices = invoices;
    }
    
   
   @Override
    public int getRowCount() {
        return invoices.size();
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }

    @Override
    public String getColumnName(int column) {
        return columns [column];
    }
    

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        SalesInvoice salesinvoice = invoices.get(rowIndex);
        
        
        switch (columnIndex){
            case 0: return salesinvoice.getNumber();
            case 1: return salesinvoice.getDate();
            case 2: return salesinvoice.getClient();
            case 3: return salesinvoice.getSalesInvoiceTotal();
            default : return "";
        }
       
    }
 



    
}
