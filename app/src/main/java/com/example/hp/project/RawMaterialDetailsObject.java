package com.example.hp.project;

/**
 * Created by VARAD on 30-03-2019.
 */

public class RawMaterialDetailsObject {
    String BlanksPerSheet;
    String BlanksPerStrip;
    String NumberOfSheetsUsed;
    String RMSpecificationGrade;
    String SheetSizeCoil;
    String StripLength;
    String StripThickness;
    String StripsPerSheet;
    String StripWidth;
    String Total;
    String TotalBlanks;


    public RawMaterialDetailsObject() {
    }


    public RawMaterialDetailsObject(String blanksPerSheet, String blanksPerStrip, String numberOfSheetsUsed, String RMSpecificationGrade, String sheetSizeCoil, String stripLength, String stripThickness, String stripsPerSheet, String stripWidth, String total, String totalBlanks) {
        BlanksPerSheet = blanksPerSheet;
        BlanksPerStrip = blanksPerStrip;
        NumberOfSheetsUsed = numberOfSheetsUsed;
        this.RMSpecificationGrade = RMSpecificationGrade;
        SheetSizeCoil = sheetSizeCoil;
        StripLength = stripLength;
        StripThickness = stripThickness;
        StripsPerSheet = stripsPerSheet;
        StripWidth = stripWidth;
        Total = total;
        TotalBlanks = totalBlanks;
    }


    public String getBlanksPerSheet() {
        return BlanksPerSheet;
    }

    public void setBlanksPerSheet(String blanksPerSheet) {
        BlanksPerSheet = blanksPerSheet;
    }

    public String getBlanksPerStrip() {
        return BlanksPerStrip;
    }

    public void setBlanksPerStrip(String blanksPerStrip) {
        BlanksPerStrip = blanksPerStrip;
    }

    public String getNumberOfSheetsUsed() {
        return NumberOfSheetsUsed;
    }

    public void setNumberOfSheetsUsed(String numberOfSheetsUsed) {
        NumberOfSheetsUsed = numberOfSheetsUsed;
    }

    public String getRMSpecificationGrade() {
        return RMSpecificationGrade;
    }

    public void setRMSpecificationGrade(String RMSpecificationGrade) {
        this.RMSpecificationGrade = RMSpecificationGrade;
    }

    public String getSheetSizeCoil() {
        return SheetSizeCoil;
    }

    public void setSheetSizeCoil(String sheetSizeCoil) {
        SheetSizeCoil = sheetSizeCoil;
    }

    public String getStripLength() {
        return StripLength;
    }

    public void setStripLength(String stripLength) {
        StripLength = stripLength;
    }

    public String getStripThickness() {
        return StripThickness;
    }

    public void setStripThickness(String stripThickness) {
        StripThickness = stripThickness;
    }

    public String getStripsPerSheet() {
        return StripsPerSheet;
    }

    public void setStripsPerSheet(String stripsPerSheet) {
        StripsPerSheet = stripsPerSheet;
    }

    public String getStripWidth() {
        return StripWidth;
    }

    public void setStripWidth(String stripWidth) {
        StripWidth = stripWidth;
    }

    public String getTotal() {
        return Total;
    }

    public void setTotal(String total) {
        Total = total;
    }

    public String getTotalBlanks() {
        return TotalBlanks;
    }

    public void setTotalBlanks(String totalBlanks) {
        TotalBlanks = totalBlanks;
    }
}
