package com.example.hp.project;

import android.*;
import android.Manifest;
import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.pdf.PdfDocument;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.Handler;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.client.ChildEventListener;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.draw.LineSeparator;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;


public class SearchActivity extends AppCompatActivity implements View.OnClickListener {
    private static final int STORAGE_CODE = 1;
    private TextView t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,t12,t13,t14;
    private Firebase mRef;

    static Integer sheetSearched=null;



    private EditText heatCode;
    private EditText invoiceNo;

    Button downloadBtn;

    private Button search;

    List<SheetObject> allSheet;
    private String sheetID = new String();



    private ListView listView;

    private String[] invoice_array = new String[14];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        t1=(TextView)findViewById(R.id.i1);
        t2=(TextView)findViewById(R.id.i2);
        t3=(TextView)findViewById(R.id.i3);
        t4=(TextView)findViewById(R.id.i4);
        t5=(TextView)findViewById(R.id.i5);
        t6=(TextView)findViewById(R.id.i6);
        t7=(TextView)findViewById(R.id.i7);
        t8=(TextView)findViewById(R.id.i8);
        t9=(TextView)findViewById(R.id.i9);
        t10=(TextView)findViewById(R.id.i10);
        t11=(TextView)findViewById(R.id.i11);
        t12=(TextView)findViewById(R.id.i12);
        t13=(TextView)findViewById(R.id.i13);
        t14=(TextView)findViewById(R.id.i14);







        heatCode = (EditText) findViewById(R.id.password);

        invoiceNo = (EditText)findViewById(R.id.textInput_invoice_number);


        search = (Button)findViewById(R.id.search);

        downloadBtn = (Button)findViewById(R.id.downloadBtn);

        downloadBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {






                int result = ContextCompat.checkSelfPermission(SearchActivity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE);

                if (result == PackageManager.PERMISSION_GRANTED)
                {

                    //If permission is granted returning true

                    final ProgressDialog dialog = ProgressDialog.show(SearchActivity.this, "",
                            "Downloading...", true);


                    Handler handler = new Handler();
                    final ProgressDialog finalPDialog = dialog;
                    handler.postDelayed(new Runnable() {
                        public void run() {




                            savePdf();



                            finalPDialog.dismiss();

                        }
                    }, 2000); // 3000 milliseconds delay


                }else {
                    //If permission is not granted returning false


                    ActivityCompat.requestPermissions(SearchActivity.this,
                            new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                            1);

                }





            }

        });

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {




                if(invoiceNo.getText().toString().isEmpty() && heatCode.getText().toString().isEmpty()){


                    Toast.makeText(SearchActivity.this, "Please Enter Input To Search!", Toast.LENGTH_SHORT).show();

                }

                if(!invoiceNo.getText().toString().isEmpty()) {


                    int isSuccess=0;
                    String invoice = invoiceNo.getText().toString();
                    for (int i = 0; i < allSheet.size(); i++) {


                        for(int j=0;j<13;j++){

                            if(allSheet.get(i).dispatchDetailsObject.SerialNos.get(j).getInvoiceNo().equalsIgnoreCase(invoice)){

                                heatCode.setText(allSheet.get(i).workOrderDetailsObject.getHeatCode());
                                t1.setText(allSheet.get(i).workOrderDetailsObject.getHeatCode());
                                sheetSearched = i;

                                isSuccess=1;
                            }
                        }

                    }
                    if(isSuccess==0){
                        Toast.makeText(SearchActivity.this, "Invalid Invoice No!", Toast.LENGTH_SHORT).show();
                    }



                }

                 if(!heatCode.getText().toString().isEmpty()){




                     Log.e("Sheets" , ""+allSheet);


                     Log.e("First",""+allSheet.get(1).sheetID);
                     Log.e("First",""+allSheet.get(1).workOrderDetailsObject.getCustomerName());
                     Log.e("First",""+allSheet.get(1).dispatchDetailsObject.SerialNos.get(5).getInvoiceNo());




                     String code = heatCode.getText().toString();
                     int isSuccess=0;

                     for(int i=0;i<allSheet.size();i++){

                         if(allSheet.get(i).sheetID.equalsIgnoreCase("SheetID "+code)){

                                isSuccess=1;

                             sheetSearched = i;




//                        invoice_array[0] = allSheet.get(i).dispatchDetailsObject.SerialNos.get(0).getInvoiceNo();
//
//
//                        invoice_array[1] = allSheet.get(i).dispatchDetailsObject.SerialNos.get(1).getInvoiceNo();
//
//                        invoice_array[2] = allSheet.get(i).dispatchDetailsObject.SerialNos.get(2).getInvoiceNo();
//
//                        invoice_array[3] = allSheet.get(i).dispatchDetailsObject.SerialNos.get(3).getInvoiceNo();
//
//                        invoice_array[4] = allSheet.get(i).dispatchDetailsObject.SerialNos.get(4).getInvoiceNo();
//
//                        invoice_array[5] = allSheet.get(i).dispatchDetailsObject.SerialNos.get(5).getInvoiceNo();
//
//                        invoice_array[6] = allSheet.get(i).dispatchDetailsObject.SerialNos.get(6).getInvoiceNo();
//
//                        invoice_array[7] = allSheet.get(i).dispatchDetailsObject.SerialNos.get(7).getInvoiceNo();
//
//                        invoice_array[8] = allSheet.get(i).dispatchDetailsObject.SerialNos.get(8).getInvoiceNo();
//
//                        invoice_array[9] = allSheet.get(i).dispatchDetailsObject.SerialNos.get(9).getInvoiceNo();
//
//                        invoice_array[10] = allSheet.get(i).dispatchDetailsObject.SerialNos.get(10).getInvoiceNo();
//
//                        invoice_array[11] = allSheet.get(i).dispatchDetailsObject.SerialNos.get(11).getInvoiceNo();
//
//                        invoice_array[12] = allSheet.get(i).dispatchDetailsObject.SerialNos.get(12).getInvoiceNo();
//
//                        invoice_array[13] = allSheet.get(i).dispatchDetailsObject.SerialNos.get(13).getInvoiceNo();

                             t1.setText(allSheet.get(i).dispatchDetailsObject.SerialNos.get(0).getInvoiceNo());
                             t6.setText(allSheet.get(i).dispatchDetailsObject.SerialNos.get(10).getInvoiceNo());

                             t7.setText(allSheet.get(i).dispatchDetailsObject.SerialNos.get(11).getInvoiceNo());

                             t8.setText(allSheet.get(i).dispatchDetailsObject.SerialNos.get(12).getInvoiceNo());

                             t9.setText(allSheet.get(i).dispatchDetailsObject.SerialNos.get(13).getInvoiceNo());


                             t10.setText(allSheet.get(i).dispatchDetailsObject.SerialNos.get(1).getInvoiceNo());
                             t11.setText(allSheet.get(i).dispatchDetailsObject.SerialNos.get(2).getInvoiceNo());

                             t12.setText(allSheet.get(i).dispatchDetailsObject.SerialNos.get(3).getInvoiceNo());

                             t13.setText(allSheet.get(i).dispatchDetailsObject.SerialNos.get(4).getInvoiceNo());


                             t14.setText(allSheet.get(i).dispatchDetailsObject.SerialNos.get(5).getInvoiceNo());


                             t2.setText(allSheet.get(i).dispatchDetailsObject.SerialNos.get(6).getInvoiceNo());
                             t3.setText(allSheet.get(i).dispatchDetailsObject.SerialNos.get(7).getInvoiceNo());
                             t4.setText(allSheet.get(i).dispatchDetailsObject.SerialNos.get(8).getInvoiceNo());
                             t5.setText(allSheet.get(i).dispatchDetailsObject.SerialNos.get(9).getInvoiceNo());


                             Log.e("Searched cham acc",""+allSheet.get(i).productionDetailsObject.chamfering.getChamferingAcceptedQty());

                             Log.e("Searched cham co",""+allSheet.get(i).productionDetailsObject.chamfering.getChamferingComplete());
                             Log.e("Searched Quantity",""+allSheet.get(i).dispatchDetailsObject.SerialNos.get(0).getQuantity());




                             //t5.setText(allSheet.get(i).dispatchDetailsObject.SerialNos.get(4).getInvoiceNo());
//                        t6.setText(allSheet.get(i).dispatchDetailsObject.SerialNos.get(5).getInvoiceNo());
//                        t7.setText(allSheet.get(i).dispatchDetailsObject.SerialNos.get(6).getInvoiceNo());
//                        t8.setText(allSheet.get(i).dispatchDetailsObject.SerialNos.get(7).getInvoiceNo());
//                        t9.setText(allSheet.get(i).dispatchDetailsObject.SerialNos.get(8).getInvoiceNo());
//                        t10.setText(allSheet.get(i).dispatchDetailsObject.SerialNos.get(9).getInvoiceNo());
//                        t11.setText(allSheet.get(i).dispatchDetailsObject.SerialNos.get(10).getInvoiceNo());
//                        t12.setText(allSheet.get(i).dispatchDetailsObject.SerialNos.get(11).getInvoiceNo());
//                        t13.setText(allSheet.get(i).dispatchDetailsObject.SerialNos.get(12).getInvoiceNo());


//                        invoiceArray.add(allSheet.get(i).dispatchDetailsObject.SerialNos.get(0).getInvoiceNo());
//
//                        invoiceArray.add(allSheet.get(i).dispatchDetailsObject.SerialNos.get(1).getInvoiceNo());
//
//                        invoiceArray.add(allSheet.get(i).dispatchDetailsObject.SerialNos.get(2).getInvoiceNo());

//                        invoiceArray.add(allSheet.get(i).dispatchDetailsObject.SerialNos.get(3).getInvoiceNo());
//
//                        invoiceArray.add(allSheet.get(i).dispatchDetailsObject.SerialNos.get(4).getInvoiceNo());
//
//                        invoiceArray.add(allSheet.get(i).dispatchDetailsObject.SerialNos.get(5).getInvoiceNo());
//
//                        invoiceArray.add(allSheet.get(i).dispatchDetailsObject.SerialNos.get(6).getInvoiceNo());
//
//                        invoiceArray.add(allSheet.get(i).dispatchDetailsObject.SerialNos.get(7).getInvoiceNo());
//
//                        invoiceArray.add(allSheet.get(i).dispatchDetailsObject.SerialNos.get(8).getInvoiceNo());
//
//                        invoiceArray.add(allSheet.get(i).dispatchDetailsObject.SerialNos.get(9).getInvoiceNo());
//
//                        invoiceArray.add(allSheet.get(i).dispatchDetailsObject.SerialNos.get(10).getInvoiceNo());
//
//                        invoiceArray.add(allSheet.get(i).dispatchDetailsObject.SerialNos.get(11).getInvoiceNo());
//
//                        invoiceArray.add(allSheet.get(i).dispatchDetailsObject.SerialNos.get(12).getInvoiceNo());
//
//                        invoiceArray.add(allSheet.get(i).dispatchDetailsObject.SerialNos.get(13).getInvoiceNo());
//












//                        Intent i1 = new Intent(getApplication(),Result.class);
//
//                        i1.putExtra("mysheet", (Parcelable) allSheet.get(i));
//
//
//
//
//
//
//
//                        Toast.makeText(getApplicationContext(), "Sheet Found!", Toast.LENGTH_SHORT).show();
//                        startActivity(i1);


                         }



                     }
                     if(isSuccess==0){
                         Toast.makeText(SearchActivity.this, "Invalid Heat Code!", Toast.LENGTH_SHORT).show();
                     }
                     // Convert ArrayList to array
                     //   invoice_array = (String[]) invoiceArray.toArray();















//                startActivity(new Intent(getApplication(),Result.class));











                 }



            }
        });




        allSheet = new ArrayList<SheetObject>();

        mRef = new Firebase("https://fastfind-289c3.firebaseio.com/");








    }

    private void savePdf(){


        if(sheetSearched!=null){

            //sheet is searched


            Document mDoc = new Document();
            //pdf file name

            String mFileName = new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault()).format(System.currentTimeMillis());

            //pdf file path

            String mPath  = Environment.getExternalStorageDirectory()+"/"+mFileName+".pdf";
            try{

                //create instance of pdf writer class
                PdfWriter.getInstance(mDoc,new FileOutputStream(mPath));

                //open document for writing
                mDoc.open();









                //add author of the document
                mDoc.addAuthor("Dhananjay Enterprises");
                mDoc.addTitle("Sheet Details");
                mDoc.addCreationDate();
                mDoc.addCreator("Dhananjay Enterprises");


                // LINE SEPARATOR
                LineSeparator lineSeparator = new LineSeparator();
                lineSeparator.setLineColor(new BaseColor(0, 0, 0, 68));











                Chunk mOrderDetailsTitleChunk = new Chunk("Dhananjay Enterprises");
// Creating Paragraph to add...
                Paragraph mOrderDetailsTitleParagraph = new Paragraph(mOrderDetailsTitleChunk);
// Setting Alignment for Heading
                mOrderDetailsTitleParagraph.setAlignment(Element.ALIGN_CENTER);
// Finally Adding that Chunk
                mDoc.add(mOrderDetailsTitleParagraph);




                Chunk head = new Chunk("HeatCode "+allSheet.get(sheetSearched).sheetID );

                mDoc.add(new Paragraph(head));

                //break line and add line separator
                mDoc.add(new Paragraph(""));
                mDoc.add(new Chunk(lineSeparator));
                mDoc.add(new Paragraph(""));


                //add paragraph to the document

                Chunk mOrderIdChunk = new Chunk("DISPATCH DETAILS:");
                Paragraph mOrderIdParagraph = new Paragraph(mOrderIdChunk);
                mDoc.add(mOrderIdParagraph);

                //break line
                mDoc.add(new Paragraph(""));


                //Dispatch Details Print
                mDoc.add(new Paragraph("Invoice Numbers\n  "+allSheet.get(sheetSearched).dispatchDetailsObject.SerialNos.get(0).getInvoiceNo()
                +" " + allSheet.get(sheetSearched).dispatchDetailsObject.SerialNos.get(6).getInvoiceNo() + " " + allSheet.get(sheetSearched).dispatchDetailsObject.SerialNos.get(7).getInvoiceNo()
                        + " "+ allSheet.get(sheetSearched).dispatchDetailsObject.SerialNos.get(8).getInvoiceNo()
                        + " " + allSheet.get(sheetSearched).dispatchDetailsObject.SerialNos.get(9).getInvoiceNo()
                        + " "+ allSheet.get(sheetSearched).dispatchDetailsObject.SerialNos.get(10).getInvoiceNo()
                        + " "+ allSheet.get(sheetSearched).dispatchDetailsObject.SerialNos.get(11).getInvoiceNo()
                        + " "+ allSheet.get(sheetSearched).dispatchDetailsObject.SerialNos.get(12).getInvoiceNo()
                        + " "+ allSheet.get(sheetSearched).dispatchDetailsObject.SerialNos.get(13).getInvoiceNo()
                        + " "+ allSheet.get(sheetSearched).dispatchDetailsObject.SerialNos.get(1).getInvoiceNo()
                        + " "+ allSheet.get(sheetSearched).dispatchDetailsObject.SerialNos.get(2).getInvoiceNo()
                        + " "+ allSheet.get(sheetSearched).dispatchDetailsObject.SerialNos.get(3).getInvoiceNo()
                        + " "+ allSheet.get(sheetSearched).dispatchDetailsObject.SerialNos.get(4).getInvoiceNo()
                        + " "+ allSheet.get(sheetSearched).dispatchDetailsObject.SerialNos.get(5).getInvoiceNo()
                ));

                //break line
                mDoc.add(new Paragraph(""));

                mDoc.add(new Paragraph("Cumulative Quantity\n"
                        + " "+ allSheet.get(sheetSearched).dispatchDetailsObject.SerialNos.get(0).getCumulativeQuantity()
                        + " "+ allSheet.get(sheetSearched).dispatchDetailsObject.SerialNos.get(6).getCumulativeQuantity()
                        + " "+ allSheet.get(sheetSearched).dispatchDetailsObject.SerialNos.get(7).getCumulativeQuantity()
                        + " "+ allSheet.get(sheetSearched).dispatchDetailsObject.SerialNos.get(8).getCumulativeQuantity()
                        + " "+ allSheet.get(sheetSearched).dispatchDetailsObject.SerialNos.get(9).getCumulativeQuantity()
                        + " "+ allSheet.get(sheetSearched).dispatchDetailsObject.SerialNos.get(10).getCumulativeQuantity()
                        + " "+ allSheet.get(sheetSearched).dispatchDetailsObject.SerialNos.get(11).getCumulativeQuantity()
                        + " "+ allSheet.get(sheetSearched).dispatchDetailsObject.SerialNos.get(12).getCumulativeQuantity()
                        + " "+ allSheet.get(sheetSearched).dispatchDetailsObject.SerialNos.get(13).getCumulativeQuantity()
                        + " "+ allSheet.get(sheetSearched).dispatchDetailsObject.SerialNos.get(1).getCumulativeQuantity()
                        + " "+ allSheet.get(sheetSearched).dispatchDetailsObject.SerialNos.get(2).getCumulativeQuantity()
                        + " "+ allSheet.get(sheetSearched).dispatchDetailsObject.SerialNos.get(3).getCumulativeQuantity()
                        + " "+ allSheet.get(sheetSearched).dispatchDetailsObject.SerialNos.get(4).getCumulativeQuantity()
                        + " "+ allSheet.get(sheetSearched).dispatchDetailsObject.SerialNos.get(5).getCumulativeQuantity()
                ));
                //break line
                mDoc.add(new Paragraph(""));

                mDoc.add(new Paragraph("Invoice Date\n"
                        + " "+ allSheet.get(sheetSearched).dispatchDetailsObject.SerialNos.get(0).getInvoiceDate()
                        + " "+ allSheet.get(sheetSearched).dispatchDetailsObject.SerialNos.get(6).getInvoiceDate()
                        + " "+ allSheet.get(sheetSearched).dispatchDetailsObject.SerialNos.get(7).getInvoiceDate()
                        + " "+ allSheet.get(sheetSearched).dispatchDetailsObject.SerialNos.get(8).getInvoiceDate()
                        + " "+ allSheet.get(sheetSearched).dispatchDetailsObject.SerialNos.get(9).getInvoiceDate()
                        + " "+ allSheet.get(sheetSearched).dispatchDetailsObject.SerialNos.get(10).getInvoiceDate()
                        + " "+ allSheet.get(sheetSearched).dispatchDetailsObject.SerialNos.get(11).getInvoiceDate()
                        + " "+ allSheet.get(sheetSearched).dispatchDetailsObject.SerialNos.get(12).getInvoiceDate()
                        + " "+ allSheet.get(sheetSearched).dispatchDetailsObject.SerialNos.get(13).getInvoiceDate()
                        + " "+ allSheet.get(sheetSearched).dispatchDetailsObject.SerialNos.get(1).getInvoiceDate()
                        + " "+ allSheet.get(sheetSearched).dispatchDetailsObject.SerialNos.get(2).getInvoiceDate()
                        + " "+ allSheet.get(sheetSearched).dispatchDetailsObject.SerialNos.get(3).getInvoiceDate()
                        + " "+ allSheet.get(sheetSearched).dispatchDetailsObject.SerialNos.get(4).getInvoiceDate()
                        + " "+ allSheet.get(sheetSearched).dispatchDetailsObject.SerialNos.get(5).getInvoiceDate()
                ));



                mDoc.add(new Paragraph("Quantity\n"
                        + " "+ allSheet.get(sheetSearched).dispatchDetailsObject.SerialNos.get(0).getQuantity()
                        + " "+ allSheet.get(sheetSearched).dispatchDetailsObject.SerialNos.get(6).getQuantity()
                        + " "+ allSheet.get(sheetSearched).dispatchDetailsObject.SerialNos.get(7).getQuantity()
                        + " "+ allSheet.get(sheetSearched).dispatchDetailsObject.SerialNos.get(8).getQuantity()
                        + " "+ allSheet.get(sheetSearched).dispatchDetailsObject.SerialNos.get(9).getQuantity()
                        + " "+ allSheet.get(sheetSearched).dispatchDetailsObject.SerialNos.get(10).getQuantity()
                        + " "+ allSheet.get(sheetSearched).dispatchDetailsObject.SerialNos.get(11).getQuantity()
                        + " "+ allSheet.get(sheetSearched).dispatchDetailsObject.SerialNos.get(12).getQuantity()
                        + " "+ allSheet.get(sheetSearched).dispatchDetailsObject.SerialNos.get(13).getQuantity()
                        + " "+ allSheet.get(sheetSearched).dispatchDetailsObject.SerialNos.get(1).getQuantity()
                        + " "+ allSheet.get(sheetSearched).dispatchDetailsObject.SerialNos.get(2).getQuantity()
                        + " "+ allSheet.get(sheetSearched).dispatchDetailsObject.SerialNos.get(3).getQuantity()
                        + " "+ allSheet.get(sheetSearched).dispatchDetailsObject.SerialNos.get(4).getQuantity()
                        + " "+ allSheet.get(sheetSearched).dispatchDetailsObject.SerialNos.get(5).getQuantity()
                ));

                //break line and add line separator
                mDoc.add(new Paragraph(""));
                mDoc.add(new Chunk(lineSeparator));
                mDoc.add(new Paragraph(""));

                //production Details
                mDoc.add(new Paragraph("PRODUCTION DETAILS :\n"));

                //Chamfering
                mDoc.add(new Paragraph("Chamfering \n"
                        + "Chamfering Accepted Qty: "+ allSheet.get(sheetSearched).productionDetailsObject.chamfering.ChamferingAcceptedQty + "\n"
                        + "Chamfering Complete: "+ allSheet.get(sheetSearched).productionDetailsObject.chamfering.ChamferingComplete + "\n"
                        + "Chamfering Input Qty: "+ allSheet.get(sheetSearched).productionDetailsObject.chamfering.ChamferingInputQty + "\n"
                        + "Chamfering Mc No: "+ allSheet.get(sheetSearched).productionDetailsObject.chamfering.ChamferingMcNo + "\n"
                        + "Chamfering Output Qty: "+ allSheet.get(sheetSearched).productionDetailsObject.chamfering.ChamferingOutputQty + "\n"
                        + "Chamfering Receipt No: "+ allSheet.get(sheetSearched).productionDetailsObject.chamfering.ChamferingReceiptNo + "\n"
                        + "Chamfering Rejected Qty: "+ allSheet.get(sheetSearched).productionDetailsObject.chamfering.ChamferingRejectedQty + "\n"
                        + "Chamfering Remark: "+ allSheet.get(sheetSearched).productionDetailsObject.chamfering.ChamferingRemark + "\n"
                        + "Chamfering Start: "+ allSheet.get(sheetSearched).productionDetailsObject.chamfering.ChamferingStart + "\n"
                        + "Chamfering Output: "+ allSheet.get(sheetSearched).productionDetailsObject.chamfering.Chamferingoutput + "\n"

                ));

                //break line
                mDoc.add(new Paragraph("\n----------------------------\n"));

                //Deburring
                mDoc.add(new Paragraph("Deburring \n"
                        + "Deburring Accepted Qty: "+ allSheet.get(sheetSearched).productionDetailsObject.deburring.DeburringAcceptedQty + "\n"
                        + "Deburring Complete: "+ allSheet.get(sheetSearched).productionDetailsObject.deburring.DeburringComplete + "\n"
                        + "Deburring Input Qty: "+ allSheet.get(sheetSearched).productionDetailsObject.deburring.DeburringInputQty + "\n"
                        + "Deburring Mc No: "+ allSheet.get(sheetSearched).productionDetailsObject.deburring.DeburringMcNo + "\n"
                        + "Deburring Output Qty: "+ allSheet.get(sheetSearched).productionDetailsObject.deburring.DeburringOutputQty + "\n"
                        + "Deburring Receipt No: "+ allSheet.get(sheetSearched).productionDetailsObject.deburring.DeburringReceiptNo + "\n"
                        + "Deburring Rejected Qty: "+ allSheet.get(sheetSearched).productionDetailsObject.deburring.DeburringRejectedQty + "\n"
                        + "Deburring Remark: "+ allSheet.get(sheetSearched).productionDetailsObject.deburring.DeburringRemark + "\n"
                        + "Deburring Start: "+ allSheet.get(sheetSearched).productionDetailsObject.deburring.DeburringStart + "\n"
                        + "Deburring Output: "+ allSheet.get(sheetSearched).productionDetailsObject.deburring.Deburringoutput + "\n"

                ));

                //break line
                mDoc.add(new Paragraph("\n----------------------------\n"));


                //Eadge Trimming
                mDoc.add(new Paragraph("Eadge Trimming \n"
                        + "Eadge Trimming Accepted Qty: "+ allSheet.get(sheetSearched).productionDetailsObject.eadgeTrimming.EadgeTrimmingAcceptedQty + "\n"
                        + "Eadge Trimming Complete: "+ allSheet.get(sheetSearched).productionDetailsObject.eadgeTrimming.EadgeTrimmingComplete + "\n"
                        + "Eadge Trimming Input Qty: "+ allSheet.get(sheetSearched).productionDetailsObject.eadgeTrimming.EadgeTrimmingInputQty + "\n"
                        + "Eadge Trimming Mc No: "+ allSheet.get(sheetSearched).productionDetailsObject.eadgeTrimming.EadgeTrimmingMcNo + "\n"
                        + "Eadge Trimming Output Qty: "+ allSheet.get(sheetSearched).productionDetailsObject.eadgeTrimming.EadgeTrimmingOutputQty + "\n"
                        + "Eadge Trimming Receipt No: "+ allSheet.get(sheetSearched).productionDetailsObject.eadgeTrimming.EadgeTrimmingReceiptNo + "\n"
                        + "Eadge Trimming Rejected Qty: "+ allSheet.get(sheetSearched).productionDetailsObject.eadgeTrimming.EadgeTrimmingRejectedQty + "\n"
                        + "Eadge Trimming Remark: "+ allSheet.get(sheetSearched).productionDetailsObject.eadgeTrimming.EadgeTrimmingRemark + "\n"
                        + "Eadge Trimming Start: "+ allSheet.get(sheetSearched).productionDetailsObject.eadgeTrimming.EadgeTrimmingStart + "\n"
                        + "Eadge Trimming Output: "+ allSheet.get(sheetSearched).productionDetailsObject.eadgeTrimming.EadgeTrimmingoutput + "\n"

                ));

                //break line
                mDoc.add(new Paragraph("\n----------------------------\n"));



                //Emboss
                mDoc.add(new Paragraph("Emboss \n"
                        + "Emboss Accepted Qty: "+ allSheet.get(sheetSearched).productionDetailsObject.emboss.EmbossAcceptedQty + "\n"
                        + "Emboss Complete: "+ allSheet.get(sheetSearched).productionDetailsObject.emboss.EmbossComplete + "\n"
                        + "Emboss Input Qty: "+ allSheet.get(sheetSearched).productionDetailsObject.emboss.EmbossInputQty + "\n"
                        + "Emboss Mc No: "+ allSheet.get(sheetSearched).productionDetailsObject.emboss.EmbossMcNo + "\n"
                        + "Emboss Output Qty: "+ allSheet.get(sheetSearched).productionDetailsObject.emboss.EmbossOutputQty + "\n"
                        + "Emboss Receipt No: "+ allSheet.get(sheetSearched).productionDetailsObject.emboss.EmbossReceiptNo + "\n"
                        + "Emboss Rejected Qty: "+ allSheet.get(sheetSearched).productionDetailsObject.emboss.EmbossRejectedQty + "\n"
                        + "Emboss Remark: "+ allSheet.get(sheetSearched).productionDetailsObject.emboss.EmbossRemark + "\n"
                        + "Emboss Start: "+ allSheet.get(sheetSearched).productionDetailsObject.emboss.EmbossStart + "\n"
                        + "Emboss Output: "+ allSheet.get(sheetSearched).productionDetailsObject.emboss.Embossoutput + "\n"

                ));

                //break line
                mDoc.add(new Paragraph("\n----------------------------\n"));


                //Full Forming
                mDoc.add(new Paragraph("Full Forming \n"
                        + "Full Forming Accepted Qty: "+ allSheet.get(sheetSearched).productionDetailsObject.fullForming.FullFormingQty + "\n"
                        + "Full Forming Complete: "+ allSheet.get(sheetSearched).productionDetailsObject.fullForming.FullFormingComplete + "\n"
                        + "Full Forming Input Qty: "+ allSheet.get(sheetSearched).productionDetailsObject.fullForming.FullFormingInputQty + "\n"
                        + "Full Forming Mc No: "+ allSheet.get(sheetSearched).productionDetailsObject.fullForming.FullFormingMcNo + "\n"
                        + "Full Forming Output Qty: "+ allSheet.get(sheetSearched).productionDetailsObject.fullForming.FullFormingOutputQty + "\n"
                        + "Full Forming Receipt No: "+ allSheet.get(sheetSearched).productionDetailsObject.fullForming.FullFormingReceiptNo + "\n"
                        + "Full Forming Rejected Qty: "+ allSheet.get(sheetSearched).productionDetailsObject.fullForming.FullFormingRejectedQty + "\n"
                        + "Full Forming Remark: "+ allSheet.get(sheetSearched).productionDetailsObject.fullForming.FullFormingRemark + "\n"
                        + "Full Forming Start: "+ allSheet.get(sheetSearched).productionDetailsObject.fullForming.FullFormingStart + "\n"
                        + "Full Forming Output: "+ allSheet.get(sheetSearched).productionDetailsObject.fullForming.FullFormingoutput + "\n"

                ));

                //break line
                mDoc.add(new Paragraph("\n----------------------------\n"));



                //Inspection
                mDoc.add(new Paragraph("Inspection \n"
                        + "Inspection Accepted Qty: "+ allSheet.get(sheetSearched).productionDetailsObject.inspection.InspectionQty + "\n"
                        + "Inspection Complete: "+ allSheet.get(sheetSearched).productionDetailsObject.inspection.InspectionComplete + "\n"
                        + "Inspection Input Qty: "+ allSheet.get(sheetSearched).productionDetailsObject.inspection.InspectionInputQty + "\n"
                        + "Inspection Mc No: "+ allSheet.get(sheetSearched).productionDetailsObject.inspection.InspectionMcNo + "\n"
                        + "Inspection Output Qty: "+ allSheet.get(sheetSearched).productionDetailsObject.inspection.InspectionOutputQty + "\n"
                        + "Inspection Receipt No: "+ allSheet.get(sheetSearched).productionDetailsObject.inspection.InspectionReceiptNo + "\n"
                        + "Inspection Rejected Qty: "+ allSheet.get(sheetSearched).productionDetailsObject.inspection.InspectionRejectedQty + "\n"
                        + "Inspection Remark: "+ allSheet.get(sheetSearched).productionDetailsObject.inspection.InspectionRemark + "\n"
                        + "Inspection Start: "+ allSheet.get(sheetSearched).productionDetailsObject.inspection.InspectionStart + "\n"
                        + "Inspection Output: "+ allSheet.get(sheetSearched).productionDetailsObject.inspection.Inspectionoutput + "\n"

                ));

                //break line
                mDoc.add(new Paragraph("\n----------------------------\n"));


                //Packing
                mDoc.add(new Paragraph("Packing \n"
                        + "Packing Accepted Qty: "+ allSheet.get(sheetSearched).productionDetailsObject.packing.PackingQty + "\n"
                        + "Packing Complete: "+ allSheet.get(sheetSearched).productionDetailsObject.packing.PackingComplete + "\n"
                        + "Packing Input Qty: "+ allSheet.get(sheetSearched).productionDetailsObject.packing.PackingInputQty + "\n"
                        + "Packing Mc No: "+ allSheet.get(sheetSearched).productionDetailsObject.packing.PackingMcNo + "\n"
                        + "Packing Output Qty: "+ allSheet.get(sheetSearched).productionDetailsObject.packing.PackingOutputQty + "\n"
                        + "Packing Receipt No: "+ allSheet.get(sheetSearched).productionDetailsObject.packing.PackingReceiptNo + "\n"
                        + "Packing Rejected Qty: "+ allSheet.get(sheetSearched).productionDetailsObject.packing.PackingRejectedQty + "\n"
                        + "Packing Remark: "+ allSheet.get(sheetSearched).productionDetailsObject.packing.PackingRemark + "\n"
                        + "Packing Start: "+ allSheet.get(sheetSearched).productionDetailsObject.packing.PackingStart + "\n"
                        + "Packing Output: "+ allSheet.get(sheetSearched).productionDetailsObject.packing.Packingoutput + "\n"

                ));

                //break line
                mDoc.add(new Paragraph("\n----------------------------\n"));




                //Parting Off
                mDoc.add(new Paragraph("Parting Off \n"
                        + "Parting Off Accepted Qty: "+ allSheet.get(sheetSearched).productionDetailsObject.partingOff.PartingOffQty + "\n"
                        + "Parting Off Complete: "+ allSheet.get(sheetSearched).productionDetailsObject.partingOff.PartingOffComplete + "\n"
                        + "Parting Off Input Qty: "+ allSheet.get(sheetSearched).productionDetailsObject.partingOff.PartingOffInputQty + "\n"
                        + "Parting Off Mc No: "+ allSheet.get(sheetSearched).productionDetailsObject.partingOff.PartingOffMcNo + "\n"
                        + "Parting Off Output Qty: "+ allSheet.get(sheetSearched).productionDetailsObject.partingOff.PartingOffOutputQty + "\n"
                        + "Parting Off Receipt No: "+ allSheet.get(sheetSearched).productionDetailsObject.partingOff.PartingOffReceiptNo + "\n"
                        + "Parting Off Rejected Qty: "+ allSheet.get(sheetSearched).productionDetailsObject.partingOff.PartingOffRejectedQty + "\n"
                        + "Parting Off Remark: "+ allSheet.get(sheetSearched).productionDetailsObject.partingOff.PartingOffRemark + "\n"
                        + "Parting Off Start: "+ allSheet.get(sheetSearched).productionDetailsObject.partingOff.PartingOffStart + "\n"
                        + "Parting Off Output: "+ allSheet.get(sheetSearched).productionDetailsObject.partingOff.PartingOffoutput + "\n"

                ));

                //break line
                mDoc.add(new Paragraph("\n----------------------------\n"));



                //Piercing
                mDoc.add(new Paragraph("Piercing \n"
                        + "Piercing Accepted Qty: "+ allSheet.get(sheetSearched).productionDetailsObject.piercing.PiercingQty + "\n"
                        + "Piercing Complete: "+ allSheet.get(sheetSearched).productionDetailsObject.piercing.PiercingComplete + "\n"
                        + "Piercing Input Qty: "+ allSheet.get(sheetSearched).productionDetailsObject.piercing.PiercingInputQty + "\n"
                        + "Piercing Mc No: "+ allSheet.get(sheetSearched).productionDetailsObject.piercing.PiercingMcNo + "\n"
                        + "Piercing Output Qty: "+ allSheet.get(sheetSearched).productionDetailsObject.piercing.PiercingOutputQty + "\n"
                        + "Piercing Receipt No: "+ allSheet.get(sheetSearched).productionDetailsObject.piercing.PiercingReceiptNo + "\n"
                        + "Piercing Rejected Qty: "+ allSheet.get(sheetSearched).productionDetailsObject.piercing.PiercingRejectedQty + "\n"
                        + "Piercing Remark: "+ allSheet.get(sheetSearched).productionDetailsObject.piercing.PiercingRemark + "\n"
                        + "Piercing Start: "+ allSheet.get(sheetSearched).productionDetailsObject.piercing.PiercingStart + "\n"
                        + "Piercing Output: "+ allSheet.get(sheetSearched).productionDetailsObject.piercing.Piercingoutput + "\n"

                ));

                //break line
                mDoc.add(new Paragraph("\n----------------------------\n"));



                //Pre-Forming
                mDoc.add(new Paragraph("Pre-Forming \n"
                        + "Pre-Forming Accepted Qty: "+ allSheet.get(sheetSearched).productionDetailsObject.preForming.PreFormingQty + "\n"
                        + "Pre-Forming Complete: "+ allSheet.get(sheetSearched).productionDetailsObject.preForming.PreFormingComplete + "\n"
                        + "Pre-Forming Input Qty: "+ allSheet.get(sheetSearched).productionDetailsObject.preForming.PreFormingInputQty + "\n"
                        + "Pre-Forming Mc No: "+ allSheet.get(sheetSearched).productionDetailsObject.preForming.PreFormingMcNo + "\n"
                        + "Pre-Forming Output Qty: "+ allSheet.get(sheetSearched).productionDetailsObject.preForming.PreFormingOutputQty + "\n"
                        + "Pre-Forming Receipt No: "+ allSheet.get(sheetSearched).productionDetailsObject.preForming.PreFormingReceiptNo + "\n"
                        + "Pre-Forming Rejected Qty: "+ allSheet.get(sheetSearched).productionDetailsObject.preForming.PreFormingRejectedQty + "\n"
                        + "Pre-Forming Remark: "+ allSheet.get(sheetSearched).productionDetailsObject.preForming.PreFormingRemark + "\n"
                        + "Pre-Forming Start: "+ allSheet.get(sheetSearched).productionDetailsObject.preForming.PreFormingStart + "\n"
                        + "Pre-Forming Output: "+ allSheet.get(sheetSearched).productionDetailsObject.preForming.PreFormingoutput + "\n"

                ));

//break line
                mDoc.add(new Paragraph("\n----------------------------\n"));



                //ProfilePiercing
                mDoc.add(new Paragraph("ProfilePiercing \n"
                        + "ProfilePiercing Accepted Qty: "+ allSheet.get(sheetSearched).productionDetailsObject.profilePiercing.ProfilePiercingQty + "\n"
                        + "ProfilePiercing Complete: "+ allSheet.get(sheetSearched).productionDetailsObject.profilePiercing.ProfilePiercingComplete + "\n"
                        + "ProfilePiercing Input Qty: "+ allSheet.get(sheetSearched).productionDetailsObject.profilePiercing.ProfilePiercingInputQty + "\n"
                        + "ProfilePiercing Mc No: "+ allSheet.get(sheetSearched).productionDetailsObject.profilePiercing.ProfilePiercingMcNo + "\n"
                        + "ProfilePiercing Output Qty: "+ allSheet.get(sheetSearched).productionDetailsObject.profilePiercing.ProfilePiercingOutputQty + "\n"
                        + "ProfilePiercing Receipt No: "+ allSheet.get(sheetSearched).productionDetailsObject.profilePiercing.ProfilePiercingReceiptNo + "\n"
                        + "ProfilePiercing Rejected Qty: "+ allSheet.get(sheetSearched).productionDetailsObject.profilePiercing.ProfilePiercingRejectedQty + "\n"
                        + "ProfilePiercing Remark: "+ allSheet.get(sheetSearched).productionDetailsObject.profilePiercing.ProfilePiercingRemark + "\n"
                        + "ProfilePiercing Start: "+ allSheet.get(sheetSearched).productionDetailsObject.profilePiercing.ProfilePiercingStart + "\n"
                        + "ProfilePiercing Output: "+ allSheet.get(sheetSearched).productionDetailsObject.profilePiercing.ProfilePiercingoutput + "\n"

                ));

//break line
                mDoc.add(new Paragraph("\n----------------------------\n"));





                //break line and add line separator
                mDoc.add(new Paragraph(""));
                mDoc.add(new Chunk(lineSeparator));
                mDoc.add(new Paragraph(""));




                //production Details
                mDoc.add(new Paragraph("RAW MATERIAL DETAILS :\n"));


                //ProfilePiercing
                mDoc.add(new Paragraph("Raw Material Details \n"
                        + "Blanks Per Sheet: "+ allSheet.get(sheetSearched).rawMaterialDetailsObject.getBlanksPerSheet() + "\n"
                        + "Blanks Per Strip: "+ allSheet.get(sheetSearched).rawMaterialDetailsObject.getBlanksPerStrip() + "\n"
                        + "Number Of Sheets Used: "+ allSheet.get(sheetSearched).rawMaterialDetailsObject.getNumberOfSheetsUsed() + "\n"
                        + "RM Specification Grade: "+ allSheet.get(sheetSearched).rawMaterialDetailsObject.getRMSpecificationGrade() + "\n"
                        + "Sheet Size Coil: "+ allSheet.get(sheetSearched).rawMaterialDetailsObject.getSheetSizeCoil() + "\n"
                        + "Strip Length: "+ allSheet.get(sheetSearched).rawMaterialDetailsObject.getStripLength() + "\n"
                        + "Strip Thickness: "+ allSheet.get(sheetSearched).rawMaterialDetailsObject.getStripThickness() + "\n"
                        + "Strips Per Sheet: "+ allSheet.get(sheetSearched).rawMaterialDetailsObject.getStripsPerSheet() + "\n"
                        + "Strip Width: "+ allSheet.get(sheetSearched).rawMaterialDetailsObject.getStripWidth() + "\n"
                        + "Total: "+ allSheet.get(sheetSearched).rawMaterialDetailsObject.getTotal() + "\n"

                        + "Total Blanks: "+ allSheet.get(sheetSearched).rawMaterialDetailsObject.getTotalBlanks() + "\n"
                ));




                //break line and add line separator
                mDoc.add(new Paragraph(""));
                mDoc.add(new Chunk(lineSeparator));
                mDoc.add(new Paragraph(""));




                //production Details
                mDoc.add(new Paragraph("WORK ORDER DETAILS :\n"));

                //ProfilePiercing
                mDoc.add(new Paragraph("Work Order Details \n"
                        + "Complete Date: "+ allSheet.get(sheetSearched).workOrderDetailsObject.getCompleteDate() + "\n"
                        + "Customer Name: "+ allSheet.get(sheetSearched).workOrderDetailsObject.getCustomerName() + "\n"
                        + "Heat Code: "+ allSheet.get(sheetSearched).workOrderDetailsObject.getHeatCode() + "\n"
                        + "Issued Store: "+ allSheet.get(sheetSearched).workOrderDetailsObject.getIssuedStore() + "\n"
                        + "Part Name: "+ allSheet.get(sheetSearched).workOrderDetailsObject.getPartName() + "\n"
                        + "Part No: "+ allSheet.get(sheetSearched).workOrderDetailsObject.getPartNo() + "\n"
                        + "Receipt Chan Date: "+ allSheet.get(sheetSearched).workOrderDetailsObject.getReceiptChanDate() + "\n"
                        + "Receipt Chan No: "+ allSheet.get(sheetSearched).workOrderDetailsObject.getReceiptChanNo() + "\n"
                        + "Start Date: "+ allSheet.get(sheetSearched).workOrderDetailsObject.getStartDate() + "\n"
                        + "Supplier Name: "+ allSheet.get(sheetSearched).workOrderDetailsObject.getSupplierName() + "\n"

                        + "Verified By QA: "+ allSheet.get(sheetSearched).workOrderDetailsObject.getVerifiedByQA() + "\n"
                        + "Weight In Kg: "+ allSheet.get(sheetSearched).workOrderDetailsObject.getWeightInKg() + "\n"
                ));



                //break line and add line separator
                mDoc.add(new Paragraph(""));
                mDoc.add(new Chunk(lineSeparator));
                mDoc.add(new Paragraph(""));


                //production Details
                mDoc.add(new Paragraph("\n------------------THANK YOU!----------------------- :\n"));
















                //close document
                mDoc.close();

                //show message file is saved
                Toast.makeText(this, mFileName+ ".pdf\nis saved to\n"+mPath, Toast.LENGTH_SHORT).show();


            }
            catch (Exception e){
                // if any thing goes wrong causing exception
                Toast.makeText(this, ""+e.getMessage(), Toast.LENGTH_SHORT).show();
            }





        }
        else{

            Toast.makeText(this, "Search For The Sheet First !", Toast.LENGTH_SHORT).show();
        }



    }

    //handle permission result


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode){
            case STORAGE_CODE:{
                if(grantResults.length > 0&& grantResults[0]==PackageManager.PERMISSION_GRANTED){
                    //permission was granted


                    savePdf();
                }else {
                    //permission denied from popup
                    Toast.makeText(this, "Permission Denied...!", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }

    @Override
    protected void onStart() {
        super.onStart();


        final ProgressDialog dialog = ProgressDialog.show(SearchActivity.this, "",
                "Loading. Please wait...", true);


        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {








        mRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {



                SheetObject sheetObject=null;
                DispatchDetailsObject dispatchDetailsObject = null;
                WorkOrderDetailsObject workOrderDetailsObject;

                for (DataSnapshot childDataSnapshot : dataSnapshot.getChildren()) {













//
//                    Log.e("Object","SheetID"+ childDataSnapshot.getKey()); //displays the key for the node
                    sheetID = childDataSnapshot.getKey();

//
//                    Log.e("Object","RawMaterialDetails"+ childDataSnapshot.child("RawMaterialDetails").getValue());   //gives the value for given keyname
//                    Log.e("Object","DispatchDetails"+ childDataSnapshot.child("DispatchDetails").getValue());   //gives the value for given keyname

                    List<SerialNo> allSerialNo=new ArrayList<SerialNo>();

                    for (DataSnapshot DispatchDetails : childDataSnapshot.child("DispatchDetails").getChildren()) {


                        SerialNo serialNo = new SerialNo();

                        String CumulativeQuantity=null;
                       String InvoiceDate=null;
                       String InvoiceNo=null;
                       String Quantity=null;
                       Integer i=0;





                        for(DataSnapshot serialNos:DispatchDetails.getChildren()){


                            if(serialNos.getKey().equalsIgnoreCase("Cummulative Quantity")){
                                CumulativeQuantity = serialNos.getValue(String.class);

                                Log.e("Setting Invoices i=0 ",""+CumulativeQuantity);

                                i=1;
                            }
                            if(serialNos.getKey().equalsIgnoreCase("Invoice Date")){
                                InvoiceDate = serialNos.getValue(String.class);

                                Log.e("Setting Invoices i=2 ",""+InvoiceDate);

                                i=2;
                            }
                            if(serialNos.getKey().equalsIgnoreCase("Invoice No")){
                                InvoiceNo = serialNos.getValue(String.class);
                                i=3;
                            }
                            if(serialNos.getKey().equalsIgnoreCase("Quantity")){
                                Quantity = serialNos.getValue(String.class);
                                i=4;


                            }




                        }

                        serialNo = new SerialNo(CumulativeQuantity,InvoiceDate,InvoiceNo,Quantity);
                        allSerialNo.add(serialNo);




                    }
                    dispatchDetailsObject = new DispatchDetailsObject(allSerialNo);



                    Chamfering chamfering=null;
                    Deburring deburring=null;
                    EadgeTrimming eadgeTrimming=null;
                    Emboss emboss=null;
                    FullForming fullForming=null;
                    Inspection inspection=null;
                    Packing packing=null;
                    PartingOff partingOff=null;
                    Piercing piercing=null;
                    PreForming preForming=null;
                    ProfilePiercing profilePiercing=null        ;
                    ProductionDetailsObject productionDetailsObject;


                    String ChamferingAcceptedQty=null;
                    String ChamferingComplete=null;
                    String ChamferingInputQty=null;
                    String ChamferingMcNo=null;

                    String ChamferingOutputQty=null;
                    String ChamferingReceiptNo=null;
                    String ChamferingRejectedQty=null;
                    String ChamferingRemark=null;
                    String ChamferingStart=null;


                    String Chamferingoutput = null;


                    for (DataSnapshot cham : childDataSnapshot.child("ProductionDetails").child("Chamfering").getChildren()) {

                        Log.e("ChamDetails",""+cham);





                            if (cham.getKey().equalsIgnoreCase("ChamferingAcceptedQty")){
                                ChamferingAcceptedQty = cham.getValue(String.class);
                                Log.e("ChamSet",""+ChamferingAcceptedQty);


                            }
                            if (cham.getKey().equalsIgnoreCase("ChamferingComplete")){
                                ChamferingComplete = cham.getValue(String.class);
                                Log.e("ChamSet2",""+ChamferingComplete);



                            }
                            if (cham.getKey().equalsIgnoreCase("ChamferingInputQty")){
                                ChamferingInputQty = cham.getValue(String.class);



                            }
                            if (cham.getKey().equalsIgnoreCase("ChamferingMcNo")){
                                ChamferingMcNo = cham.getValue(String.class);



                            }
                            if (cham.getKey().equalsIgnoreCase("ChamferingOutputQty")){
                                ChamferingOutputQty = cham.getValue(String.class);



                            }
                            if (cham.getKey().equalsIgnoreCase("ChamferingReceiptNo")){
                                ChamferingReceiptNo = cham.getValue(String.class);



                            }
                            if (cham.getKey().equalsIgnoreCase("ChamferingRejectedQty")){
                                ChamferingRejectedQty = cham.getValue(String.class);



                            }
                            if (cham.getKey().equalsIgnoreCase("ChamferingRemark")){
                                ChamferingRemark = cham.getValue(String.class);



                            }
                            if (cham.getKey().equalsIgnoreCase("ChamferingStart")){
                                ChamferingStart = cham.getValue(String.class);



                            }
                            if(cham.getKey().equalsIgnoreCase("Chamferingoutput")){
                             Chamferingoutput = cham.getValue(String.class);
                            }















                    }
                    chamfering = new Chamfering(ChamferingAcceptedQty,ChamferingComplete,ChamferingInputQty,ChamferingMcNo,ChamferingOutputQty,ChamferingReceiptNo,ChamferingRejectedQty,ChamferingRemark,ChamferingStart,Chamferingoutput);

                    Log.e("ChamObject",""+chamfering.getChamferingAcceptedQty());
                    Log.e("ChamObject",""+chamfering.getChamferingComplete());
                    Log.e("ChamObject",""+chamfering);





                    for (DataSnapshot cham : childDataSnapshot.child("ProductionDetails").child("Deburring").getChildren()) {





                        if (cham.getKey().equalsIgnoreCase("DeburringAcceptedQty")){
                            ChamferingAcceptedQty = cham.getValue(String.class);


                        }
                        if (cham.getKey().equalsIgnoreCase("DeburringComplete")){
                            ChamferingComplete = cham.getValue(String.class);



                        }
                        if (cham.getKey().equalsIgnoreCase("DeburringInputQty")){
                            ChamferingInputQty = cham.getValue(String.class);



                        }
                        if (cham.getKey().equalsIgnoreCase("DeburringMcNo")){
                            ChamferingMcNo = cham.getValue(String.class);



                        }
                        if (cham.getKey().equalsIgnoreCase("DeburringOutputQty")){
                            ChamferingOutputQty = cham.getValue(String.class);



                        }
                        if (cham.getKey().equalsIgnoreCase("DeburringReceiptNo")){
                            ChamferingReceiptNo = cham.getValue(String.class);



                        }
                        if (cham.getKey().equalsIgnoreCase("DeburringRejectedQty")){
                            ChamferingRejectedQty = cham.getValue(String.class);



                        }
                        if (cham.getKey().equalsIgnoreCase("DeburringRemark")){
                            ChamferingRemark = cham.getValue(String.class);



                        }
                        if (cham.getKey().equalsIgnoreCase("DeburringStart")){
                            ChamferingStart = cham.getValue(String.class);



                        }
                        if(cham.getKey().equalsIgnoreCase("Deburringoutput")){
                            Chamferingoutput = cham.getValue(String.class);
                        }
















                    }
                    deburring = new Deburring(ChamferingAcceptedQty,ChamferingComplete,ChamferingInputQty,ChamferingMcNo,ChamferingOutputQty,ChamferingReceiptNo,ChamferingRejectedQty,ChamferingRemark,ChamferingStart,Chamferingoutput);




                    for (DataSnapshot cham : childDataSnapshot.child("ProductionDetails").child("EadgeTriming").getChildren()) {






                        if (cham.getKey().equalsIgnoreCase("EadgeTrimingAcceptedQty")){
                            ChamferingAcceptedQty = cham.getValue(String.class);


                        }
                        if (cham.getKey().equalsIgnoreCase("EadgeTrimingComplete")){
                            ChamferingComplete = cham.getValue(String.class);



                        }
                        if (cham.getKey().equalsIgnoreCase("EadgeTrimingInputQty")){
                            ChamferingInputQty = cham.getValue(String.class);



                        }
                        if (cham.getKey().equalsIgnoreCase("EadgeTrimingMcNo")){
                            ChamferingMcNo = cham.getValue(String.class);



                        }
                        if (cham.getKey().equalsIgnoreCase("EadgeTrimingOutputQty")){
                            ChamferingOutputQty = cham.getValue(String.class);



                        }
                        if (cham.getKey().equalsIgnoreCase("EadgeTrimingReceiptNo")){
                            ChamferingReceiptNo = cham.getValue(String.class);



                        }
                        if (cham.getKey().equalsIgnoreCase("EadgeTrimingRejectedQty")){
                            ChamferingRejectedQty = cham.getValue(String.class);



                        }
                        if (cham.getKey().equalsIgnoreCase("EadgeTrimingRemark")){
                            ChamferingRemark = cham.getValue(String.class);



                        }
                        if (cham.getKey().equalsIgnoreCase("EadgeTrimingStart")){
                            ChamferingStart = cham.getValue(String.class);



                        }
                        if(cham.getKey().equalsIgnoreCase("EadgeTrimingoutput")){
                            Chamferingoutput = cham.getValue(String.class);
                        }















                    }

                    eadgeTrimming = new EadgeTrimming(ChamferingAcceptedQty,ChamferingComplete,ChamferingInputQty,ChamferingMcNo,ChamferingOutputQty,ChamferingReceiptNo,ChamferingRejectedQty,ChamferingRemark,ChamferingStart,Chamferingoutput);




                    for (DataSnapshot cham : childDataSnapshot.child("ProductionDetails").child("Emboss").getChildren()) {





                        if (cham.getKey().equalsIgnoreCase("EmbossAcceptedQty")){
                            ChamferingAcceptedQty = cham.getValue(String.class);


                        }
                        if (cham.getKey().equalsIgnoreCase("EmbossComplete")){
                            ChamferingComplete = cham.getValue(String.class);



                        }
                        if (cham.getKey().equalsIgnoreCase("EmbossInputQty")){
                            ChamferingInputQty = cham.getValue(String.class);



                        }
                        if (cham.getKey().equalsIgnoreCase("EmbossMcNo")){
                            ChamferingMcNo = cham.getValue(String.class);



                        }
                        if (cham.getKey().equalsIgnoreCase("EmbossOutputQty")){
                            ChamferingOutputQty = cham.getValue(String.class);



                        }
                        if (cham.getKey().equalsIgnoreCase("EmbossReceiptNo")){
                            ChamferingReceiptNo = cham.getValue(String.class);



                        }
                        if (cham.getKey().equalsIgnoreCase("EmbossRejectedQty")){
                            ChamferingRejectedQty = cham.getValue(String.class);



                        }
                        if (cham.getKey().equalsIgnoreCase("EmbossRemark")){
                            ChamferingRemark = cham.getValue(String.class);



                        }
                        if (cham.getKey().equalsIgnoreCase("EmbossStart")){
                            ChamferingStart = cham.getValue(String.class);



                        }
                        if(cham.getKey().equalsIgnoreCase("Embossoutput")){
                            Chamferingoutput = cham.getValue(String.class);
                        }
















                    }

                    emboss = new Emboss(ChamferingAcceptedQty,ChamferingComplete,ChamferingInputQty,ChamferingMcNo,ChamferingOutputQty,ChamferingReceiptNo,ChamferingRejectedQty,ChamferingRemark,ChamferingStart,Chamferingoutput);




                    for (DataSnapshot cham : childDataSnapshot.child("ProductionDetails").child("FullForming").getChildren()) {






                        if (cham.getKey().equalsIgnoreCase("FullFormingAcceptedQty")){
                            ChamferingAcceptedQty = cham.getValue(String.class);


                        }
                        if (cham.getKey().equalsIgnoreCase("FullFormingComplete")){
                            ChamferingComplete = cham.getValue(String.class);



                        }
                        if (cham.getKey().equalsIgnoreCase("FullFormingInputQty")){
                            ChamferingInputQty = cham.getValue(String.class);



                        }
                        if (cham.getKey().equalsIgnoreCase("FullFormingMcNo")){
                            ChamferingMcNo = cham.getValue(String.class);



                        }
                        if (cham.getKey().equalsIgnoreCase("FullFormingOutputQty")){
                            ChamferingOutputQty = cham.getValue(String.class);



                        }
                        if (cham.getKey().equalsIgnoreCase("FullFormingReceiptNo")){
                            ChamferingReceiptNo = cham.getValue(String.class);



                        }
                        if (cham.getKey().equalsIgnoreCase("FullFormingRejectedQty")){
                            ChamferingRejectedQty = cham.getValue(String.class);



                        }
                        if (cham.getKey().equalsIgnoreCase("FullFormingRemark")){
                            ChamferingRemark = cham.getValue(String.class);



                        }
                        if (cham.getKey().equalsIgnoreCase("FullFormingStart")){
                            ChamferingStart = cham.getValue(String.class);



                        }
                        if(cham.getKey().equalsIgnoreCase("FullFormingoutput")){
                            Chamferingoutput = cham.getValue(String.class);
                        }
















                    }
                    fullForming = new FullForming(ChamferingAcceptedQty,ChamferingComplete,ChamferingInputQty,ChamferingMcNo,ChamferingOutputQty,ChamferingReceiptNo,ChamferingRejectedQty,ChamferingRemark,ChamferingStart,Chamferingoutput);






                    for (DataSnapshot cham : childDataSnapshot.child("ProductionDetails").child("Inspection").getChildren()) {






                        if (cham.getKey().equalsIgnoreCase("InspectionAcceptedQty")){
                            ChamferingAcceptedQty = cham.getValue(String.class);


                        }
                        if (cham.getKey().equalsIgnoreCase("InspectionComplete")){
                            ChamferingComplete = cham.getValue(String.class);



                        }
                        if (cham.getKey().equalsIgnoreCase("InspectionInputQty")){
                            ChamferingInputQty = cham.getValue(String.class);



                        }
                        if (cham.getKey().equalsIgnoreCase("InspectionMcNo")){
                            ChamferingMcNo = cham.getValue(String.class);



                        }
                        if (cham.getKey().equalsIgnoreCase("InspectionOutputQty")){
                            ChamferingOutputQty = cham.getValue(String.class);



                        }
                        if (cham.getKey().equalsIgnoreCase("InspectionReceiptNo")){
                            ChamferingReceiptNo = cham.getValue(String.class);



                        }
                        if (cham.getKey().equalsIgnoreCase("InspectionRejectedQty")){
                            ChamferingRejectedQty = cham.getValue(String.class);



                        }
                        if (cham.getKey().equalsIgnoreCase("InspectionRemark")){
                            ChamferingRemark = cham.getValue(String.class);



                        }
                        if (cham.getKey().equalsIgnoreCase("InspectionStart")){
                            ChamferingStart = cham.getValue(String.class);



                        }
                        if(cham.getKey().equalsIgnoreCase("Inspectionoutput")){
                            Chamferingoutput = cham.getValue(String.class);
                        }
















                    }
                    inspection = new Inspection(ChamferingAcceptedQty,ChamferingComplete,ChamferingInputQty,ChamferingMcNo,ChamferingOutputQty,ChamferingReceiptNo,ChamferingRejectedQty,ChamferingRemark,ChamferingStart,Chamferingoutput);




                    for (DataSnapshot cham : childDataSnapshot.child("ProductionDetails").child("Packing").getChildren()) {





                        if (cham.getKey().equalsIgnoreCase("PackingAcceptedQty")){
                            ChamferingAcceptedQty = cham.getValue(String.class);


                        }
                        if (cham.getKey().equalsIgnoreCase("PackingComplete")){
                            ChamferingComplete = cham.getValue(String.class);



                        }
                        if (cham.getKey().equalsIgnoreCase("PackingInputQty")){
                            ChamferingInputQty = cham.getValue(String.class);



                        }
                        if (cham.getKey().equalsIgnoreCase("PackingMcNo")){
                            ChamferingMcNo = cham.getValue(String.class);



                        }
                        if (cham.getKey().equalsIgnoreCase("PackingOutputQty")){
                            ChamferingOutputQty = cham.getValue(String.class);



                        }
                        if (cham.getKey().equalsIgnoreCase("PackingReceiptNo")){
                            ChamferingReceiptNo = cham.getValue(String.class);



                        }
                        if (cham.getKey().equalsIgnoreCase("PackingRejectedQty")){
                            ChamferingRejectedQty = cham.getValue(String.class);



                        }
                        if (cham.getKey().equalsIgnoreCase("PackingRemark")){
                            ChamferingRemark = cham.getValue(String.class);



                        }
                        if (cham.getKey().equalsIgnoreCase("PackingStart")){
                            ChamferingStart = cham.getValue(String.class);



                        }
                        if(cham.getKey().equalsIgnoreCase("Packingoutput")){
                            Chamferingoutput = cham.getValue(String.class);
                        }














                    }


                    packing= new Packing(ChamferingAcceptedQty,ChamferingComplete,ChamferingInputQty,ChamferingMcNo,ChamferingOutputQty,ChamferingReceiptNo,ChamferingRejectedQty,ChamferingRemark,ChamferingStart,Chamferingoutput);





                    for (DataSnapshot cham : childDataSnapshot.child("ProductionDetails").child("PartingOff").getChildren()) {






                        if (cham.getKey().equalsIgnoreCase("PartingOffAcceptedQty")){
                            ChamferingAcceptedQty = cham.getValue(String.class);


                        }
                        if (cham.getKey().equalsIgnoreCase("PartingOffComplete")){
                            ChamferingComplete = cham.getValue(String.class);



                        }
                        if (cham.getKey().equalsIgnoreCase("PartingOffInputQty")){
                            ChamferingInputQty = cham.getValue(String.class);



                        }
                        if (cham.getKey().equalsIgnoreCase("PartingOffMcNo")){
                            ChamferingMcNo = cham.getValue(String.class);



                        }
                        if (cham.getKey().equalsIgnoreCase("PartingOffOutputQty")){
                            ChamferingOutputQty = cham.getValue(String.class);



                        }
                        if (cham.getKey().equalsIgnoreCase("PartingOffReceiptNo")){
                            ChamferingReceiptNo = cham.getValue(String.class);



                        }
                        if (cham.getKey().equalsIgnoreCase("PartingOffRejectedQty")){
                            ChamferingRejectedQty = cham.getValue(String.class);



                        }
                        if (cham.getKey().equalsIgnoreCase("PartingOffRemark")){
                            ChamferingRemark = cham.getValue(String.class);



                        }
                        if (cham.getKey().equalsIgnoreCase("PartingOffStart")){
                            ChamferingStart = cham.getValue(String.class);



                        }
                        if(cham.getKey().equalsIgnoreCase("PartingOffoutput")){
                            Chamferingoutput = cham.getValue(String.class);
                        }
















                    }
                    partingOff= new PartingOff(ChamferingAcceptedQty,ChamferingComplete,ChamferingInputQty,ChamferingMcNo,ChamferingOutputQty,ChamferingReceiptNo,ChamferingRejectedQty,ChamferingRemark,ChamferingStart,Chamferingoutput);




                    for (DataSnapshot cham : childDataSnapshot.child("ProductionDetails").child("Piercing").getChildren()) {






                        if (cham.getKey().equalsIgnoreCase("PiercingAcceptedQty")){
                            ChamferingAcceptedQty = cham.getValue(String.class);


                        }
                        if (cham.getKey().equalsIgnoreCase("PiercingComplete")){
                            ChamferingComplete = cham.getValue(String.class);



                        }
                        if (cham.getKey().equalsIgnoreCase("PiercingInputQty")){
                            ChamferingInputQty = cham.getValue(String.class);



                        }
                        if (cham.getKey().equalsIgnoreCase("PiercingMcNo")){
                            ChamferingMcNo = cham.getValue(String.class);



                        }
                        if (cham.getKey().equalsIgnoreCase("PiercingOutputQty")){
                            ChamferingOutputQty = cham.getValue(String.class);



                        }
                        if (cham.getKey().equalsIgnoreCase("PiercingReceiptNo")){
                            ChamferingReceiptNo = cham.getValue(String.class);



                        }
                        if (cham.getKey().equalsIgnoreCase("PiercingRejectedQty")){
                            ChamferingRejectedQty = cham.getValue(String.class);



                        }
                        if (cham.getKey().equalsIgnoreCase("PiercingRemark")){
                            ChamferingRemark = cham.getValue(String.class);



                        }
                        if (cham.getKey().equalsIgnoreCase("PiercingStart")){
                            ChamferingStart = cham.getValue(String.class);



                        }
                        if(cham.getKey().equalsIgnoreCase("Piercingoutput")){
                            Chamferingoutput = cham.getValue(String.class);
                        }
















                    }
                    piercing= new Piercing(ChamferingAcceptedQty,ChamferingComplete,ChamferingInputQty,ChamferingMcNo,ChamferingOutputQty,ChamferingReceiptNo,ChamferingRejectedQty,ChamferingRemark,ChamferingStart,Chamferingoutput);




                    for (DataSnapshot cham : childDataSnapshot.child("ProductionDetails").child("Pre-Forming").getChildren()) {





                        if (cham.getKey().equalsIgnoreCase("Pre-Forming Accepted Quantity")){
                            ChamferingAcceptedQty = cham.getValue(String.class);


                        }
                        if (cham.getKey().equalsIgnoreCase("Pre-Forming Complete")){
                            ChamferingComplete = cham.getValue(String.class);



                        }
                        if (cham.getKey().equalsIgnoreCase("Pre-Forming Input Quantity")){
                            ChamferingInputQty = cham.getValue(String.class);



                        }
                        if (cham.getKey().equalsIgnoreCase("Pre-Forming MC NO")){
                            ChamferingMcNo = cham.getValue(String.class);



                        }
                        if (cham.getKey().equalsIgnoreCase("Pre-Forming Output Quantity")){
                            ChamferingOutputQty = cham.getValue(String.class);



                        }
                        if (cham.getKey().equalsIgnoreCase("Pre-Forming Receipt No")){
                            ChamferingReceiptNo = cham.getValue(String.class);



                        }
                        if (cham.getKey().equalsIgnoreCase("Pre-Forming Rejected Quantity")){
                            ChamferingRejectedQty = cham.getValue(String.class);



                        }
                        if (cham.getKey().equalsIgnoreCase("Pre-Forming Remark")){
                            ChamferingRemark = cham.getValue(String.class);



                        }
                        if (cham.getKey().equalsIgnoreCase("Pre-Forming Start")){
                            ChamferingStart = cham.getValue(String.class);



                        }
                        if(cham.getKey().equalsIgnoreCase("Pre-Forming Output")){
                            Chamferingoutput = cham.getValue(String.class);
                        }














                    }


                    preForming= new PreForming(ChamferingAcceptedQty,ChamferingComplete,ChamferingInputQty,ChamferingMcNo,ChamferingOutputQty,ChamferingReceiptNo,ChamferingRejectedQty,ChamferingRemark,ChamferingStart,Chamferingoutput);



                    for (DataSnapshot cham : childDataSnapshot.child("ProductionDetails").child("ProfilePiercing").getChildren()) {





                        if (cham.getKey().equalsIgnoreCase("ProfilePiercingAcceptedQty")){
                            ChamferingAcceptedQty = cham.getValue(String.class);


                        }
                        if (cham.getKey().equalsIgnoreCase("ProfilePiercingComplete")){
                            ChamferingComplete = cham.getValue(String.class);



                        }
                        if (cham.getKey().equalsIgnoreCase("ProfilePiercingInputQty")){
                            ChamferingInputQty = cham.getValue(String.class);



                        }
                        if (cham.getKey().equalsIgnoreCase("ProfilePiercingMcNo")){
                            ChamferingMcNo = cham.getValue(String.class);



                        }
                        if (cham.getKey().equalsIgnoreCase("ProfilePiercingOutputQty")){
                            ChamferingOutputQty = cham.getValue(String.class);



                        }
                        if (cham.getKey().equalsIgnoreCase("ProfilePiercingReceiptNo")){
                            ChamferingReceiptNo = cham.getValue(String.class);



                        }
                        if (cham.getKey().equalsIgnoreCase("ProfilePiercingRejectedQty")){
                            ChamferingRejectedQty = cham.getValue(String.class);



                        }
                        if (cham.getKey().equalsIgnoreCase("ProfilePiercingRemark")){
                            ChamferingRemark = cham.getValue(String.class);



                        }
                        if (cham.getKey().equalsIgnoreCase("ProfilePiercingStart")){
                            ChamferingStart = cham.getValue(String.class);



                        }
                        if(cham.getKey().equalsIgnoreCase("ProfilePiercingoutput")){
                            Chamferingoutput = cham.getValue(String.class);
                        }
















                    }
                    profilePiercing= new ProfilePiercing(ChamferingAcceptedQty,ChamferingComplete,ChamferingInputQty,ChamferingMcNo,ChamferingOutputQty,ChamferingReceiptNo,ChamferingRejectedQty,ChamferingRemark,ChamferingStart,Chamferingoutput);





                    productionDetailsObject = new ProductionDetailsObject(chamfering,deburring,eadgeTrimming,emboss,fullForming,inspection,packing,partingOff,piercing,preForming,profilePiercing);







                //RawMaterial

                    RawMaterialDetailsObject rawMaterialDetailsObject;
                    String blanksPerSheet=null,blanksPerStrip=null,numberOfSheetsUsed=null,rmSpecificationGrade=null,sheetSizeCoil=null,stripLength=null,stripThickness=null,stripsPerSheet=null,stripWidth=null,total=null,totalBlanks=null;
                    for (DataSnapshot rawMaterial : childDataSnapshot.child("RawMaterialDetails").getChildren()) {

                        if(rawMaterial.getKey().equalsIgnoreCase("Blanks Per Sheet")){
                            blanksPerSheet = rawMaterial.getValue(String.class);


                        }

                        if(rawMaterial.getKey().equalsIgnoreCase("Blanks Per Strip")){
                            blanksPerStrip = rawMaterial.getValue(String.class);


                        }
                        if(rawMaterial.getKey().equalsIgnoreCase("Number Of Sheets Used")){
                            numberOfSheetsUsed = rawMaterial.getValue(String.class);


                        }

                        if(rawMaterial.getKey().equalsIgnoreCase("RM Specification-Grade")){
                            rmSpecificationGrade = rawMaterial.getValue(String.class);


                        }
                        if(rawMaterial.getKey().equalsIgnoreCase("Sheet Size-Coil")){
                            sheetSizeCoil = rawMaterial.getValue(String.class);


                        }
                        if(rawMaterial.getKey().equalsIgnoreCase("Strip Length")){
                            stripLength = rawMaterial.getValue(String.class);


                        }
                        if(rawMaterial.getKey().equalsIgnoreCase("Strip Thickness")){
                            stripThickness = rawMaterial.getValue(String.class);


                        }
                        if(rawMaterial.getKey().equalsIgnoreCase("Strips Per Sheet")){
                            stripsPerSheet = rawMaterial.getValue(String.class);


                        }

                        if(rawMaterial.getKey().equalsIgnoreCase("Strip Width")){
                            stripWidth = rawMaterial.getValue(String.class);


                        }

                        if(rawMaterial.getKey().equalsIgnoreCase("Total")){
                            total = rawMaterial.getValue(String.class);


                        }

                        if(rawMaterial.getKey().equalsIgnoreCase("Total Blanks")){
                            totalBlanks = rawMaterial.getValue(String.class);


                        }















                    }
                    rawMaterialDetailsObject = new RawMaterialDetailsObject(blanksPerSheet,blanksPerStrip,numberOfSheetsUsed,rmSpecificationGrade,sheetSizeCoil,stripLength,stripThickness,stripsPerSheet,stripWidth,total,totalBlanks);






















//                    Log.e("Object","ProductionDetails"+ childDataSnapshot.child("ProductionDetails").getValue());   //gives the value for given keyname
//                    Log.e("Object","WorkOrderDetails"+ childDataSnapshot.child("WorkOrderDetails").getValue());   //gives the value for given keyname




                    String CompleteDate=null,CustomerName=null,HeatCode=null,IssuedStore=null,PartName=null,PartNo=null,ReceiptChanDate=null,ReceiptChanNo=null,StartDate=null,SupplierName=null,VerifiedByQA=null,WeightInKg=null;
                    Integer i = 0;
                    for (DataSnapshot workOrderDetails : childDataSnapshot.child("WorkOrderDetails").getChildren()) {

//                        Log.e("WorkOrderDetails of "+ sheetID,""+workOrderDetails );

                        if(workOrderDetails.getKey().equalsIgnoreCase("Complete Date")){
                            CompleteDate = workOrderDetails.getValue(String.class);


                            i=1;
                        }
                        if(workOrderDetails.getKey().equalsIgnoreCase("Customer Name")){
                            CustomerName = workOrderDetails.getValue(String.class);
                            i=2;
                        }
                        if(workOrderDetails.getKey().equalsIgnoreCase("HeatCode")){
                            HeatCode = workOrderDetails.getValue(String.class);
                            i=3;
                        }
                        if(workOrderDetails.getKey().equalsIgnoreCase("Issued Store")){
                            IssuedStore = workOrderDetails.getValue(String.class);
                            i=4;


                        }

                        if(workOrderDetails.getKey().equalsIgnoreCase("Part Name")){
                            PartName = workOrderDetails.getValue(String.class);
                            i=5;


                        }

                        if(workOrderDetails.getKey().equalsIgnoreCase("Part No")){
                            PartNo = workOrderDetails.getValue(String.class);
                            i=6;


                        }

                        if(workOrderDetails.getKey().equalsIgnoreCase("Receipt Chan Date")){
                            ReceiptChanDate = workOrderDetails.getValue(String.class);
                            i=8;


                        }

                        if(workOrderDetails.getKey().equalsIgnoreCase("Receipt Chan No")){
                            ReceiptChanNo = workOrderDetails.getValue(String.class);
                            i=9;


                        }

                        if(workOrderDetails.getKey().equalsIgnoreCase("Start Date")){
                            StartDate = workOrderDetails.getValue(String.class);
                            i=10;


                        }

                        if(workOrderDetails.getKey().equalsIgnoreCase("Supplier Name")){
                            SupplierName = workOrderDetails.getValue(String.class);
                            i=11;


                        }

                        if(workOrderDetails.getKey().equalsIgnoreCase("Verified By QA")){
                            VerifiedByQA = workOrderDetails.getValue(String.class);
                            i=13;


                        }

                        if(workOrderDetails.getKey().equalsIgnoreCase("Weight In kg")){
                            WeightInKg = workOrderDetails.getValue(String.class);
                            i=14;


                        }



                    }

                    workOrderDetailsObject = new WorkOrderDetailsObject(CompleteDate,CustomerName,HeatCode,IssuedStore,PartName,PartNo,ReceiptChanDate,ReceiptChanNo,StartDate,SupplierName,VerifiedByQA,WeightInKg);

                    sheetObject = new SheetObject(productionDetailsObject,dispatchDetailsObject,workOrderDetailsObject,rawMaterialDetailsObject,sheetID);

                    allSheet.add(sheetObject);





                    }

            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });



//        mRef.addValueEventListener(new ValueEventListener() {
//            Integer i2=0;
//            @SuppressLint("LongLogTag")
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//
//
//                Log.e("Videos Received",""+dataSnapshot);
//
////                for(DataSnapshot videoSnapshot : dataSnapshot.getChildren()){
////
////                    for(DataSnapshot videoParams : videoSnapshot.getChildren()){
////
////
////                    }
////
////
////
////
////                }
////
////                VideoList adapter = new VideoList(VideoPlayer.this,videosList);
////
////
////
////                listViewVideos.setAdapter(adapter);
//
//
//            }
//
//            @Override
//            public void onCancelled(FirebaseError firebaseError) {
//
//            }
//        });
//


        dialog.dismiss();

            }
        }, 2000); // 3000 milliseconds delay
    }


    @Override
    public void onClick(View v) {

        if(v==search){

            Toast.makeText(this, "Clicking and Checking", Toast.LENGTH_SHORT).show();

        }

    }
}
