
package com.SIG.modelling;


public class ItemLine {
    
    
    private String Item;
    private Double payment;
    private int QTY;
    private SalesInvoice invoice;

    public ItemLine() {
    }

    public ItemLine(String Item, Double payment, int QTY) {
       // this.Number = Number;
        this.Item = Item;
        this.payment = payment;
        this.QTY = QTY;   
    }

    public ItemLine( String Item, Double payment, int QTY, SalesInvoice invoice) {
       // this.Number = Number;
        this.Item = Item;
        this.payment = payment;
        this.QTY = QTY;
        this.invoice = invoice;
    }

    
   public double getLineTotal(){
       return payment*QTY;
   }
    
    
    
    
    
    public int getQTY() {
        return QTY;
    }

    public void setQTY(int QTY) {
        this.QTY = QTY;
    }



    public String getItem() {
        return Item;
    }

    public void setItem(String Item) {
        this.Item = Item;
    }

    public Double getPayment() {
        return payment;
    }

    public void setPayment(Double payment) {
        this.payment = payment;
    }

    @Override
    public String toString() {
        return "ItemLine{" + "Number=" + invoice.getNumber() + ", Item=" + Item + ", payment=" + payment + ", QTY=" + QTY + '}';
    }

    public SalesInvoice getInvoice() {
        return invoice;
    }
    
    
  public String getAsCSV(){
       return invoice.getNumber() + "," + Item + "," + payment + "," + QTY;
   }  
    
    
}
