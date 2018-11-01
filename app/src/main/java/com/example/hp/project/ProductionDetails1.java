package com.example.hp.project;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class ProductionDetails1 extends AppCompatActivity {
    private static final String TAG = "ProductionDetails1";
    private DatePickerDialog.OnDateSetListener cDateSetListener;
    private DatePickerDialog.OnDateSetListener dDateSetListener;
    private EditText profilePiercingMcNo;
    private EditText profilePiercingStart;
    private EditText profilePiercingComplete;
    private EditText profilePiercingInputQty;
    private EditText profilePiercingAcceptedQty;
    private EditText profilePiercingRejectedQty;
    private TextView profilePiercingOutputQty;
    private TextView profilePiercingoutput;
    private EditText profilePiercingRecieptNo;
    private EditText profilePiercingRemark;
    Button next4Btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_production_details1);

        profilePiercingMcNo = (EditText)findViewById(R.id.profile_piercing_machine_no);
        profilePiercingStart = (EditText)findViewById(R.id.profile_piercing_start_date);
        profilePiercingComplete = (EditText) findViewById(R.id.profile_piercing_comp_date);
        profilePiercingInputQty = (EditText) findViewById(R.id.profile_piercing_input_quantity);
        profilePiercingAcceptedQty = (EditText) findViewById(R.id.profile_piercing_accepted_quantity);
        profilePiercingRejectedQty = (EditText) findViewById(R.id.profile_piercing_rejected_quantity);
        profilePiercingOutputQty = (TextView) findViewById(R.id.profile_piercing_output_qty1);
        profilePiercingoutput = (TextView)findViewById(R.id.profile_piercing_output_qty);
        profilePiercingRecieptNo = (EditText) findViewById(R.id.profile_piercing_prod_receipt_no);
        profilePiercingRemark = (EditText) findViewById(R.id.profile_piercing_remark);
        next4Btn = (Button)findViewById(R.id.next4_btn);

        next4Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (profilePiercingMcNo.getText().toString().length() == 0) {
                    profilePiercingMcNo.setError("Input Needed");
                    profilePiercingMcNo.requestFocus();
                }else if (profilePiercingStart.getText().toString().length() == 0) {
                    profilePiercingStart.setError("Input Needed");
                    profilePiercingStart.requestFocus();
                } else if (profilePiercingComplete.getText().toString().length() == 0) {
                    profilePiercingComplete.setError("Input Needed");
                    profilePiercingComplete.requestFocus();
                } else if (profilePiercingInputQty.getText().toString().length() == 0) {
                    profilePiercingInputQty.setError("Input Needed");
                    profilePiercingInputQty.requestFocus();
                } else if (profilePiercingAcceptedQty.getText().toString().length() == 0) {
                    profilePiercingAcceptedQty.setError("Input Needed");
                    profilePiercingAcceptedQty.requestFocus();
                } else if (profilePiercingRejectedQty.getText().toString().length() == 0) {
                    profilePiercingRejectedQty.setError("Input Needed");
                    profilePiercingRejectedQty.requestFocus();
                }else if(profilePiercingOutputQty.getText().toString().length() == 0){
                    profilePiercingOutputQty.setError("Input Needed");
                    profilePiercingOutputQty.requestFocus();
                }
                else {
                    Toast.makeText(ProductionDetails1.this, "Next clicked", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(getApplication(), ProductionDetails1.class));
                }
            }
        });

        profilePiercingStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(
                        ProductionDetails1.this,
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
                profilePiercingStart.setText(date);
            }
        };
        profilePiercingComplete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(
                        ProductionDetails1.this,
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
                profilePiercingComplete.setText(date);
            }
        };

        profilePiercingoutput.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int accepteQty = Integer.parseInt(profilePiercingAcceptedQty.getText().toString());
                int rejectQty = Integer.parseInt(profilePiercingRejectedQty.getText().toString());
                int result = accepteQty - rejectQty;
                profilePiercingOutputQty.setText(""+result);
            }
        });
    }
}
