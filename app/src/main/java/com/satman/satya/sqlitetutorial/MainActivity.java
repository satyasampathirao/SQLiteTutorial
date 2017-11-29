package com.satman.satya.sqlitetutorial;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    TextView tvtext;

    EditText etid, etname,etphone;

    Button bsave, bcancel, bupdate, bdelete;



    DatabaseHandler db;
    List<Contact> contacts;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        tvtext = (TextView)findViewById(R.id.tvtext);

        etid= (EditText)findViewById(R.id.etid);
        etname = (EditText)findViewById(R.id.etname);
        etphone = (EditText)findViewById(R.id.etphone);


        bsave = (Button)findViewById(R.id.bsave);
        bupdate = (Button)findViewById(R.id.bupdate);
        bdelete = (Button)findViewById(R.id.bdelete);



        db = new DatabaseHandler(this);


        /**
         * CRUD Operations
         * */
        // Inserting Contacts
        // Log.d("Insert: ", "Inserting ..");
       /* db.addContact(new Contact("Ravi", "9100000000"));
        db.addContact(new Contact("Srinivas", "9199999999"));
        db.addContact(new Contact("Tommy", "9522222222"));
        db.addContact(new Contact("Karthik", "9533333333"));*/





       
        // Reading all contacts
      /*  Log.d("Reading: ", "Reading all contacts..");
        contacts = db.getAllContacts();
        for (Contact cn : contacts) {
            String log = "Id: "+cn.getID()+" ,Name: " + cn.getName() + " ,Phone: " + cn.getPhoneNumber();
            // Writing Contacts to log
            Log.d("Name: ", log);


            tvtext.append( log+"\n");
        }*/




        bsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //  db.addContact(new Contact("Satya", "9491816335"));

                db.addContact(new Contact(etname.getText().toString(), etphone.getText().toString()));


                // Reading all contacts
                Log.d("Reading: ", "Reading all contacts..");
                contacts = db.getAllContacts();

                tvtext.setText("");
                for (Contact cn : contacts) {
                    String log = "Id: "+cn.getID()+" ,Name: " + cn.getName() + " ,Phone: " + cn.getPhoneNumber();
                    // Writing Contacts to log
                    Log.d("Name: ", log);


                    tvtext.append( log+"\n");
                }





            }
        });




        bupdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // only id is enough to update a record

                int fid = Integer.parseInt( etid.getText().toString());
                String fname = etname.getText().toString().trim();
                String fphone = etphone.getText().toString().trim();

                //  db.updateContact(new Contact(etname.getText().toString(), etphone.getText().toString()));

                db.updateContact(new Contact(fid, fname, fphone));


                // Reading all contacts
                Log.d("Reading: ", "Reading all contacts..");
                contacts = db.getAllContacts();

                tvtext.setText("");

                for (Contact cn : contacts) {
                    String log = "Id: "+cn.getID()+" ,Name: " + cn.getName() + " ,Phone: " + cn.getPhoneNumber();
                    // Writing Contacts to log
                    Log.d("Name: ", log);


                    tvtext.append( log+"\n");
                }





            }
        });




        bdelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                // only id is enough to delete a record

                int fid = Integer.parseInt( etid.getText().toString());
                String fname = etname.getText().toString().trim();
                String fphone = etphone.getText().toString().trim();

                //  db.updateContact(new Contact(etname.getText().toString(), etphone.getText().toString()));

                db.deleteContact(new Contact(fid, fname, fphone));



                // Reading all contacts from table in database
                Log.d("Reading: ", "Reading all contacts..");
                contacts = db.getAllContacts();

                tvtext.setText("");

                for (Contact cn : contacts) {
                    String log = "Id: "+cn.getID()+" ,Name: " + cn.getName() + " ,Phone: " + cn.getPhoneNumber();
                    // Writing Contacts to log
                    Log.d("Name: ", log);


                    tvtext.append( log+"\n");
                }






            }
        });







    }
}
