package com.example.ritwikkaul.final3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class AndroidSQLiteTutorialActivity extends AppCompatActivity {
    DatabaseHandler db = new DatabaseHandler(this);
    private EditText name ;
    private EditText  number;
    private EditText id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_android_sqlite_tutorial);
        id=(EditText)findViewById(R.id.getinfo);
    }

    public void addname(View view) {
        name = (EditText) findViewById(R.id.name);
        number = (EditText) findViewById(R.id.number);
        String na = name.getText().toString();
        String num = number.getText().toString();
        int i=na.length();
        int n=num.length();


        if(na.length()!=0 && num.length()!=0){
            db.addContact(new Contact(na, num));
            Toast.makeText(this, "Contact Added", Toast.LENGTH_SHORT).show();
            name.setText("");
            number.setText("");
        }
        else {
            Toast.makeText(this, "Please don't leave any field blank" , Toast.LENGTH_SHORT).show();
        }}

    public void displaynames(View view) {
        Log.d("Reading: ", "Reading all contacts..");
        List<Contact> contacts = db.getAllContacts();

        StringBuilder log = new StringBuilder("");

        for (Contact cn : contacts) {
            log.append("Id: " + cn.getID() + " ,Name: " + cn.getName() + " ,Phone: " + cn.getPhoneNumber() + "\n");
            // Writing Contacts to log
        }

        Intent myIntent = new Intent(this,DisplayData.class);
        myIntent.putExtra("Ans", log.toString());
        startActivity(myIntent);
    }

    public void getinfofun(View view){

        String i=id.getText().toString();
        int _id=Integer.parseInt(i);
        Contact contact;
        contact=db.getContact(_id);

        Toast.makeText(this,"The name is "+contact.getName()+" and the phone number is "+contact.getPhoneNumber(),Toast.LENGTH_LONG).show();
    }

    public void deleteperson(View view){
        String i=id.getText().toString();
        int _id=Integer.parseInt(i);
        db.deleteContact(db.getContact(_id));
        Toast.makeText(this,"The details of person with ID "+_id+" were deleted",Toast.LENGTH_SHORT).show();
        id.setText("");

    }

    public void count(View view){
        int i = db.getContactsCount();
        Toast.makeText(this, "The table currently has "+String.valueOf(i)+" enteries",Toast.LENGTH_SHORT).show();

    }

    public void update(View view){
        name = (EditText) findViewById(R.id.name);
        number = (EditText) findViewById(R.id.number);
        String i=id.getText().toString();

        String na = name.getText().toString();
        String num = number.getText().toString();
        Contact cnt = new Contact(na,num);
        db.updateContact(cnt,i);
        Toast.makeText(this,"Details Updated for "+ cnt.getName(),Toast.LENGTH_SHORT).show();
        name.setText("");
        number.setText("");
        id.setText("");
    }

}
