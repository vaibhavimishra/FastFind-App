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

public class ProductionDetails10 extends AppCompatActivity {
    private static final String TAG = "ProductionDetails10";
    private DatePickerDialog.OnDateSetListener cDateSetListener;
    private DatePickerDialog.OnDateSetListener dDateSetListener;
    private EditText packingMcNo;
    private EditText packingStart;
    private EditText packingComplete;
    private EditText packingInputQty;
    private EditText packingAcceptedQty;
    private EditText packingRejectedQty;
    private TextView packingOutputQty;
    private TextView packingoutput;
    private EditText packingRecieptNo;
    private EditText packingRemark;
    Button next12Btn;


    private Firebase mRootRef;



    private static String gameNameFinal = null;
    private Uri filePath;

    private EditText editTextEventName;
    private EditText editTextEventDescription;

    private DatabaseReference databaseReference;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_production_details10);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        packingMcNo = (EditText)findViewById(R.id.packing_machine_no);
        packingStart = (EditText)findViewById(R.id.packing_start_date);
        packingComplete = (EditText) findViewById(R.id.packing_comp_date);
        packingInputQty = (EditText) findViewById(R.id.packing_input_quantity);
        packingAcceptedQty = (EditText) findViewById(R.id.packing_accepted_quantity);
        packingRejectedQty = (EditText) findViewById(R.id.packing_rejected_quantity);
        packingOutputQty = (TextView) findViewById(R.id.packing_output_qty1);
        packingoutput = (TextView)findViewById(R.id.packing_output_qty);
        packingRecieptNo = (EditText) findViewById(R.id.packing_prod_receipt_no);
        packingRemark = (EditText) findViewById(R.id.packing_remark);
        next12Btn = (Button)findViewById(R.id.next12_btn);

        next12Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (packingMcNo.getText().toString().length() == 0) {
                    packingMcNo.setError("Input Needed");
                    packingMcNo.requestFocus();
                }else if (packingStart.getText().toString().length() == 0) {
                    packingStart.setError("Input Needed");
                    packingStart.requestFocus();
                } else if (packingComplete.getText().toString().length() == 0) {
                    packingComplete.setError("Input Needed");
                    packingComplete.requestFocus();
                } else if (packingInputQty.getText().toString().length() == 0) {
                    packingInputQty.setError("Input Needed");
                    packingInputQty.requestFocus();
                } else if (packingAcceptedQty.getText().toString().length() == 0) {
                    packingAcceptedQty.setError("Input Needed");
                    packingAcceptedQty.requestFocus();
                } else if (packingRejectedQty.getText().toString().length() == 0) {
                    packingRejectedQty.setError("Input Needed");
                    packingRejectedQty.requestFocus();
                }else if(packingOutputQty.getText().toString().length() == 0){
                    packingOutputQty.setError("Input Needed");
                    packingOutputQty.requestFocus();
                }
                else {


                    mRootRef = new Firebase("https://fastfind-289c3.firebaseio.com/"+"Sheets");


                    final Firebase databaseRef = new Firebase("https://fastfind-289c3.firebaseio.com/"+"Sheets");



                    Intent i = getIntent();

                    String Id = i.getStringExtra("ID");




                    Firebase childRef1 = databaseRef.child("SheetID "+Id);
                    Firebase childRef = childRef1.child("ProductionDetails");


                    Firebase childRef2 = childRef.child("Packing");




                    childRef2.child("PackingMcNo").setValue(packingMcNo.getText().toString());
                    childRef2.child("PackingStart").setValue(packingStart.getText().toString());
                    childRef2.child("PackingComplete").setValue(packingComplete.getText().toString());
                    childRef2.child("PackingInputQty").setValue(packingInputQty.getText().toString());
                    childRef2.child("PackingAcceptedQty").setValue(packingAcceptedQty.getText().toString());
                    childRef2.child("PackingRejectedQty").setValue(packingRejectedQty.getText().toString());
                    childRef2.child("PackingOutputQty").setValue(packingOutputQty.getText().toString());
                    childRef2.child("Packingoutput").setValue(packingoutput.getText().toString());
                    childRef2.child("PackingReceiptNo").setValue(packingRecieptNo.getText().toString());
                    childRef2.child("PackingRemark").setValue(packingRemark.getText().toString());



                    Intent i1 = new Intent(getApplication(),DispatchDetails.class);

                    i1.putExtra("ID",Id);




                    Toast.makeText(ProductionDetails10.this, "Next clicked", Toast.LENGTH_SHORT).show();
                    startActivity(i1);
                }
            }
        });

        packingStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(
                        ProductionDetails10.this,
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
                packingStart.setText(date);
            }
        };
        packingComplete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(
                        ProductionDetails10.this,
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
                packingComplete.setText(date);
            }
        };

        packingoutput.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int accepteQty = Integer.parseInt(packingAcceptedQty.getText().toString());
                int rejectQty = Integer.parseInt(packingRejectedQty.getText().toString());
                int result = accepteQty - rejectQty;
                packingOutputQty.setText(""+result);
            }
        });
    }
}



