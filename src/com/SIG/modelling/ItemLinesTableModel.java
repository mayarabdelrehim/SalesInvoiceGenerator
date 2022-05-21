
package com.SIG.modelling;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;


public class ItemLinesTableModel extends AbstractTableModel {
    
    
    private ArrayList<ItemLine> itemlines;
    private String[] columns = {"Number","Item","Payment","QTY","Total"};

    public ItemLinesTableModel(ArrayList<ItemLine> itemlines) {
        this.itemlines = itemlines;
    }
    

    @Override
    public int getRowCount() {
        return itemlines.size();
     }

    @Override
    public int getColumnCount() {
        return columns.length;
    }

    @Override
    public String getColumnName(int y) {
        return columns[y];
    }

     
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        ItemLine itemline = itemlines.get(rowIndex);
        
        switch(columnIndex){
            case 0: return itemline.getInvoice().getNumber();
            case 1 :return itemline.getItem();
            case 2 :return itemline.getPayment();
            case 3 :return itemline.getQTY();
            case 4 :return itemline.getLineTotal();
            default : return "";
        
        }
    }
    
}
