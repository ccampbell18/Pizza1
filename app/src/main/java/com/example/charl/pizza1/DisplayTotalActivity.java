package com.example.charl.pizza1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.TextView;

public class DisplayTotalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_total);

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();

        String total = extras.getString("Total");
        String size = extras.getString("Size");

        TextView textView = new TextView(this);
        textView.setTextSize(36);

        textView.setText("Total Cost: " + total + "\n" + "Size: " + size);

        ViewGroup layout = (ViewGroup) findViewById(R.id.activity_display_total);
        layout.addView(textView);
    }
}
