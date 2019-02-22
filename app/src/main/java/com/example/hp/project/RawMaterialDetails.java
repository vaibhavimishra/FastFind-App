package com.example.hp.project;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.client.Firebase;
import com.google.firebase.database.DatabaseReference;

public class RawMaterialDetails extends AppCompatActivity {
    private static final String TAG = "RawMaterialDetails";
    int res;
    private EditText rmSpecC;
    private EditText sheetSizeC;
    private EditText numberSheetC;
    private EditText stripThicknessC;
    private EditText stripWidthC;
    private EditText stripLengthC;
    private EditText stripPerSheetC;
    private EditText blanksPerStripC;
    private EditText blanksPerSheetC;
    private TextView totalBlanksC;
    private TextView total;
    private Button next2Btn;

    private Firebase mRootRef;

    private static String gameNameFinal = null;
    private Uri filePath;

    private EditText editTextEventName;
    private EditText editTextEventDescription;

    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_raw_material_details);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);





        rmSpecC = (EditText) findViewById(R.id.rm_spec);
        sheetSizeC = (EditText) findViewById(R.id.sheet_size);
        numberSheetC = (EditText) findViewById(R.id.no_Sheet);
        stripThicknessC = (EditText) findViewById(R.id.strip_thickness);
        stripWidthC = (EditText) findViewById(R.id.strip_width);
        stripLengthC = (EditText) findViewById(R.id.strip_length);
        stripPerSheetC = (EditText) findViewById(R.id.strip_per_sheet);
        blanksPerStripC =(EditText)findViewById(R.id.blank_per_strip);
        blanksPerSheetC = (EditText) findViewById(R.id.blank_per_sheet);
        totalBlanksC = (TextView) findViewById(R.id.total_blanks);
        total = (TextView) findViewById(R.id.total);
        next2Btn = (Button)findViewById(R.id.next2_btn);

        next2Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (rmSpecC.getText().toString().length() == 0) {
                    rmSpecC.setError("Input Needed");
                    rmSpecC.requestFocus();
                }
                else if (sheetSizeC.getText().toString().length() == 0) {
                    sheetSizeC.setError("Input Needed");
                    sheetSizeC.requestFocus();
                } else if (numberSheetC.getText().toString().length() == 0) {
                    numberSheetC.setError("Input Needed");
                    numberSheetC.requestFocus();
                } else if (stripThicknessC.getText().toString().length() == 0) {
                    stripThicknessC.setError("Input Needed");
                    stripThicknessC.requestFocus();
                } else if (stripWidthC.getText().toString().length() == 0) {
                    stripWidthC.setError("Input Needed");
                    stripWidthC.requestFocus();
                } else if (stripLengthC.getText().toString().length() == 0) {
                    stripLengthC.setError("Input Needed");
                    stripLengthC.requestFocus();
                } else if (stripPerSheetC.getText().toString().length() == 0) {
                    stripPerSheetC.setError("Input Needed");
                    stripPerSheetC.requestFocus();
                } else if (blanksPerStripC.getText().toString().length() == 0) {
                    blanksPerStripC.setError("Input Needed");
                    blanksPerStripC.requestFocus();
                } else if (blanksPerSheetC.getText().toString().length() == 0) {
                    blanksPerSheetC.setError("Input Needed");
                    blanksPerSheetC.requestFocus();
                } else if (totalBlanksC.getText().toString().length() == 0) {
                    totalBlanksC.setError("Input Needed");
                    totalBlanksC.requestFocus();
                }
                else {


                    mRootRef = new Firebase("https://fastfind-289c3.firebaseio.com/"+"Sheets");


                    final Firebase databaseRef = new Firebase("https://fastfind-289c3.firebaseio.com/"+"Sheets");


                    Intent i = getIntent();

                    String Id = i.getStringExtra("ID");



                    Firebase childRef1 = databaseRef.child("SheetID "+Id);
                    Firebase childRef = childRef1.child("RawMaterialDetails");

                    childRef.child("RM Specification-Grade").setValue(rmSpecC.getText().toString());
                    childRef.child("Sheet Size-Coil").setValue(sheetSizeC.getText().toString());
                    childRef.child("Number Of Sheets Used").setValue(numberSheetC.getText().toString());
                    childRef.child("Strip Thickness").setValue(stripThicknessC.getText().toString());

                    childRef.child("Stript Width").setValue(stripWidthC.getText().toString());
                    childRef.child("Strip Length").setValue(stripLengthC.getText().toString());
                    childRef.child("Strips Per Sheet").setValue(stripPerSheetC.getText().toString());
                    childRef.child("Blanks Per Strip").setValue(blanksPerStripC.getText().toString());

                    childRef.child("Blanks Per Sheet").setValue(blanksPerSheetC.getText().toString());
                    childRef.child("Total Blanks").setValue(totalBlanksC.getText().toString());
                    childRef.child("Total").setValue(total.getText().toString());











                    Toast.makeText(RawMaterialDetails.this, "Next clicked", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(getApplication(), ProductionDetails.class));
                }
            }
        });

        total.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int strip1 = Integer.parseInt(stripPerSheetC.getText().toString());
                int blank1 = Integer.parseInt(blanksPerStripC.getText().toString());
                int blank2 = Integer.parseInt(blanksPerSheetC.getText().toString());
                res = strip1*blank1*blank2;
                totalBlanksC.setText(""+res);
            }
        } );

    }
}
