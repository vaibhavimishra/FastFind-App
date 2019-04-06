package com.example.hp.project;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by VARAD on 21-03-2019.
 */

public class DispatchDetailsObject {

    List<SerialNo> SerialNos=new ArrayList<SerialNo>();




    public DispatchDetailsObject() {
    }

    public DispatchDetailsObject(List<SerialNo> serialNos) {
        SerialNos = serialNos;
    }
}
