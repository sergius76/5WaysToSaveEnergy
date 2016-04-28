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

    public void MostrarCalculo(View view) {

        //variables to get the value of consum and Price.
        double valueConsumKw, valuePriceKwh;

        EditText consumo = (EditText) findViewById(R.id.valueConsumo);
        EditText precio = (EditText) findViewById(R.id.priceKwHora);

        /**
         * /check if the values of consum and price are empty
         * if not empty continue to do calcul and show the result
         */

        if (!consumo.getText().toString().isEmpty()
                && !precio.getText().toString().isEmpty()) {
            //Convert values String to double the values wrote by the customer
            String valueConsum = consumo.getText().toString();
            valueConsumKw = Double.parseDouble(valueConsum);

            String valuePrecioKw = precio.getText().toString();
            valuePriceKwh = Double.parseDouble(valuePrecioKw);

            //Incated the state of radio button Bimestral
            RadioButton tipoFactura = (RadioButton) findViewById(R.id.radioBimestral);
            boolean biActivado = tipoFactura.isChecked();

            /**
             * /call the method displayCalculo
             *
             */
            double resumen = displayCalculo(valueConsumKw, valuePriceKwh, biActivado);
            DecimalFormat df = new DecimalFormat("0.00");
            /**
             * Display result price on the screen
             */
            TextView totales = (TextView) findViewById(R.id.resultPrice);
            totales.setText(df.format(resumen) + "€");

        } else {
            //Show a message to inform the user if the values of price or consum are empty
            Toast.makeText(this, "Faltan datos", Toast.LENGTH_SHORT).show();
        }

    }
    /**
     * Calculates the price.
     *
     * @return total is the final price of consum by day.
     */
    private double displayCalculo(double consumido, double precio, boolean biSelected) {
        double consum = consumido;
        double preciokw = precio;
        double total;

        if (biSelected) {
            total = (consumido * precio) / 60;
        } else {
            total = (consumido * precio) / 90;
        }

        return total;

    }
}
