package com.example.hp.project;

/**
 * Created by VARAD on 30-03-2019.
 */

public class Chamfering {

    String ChamferingAcceptedQty;
    String ChamferingComplete;
    String ChamferingInputQty;
    String ChamferingMcNo;

    String ChamferingOutputQty;
    String ChamferingReceiptNo;
    String ChamferingRejectedQty;
    String ChamferingRemark;
    String ChamferingStart;

    String Chamferingoutput;

    @Override
    public String toString() {
        return "Chamfering{" +
                "ChamferingAcceptedQty='" + ChamferingAcceptedQty + '\'' +
                ", ChamferingComplete='" + ChamferingComplete + '\'' +
                ", ChamferingInputQty='" + ChamferingInputQty + '\'' +
                ", ChamferingMcNo='" + ChamferingMcNo + '\'' +
                ", ChamferingOutputQty='" + ChamferingOutputQty + '\'' +
                ", ChamferingReceiptNo='" + ChamferingReceiptNo + '\'' +
                ", ChamferingRejectedQty='" + ChamferingRejectedQty + '\'' +
                ", ChamferingRemark='" + ChamferingRemark + '\'' +
                ", ChamferingStart='" + ChamferingStart + '\'' +
                ", Chamferingoutput='" + Chamferingoutput + '\'' +
                '}';
    }

    public String getChamferingAcceptedQty() {
        return ChamferingAcceptedQty;
    }

    public void setChamferingAcceptedQty(String chamferingAcceptedQty) {
        ChamferingAcceptedQty = chamferingAcceptedQty;
    }

    public String getChamferingComplete() {
        return ChamferingComplete;
    }

    public void setChamferingComplete(String chamferingComplete) {
        ChamferingComplete = chamferingComplete;
    }

    public String getChamferingInputQty() {
        return ChamferingInputQty;
    }

    public void setChamferingInputQty(String chamferingInputQty) {
        ChamferingInputQty = chamferingInputQty;
    }

    public String getChamferingMcNo() {
        return ChamferingMcNo;
    }

    public void setChamferingMcNo(String chamferingMcNo) {
        ChamferingMcNo = chamferingMcNo;
    }

    public String getChamferingOutputQty() {
        return ChamferingOutputQty;
    }

    public void setChamferingOutputQty(String chamferingOutputQty) {
        ChamferingOutputQty = chamferingOutputQty;
    }

    public String getChamferingReceiptNo() {
        return ChamferingReceiptNo;
    }

    public void setChamferingReceiptNo(String chamferingReceiptNo) {
        ChamferingReceiptNo = chamferingReceiptNo;
    }

    public String getChamferingRejectedQty() {
        return ChamferingRejectedQty;
    }

    public void setChamferingRejectedQty(String chamferingRejectedQty) {
        ChamferingRejectedQty = chamferingRejectedQty;
    }

    public String getChamferingRemark() {
        return ChamferingRemark;
    }

    public void setChamferingRemark(String chamferingRemark) {
        ChamferingRemark = chamferingRemark;
    }

    public String getChamferingStart() {
        return ChamferingStart;
    }

    public void setChamferingStart(String chamferingStart) {
        ChamferingStart = chamferingStart;
    }

    public String getChamferingoutput() {
        return Chamferingoutput;
    }

    public void setChamferingoutput(String chamferingoutput) {
        Chamferingoutput = chamferingoutput;
    }



    public Chamfering() {
    }

    public Chamfering(String chamferingAcceptedQty, String chamferingComplete, String chamferingInputQty, String chamferingMcNo, String chamferingOutputQty, String chamferingReceiptNo, String chamferingRejectedQty, String chamferingRemark, String chamferingStart, String chamferingoutput) {
        ChamferingAcceptedQty = chamferingAcceptedQty;
        ChamferingComplete = chamferingComplete;
        ChamferingInputQty = chamferingInputQty;
        ChamferingMcNo = chamferingMcNo;
        ChamferingOutputQty = chamferingOutputQty;
        ChamferingReceiptNo = chamferingReceiptNo;
        ChamferingRejectedQty = chamferingRejectedQty;
        ChamferingRemark = chamferingRemark;
        ChamferingStart = chamferingStart;
        Chamferingoutput = chamferingoutput;
    }
}
