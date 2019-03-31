package com.example.hp.project;

/**
 * Created by VARAD on 21-03-2019.
 */

public class SerialNo {

    private String CumulativeQuantity;
    private String InvoiceDate;
    private String InvoiceNo;
    private String Quantity;


    public SerialNo()
    {

    }




    public SerialNo(String cumulativeQuantity, String invoiceDate, String invoiceNo, String quantity) {
        CumulativeQuantity = cumulativeQuantity;
        InvoiceDate = invoiceDate;
        InvoiceNo = invoiceNo;
        Quantity = quantity;
    }

    public String getCumulativeQuantity() {
        return CumulativeQuantity;
    }

    public void setCumulativeQuantity(String cumulativeQuantity) {
        CumulativeQuantity = cumulativeQuantity;
    }

    public String getInvoiceDate() {
        return InvoiceDate;
    }

    public void setInvoiceDate(String invoiceDate) {
        InvoiceDate = invoiceDate;
    }

    public String getInvoiceNo() {
        return InvoiceNo;
    }

    public void setInvoiceNo(String invoiceNo) {
        InvoiceNo = invoiceNo;
    }

    public String getQuantity() {
        return Quantity;
    }

    public void setQuantity(String quantity) {
        Quantity = quantity;
    }
}
