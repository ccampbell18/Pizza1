package com.example.charl.pizza1;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class DisplayTotalActivity extends Activity {
    MediaPlayer musicPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_total);

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();

        String total = extras.getString("Total");
        String size = extras.getString("Size");
        ArrayList<String> topList = extras.getStringArrayList("Toppings");
        String firstName = extras.getString("FirstName");
        String lastName = extras.getString("LastName");
        String phone = extras.getString("Phone");
        String email = extras.getString("Email");

        TextView toppingView = (TextView) findViewById(R.id.toppingsView);
        TextView textView = (TextView) findViewById(R.id.totalView);
        TextView personalView = (TextView) findViewById(R.id.personalView);

        StringBuilder b = new StringBuilder();
        for (String s : topList) {
            b.append(s + "\n");
        }

        toppingView.setText("Toppings: " + "\n" + "\n" + b.toString());

        textView.setText("Total Cost: " + total + "\n" + "Size: " + size);

        personalView.setText("First Name: " + firstName + "\n" + "Last Name: " + lastName
                + "\n" + "Phone Number: " + phone + "\n" + "Email Address: " + email);

        musicPlayer = MediaPlayer.create(this, R.raw.pizza);
        musicPlayer.start();

        Toast.makeText(DisplayTotalActivity.this, "Order Received", Toast.LENGTH_LONG).show();

    }

    public void onBack(View v) {
        this.finish();
        TextView topping = (TextView) findViewById(R.id.toppingsView);
        topping.setText(" ");
    }
}