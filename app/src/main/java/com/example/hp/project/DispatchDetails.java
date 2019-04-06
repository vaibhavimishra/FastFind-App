package com.example.hp.project;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import com.firebase.client.Firebase;
import com.firebase.client.core.Tag;
import com.google.firebase.database.DatabaseReference;

import java.util.Calendar;

public class DispatchDetails extends AppCompatActivity {
    Button sheet_summary;





    private Firebase mRootRef;




    private static String gameNameFinal = null;
    private Uri filePath;

    private EditText editTextEventName;
    private EditText editTextEventDescription;

    private DatabaseReference databaseReference;
    EditText invoice_date1,invoice_date2, invoice_date3, invoice_date4, invoice_date5, invoice_date6, invoice_date7, invoice_date8, invoice_date9, invoice_date10, invoice_date11, invoice_date12, invoice_date13, invoice_date14;

    EditText invoice1_no,invoice2_no,invoice3_no,invoice4_no,invoice5_no,invoice6_no,invoice7_no,invoice8_no,invoice9_no,invoice10_no,invoice11_no,invoice12_no,invoice13_no,invoice14_no;

    EditText qunatity1,qunatity2,qunatity3,qunatity4,qunatity5,qunatity6,qunatity7,qunatity8,qunatity9,qunatity10,qunatity11,qunatity12,qunatity13,qunatity14;

    EditText cummulative_quantity1,cummulative_quantity2,cummulative_quantity3,cummulative_quantity4,cummulative_quantity5,cummulative_quantity6,cummulative_quantity7,cummulative_quantity8,cummulative_quantity9,cummulative_quantity10,cummulative_quantity11,cummulative_quantity12,cummulative_quantity13,cummulative_quantity14;



