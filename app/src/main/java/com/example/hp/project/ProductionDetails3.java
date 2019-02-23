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

public class ProductionDetails3 extends AppCompatActivity {


    private static final String TAG = "ProductionDetails3";
    private DatePickerDialog.OnDateSetListener cDateSetListener;
    private DatePickerDialog.OnDateSetListener dDateSetListener;
    private EditText fullFormingMcNo;
    private EditText fullFormingStart;
    private EditText fullFormingComplete;
    private EditText fullFormingInputQty;
    private EditText fullFormingAcceptedQty;
    private EditText fullFormingRejectedQty;
    private TextView fullFormingOutputQty;
    private TextView fullFormingoutput;
    private EditText fullFormingRecieptNo;
    private EditText fullFormingRemark;
    Button next6Btn;


    private Firebase mRootRef;



    private static String gameNameFinal = null;
    private Uri filePath;

    private EditText editTextEventName;
    private EditText editTextEventDescription;

    private DatabaseReference databaseReference;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_production_details3);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        fullFormingMcNo = (EditText)findViewById(R.id.full_forming_machine_no);
        fullFormingStart = (EditText)findViewById(R.id.full_forming_start_date);
        fullFormingComplete = (EditText) findViewById(R.id.full_forming_comp_date);
        fullFormingInputQty = (EditText) findViewById(R.id.full_forming_input_quantity);
        fullFormingAcceptedQty = (EditText) findViewById(R.id.full_forming_accepted_quantity);
        fullFormingRejectedQty = (EditText) findViewById(R.id.full_forming_rejected_quantity);
        fullFormingOutputQty = (TextView) findViewById(R.id.full_forming_output_qty1);
        fullFormingoutput = (TextView)findViewById(R.id.full_forming_output_qty);
        fullFormingRecieptNo = (EditText) findViewById(R.id.full_forming_prod_receipt_no);
        fullFormingRemark = (EditText) findViewById(R.id.full_forming_remark);
        next6Btn = (Button)findViewById(R.id.next6_btn);

        next6Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (fullFormingMcNo.getText().toString().length() == 0) {
                    fullFormingMcNo.setError("Input Needed");
                    fullFormingMcNo.requestFocus();
                }else if (fullFormingStart.getText().toString().length() == 0) {
                    fullFormingStart.setError("Input Needed");
                    fullFormingStart.requestFocus();
                } else if (fullFormingComplete.getText().toString().length() == 0) {
                    fullFormingComplete.setError("Input Needed");
                    fullFormingComplete.requestFocus();
                } else if (fullFormingInputQty.getText().toString().length() == 0) {
                    fullFormingInputQty.setError("Input Needed");
                    fullFormingInputQty.requestFocus();
                } else if (fullFormingAcceptedQty.getText().toString().length() == 0) {
                    fullFormingAcceptedQty.setError("Input Needed");
                    fullFormingAcceptedQty.requestFocus();
                } else if (fullFormingRejectedQty.getText().toString().length() == 0) {
                    fullFormingRejectedQty.setError("Input Needed");
                    fullFormingRejectedQty.requestFocus();
                }else if(fullFormingOutputQty.getText().toString().length() == 0){
                    fullFormingOutputQty.setError("Input Needed");
                    fullFormingOutputQty.requestFocus();
                }
                else {





                    mRootRef = new Firebase("https://fastfind-289c3.firebaseio.com/"+"Sheets");


                    final Firebase databaseRef = new Firebase("https://fastfind-289c3.firebaseio.com/"+"Sheets");



                    Intent i = getIntent();

                    String Id = i.getStringExtra("ID");




                    Firebase childRef1 = databaseRef.child("SheetID "+Id);
                    Firebase childRef = childRef1.child("ProductionDetails");


                    Firebase childRef2 = childRef.child("FullForming");




                    childRef2.child("FullFormingMcNo").setValue(fullFormingMcNo.getText().toString());
                    childRef2.child("FullFormingStart").setValue(fullFormingStart.getText().toString());
                    childRef2.child("FullFormingComplete").setValue(fullFormingComplete.getText().toString());
                    childRef2.child("FullFormingInputQty").setValue(fullFormingInputQty.getText().toString());
                    childRef2.child("FullFormingAcceptedQty").setValue(fullFormingAcceptedQty.getText().toString());
                    childRef2.child("FullFormingRejectedQty").setValue(fullFormingRejectedQty.getText().toString());
                    childRef2.child("FullFormingOutputQty").setValue(fullFormingOutputQty.getText().toString());
                    childRef2.child("FullFormingoutput").setValue(fullFormingoutput.getText().toString());
                    childRef2.child("FullFormingReceiptNo").setValue(fullFormingRecieptNo.getText().toString());
                    childRef2.child("FullFormingRemark").setValue(fullFormingRemark.getText().toString());



                    Intent i1 = new Intent(getApplication(),ProductionDetails4.class);

                    i1.putExtra("ID",Id);




                    Toast.makeText(ProductionDetails3.this, "Next clicked", Toast.LENGTH_SHORT).show();
                    startActivity(i1);

                }
            }
        });

        fullFormingStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(
                        ProductionDetails3.this,
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
                fullFormingStart.setText(date);
            }
        };
        fullFormingComplete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(
                        ProductionDetails3.this,
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
                fullFormingComplete.setText(date);
            }
        };

        fullFormingoutput.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int accepteQty = Integer.parseInt(fullFormingAcceptedQty.getText().toString());
                int rejectQty = Integer.parseInt(fullFormingRejectedQty.getText().toString());
                int result = accepteQty - rejectQty;
                fullFormingOutputQty.setText(""+result);
            }
        });
    }
}


