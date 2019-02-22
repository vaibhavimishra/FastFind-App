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

public class ProductionDetails9 extends AppCompatActivity {
    private static final String TAG = "ProductionDetails9";
    private DatePickerDialog.OnDateSetListener cDateSetListener;
    private DatePickerDialog.OnDateSetListener dDateSetListener;
    private EditText inspectionMcNo;
    private EditText inspectionStart;
    private EditText inspectionComplete;
    private EditText inspectionInputQty;
    private EditText inspectionAcceptedQty;
    private EditText inspectionRejectedQty;
    private TextView inspectionOutputQty;
    private TextView inspectionoutput;
    private EditText inspectionRecieptNo;
    private EditText inspectionRemark;
    Button next11Btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_production_details9);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        inspectionMcNo = (EditText)findViewById(R.id.inspection_machine_no);
        inspectionStart = (EditText)findViewById(R.id.inspection_start_date);
        inspectionComplete = (EditText) findViewById(R.id.inspection_comp_date);
        inspectionInputQty = (EditText) findViewById(R.id.inspection_input_quantity);
        inspectionAcceptedQty = (EditText) findViewById(R.id.inspection_accepted_quantity);
        inspectionRejectedQty = (EditText) findViewById(R.id.inspection_rejected_quantity);
        inspectionOutputQty = (TextView) findViewById(R.id.inspection_output_qty1);
        inspectionoutput = (TextView)findViewById(R.id.inspection_output_qty);
        inspectionRecieptNo = (EditText) findViewById(R.id.inspection_prod_receipt_no);
        inspectionRemark = (EditText) findViewById(R.id.inspection_remark);
        next11Btn = (Button)findViewById(R.id.next11_btn);

        next11Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (inspectionMcNo.getText().toString().length() == 0) {
                    inspectionMcNo.setError("Input Needed");
                    inspectionMcNo.requestFocus();
                }else if (inspectionStart.getText().toString().length() == 0) {
                    inspectionStart.setError("Input Needed");
                    inspectionStart.requestFocus();
                } else if (inspectionComplete.getText().toString().length() == 0) {
                    inspectionComplete.setError("Input Needed");
                    inspectionComplete.requestFocus();
                } else if (inspectionInputQty.getText().toString().length() == 0) {
                    inspectionInputQty.setError("Input Needed");
                    inspectionInputQty.requestFocus();
                } else if (inspectionAcceptedQty.getText().toString().length() == 0) {
                    inspectionAcceptedQty.setError("Input Needed");
                    inspectionAcceptedQty.requestFocus();
                } else if (inspectionRejectedQty.getText().toString().length() == 0) {
                    inspectionRejectedQty.setError("Input Needed");
                    inspectionRejectedQty.requestFocus();
                }else if(inspectionOutputQty.getText().toString().length() == 0){
                    inspectionOutputQty.setError("Input Needed");
                    inspectionOutputQty.requestFocus();
                }
                else {
                    Toast.makeText(ProductionDetails9.this, "Next clicked", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(getApplication(), ProductionDetails10.class));
                }
            }
        });

        inspectionStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(
                        ProductionDetails9.this,
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
                inspectionStart.setText(date);
            }
        };
        inspectionComplete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(
                        ProductionDetails9.this,
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
                inspectionComplete.setText(date);
            }
        };

        inspectionoutput.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int accepteQty = Integer.parseInt(inspectionAcceptedQty.getText().toString());
                int rejectQty = Integer.parseInt(inspectionRejectedQty.getText().toString());
                int result = accepteQty - rejectQty;
                inspectionOutputQty.setText(""+result);
            }
        });
    }
}



