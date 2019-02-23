package com.example.hp.project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ChooseActivity extends AppCompatActivity {
    Button Search;
    Button SheetEntry;
    Button ViewReport;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose);

        Search = (Button) findViewById(R.id.search_bt);
        SheetEntry = (Button) findViewById(R.id.search_Entry);
        ViewReport = (Button) findViewById(R.id.View_Report);

//        Search.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                startActivity(Intent(getApplication(),Search.class));
//            }
//        });


        Search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplication(),SearchActivity.class));
            }
        });


        SheetEntry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplication(),Sheet_Card.class));
            }
        });
//        Search.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                startActivity(Intent(getApplication(),Search.class));
//            }
//        });

//        Intent i = new Intent(this, WorkOrderDetails.class);
//        startActivity(i);
    }
}
