package com.example.hp.project;

/**
 * Created by VARAD on 21-03-2019.
 */

public class SheetObject {


    ProductionDetailsObject productionDetailsObject;
    DispatchDetailsObject dispatchDetailsObject;
    WorkOrderDetailsObject workOrderDetailsObject;
    RawMaterialDetailsObject rawMaterialDetailsObject;
    String sheetID;



    public SheetObject() {
    }

    public SheetObject(DispatchDetailsObject dispatchDetailsObject, WorkOrderDetailsObject workOrderDetailsObject,String sheetID) {
        this.dispatchDetailsObject = dispatchDetailsObject;
        this.workOrderDetailsObject = workOrderDetailsObject;
        this.sheetID = sheetID;

    }

    public SheetObject(ProductionDetailsObject productionDetailsObject, DispatchDetailsObject dispatchDetailsObject, WorkOrderDetailsObject workOrderDetailsObject, RawMaterialDetailsObject rawMaterialDetailsObject, String sheetID) {
        this.productionDetailsObject = productionDetailsObject;
        this.dispatchDetailsObject = dispatchDetailsObject;
        this.workOrderDetailsObject = workOrderDetailsObject;
        this.rawMaterialDetailsObject = rawMaterialDetailsObject;
        this.sheetID = sheetID;
    }

    public SheetObject(DispatchDetailsObject dispatchDetailsObject, ProductionDetailsObject productionDetailsObject, WorkOrderDetailsObject workOrderDetailsObject, String sheetID) {
        this.dispatchDetailsObject = dispatchDetailsObject;
        this.workOrderDetailsObject = workOrderDetailsObject;
        this.sheetID = sheetID;
        this.productionDetailsObject = productionDetailsObject;


    }


    public SheetObject(WorkOrderDetailsObject workOrderDetailsObject,String sheetID) {
        this.workOrderDetailsObject = workOrderDetailsObject;
        this.sheetID = sheetID;

    }


}
