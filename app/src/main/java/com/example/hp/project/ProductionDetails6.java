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

public class ProductionDetails6 extends AppCompatActivity {
    private static final String TAG = "ProductionDetails6";
    private DatePickerDialog.OnDateSetListener cDateSetListener;
    private DatePickerDialog.OnDateSetListener dDateSetListener;
    private EditText embossMcNo;
    private EditText embossStart;
    private EditText embossComplete;
    private EditText embossInputQty;
    private EditText embossAcceptedQty;
    private EditText embossRejectedQty;
    private TextView embossOutputQty;
    private TextView embossoutput;
    private EditText embossRecieptNo;
    private EditText embossRemark;
    Button next9Btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_production_details6);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        embossMcNo = (EditText)findViewById(R.id.emboss_machine_no);
        embossStart = (EditText)findViewById(R.id.emboss_start_date);
        embossComplete = (EditText) findViewById(R.id.emboss_comp_date);
        embossInputQty = (EditText) findViewById(R.id.emboss_input_quantity);
        embossAcceptedQty = (EditText) findViewById(R.id.emboss_accepted_quantity);
        embossRejectedQty = (EditText) findViewById(R.id.emboss_rejected_quantity);
        embossOutputQty = (TextView) findViewById(R.id.emboss_output_qty1);
        embossoutput = (TextView)findViewById(R.id.emboss_output_qty);
        embossRecieptNo = (EditText) findViewById(R.id.emboss_prod_receipt_no);
        embossRemark = (EditText) findViewById(R.id.emboss_remark);
        next9Btn = (Button)findViewById(R.id.next9_btn);

        next9Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (embossMcNo.getText().toString().length() == 0) {
                    embossMcNo.setError("Input Needed");
                    embossMcNo.requestFocus();
                }else if (embossStart.getText().toString().length() == 0) {
                    embossStart.setError("Input Needed");
                    embossStart.requestFocus();
                } else if (embossComplete.getText().toString().length() == 0) {
                    embossComplete.setError("Input Needed");
                    embossComplete.requestFocus();
                } else if (embossInputQty.getText().toString().length() == 0) {
                    embossInputQty.setError("Input Needed");
                    embossInputQty.requestFocus();
                } else if (embossAcceptedQty.getText().toString().length() == 0) {
                    embossAcceptedQty.setError("Input Needed");
                    embossAcceptedQty.requestFocus();
                } else if (embossRejectedQty.getText().toString().length() == 0) {
                    embossRejectedQty.setError("Input Needed");
                    embossRejectedQty.requestFocus();
                }else if(embossOutputQty.getText().toString().length() == 0){
                    embossOutputQty.setError("Input Needed");
                    embossOutputQty.requestFocus();
                }
                else {
                    Toast.makeText(ProductionDetails6.this, "Next clicked", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(getApplication(), ProductionDetails7.class));
                }
            }
        });

        embossStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(
                        ProductionDetails6.this,
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
                embossStart.setText(date);
            }
        };
        embossComplete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(
                        ProductionDetails6.this,
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
                embossComplete.setText(date);
            }
        };

        embossoutput.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int accepteQty = Integer.parseInt(embossAcceptedQty.getText().toString());
                int rejectQty = Integer.parseInt(embossRejectedQty.getText().toString());
                int result = accepteQty - rejectQty;
                embossOutputQty.setText(""+result);
            }
        });
    }
}


