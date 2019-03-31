package com.example.hp.project;

/**
 * Created by VARAD on 30-03-2019.
 */

public class Packing {


    String PackingQty;
    String PackingComplete;
    String PackingInputQty;
    String PackingMcNo;

    String PackingOutputQty;
    String PackingReceiptNo;
    String PackingRejectedQty;
    String PackingRemark;
    String PackingStart;

    String Packingoutput;


    public Packing() {
    }


    public Packing(String packingQty, String packingComplete, String packingInputQty, String packingMcNo, String packingOutputQty, String packingReceiptNo, String packingRejectedQty, String packingRemark, String packingStart, String packingoutput) {
        PackingQty = packingQty;
        PackingComplete = packingComplete;
        PackingInputQty = packingInputQty;
        PackingMcNo = packingMcNo;
        PackingOutputQty = packingOutputQty;
        PackingReceiptNo = packingReceiptNo;
        PackingRejectedQty = packingRejectedQty;
        PackingRemark = packingRemark;
        PackingStart = packingStart;
        Packingoutput = packingoutput;
    }


    public String getPackingQty() {
        return PackingQty;
    }

    public void setPackingQty(String packingQty) {
        PackingQty = packingQty;
    }

    public String getPackingComplete() {
        return PackingComplete;
    }

    public void setPackingComplete(String packingComplete) {
        PackingComplete = packingComplete;
    }

    public String getPackingInputQty() {
        return PackingInputQty;
    }

    public void setPackingInputQty(String packingInputQty) {
        PackingInputQty = packingInputQty;
    }

    public String getPackingMcNo() {
        return PackingMcNo;
    }

    public void setPackingMcNo(String packingMcNo) {
        PackingMcNo = packingMcNo;
    }

    public String getPackingOutputQty() {
        return PackingOutputQty;
    }

    public void setPackingOutputQty(String packingOutputQty) {
        PackingOutputQty = packingOutputQty;
    }

    public String getPackingReceiptNo() {
        return PackingReceiptNo;
    }

    public void setPackingReceiptNo(String packingReceiptNo) {
        PackingReceiptNo = packingReceiptNo;
    }

    public String getPackingRejectedQty() {
        return PackingRejectedQty;
    }

    public void setPackingRejectedQty(String packingRejectedQty) {
        PackingRejectedQty = packingRejectedQty;
    }

    public String getPackingRemark() {
        return PackingRemark;
    }

    public void setPackingRemark(String packingRemark) {
        PackingRemark = packingRemark;
    }

    public String getPackingStart() {
        return PackingStart;
    }

    public void setPackingStart(String packingStart) {
        PackingStart = packingStart;
    }

    public String getPackingoutput() {
        return Packingoutput;
    }

    public void setPackingoutput(String packingoutput) {
        Packingoutput = packingoutput;
    }
}
