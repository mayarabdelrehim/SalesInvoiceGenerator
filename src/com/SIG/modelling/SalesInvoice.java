
package com.SIG.modelling;

import java.util.ArrayList;


public class SalesInvoice {
    
    private int Number;
    private String Date;
    private String Client;
    private ArrayList<ItemLine> lines;
    //private double SalesInvoicesSummary;
    

    public SalesInvoice() {
    }

    public SalesInvoice(int Number, String Date, String Client) {
        this.Number = Number;
        this.Date = Date;
        this.Client = Client;
    }

    
    public double getSalesInvoiceTotal(){
        double total=0.0;
        for(ItemLine itemline : getLines()){
            total += itemline.getLineTotal();
        }
        return total;
        }
    
    
    
    
    
    
    public ArrayList<ItemLine> getLines() {
        if (lines == null){
            lines = new ArrayList<>();
        }
        return lines;
    }
    
    
    
    
    
    
    

    public String getClient() {
        return Client;
    }

    public void setClient(String Client) {
        this.Client = Client;
    }

    public int getNumber() {
        return Number;
    }

    public void setNumber(int Number) {
        this.Number = Number;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String Date) {
        this.Date = Date;
    }

    @Override
    public String toString() {
        return "SalesInvoice{" + "Number=" + Number + ", Date=" + Date + ", Client=" + Client + '}';
    }

    
    

   public String getAsCSV(){
       return Number + "," + Date + "," +Client;
   }
    

  
    
    
    
    
    
    
}
