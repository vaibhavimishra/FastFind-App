package com.example.hp.project;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.provider.Settings;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.client.Firebase;
import com.google.firebase.database.DatabaseReference;

import static android.app.PendingIntent.getActivity;


public class LoginActivity extends AppCompatActivity {
   Button login;

    private Firebase mRootRef;

    CollapsingToolbarLayout collapsingToolbar=null;





    private static String gameNameFinal = null;
    private Uri filePath;

    private EditText editTextEventName;
    private EditText editTextEventDescription;

    private DatabaseReference databaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        login = (Button)findViewById(R.id.btn);


        TextView registerScreen = (TextView) findViewById(R.id.link_to_register);







        ConnectivityManager conMgr = (ConnectivityManager)this.getSystemService(Context.CONNECTIVITY_SERVICE);

        if ( conMgr.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState() == NetworkInfo.State.CONNECTED
                || conMgr.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState() == NetworkInfo.State.CONNECTED ) {

            // user is online
            //getSupportActionBar().setTitle("Sign In");


        }
        else if ( conMgr.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState() == NetworkInfo.State.DISCONNECTED
                || conMgr.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState() == NetworkInfo.State.DISCONNECTED) {

            // notify user you are not online

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("Please Connect to Internet")
                    .setCancelable(false)
                    .setPositiveButton("Connect to Internet", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            startActivity(new Intent(Settings.ACTION_WIFI_SETTINGS));
                        }
                    })
                    .setNegativeButton("Ok", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {

                            Toast.makeText(LoginActivity.this, "Connect To The Internet", Toast.LENGTH_SHORT).show();

                        }
                    });
            AlertDialog alert = builder.create();
            alert.show();
//
//            //getSupportActionBar().setTitle("Sign In");
//            ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle("Please Turn On Internet");


        }













        // Listening to register new account link
        registerScreen.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                // Switching to Register screen
                Intent i = new Intent(getApplicationContext(), RegisterActivity.class);
                startActivity(i);
            }
        });
















        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                    //Trial code


//                mRootRef = new Firebase("https://fastfind-289c3.firebaseio.com/"+"Sheets");
//
//
//                final Firebase databaseRef = new Firebase("https://fastfind-289c3.firebaseio.com/"+"Sheets");
//
//
//
//                Firebase childRef1 = databaseRef.push();
//                Firebase childRef = childRef1.child("Pre-Forming");


//                childRef.child("Pre-Forming MC NO").setValue("Hello");
//                    childRef.child("Pre-Forming Start").setValue(preFormingStart.getText().toString());
//                    childRef.child("Pre-Forming Complete").setValue(preFormingComplete.getText().toString());
//                    childRef.child("Pre-Forming Input Quantity").setValue(preFormingInputQty.getText().toString());

//                    childRef.child("Pre-Forming Accepted Quantity").setValue(preFormingAcceptedQty.getText().toString());
//                    childRef.child("Pre-Forming Rejected Quantity").setValue(preFormingRejectedQty.getText().toString());
//                    childRef.child("Pre-Forming Output Quantity").setValue(preFormingOutputQty.getText().toString());
//                    childRef.child("Pre-Forming Output").setValue(output.getText().toString());
//
//                    childRef.child("Pre-Forming Receipt No").setValue(preFormingRecieptNo.getText().toString());
//                    childRef.child("Pre-Forming Remark").setValue(preFormingRemark.getText().toString());















                startActivity(new Intent(getApplication(),ChooseActivity.class));
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();




    }


}
