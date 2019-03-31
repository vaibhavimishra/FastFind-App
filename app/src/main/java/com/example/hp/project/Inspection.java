package com.example.hp.project;

/**
 * Created by VARAD on 30-03-2019.
 */

public class Inspection {


    String InspectionQty;
    String InspectionComplete;
    String InspectionInputQty;
    String InspectionMcNo;

    String InspectionOutputQty;
    String InspectionReceiptNo;
    String InspectionRejectedQty;
    String InspectionRemark;
    String InspectionStart;

    String Inspectionoutput;


    public Inspection() {
    }


    public Inspection(String inspectionQty, String inspectionComplete, String inspectionInputQty, String inspectionMcNo, String inspectionOutputQty, String inspectionReceiptNo, String inspectionRejectedQty, String inspectionRemark, String inspectionStart, String inspectionoutput) {
        InspectionQty = inspectionQty;
        InspectionComplete = inspectionComplete;
        InspectionInputQty = inspectionInputQty;
        InspectionMcNo = inspectionMcNo;
        InspectionOutputQty = inspectionOutputQty;
        InspectionReceiptNo = inspectionReceiptNo;
        InspectionRejectedQty = inspectionRejectedQty;
        InspectionRemark = inspectionRemark;
        InspectionStart = inspectionStart;
        Inspectionoutput = inspectionoutput;
    }


    public String getInspectionQty() {
        return InspectionQty;
    }

    public void setInspectionQty(String inspectionQty) {
        InspectionQty = inspectionQty;
    }

    public String getInspectionComplete() {
        return InspectionComplete;
    }

    public void setInspectionComplete(String inspectionComplete) {
        InspectionComplete = inspectionComplete;
    }

    public String getInspectionInputQty() {
        return InspectionInputQty;
    }

    public void setInspectionInputQty(String inspectionInputQty) {
        InspectionInputQty = inspectionInputQty;
    }

    public String getInspectionMcNo() {
        return InspectionMcNo;
    }

    public void setInspectionMcNo(String inspectionMcNo) {
        InspectionMcNo = inspectionMcNo;
    }

    public String getInspectionOutputQty() {
        return InspectionOutputQty;
    }

    public void setInspectionOutputQty(String inspectionOutputQty) {
        InspectionOutputQty = inspectionOutputQty;
    }

    public String getInspectionReceiptNo() {
        return InspectionReceiptNo;
    }

    public void setInspectionReceiptNo(String inspectionReceiptNo) {
        InspectionReceiptNo = inspectionReceiptNo;
    }

    public String getInspectionRejectedQty() {
        return InspectionRejectedQty;
    }

    public void setInspectionRejectedQty(String inspectionRejectedQty) {
        InspectionRejectedQty = inspectionRejectedQty;
    }

    public String getInspectionRemark() {
        return InspectionRemark;
    }

    public void setInspectionRemark(String inspectionRemark) {
        InspectionRemark = inspectionRemark;
    }

    public String getInspectionStart() {
        return InspectionStart;
    }

    public void setInspectionStart(String inspectionStart) {
        InspectionStart = inspectionStart;
    }

    public String getInspectionoutput() {
        return Inspectionoutput;
    }

    public void setInspectionoutput(String inspectionoutput) {
        Inspectionoutput = inspectionoutput;
    }
}
