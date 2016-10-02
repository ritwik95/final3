package com.example.ritwikkaul.final3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DisplayData extends AppCompatActivity {
    TextView tex;
    String fil;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_data);
        tex=(TextView)findViewById(R.id.fill);
        fil = getIntent().getStringExtra("Ans");
        tex.setText(fil);

    }
}
