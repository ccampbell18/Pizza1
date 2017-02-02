package com.example.charl.pizza1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Spinner;
import android.view.Window;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {

    double cost_small = 9.99;
    double cost_med = 12.99;
    double cost_large = 15.99;
    double cost_extra = 18.99;

    CheckBox pep_checkbox;
    CheckBox mush_checkbox;
    CheckBox saus_checkbox;
    CheckBox olive_checkbox;
    CheckBox gp_checkbox;

    double finalPrice = 0.00;
    String sizeChoice;
    ArrayList<String> topList = new ArrayList<String>();




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        pep_checkbox = (CheckBox)findViewById(R.id.checkPep);
        mush_checkbox = (CheckBox)findViewById(R.id.checkMush);
        saus_checkbox = (CheckBox)findViewById(R.id.checkSaus);
        olive_checkbox = (CheckBox)findViewById(R.id.checkOlive);
        gp_checkbox = (CheckBox)findViewById(R.id.checkGrPep);






    }


    public void sendInfo(View v){

        Intent intent = new Intent(this, DisplayTotalActivity.class);
        Bundle extras = new Bundle();

        Spinner size = (Spinner) findViewById(R.id.spinner_size);



        sizeChoice = size.getSelectedItem().toString();


        if (sizeChoice.equals("Small")){
            finalPrice += cost_small;
        }else if (sizeChoice.equals("Medium")){
            finalPrice += cost_med;
        }else if (sizeChoice.equals("Large")){
            finalPrice += cost_large;
        }else if(sizeChoice.equals("Extra Large")){
            finalPrice += cost_extra;
        }


        if (pep_checkbox.isChecked()){
            topList.add("Pepperoni");
            finalPrice += .50;
        }

        if(mush_checkbox.isChecked()){
            topList.add("Mushrooms");
            finalPrice += .50;
        }

        if(saus_checkbox.isChecked()){
            topList.add("Sausage");
            finalPrice += .50;
        }

        if(olive_checkbox.isChecked()){
            topList.add("Black Olives");
            finalPrice += .50;
        }

        if(gp_checkbox.isChecked()){
            topList.add("Green Peppers");
            finalPrice += .50;
        }





        DecimalFormat currency = new DecimalFormat("$#,###.##");

        extras.putString("Total", currency.format(finalPrice));
        extras.putString("Size", sizeChoice);
        extras.putStringArrayList("Toppings", topList);
        intent.putExtras(extras);
        startActivity(intent);


    }
}