    private DatePickerDialog.OnDateSetListener bDateSetListener;
    private static final String TAG = "DispatchDetails";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dispatch_details);

        invoice_date1 = (EditText) findViewById(R.id.invoice1_date_txt);
        invoice1_no = (EditText)findViewById(R.id.invoice1_no);
        qunatity1 = (EditText)findViewById(R.id.quantity1);
        cummulative_quantity1 = (EditText)findViewById(R.id.cummulative_quantity1);



        invoice_date2 = (EditText) findViewById(R.id.invoice2_date_txt);
        invoice2_no = (EditText)findViewById(R.id.invoice2_no);
        qunatity2 = (EditText)findViewById(R.id.quantity2);
        cummulative_quantity2 = (EditText)findViewById(R.id.cummulative_quantity2);




        invoice_date3 = (EditText) findViewById(R.id.invoice3_date_txt);
        invoice3_no = (EditText)findViewById(R.id.invoice3_no);
        qunatity3 = (EditText)findViewById(R.id.quantity3);
        cummulative_quantity3 = (EditText)findViewById(R.id.cummulative_quantity3);


        invoice_date4 = (EditText) findViewById(R.id.invoice4_date_txt);
        invoice4_no = (EditText)findViewById(R.id.invoice4_no);
        qunatity4 = (EditText)findViewById(R.id.quantity4);
        cummulative_quantity4 = (EditText)findViewById(R.id.cummulative_quantity4);



        invoice_date5 = (EditText) findViewById(R.id.invoice5_date_txt);
        invoice5_no = (EditText)findViewById(R.id.invoice5_no);
        qunatity5 = (EditText)findViewById(R.id.quantity5);
        cummulative_quantity5 = (EditText)findViewById(R.id.cummulative_quantity5);



        invoice_date6 = (EditText) findViewById(R.id.invoice6_date_txt);
        invoice6_no = (EditText)findViewById(R.id.invoice6_no);
        qunatity6 = (EditText)findViewById(R.id.quantity6);
        cummulative_quantity6 = (EditText)findViewById(R.id.cummulative_quantity6);



        invoice_date7 = (EditText) findViewById(R.id.invoice7_date_txt);
        invoice7_no = (EditText)findViewById(R.id.invoice7_no);
        qunatity7 = (EditText)findViewById(R.id.quantity7);
        cummulative_quantity7 = (EditText)findViewById(R.id.cummulative_quantity7);



        invoice_date8 = (EditText) findViewById(R.id.invoice8_date_txt);
        invoice8_no = (EditText)findViewById(R.id.invoice8_no);
        qunatity8 = (EditText)findViewById(R.id.quantity8);
        cummulative_quantity8 = (EditText)findViewById(R.id.cummulative_quantity8);




        invoice_date9 = (EditText) findViewById(R.id.invoice9_date_txt);
        invoice9_no = (EditText)findViewById(R.id.invoice9_no);
        qunatity9 = (EditText)findViewById(R.id.quantity9);
        cummulative_quantity9 = (EditText)findViewById(R.id.cummulative_quantity9);



        invoice_date10 = (EditText) findViewById(R.id.invoice10_date_txt);
        invoice10_no = (EditText)findViewById(R.id.invoice10_no);
        qunatity10 = (EditText)findViewById(R.id.quantity10);
        cummulative_quantity10 = (EditText)findViewById(R.id.cummulative_quantity10);



        invoice_date11 = (EditText) findViewById(R.id.invoice11_date_txt);
        invoice11_no = (EditText)findViewById(R.id.invoice11_no);
        qunatity11 = (EditText)findViewById(R.id.quantity11);
        cummulative_quantity11 = (EditText)findViewById(R.id.cummulative_quantity11);



        invoice_date12 = (EditText) findViewById(R.id.invoice12_date_txt);
        invoice12_no = (EditText)findViewById(R.id.invoice12_no);
        qunatity12 = (EditText)findViewById(R.id.quantity12);
        cummulative_quantity12 = (EditText)findViewById(R.id.cummulative_quantity12);



        invoice_date13 = (EditText) findViewById(R.id.invoice13_date_txt);
        invoice13_no = (EditText)findViewById(R.id.invoice13_no);
        qunatity13 = (EditText)findViewById(R.id.quantity13);
        cummulative_quantity13 = (EditText)findViewById(R.id.cummulative_quantity13);


        invoice_date14 = (EditText) findViewById(R.id.invoice14_date_txt);
        invoice14_no = (EditText)findViewById(R.id.invoice14_no);
        qunatity14 = (EditText)findViewById(R.id.quantity14);
        cummulative_quantity14 = (EditText)findViewById(R.id.cummulative_quantity14);



        sheet_summary = (Button)findViewById(R.id.save_see_sheet_summary_btn);

        sheet_summary.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                // Switching to Register screen


                mRootRef = new Firebase("https://fastfind-289c3.firebaseio.com/"+"Sheets");


                final Firebase databaseRef = new Firebase("https://fastfind-289c3.firebaseio.com/"+"Sheets");



                Intent i = getIntent();

                String Id = i.getStringExtra("ID");




                Firebase childRef1 = databaseRef.child("SheetID "+Id);
                Firebase childRef = childRef1.child("DispatchDetails");

                Firebase childRef2 = childRef.child("SerialNo1");

                childRef2.child("Invoice No").setValue(invoice1_no.getText().toString());
                childRef2.child("Invoice Date").setValue(invoice_date1.getText().toString());
                childRef2.child("Quantity").setValue(qunatity1.getText().toString());
                childRef2.child("Cummulative Quantity").setValue(cummulative_quantity1.getText().toString());

                Firebase childRef3 = childRef.child("SerialNo2");

                childRef3.child("Invoice No").setValue(invoice2_no.getText().toString());
                childRef3.child("Invoice Date").setValue(invoice_date2.getText().toString());
                childRef3.child("Quantity").setValue(qunatity2.getText().toString());
                childRef3.child("Cummulative Quantity").setValue(cummulative_quantity2.getText().toString());


                Firebase childRef4 = childRef.child("SerialNo3");

                childRef4.child("Invoice No").setValue(invoice3_no.getText().toString());
                childRef4.child("Invoice Date").setValue(invoice_date3.getText().toString());
                childRef4.child("Quantity").setValue(qunatity3.getText().toString());
                childRef4.child("Cummulative Quantity").setValue(cummulative_quantity3.getText().toString());



                Firebase childRef5 = childRef.child("SerialNo4");

                childRef5.child("Invoice No").setValue(invoice4_no.getText().toString());
                childRef5.child("Invoice Date").setValue(invoice_date4.getText().toString());
                childRef5.child("Quantity").setValue(qunatity4.getText().toString());
                childRef5.child("Cummulative Quantity").setValue(cummulative_quantity4.getText().toString());




                Firebase childRef6 = childRef.child("SerialNo5");

                childRef6.child("Invoice No").setValue(invoice5_no.getText().toString());
                childRef6.child("Invoice Date").setValue(invoice_date5.getText().toString());
                childRef6.child("Quantity").setValue(qunatity5.getText().toString());
                childRef6.child("Cummulative Quantity").setValue(cummulative_quantity5.getText().toString());




                Firebase childRef7 = childRef.child("SerialNo6");

                childRef7.child("Invoice No").setValue(invoice6_no.getText().toString());
                childRef7.child("Invoice Date").setValue(invoice_date6.getText().toString());
                childRef7.child("Quantity").setValue(qunatity6.getText().toString());
                childRef7.child("Cummulative Quantity").setValue(cummulative_quantity6.getText().toString());



                Firebase childRef8 = childRef.child("SerialNo7");

                childRef8.child("Invoice No").setValue(invoice7_no.getText().toString());
                childRef8.child("Invoice Date").setValue(invoice_date7.getText().toString());
                childRef8.child("Quantity").setValue(qunatity7.getText().toString());
                childRef8.child("Cummulative Quantity").setValue(cummulative_quantity7.getText().toString());




                Firebase childRef9 = childRef.child("SerialNo8");

                childRef9.child("Invoice No").setValue(invoice8_no.getText().toString());
                childRef9.child("Invoice Date").setValue(invoice_date8.getText().toString());
                childRef9.child("Quantity").setValue(qunatity8.getText().toString());
                childRef9.child("Cummulative Quantity").setValue(cummulative_quantity8.getText().toString());


                Firebase childRef10 = childRef.child("SerialNo9");

                childRef10.child("Invoice No").setValue(invoice9_no.getText().toString());
                childRef10.child("Invoice Date").setValue(invoice_date9.getText().toString());
                childRef10.child("Quantity").setValue(qunatity9.getText().toString());
                childRef10.child("Cummulative Quantity").setValue(cummulative_quantity9.getText().toString());


                Firebase childRef11 = childRef.child("SerialNo10");

                childRef11.child("Invoice No").setValue(invoice10_no.getText().toString());
                childRef11.child("Invoice Date").setValue(invoice_date10.getText().toString());
                childRef11.child("Quantity").setValue(qunatity10.getText().toString());
                childRef11.child("Cummulative Quantity").setValue(cummulative_quantity10.getText().toString());




                Firebase childRef12 = childRef.child("SerialNo11");

                childRef12.child("Invoice No").setValue(invoice11_no.getText().toString());
                childRef12.child("Invoice Date").setValue(invoice_date11.getText().toString());
                childRef12.child("Quantity").setValue(qunatity11.getText().toString());
                childRef12.child("Cummulative Quantity").setValue(cummulative_quantity11.getText().toString());




                Firebase childRef13 = childRef.child("SerialNo12");

                childRef13.child("Invoice No").setValue(invoice12_no.getText().toString());
                childRef13.child("Invoice Date").setValue(invoice_date12.getText().toString());
                childRef13.child("Quantity").setValue(qunatity12.getText().toString());
                childRef13.child("Cummulative Quantity").setValue(cummulative_quantity12.getText().toString());





                Firebase childRef14 = childRef.child("SerialNo13");

                childRef14.child("Invoice No").setValue(invoice13_no.getText().toString());
                childRef14.child("Invoice Date").setValue(invoice_date13.getText().toString());
                childRef14.child("Quantity").setValue(qunatity13.getText().toString());
                childRef14.child("Cummulative Quantity").setValue(cummulative_quantity13.getText().toString());




                Firebase childRef15 = childRef.child("SerialNo14");

                childRef15.child("Invoice No").setValue(invoice14_no.getText().toString());
                childRef15.child("Invoice Date").setValue(invoice_date14.getText().toString());
                childRef15.child("Quantity").setValue(qunatity14.getText().toString());
                childRef15.child("Cummulative Quantity").setValue(cummulative_quantity14.getText().toString());



                Intent i1 = new Intent(getApplicationContext(), SheetSummary.class);
                startActivity(i1);
            }
        });



        invoice_date1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(
                        DispatchDetails.this,
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
                invoice_date1.setText(date);
            }
        };

        invoice_date2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(
                        DispatchDetails.this,
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
                invoice_date2.setText(date);
            }
        };
        invoice_date3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(
                        DispatchDetails.this,
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
                invoice_date3.setText(date);
            }
        };
        invoice_date4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(
                        DispatchDetails.this,
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
                invoice_date4.setText(date);
            }
        };
        invoice_date5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(
                        DispatchDetails.this,
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
                invoice_date5.setText(date);
            }
        };
        invoice_date6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(
                        DispatchDetails.this,
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
                invoice_date6.setText(date);
            }
        };
        invoice_date7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(
                        DispatchDetails.this,
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
                invoice_date7.setText(date);
            }
        };
        invoice_date8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(
                        DispatchDetails.this,
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
                invoice_date8.setText(date);
            }
        };
        invoice_date9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(
                        DispatchDetails.this,
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
                invoice_date9.setText(date);
            }
        };
        invoice_date10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(
                        DispatchDetails.this,
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
                invoice_date10.setText(date);
            }
        };
        invoice_date11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(
                        DispatchDetails.this,
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
                invoice_date11.setText(date);
            }
        };
        invoice_date12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(
                        DispatchDetails.this,
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
                invoice_date12.setText(date);
            }
        };
        invoice_date13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(
                        DispatchDetails.this,
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
                invoice_date13.setText(date);
            }
        };
        invoice_date14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(
                        DispatchDetails.this,
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
                invoice_date14.setText(date);
            }
        };

    }
}
