package com.example.charl.pizza1;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
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

   /* boolean pepChecked = ((CheckBox) findViewById(R.id.checkPep)).isChecked();
    boolean mushChecked = ((CheckBox) findViewById(R.id.checkMush)).isChecked();
    boolean sausChecked = ((CheckBox) findViewById(R.id.checkSaus)).isChecked();
    boolean oliveChecked = ((CheckBox) findViewById(R.id.checkOlive)).isChecked();
    boolean grPepChecked = ((CheckBox) findViewById(R.id.checkGrPep)).isChecked();*/

    double finalPrice;
    String sizeChoice;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);



    }


    public void sendInfo(View v){

        Intent intent = new Intent(this, DisplayTotalActivity.class);
        Bundle extras = new Bundle();

        Spinner size = (Spinner) findViewById(R.id.spinner_size);



        sizeChoice = size.getSelectedItem().toString();


        if (sizeChoice.equals("Small")){
            finalPrice = cost_small;
        }else if (sizeChoice.equals("Medium")){
            finalPrice = cost_med;
        }else if (sizeChoice.equals("Large")){
            finalPrice = cost_large;
        }else if(sizeChoice.equals("Extra Large")){
            finalPrice = cost_extra;
        }

       /* if(pepChecked){
            finalPrice = +.50;
        }
        if(mushChecked){
            finalPrice = +.50;
        }
        if(sausChecked){
            finalPrice = +.50;
        }
        if(oliveChecked){
            finalPrice = +.50;
        }
        if(grPepChecked){
            finalPrice = +.50;
        }
*/



        DecimalFormat currency = new DecimalFormat("$#,###.##");

        extras.putString("Total", currency.format(finalPrice));
        extras.putString("Size", sizeChoice);
        intent.putExtras(extras);
        startActivity(intent);


    }
}


