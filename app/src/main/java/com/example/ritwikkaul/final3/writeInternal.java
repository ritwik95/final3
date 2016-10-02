package com.example.ritwikkaul.final3;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

public class writeInternal extends AppCompatActivity {
    private final String FILENAME="internalfile.txt";
    EditText mEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write_internal);
        mEditText = (EditText)findViewById(R.id.editText);
    }

    public void writeFile(View view) {
        try {
            FileOutputStream fileOutputStream =
                    openFileOutput(FILENAME, Context.MODE_PRIVATE);
            fileOutputStream.write(
                    mEditText.getText().toString().getBytes());
            fileOutputStream.close();
            mEditText.setText("");
            Toast.makeText(this,"Data written to file",Toast.LENGTH_SHORT).show();
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
    }

    public void readFile(View view) {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            InputStream inputStream = openFileInput(FILENAME);
            if ( inputStream != null ) {
                InputStreamReader inputStreamReader = new
                        InputStreamReader(inputStream);
                BufferedReader bufferedReader = new
                        BufferedReader(inputStreamReader);
                String newLine = null;
                while ((newLine = bufferedReader.readLine()) != null ) {
                    stringBuilder.append(newLine+"\n");
                }
                inputStream.close();
            }
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
        mEditText.setText(stringBuilder);
        Toast.makeText(this,"Reading data",Toast.LENGTH_SHORT).show();
    }

}
