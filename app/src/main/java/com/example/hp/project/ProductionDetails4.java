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

public class ProductionDetails4 extends AppCompatActivity {


    private static final String TAG = "ProductionDetails4";
    private DatePickerDialog.OnDateSetListener cDateSetListener;
    private DatePickerDialog.OnDateSetListener dDateSetListener;
    private EditText eadgeTrimingMcNo;
    private EditText eadgeTrimingStart;
    private EditText eadgeTrimingComplete;
    private EditText eadgeTrimingInputQty;
    private EditText eadgeTrimingAcceptedQty;
    private EditText eadgeTrimingRejectedQty;
    private TextView eadgeTrimingOutputQty;
    private TextView eadgeTrimingoutput;
    private EditText eadgeTrimingRecieptNo;
    private EditText eadgeTrimingRemark;
    Button next7Btn;

    private Firebase mRootRef;



    private static String gameNameFinal = null;
    private Uri filePath;

    private EditText editTextEventName;
    private EditText editTextEventDescription;

    private DatabaseReference databaseReference;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_production_details4);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        eadgeTrimingMcNo = (EditText)findViewById(R.id.eadge_triming_machine_no);
        eadgeTrimingStart = (EditText)findViewById(R.id.eadge_triming_start_date);
        eadgeTrimingComplete = (EditText) findViewById(R.id.eadge_triming_comp_date);
        eadgeTrimingInputQty = (EditText) findViewById(R.id.eadge_triming_input_quantity);
        eadgeTrimingAcceptedQty = (EditText) findViewById(R.id.eadge_triming_accepted_quantity);
        eadgeTrimingRejectedQty = (EditText) findViewById(R.id.eadge_triming_rejected_quantity);
        eadgeTrimingOutputQty = (TextView) findViewById(R.id.eadge_triming_output_qty1);
        eadgeTrimingoutput = (TextView)findViewById(R.id.eadge_triming_output_qty);
        eadgeTrimingRecieptNo = (EditText) findViewById(R.id.eadge_triming_prod_receipt_no);
        eadgeTrimingRemark = (EditText) findViewById(R.id.eadge_triming_remark);
        next7Btn = (Button)findViewById(R.id.next7_btn);

        next7Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (eadgeTrimingMcNo.getText().toString().length() == 0) {
                    eadgeTrimingMcNo.setError("Input Needed");
                    eadgeTrimingMcNo.requestFocus();
                }else if (eadgeTrimingStart.getText().toString().length() == 0) {
                    eadgeTrimingStart.setError("Input Needed");
                    eadgeTrimingStart.requestFocus();
                } else if (eadgeTrimingComplete.getText().toString().length() == 0) {
                    eadgeTrimingComplete.setError("Input Needed");
                    eadgeTrimingComplete.requestFocus();
                } else if (eadgeTrimingInputQty.getText().toString().length() == 0) {
                    eadgeTrimingInputQty.setError("Input Needed");
                    eadgeTrimingInputQty.requestFocus();
                } else if (eadgeTrimingAcceptedQty.getText().toString().length() == 0) {
                    eadgeTrimingAcceptedQty.setError("Input Needed");
                    eadgeTrimingAcceptedQty.requestFocus();
                } else if (eadgeTrimingRejectedQty.getText().toString().length() == 0) {
                    eadgeTrimingRejectedQty.setError("Input Needed");
                    eadgeTrimingRejectedQty.requestFocus();
                }else if(eadgeTrimingOutputQty.getText().toString().length() == 0){
                    eadgeTrimingOutputQty.setError("Input Needed");
                    eadgeTrimingOutputQty.requestFocus();
                }
                else {








                    mRootRef = new Firebase("https://fastfind-289c3.firebaseio.com/"+"Sheets");


                    final Firebase databaseRef = new Firebase("https://fastfind-289c3.firebaseio.com/"+"Sheets");



                    Intent i = getIntent();

                    String Id = i.getStringExtra("ID");




                    Firebase childRef1 = databaseRef.child("SheetID "+Id);
                    Firebase childRef = childRef1.child("ProductionDetails");


                    Firebase childRef2 = childRef.child("EadgeTriming");




                    childRef2.child("EadgeTrimingMcNo").setValue(eadgeTrimingMcNo.getText().toString());
                    childRef2.child("EadgeTrimingStart").setValue(eadgeTrimingStart.getText().toString());
                    childRef2.child("EadgeTrimingComplete").setValue(eadgeTrimingComplete.getText().toString());
                    childRef2.child("EeadgeTrimingInputQty").setValue(eadgeTrimingInputQty.getText().toString());
                    childRef2.child("EadgeTrimingAcceptedQty").setValue(eadgeTrimingAcceptedQty.getText().toString());
                    childRef2.child("EadgeTrimingRejectedQty").setValue(eadgeTrimingRejectedQty.getText().toString());
                    childRef2.child("EadgeTrimingOutputQty").setValue(eadgeTrimingOutputQty.getText().toString());
                    childRef2.child("EadgeTrimingoutput").setValue(eadgeTrimingoutput.getText().toString());
                    childRef2.child("EadgeTrimingReceiptNo").setValue(eadgeTrimingRecieptNo.getText().toString());
                    childRef2.child("EadgeTrimingRemark").setValue(eadgeTrimingRemark.getText().toString());



                    Intent i1 = new Intent(getApplication(),ProductionDetails5.class);

                    i1.putExtra("ID",Id);




                    Toast.makeText(ProductionDetails4.this, "Next clicked", Toast.LENGTH_SHORT).show();
                    startActivity(i1);

                }
            }
        });

        eadgeTrimingStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(
                        ProductionDetails4.this,
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
                eadgeTrimingStart.setText(date);
            }
        };
        eadgeTrimingComplete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(
                        ProductionDetails4.this,
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
                eadgeTrimingComplete.setText(date);
            }
        };

        eadgeTrimingoutput.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int accepteQty = Integer.parseInt(eadgeTrimingAcceptedQty.getText().toString());
                int rejectQty = Integer.parseInt(eadgeTrimingRejectedQty.getText().toString());
                int result = accepteQty - rejectQty;
                eadgeTrimingOutputQty.setText(""+result);
            }
        });
    }
}


