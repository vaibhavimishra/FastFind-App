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

public class ProductionDetails7 extends AppCompatActivity {
    private static final String TAG = "ProductionDetails7";
    private DatePickerDialog.OnDateSetListener cDateSetListener;
    private DatePickerDialog.OnDateSetListener dDateSetListener;
    private EditText chamferingMcNo;
    private EditText chamferingStart;
    private EditText chamferingComplete;
    private EditText chamferingInputQty;
    private EditText chamferingAcceptedQty;
    private EditText chamferingRejectedQty;
    private TextView chamferingOutputQty;
    private TextView chamferingoutput;
    private EditText chamferingRecieptNo;
    private EditText chamferingRemark;
    Button next10Btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_production_details7);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        chamferingMcNo = (EditText)findViewById(R.id.chamfering_machine_no);
        chamferingStart = (EditText)findViewById(R.id.chamfering_start_date);
        chamferingComplete = (EditText) findViewById(R.id.chamfering_comp_date);
        chamferingInputQty = (EditText) findViewById(R.id.chamfering_input_quantity);
        chamferingAcceptedQty = (EditText) findViewById(R.id.chamfering_accepted_quantity);
        chamferingRejectedQty = (EditText) findViewById(R.id.chamfering_rejected_quantity);
        chamferingOutputQty = (TextView) findViewById(R.id.chamfering_output_qty1);
        chamferingoutput = (TextView)findViewById(R.id.chamfering_output_qty);
        chamferingRecieptNo = (EditText) findViewById(R.id.chamfering_prod_receipt_no);
        chamferingRemark = (EditText) findViewById(R.id.chamfering_remark);
        next10Btn = (Button)findViewById(R.id.next10_btn);

        next10Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (chamferingMcNo.getText().toString().length() == 0) {
                    chamferingMcNo.setError("Input Needed");
                    chamferingMcNo.requestFocus();
                }else if (chamferingStart.getText().toString().length() == 0) {
                    chamferingStart.setError("Input Needed");
                    chamferingStart.requestFocus();
                } else if (chamferingComplete.getText().toString().length() == 0) {
                    chamferingComplete.setError("Input Needed");
                    chamferingComplete.requestFocus();
                } else if (chamferingInputQty.getText().toString().length() == 0) {
                    chamferingInputQty.setError("Input Needed");
                    chamferingInputQty.requestFocus();
                } else if (chamferingAcceptedQty.getText().toString().length() == 0) {
                    chamferingAcceptedQty.setError("Input Needed");
                    chamferingAcceptedQty.requestFocus();
                } else if (chamferingRejectedQty.getText().toString().length() == 0) {
                    chamferingRejectedQty.setError("Input Needed");
                    chamferingRejectedQty.requestFocus();
                }else if(chamferingOutputQty.getText().toString().length() == 0){
                    chamferingOutputQty.setError("Input Needed");
                    chamferingOutputQty.requestFocus();
                }
                else {
                    Toast.makeText(ProductionDetails7.this, "Next clicked", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(getApplication(), ProductionDetails8.class));
                }
            }
        });

        chamferingStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(
                        ProductionDetails7.this,
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
                chamferingStart.setText(date);
            }
        };
        chamferingComplete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(
                        ProductionDetails7.this,
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
                chamferingComplete.setText(date);
            }
        };

        chamferingoutput.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int accepteQty = Integer.parseInt(chamferingAcceptedQty.getText().toString());
                int rejectQty = Integer.parseInt(chamferingRejectedQty.getText().toString());
                int result = accepteQty - rejectQty;
                chamferingOutputQty.setText(""+result);
            }
        });
    }
}



