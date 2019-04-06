package com.example.hp.project;

/**
 * Created by VARAD on 21-03-2019.
 */

public class WorkOrderDetailsObject {

    private String CompleteDate;
    private String CustomerName;
    private String HeatCode;
    private String IssuedStore;
    private String PartName;
    private String PartNo;
    private String ReceiptChanDate;
    private String ReceiptChanNo;
    private String StartDate;
    private String SupplierName;
    private String VerifiedByQA;
    private String WeightInKg;






    public WorkOrderDetailsObject() {
    }

    public String getCompleteDate() {
        return CompleteDate;
    }

    public void setCompleteDate(String completeDate) {
        CompleteDate = completeDate;
    }

    public String getCustomerName() {
        return CustomerName;
    }

    public void setCustomerName(String customerName) {
        CustomerName = customerName;
    }

    public String getHeatCode() {
        return HeatCode;
    }

    public void setHeatCode(String heatCode) {
        HeatCode = heatCode;
    }

    public String getIssuedStore() {
        return IssuedStore;
    }

    public void setIssuedStore(String issuedStore) {
        IssuedStore = issuedStore;
    }

    public String getPartName() {
        return PartName;
    }

    public void setPartName(String partName) {
        PartName = partName;
    }

    public String getPartNo() {
        return PartNo;
    }

    public void setPartNo(String partNo) {
        PartNo = partNo;
    }

    public String getReceiptChanDate() {
        return ReceiptChanDate;
    }

    public void setReceiptChanDate(String receiptChanDate) {
        ReceiptChanDate = receiptChanDate;
    }

    public String getReceiptChanNo() {
        return ReceiptChanNo;
    }

    public void setReceiptChanNo(String receiptChanNo) {
        ReceiptChanNo = receiptChanNo;
    }

    public String getStartDate() {
        return StartDate;
    }

    public void setStartDate(String startDate) {
        StartDate = startDate;
    }

    public String getSupplierName() {
        return SupplierName;
    }

    public void setSupplierName(String supplierName) {
        SupplierName = supplierName;
    }

    public String getVerifiedByQA() {
        return VerifiedByQA;
    }

    public void setVerifiedByQA(String verifiedByQA) {
        VerifiedByQA = verifiedByQA;
    }

    public String getWeightInKg() {
        return WeightInKg;
    }

    public void setWeightInKg(String weightInKg) {
        WeightInKg = weightInKg;
    }

    public WorkOrderDetailsObject(String completeDate, String customerName, String heatCode, String issuedStore, String partName, String partNo, String receiptChanDate, String receiptChanNo, String startDate, String supplierName, String verifiedByQA, String weightInKg) {
        CompleteDate = completeDate;
        CustomerName = customerName;
        HeatCode = heatCode;
        IssuedStore = issuedStore;
        PartName = partName;
        PartNo = partNo;
        ReceiptChanDate = receiptChanDate;
        ReceiptChanNo = receiptChanNo;
        StartDate = startDate;
        SupplierName = supplierName;
        VerifiedByQA = verifiedByQA;
        WeightInKg = weightInKg;
    }
}
