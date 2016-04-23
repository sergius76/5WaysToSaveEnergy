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
    @Override public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculadora);
    }
    public void MostrarCalculo(View view){

        double valueConsumKw, valuePriceKwh;

        EditText consumo = (EditText)findViewById(R.id.consumoValor);
        EditText precio = (EditText)findViewById(R.id.precioKwHora);

        if (!consumo.getText().toString().isEmpty()
                && !precio.getText().toString().isEmpty()) {
            String valueConsum = consumo.getText().toString();
            valueConsumKw = Double.parseDouble(valueConsum);

            String valuePrecioKw = precio.getText().toString();
            valuePriceKwh = Double.parseDouble(valuePrecioKw);

            RadioButton tipoFactura = (RadioButton)findViewById(R.id.radioBimestral);
            boolean biActivado = tipoFactura.isChecked();

            //  RadioButton tipoFactura2 = (RadioButton)findViewById(R.id.radioTriMestral);
            //  boolean triActivado = tipoFactura2.isChecked();


            /**  if((consumValue=0.000) && (consumPrecio = 0.000)){

             }*/
            double resumen = Calculo(valueConsumKw, valuePriceKwh, biActivado);
            DecimalFormat df = new DecimalFormat("0.00");
            //  String total = Double.toString(resumen);

            TextView totales = (TextView)findViewById(R.id.totalConsumo);
            totales.setText(df.format(resumen)+"€");
            //  DisplayTotal(total);

        } else {
            Toast.makeText(this, "Faltan datos", Toast.LENGTH_SHORT).show();
        }

    }

    private double Calculo(double consumido, double precio, boolean biSelected){
        double consum = consumido;
        double preciokw = precio;
        double total;

        if(biSelected){
            total = (consumido * precio) / 60;
        }else{
            total = (consumido * precio) / 90;
        }

        return total;

    }


}
