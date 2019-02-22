package com.example.hp.project;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import com.firebase.client.Firebase;
import com.google.firebase.database.DatabaseReference;

import java.util.Calendar;


public class WorkOrderDetails extends AppCompatActivity {

    private static final String TAG = "WorkOrderDetails";
    private DatePickerDialog.OnDateSetListener lDateSetListener;
    private DatePickerDialog.OnDateSetListener mDateSetListener;
    private DatePickerDialog.OnDateSetListener nDateSetListener;
    private EditText recChanNoC;
    private EditText recChanDateC;
    private EditText startDateC;
    private EditText supplierNameC;
    private EditText custNameC;
    private EditText partNoC;
    private EditText partNameC;
    private EditText heatCodeC;
    private EditText weightInKgC;
    private EditText completeDateC;
    private CheckBox issuedStore;
    private CheckBox verifiedQA;
    private Button nextBtn;


    private Firebase mRootRef;




    private static String gameNameFinal = null;
    private Uri filePath;

    private EditText editTextEventName;
    private EditText editTextEventDescription;

    private DatabaseReference databaseReference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_work_order_details);

        recChanNoC = (EditText) findViewById(R.id.rec_chan_no);
        recChanDateC = (EditText) findViewById(R.id.rec_chan_date);
        startDateC = (EditText) findViewById(R.id.start_date);
        supplierNameC = (EditText) findViewById(R.id.suppiler_name);
        custNameC = (EditText) findViewById(R.id.custom_name_date);
        partNoC = (EditText) findViewById(R.id.part_no);
        partNameC = (EditText) findViewById(R.id.part_name);
        heatCodeC = (EditText) findViewById(R.id.heatCode);
        weightInKgC = (EditText) findViewById(R.id.weight_in_kg);
        completeDateC=(EditText)findViewById(R.id.complete_date);
        issuedStore = (CheckBox) findViewById(R.id.issued_Store_cb);
        verifiedQA = (CheckBox) findViewById(R.id.verified_QA_cb);
        nextBtn = (Button)findViewById(R.id.next_btn);

        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (recChanNoC.getText().toString().length() == 0) {
                    recChanNoC.setError("Input Needed");
                    recChanNoC.requestFocus();
                }
                else if (recChanDateC.getText().toString().length() == 0) {
                    recChanDateC.setError("Input Needed");
                    recChanDateC.requestFocus();
                } else if (startDateC.getText().toString().length() == 0) {
                    startDateC.setError("Input Needed");
                    startDateC.requestFocus();
                } else if (supplierNameC.getText().toString().length() == 0) {
                    supplierNameC.setError("Input Needed");
                    supplierNameC.requestFocus();
                } else if (custNameC.getText().toString().length() == 0) {
                    custNameC.setError("Input Needed");
                    custNameC.requestFocus();
                } else if (partNoC.getText().toString().length() == 0) {
                    partNoC.setError("Input Needed");
                    partNoC.requestFocus();
                } else if (partNameC.getText().toString().length() == 0) {
                    partNameC.setError("Input Needed");
                    partNameC.requestFocus();
                } else if (heatCodeC.getText().toString().length() == 0) {
                    heatCodeC.setError("Input Needed");
                    heatCodeC.requestFocus();
                } else if (weightInKgC.getText().toString().length() == 0) {
                    weightInKgC.setError("Input Needed");
                    weightInKgC.requestFocus();
                } else if (completeDateC.getText().toString().length() == 0) {
                    completeDateC.setError("Input Needed");
                    completeDateC.requestFocus();
                }
                else if(!issuedStore.isChecked()){
                    issuedStore.setError("Tick It");
                    issuedStore.requestFocus();
                }

                else if(!verifiedQA.isChecked()){
                    verifiedQA.setError("Tick It");
                    verifiedQA.requestFocus();
                }
                else {



                    mRootRef = new Firebase("https://fastfind-289c3.firebaseio.com/"+"Sheets");


                    final Firebase databaseRef = new Firebase("https://fastfind-289c3.firebaseio.com/"+"Sheets");



                    Firebase childRef1 = databaseRef.child("SheetID "+recChanNoC.getText().toString());
                    Firebase childRef = childRef1.child("WorkOrderDetails");

                    childRef.child("Receipt Chan No").setValue(recChanNoC.getText().toString());
                    childRef.child("Receipt Chan Date").setValue(recChanDateC.getText().toString());
                    childRef.child("Start Date").setValue(startDateC.getText().toString());
                    childRef.child("Supplier Name").setValue(supplierNameC.getText().toString());

                    childRef.child("Customer Name").setValue(custNameC.getText().toString());
                    childRef.child("Part No").setValue(partNoC.getText().toString());
                    childRef.child("Part Name").setValue(partNameC.getText().toString());
                    childRef.child("HeatCode").setValue(heatCodeC.getText().toString());

                    childRef.child("Weight In kg").setValue(weightInKgC.getText().toString());
                    childRef.child("Complete Date").setValue(completeDateC.getText().toString());
                    childRef.child("Issued Store").setValue(issuedStore.isChecked());
                    childRef.child("Verified By QA").setValue(verifiedQA.isChecked());


                    Intent i = new Intent(getApplication(),RawMaterialDetails.class);

                    i.putExtra("ID",recChanNoC.getText().toString());

                    Toast.makeText(WorkOrderDetails.this, "Next clicked", Toast.LENGTH_SHORT).show();

                    startActivity(i);

                }
            }
        });

        
 recChanDateC.setOnClickListener(new View.OnClickListener() {
     @Override
     public void onClick(View view) {
         Calendar cal = Calendar.getInstance();
         int year = cal.get(Calendar.YEAR);
         int month = cal.get(Calendar.MONTH);
         int day = cal.get(Calendar.DAY_OF_MONTH);

         DatePickerDialog dialog = new DatePickerDialog(
                 WorkOrderDetails.this,
                 android.R.style.Theme_Holo_Dialog_MinWidth,
                 lDateSetListener,
                 year,month,day);
         dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
         dialog.show();
        }
    });
        lDateSetListener=new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month=month+1;
                Log.d(TAG,"onDateSet: dd/mm/yyyy:" + day + "/" + month + "/" + year);
                String date = day + "/" + month + "/" + year;
                recChanDateC.setText(date);
            }
        };

        startDateC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(
                        WorkOrderDetails.this,
                        android.R.style.Theme_Holo_Dialog_MinWidth,
                        mDateSetListener,
                        year,month,day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });
        mDateSetListener=new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month=month+1;
                Log.d(TAG,"onDateSet: dd/mm/yyyy:" + day + "/" + month + "/" + year);
                String date = day + "/" + month + "/" + year;
                startDateC.setText(date);
            }
        };

        completeDateC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(
                        WorkOrderDetails.this,
                        android.R.style.Theme_Holo_Dialog_MinWidth,
                        nDateSetListener,
                        year,month,day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });
        nDateSetListener=new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month=month+1;
                Log.d(TAG,"onDateSet: dd/mm/yyyy:" + day + "/" + month + "/" + year);
                String date = day + "/" + month + "/" + year;
                completeDateC.setText(date);
            }
        };
    }
}

