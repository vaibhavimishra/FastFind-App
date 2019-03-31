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
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.client.Firebase;
import com.google.firebase.database.DatabaseReference;

import java.util.Calendar;

public class ProductionDetails2 extends AppCompatActivity {


    private static final String TAG = "ProductionDetails2";
    private DatePickerDialog.OnDateSetListener cDateSetListener;
    private DatePickerDialog.OnDateSetListener dDateSetListener;
    private EditText partingOffMcNo;
    private EditText partingOffStart;
    private EditText partingOffComplete;
    private EditText partingOffInputQty;
    private EditText partingOffAcceptedQty;
    private EditText partingOffRejectedQty;
    private TextView partingOffOutputQty;
    private TextView partingOffoutput;
    private EditText partingOffRecieptNo;
    private EditText partingOffRemark;
    Button next5Btn;


    private Firebase mRootRef;



    private static String gameNameFinal = null;
    private Uri filePath;

    private EditText editTextEventName;
    private EditText editTextEventDescription;

    private DatabaseReference databaseReference;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_production_details2);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        partingOffMcNo = (EditText)findViewById(R.id.parting_off_machine_no);
        partingOffStart = (EditText)findViewById(R.id.parting_off_start_date);
        partingOffComplete = (EditText) findViewById(R.id.parting_off_comp_date);
        partingOffInputQty = (EditText) findViewById(R.id.parting_off_input_quantity);
        partingOffAcceptedQty = (EditText) findViewById(R.id.parting_off_accepted_quantity);
        partingOffRejectedQty = (EditText) findViewById(R.id.parting_off_rejected_quantity);
        partingOffOutputQty = (TextView) findViewById(R.id.parting_off_output_qty1);
        partingOffoutput = (TextView)findViewById(R.id.parting_off_output_qty);
        partingOffRecieptNo = (EditText) findViewById(R.id.parting_off_prod_receipt_no);
        partingOffRemark = (EditText) findViewById(R.id.parting_off_remark);
        next5Btn = (Button)findViewById(R.id.next5_btn);

        next5Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (partingOffMcNo.getText().toString().length() == 0) {
                    partingOffMcNo.setError("Input Needed");
                    partingOffMcNo.requestFocus();
                }else if (partingOffStart.getText().toString().length() == 0) {
                    partingOffStart.setError("Input Needed");
                    partingOffStart.requestFocus();
                } else if (partingOffComplete.getText().toString().length() == 0) {
                    partingOffComplete.setError("Input Needed");
                    partingOffComplete.requestFocus();
                } else if (partingOffInputQty.getText().toString().length() == 0) {
                    partingOffInputQty.setError("Input Needed");
                    partingOffInputQty.requestFocus();
                } else if (partingOffAcceptedQty.getText().toString().length() == 0) {
                    partingOffAcceptedQty.setError("Input Needed");
                    partingOffAcceptedQty.requestFocus();
                } else if (partingOffRejectedQty.getText().toString().length() == 0) {
                    partingOffRejectedQty.setError("Input Needed");
                    partingOffRejectedQty.requestFocus();
                }else if(partingOffOutputQty.getText().toString().length() == 0){
                    partingOffOutputQty.setError("Input Needed");
                    partingOffOutputQty.requestFocus();
                }
                else {



                    mRootRef = new Firebase("https://fastfind-289c3.firebaseio.com/"+"Sheets");


                    final Firebase databaseRef = new Firebase("https://fastfind-289c3.firebaseio.com/"+"Sheets");



                    Intent i = getIntent();

                    String Id = i.getStringExtra("ID");




                    Firebase childRef1 = databaseRef.child("SheetID "+Id);
                    Firebase childRef = childRef1.child("ProductionDetails");


                    Firebase childRef2 = childRef.child("PartingOff");




                    childRef2.child("PartingOffMcNo").setValue(partingOffMcNo.getText().toString());
                    childRef2.child("PartingOffStart").setValue(partingOffStart.getText().toString());
                    childRef2.child("PartingOffComplete").setValue(partingOffComplete.getText().toString());
                    childRef2.child("PartingOffInputQty").setValue(partingOffInputQty.getText().toString());
                    childRef2.child("PartingOffAcceptedQty").setValue(partingOffAcceptedQty.getText().toString());
                    childRef2.child("PartingOffRejectedQty").setValue(partingOffRejectedQty.getText().toString());
                    childRef2.child("PartingOffOutputQty").setValue(partingOffOutputQty.getText().toString());
                    childRef2.child("PartingOffoutput").setValue(partingOffoutput.getText().toString());
                    childRef2.child("PartingOffReceiptNo").setValue(partingOffRecieptNo.getText().toString());
                    childRef2.child("PartingOffRemark").setValue(partingOffRemark.getText().toString());



                    Intent i1 = new Intent(getApplication(),ProductionDetails3.class);

                    i1.putExtra("ID",Id);




                    Toast.makeText(ProductionDetails2.this, "Next clicked", Toast.LENGTH_SHORT).show();
                    startActivity(i1);

                }
            }
        });

        partingOffStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(
                        ProductionDetails2.this,
                        android.R.style.Theme_Holo_Dialog_MinWidth,
                        cDateSetListener,
                        year,month,day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });
        cDateSetListener=new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month=month+1;
                Log.d(TAG,"onDateSet: dd/mm/yyyy:" + day + "/" + month + "/" + year);
                String date = day + "/" + month + "/" + year;
                partingOffStart.setText(date);
            }
        };
        partingOffComplete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(
                        ProductionDetails2.this,
                        android.R.style.Theme_Holo_Dialog_MinWidth,
                        dDateSetListener,
                        year,month,day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });
        dDateSetListener=new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month=month+1;
                Log.d(TAG,"onDateSet: dd/mm/yyyy:" + day + "/" + month + "/" + year);
                String date = day + "/" + month + "/" + year;
                partingOffComplete.setText(date);
            }
        };

        partingOffoutput.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int accepteQty = Integer.parseInt(partingOffAcceptedQty.getText().toString());
                int rejectQty = Integer.parseInt(partingOffRejectedQty.getText().toString());
                int result = accepteQty - rejectQty;
                partingOffOutputQty.setText(""+result);
            }
        });
    }
}

