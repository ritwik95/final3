package com.example.ritwikkaul.final3;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class sharedPref extends AppCompatActivity {

    private final String NAME="NAME";
    private final String AGE="AGE";
    private EditText mEditTextName;
    private EditText mEditTextAge;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_pref);
        TextView textView = (TextView)findViewById(R.id.displaydetails);
        SharedPreferences sharedPreferences = getPreferences(
                MODE_PRIVATE);
        String name = sharedPreferences.getString(NAME,null);
        String age = sharedPreferences.getString(AGE,null);
        if (name==null) {
            textView.setText("Hello...");
        } else {
            if (age == "") {
                textView.setText("Welcome back " + name + " !!! \nYour age is not known");
            } else {
                textView.setText("Welcome back " + name + "! \n Your age is " + age);
            }
        }
        mEditTextName = (EditText)findViewById(R.id.editTextName);
        mEditTextAge = (EditText)findViewById(R.id.editTextAge);
    }

    public void saveDetails(View view) {
        SharedPreferences.Editor editor =
                getPreferences(MODE_PRIVATE).edit();
        editor.putString(NAME, mEditTextName.getText().
                toString());
        editor.putString(AGE, mEditTextAge.getText().
                toString());
        editor.commit();
        mEditTextAge.setText("");
        mEditTextName.setText("");
        Toast.makeText(this,"Preferences Saved",Toast.LENGTH_SHORT).show();
    }


}


