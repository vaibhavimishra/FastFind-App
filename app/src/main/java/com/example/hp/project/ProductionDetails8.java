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

public class ProductionDetails8 extends AppCompatActivity {


    private static final String TAG = "ProductionDetails8";
    private DatePickerDialog.OnDateSetListener cDateSetListener;
    private DatePickerDialog.OnDateSetListener dDateSetListener;
    private EditText deburringMcNo;
    private EditText deburringStart;
    private EditText deburringComplete;
    private EditText deburringInputQty;
    private EditText deburringAcceptedQty;
    private EditText deburringRejectedQty;
    private TextView deburringOutputQty;
    private TextView deburringoutput;
    private EditText deburringRecieptNo;
    private EditText deburringRemark;
    Button next11Btn;

    private Firebase mRootRef;



    private static String gameNameFinal = null;
    private Uri filePath;

    private EditText editTextEventName;
    private EditText editTextEventDescription;

    private DatabaseReference databaseReference;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_production_details8);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        deburringMcNo = (EditText)findViewById(R.id.deburring_machine_no);
        deburringStart = (EditText)findViewById(R.id.deburring_start_date);
        deburringComplete = (EditText) findViewById(R.id.deburring_comp_date);
        deburringInputQty = (EditText) findViewById(R.id.deburring_input_quantity);
        deburringAcceptedQty = (EditText) findViewById(R.id.deburring_accepted_quantity);
        deburringRejectedQty = (EditText) findViewById(R.id.deburring_rejected_quantity);
        deburringOutputQty = (TextView) findViewById(R.id.deburring_output_qty1);
        deburringoutput = (TextView)findViewById(R.id.deburring_output_qty);
        deburringRecieptNo = (EditText) findViewById(R.id.deburring_prod_receipt_no);
        deburringRemark = (EditText) findViewById(R.id.deburring_remark);
        next11Btn = (Button)findViewById(R.id.next11_btn);

        next11Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (deburringMcNo.getText().toString().length() == 0) {
                    deburringMcNo.setError("Input Needed");
                    deburringMcNo.requestFocus();
                }else if (deburringStart.getText().toString().length() == 0) {
                    deburringStart.setError("Input Needed");
                    deburringStart.requestFocus();
                } else if (deburringComplete.getText().toString().length() == 0) {
                    deburringComplete.setError("Input Needed");
                    deburringComplete.requestFocus();
                } else if (deburringInputQty.getText().toString().length() == 0) {
                    deburringInputQty.setError("Input Needed");
                    deburringInputQty.requestFocus();
                } else if (deburringAcceptedQty.getText().toString().length() == 0) {
                    deburringAcceptedQty.setError("Input Needed");
                    deburringAcceptedQty.requestFocus();
                } else if (deburringRejectedQty.getText().toString().length() == 0) {
                    deburringRejectedQty.setError("Input Needed");
                    deburringRejectedQty.requestFocus();
                }else if(deburringOutputQty.getText().toString().length() == 0){
                    deburringOutputQty.setError("Input Needed");
                    deburringOutputQty.requestFocus();
                }
                else {




                    mRootRef = new Firebase("https://fastfind-289c3.firebaseio.com/"+"Sheets");


                    final Firebase databaseRef = new Firebase("https://fastfind-289c3.firebaseio.com/"+"Sheets");



                    Intent i = getIntent();

                    String Id = i.getStringExtra("ID");




                    Firebase childRef1 = databaseRef.child("SheetID "+Id);
                    Firebase childRef = childRef1.child("ProductionDetails");


                    Firebase childRef2 = childRef.child("Deburring");




                    childRef2.child("DeburringMcNo").setValue(deburringMcNo.getText().toString());
                    childRef2.child("DeburringStart").setValue(deburringStart.getText().toString());
                    childRef2.child("DeburringComplete").setValue(deburringComplete.getText().toString());
                    childRef2.child("DeburringInputQty").setValue(deburringInputQty.getText().toString());
                    childRef2.child("DeburringAcceptedQty").setValue(deburringAcceptedQty.getText().toString());
                    childRef2.child("DeburringRejectedQty").setValue(deburringRejectedQty.getText().toString());
                    childRef2.child("DeburringOutputQty").setValue(deburringOutputQty.getText().toString());
                    childRef2.child("Deburringoutput").setValue(deburringoutput.getText().toString());
                    childRef2.child("DeburringReceiptNo").setValue(deburringRecieptNo.getText().toString());
                    childRef2.child("DeburringRemark").setValue(deburringRemark.getText().toString());



                    Intent i1 = new Intent(getApplication(),ProductionDetails9.class);

                    i1.putExtra("ID",Id);




                    Toast.makeText(ProductionDetails8.this, "Next clicked", Toast.LENGTH_SHORT).show();
                    startActivity(i1);
                }
            }
        });

        deburringStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(
                        ProductionDetails8.this,
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
                deburringStart.setText(date);
            }
        };
        deburringComplete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(
                        ProductionDetails8.this,
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
                deburringComplete.setText(date);
            }
        };

        deburringoutput.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int accepteQty = Integer.parseInt(deburringAcceptedQty.getText().toString());
                int rejectQty = Integer.parseInt(deburringRejectedQty.getText().toString());
                int result = accepteQty - rejectQty;
                deburringOutputQty.setText(""+result);
            }
        });
    }
}


