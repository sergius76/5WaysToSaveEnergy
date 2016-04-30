package com.example.android.myproject5ways;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

/**
 * Created by SERGIUS on 21/04/2016.
 */
public class calculadora extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculadora);
    }
    /**
     * This method is called when the Calculo button is clicked.
     */
    public void displayCalculo(View view) {
        //variables to get the value of and Price and consun kw.
        double valueConsumKw, valuePriceKwh;
        EditText addConsumo = (EditText) findViewById(R.id.valueConsumo);
        EditText addPrice = (EditText) findViewById(R.id.priceKwHora);
        /**
         * /check if the values of addConsumo and addPrice are empty
         * if not empty continue to do calculate and show the result
         */
        if (!addConsumo.getText().toString().isEmpty()
                && !addPrice.getText().toString().isEmpty()) {
            /**Convert values String to double the values wrote by the customer
             * add value Kw price
             */
            String valueConsum = addConsumo.getText().toString();
            valueConsumKw = Double.parseDouble(valueConsum);
            //add value of Kw
            String valuePrecioKw = addPrice.getText().toString();
            valuePriceKwh = Double.parseDouble(valuePrecioKw);
            //Check the state of radio button Bimestral
            RadioButton typeFactura = (RadioButton) findViewById(R.id.radioBimestral);
            boolean biActivated = typeFactura.isChecked();
            /**
             * /call the method getPriceTotal
             *
             */
            String priceTotal = getPriceTotal(valueConsumKw, valuePriceKwh, biActivated);
            /**
             * Display result price on the screen
             */
            TextView totales = (TextView) findViewById(R.id.resultPrice);
            totales.setText(priceTotal);
        } else {
            //Show a message to inform the user if the values of price or consum are empty
            Toast.makeText(this, "Faltan datos", Toast.LENGTH_SHORT).show();
        }
    }
    /**
     * Calculates the price.
     * @return total is the final price of consum by day.
     */
    private String getPriceTotal(double valueKw, double valueKwh, boolean biSelected) {
        double total;
        if (biSelected) {
            total = (valueKw * valueKwh) / 60;
        } else {
            total = (valueKw * valueKwh) / 90;
        }
        DecimalFormat df = new DecimalFormat("0.00");
        return df.format(total);
    }
}
