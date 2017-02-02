package com.example.charl.pizza1;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class DisplayTotalActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_total);

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();

        String total = extras.getString("Total");
        String size = extras.getString("Size");
        ArrayList<String> topList = extras.getStringArrayList("Toppings");

        TextView toppingView = (TextView) findViewById(R.id.toppingsView);
        TextView textView = (TextView) findViewById(R.id.totalView);

        StringBuilder b = new StringBuilder();
        for (String s : topList){
            b.append(s + "\n");
        }

        toppingView.setText("Toppings: " + "\n" + "\n" + b.toString());

        textView.setText("Total Cost: " + total + "\n" + "Size: " + size);

    }
}
