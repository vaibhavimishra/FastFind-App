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
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.client.Firebase;
import com.google.firebase.database.DatabaseReference;

import java.util.Calendar;

public class ProductionDetails extends AppCompatActivity {
    private static final String TAG = "ProductionDetails";
    private DatePickerDialog.OnDateSetListener aDateSetListener;
    private DatePickerDialog.OnDateSetListener bDateSetListener;
    private EditText preFormingMcNo;
    private EditText preFormingStart;
    private EditText preFormingComplete;
    private EditText preFormingInputQty;
    private EditText preFormingAcceptedQty;
    private EditText preFormingRejectedQty;
    private TextView preFormingOutputQty;
    private TextView output;
    private EditText preFormingRecieptNo;
    private EditText preFormingRemark;
    Button next3Btn;

<<<<<<< HEAD
    private Firebase mRootRef;

=======


    private Firebase mRootRef;




>>>>>>> 03c90ccc591b72f56eecdb633d9f78e20fd90dfe
    private static String gameNameFinal = null;
    private Uri filePath;

    private EditText editTextEventName;
    private EditText editTextEventDescription;

    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_production);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        preFormingMcNo = (EditText)findViewById(R.id.pre_forming_machine_no);
        preFormingStart = (EditText)findViewById(R.id.pre_forming_start_date);
        preFormingComplete = (EditText) findViewById(R.id.pre_forming_comp_date);
        preFormingInputQty = (EditText) findViewById(R.id.pre_forming_input_quantity);
        preFormingAcceptedQty = (EditText) findViewById(R.id.pre_forming_accepted_quantity);
        preFormingRejectedQty = (EditText) findViewById(R.id.pre_forming_rejected_quantity);
        preFormingOutputQty = (TextView) findViewById(R.id.pre_forming_output_qty1);
        output = (TextView)findViewById(R.id.pre_forming_output_qty);
        preFormingRecieptNo = (EditText) findViewById(R.id.pre_forming_prod_receipt_no);
        preFormingRemark = (EditText) findViewById(R.id.pre_forming_remark);
        next3Btn = (Button)findViewById(R.id.next3_btn);

        next3Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (preFormingMcNo.getText().toString().length() == 0) {
                    preFormingMcNo.setError("Input Needed");
                    preFormingMcNo.requestFocus();
                }else if (preFormingStart.getText().toString().length() == 0) {
                    preFormingStart.setError("Input Needed");
                    preFormingStart.requestFocus();
                } else if (preFormingComplete.getText().toString().length() == 0) {
                    preFormingComplete.setError("Input Needed");
                    preFormingComplete.requestFocus();
                } else if (preFormingInputQty.getText().toString().length() == 0) {
                    preFormingInputQty.setError("Input Needed");
                    preFormingInputQty.requestFocus();
                } else if (preFormingAcceptedQty.getText().toString().length() == 0) {
                    preFormingAcceptedQty.setError("Input Needed");
                    preFormingAcceptedQty.requestFocus();
                } else if (preFormingRejectedQty.getText().toString().length() == 0) {
                    preFormingRejectedQty.setError("Input Needed");
                    preFormingRejectedQty.requestFocus();
                }else if(preFormingOutputQty.getText().toString().length() == 0){
                    preFormingRejectedQty.setError("Input Needed");
                    preFormingRejectedQty.requestFocus();
                }
                else {


                    mRootRef = new Firebase("https://fastfind-289c3.firebaseio.com/"+"Sheets");


                    final Firebase databaseRef = new Firebase("https://fastfind-289c3.firebaseio.com/"+"Sheets");



                    Firebase childRef1 = databaseRef.child("SheetID "+preFormingMcNo.getText().toString());
                    Firebase childRef = childRef1.child("Pre-Forming");

                    childRef.child("Pre-Forming MC NO").setValue(preFormingMcNo.getText().toString());
                    childRef.child("Pre-Forming Start").setValue(preFormingStart.getText().toString());
                    childRef.child("Pre-Forming Complete").setValue(preFormingComplete.getText().toString());
                    childRef.child("Pre-Forming Input Quantity").setValue(preFormingInputQty.getText().toString());

                    childRef.child("Pre-Forming Accepted Quantity").setValue(preFormingAcceptedQty.getText().toString());
                    childRef.child("Pre-Forming Rejected Quantity").setValue(preFormingRejectedQty.getText().toString());
                    childRef.child("Pre-Forming Output Quantity").setValue(preFormingOutputQty.getText().toString());
                    childRef.child("Pre-Forming Output").setValue(output.getText().toString());

                    childRef.child("Pre-Forming Receipt No").setValue(preFormingRecieptNo.getText().toString());
                    childRef.child("Pre-Forming Remark").setValue(preFormingRemark.getText().toString());

<<<<<<< HEAD
=======




>>>>>>> 03c90ccc591b72f56eecdb633d9f78e20fd90dfe
                    Toast.makeText(ProductionDetails.this, "Next clicked", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(getApplication(), ProductionDetails1.class));
                }
            }
        });

        preFormingStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(
                        ProductionDetails.this,
                        android.R.style.Theme_Holo_Dialog_MinWidth,
                        aDateSetListener,
                        year,month,day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });
        aDateSetListener=new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month=month+1;
                Log.d(TAG,"onDateSet: dd/mm/yyyy:" + day + "/" + month + "/" + year);
                String date = day + "/" + month + "/" + year;
                preFormingStart.setText(date);
            }
        };
        preFormingComplete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(
                        ProductionDetails.this,
                        android.R.style.Theme_Holo_Dialog_MinWidth,
                        bDateSetListener,
                        year,month,day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });
        bDateSetListener=new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month=month+1;
                Log.d(TAG,"onDateSet: dd/mm/yyyy:" + day + "/" + month + "/" + year);
                String date = day + "/" + month + "/" + year;
                preFormingComplete.setText(date);
            }
        };

        output.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int accepteQty = Integer.parseInt(preFormingAcceptedQty.getText().toString());
                int rejectQty = Integer.parseInt(preFormingRejectedQty.getText().toString());
                int result = accepteQty - rejectQty;
                preFormingOutputQty.setText(""+result);
            }
        });
    }
}
