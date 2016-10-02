package com.example.ritwikkaul.final3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void sharefpref(View view) {
        Intent intent = new Intent(this, sharedPref.class);
        startActivity(intent);
    }

    public void writeinternal(View view){
        Intent intent = new Intent(this, writeInternal.class);
        startActivity(intent);
    }

    public void writeexternal(View view){
        Intent intent = new Intent(this, writeExternal.class);
        startActivity(intent);
    }

    public void sqlite(View view){
        Intent intent = new Intent(this, AndroidSQLiteTutorialActivity.class);
        startActivity(intent);

    }


}
