package com.example.dovizprojesi;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Convert extends AppCompatActivity {
String usd,eur,chf,aud,gbp,rub,jpy,pln;
String sayi;
public String usd2;



    EditText edit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_convert);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        TextView txt,eur1,chf1,aud1,gbp1,rub1,jpy1,pln1;
        Button button=findViewById(R.id.button3);

        txt=findViewById(R.id.USD);
        edit=findViewById(R.id.edit);
        eur1 = findViewById(R.id.EUR);
        chf1 = findViewById(R.id.CHF);
        aud1 = findViewById(R.id.AUD);
        gbp1 = findViewById(R.id.GBP);
        rub1 = findViewById(R.id.RUB);
        jpy1 = findViewById(R.id.JPY);
        pln1 = findViewById(R.id.PLN);



        Intent verial=getIntent();
        usd= verial.getStringExtra("usd");
        eur=verial.getStringExtra("eur");
        chf=verial.getStringExtra("chf");
        aud=verial.getStringExtra("aud");
        gbp=verial.getStringExtra("gbp");
        rub=verial.getStringExtra("rub");
        jpy=verial.getStringExtra("jpy");
        pln=verial.getStringExtra("pln");


       // float eur2=Float.parseFloat(eur);

        NumberFormat nf_in = NumberFormat.getNumberInstance(Locale.GERMANY);
        double val = 0;
        try {
            val = nf_in.parse(eur).doubleValue();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        NumberFormat nf_out = NumberFormat.getNumberInstance(Locale.UK);
        nf_out.setMaximumFractionDigits(3);
        String eur2 = nf_out.format(val);


        NumberFormat nf_in1 = NumberFormat.getNumberInstance(Locale.GERMANY);
        double val1 = 0;
        try {
            val = nf_in.parse(chf).doubleValue();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        NumberFormat nf_out1 = NumberFormat.getNumberInstance(Locale.UK);
        nf_out.setMaximumFractionDigits(3);
        String chf2 = nf_out.format(val);

        NumberFormat nf_in2 = NumberFormat.getNumberInstance(Locale.GERMANY);
        double val2 = 0;
        try {
            val = nf_in.parse(aud).doubleValue();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        NumberFormat nf_out2 = NumberFormat.getNumberInstance(Locale.UK);
        nf_out.setMaximumFractionDigits(3);
        String aud2 = nf_out.format(val);

        NumberFormat nf_in3 = NumberFormat.getNumberInstance(Locale.GERMANY);
        double val3 = 0;
        try {
            val = nf_in.parse(gbp).doubleValue();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        NumberFormat nf_out3 = NumberFormat.getNumberInstance(Locale.UK);
        nf_out.setMaximumFractionDigits(3);
        String gbp2 = nf_out.format(val);

        NumberFormat nf_in4 = NumberFormat.getNumberInstance(Locale.GERMANY);
        double val4 = 0;
        try {
            val = nf_in.parse(rub).doubleValue();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        NumberFormat nf_out4 = NumberFormat.getNumberInstance(Locale.UK);
        nf_out.setMaximumFractionDigits(3);
        String rub2 = nf_out.format(val);

        NumberFormat nf_in5 = NumberFormat.getNumberInstance(Locale.GERMANY);
        double val5 = 0;
        try {
            val = nf_in.parse(jpy).doubleValue();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        NumberFormat nf_out5 = NumberFormat.getNumberInstance(Locale.UK);
        nf_out.setMaximumFractionDigits(3);
        String jpy2 = nf_out.format(val);

        NumberFormat nf_in6 = NumberFormat.getNumberInstance(Locale.GERMANY);
        double val6 = 0;
        try {
            val = nf_in.parse(pln).doubleValue();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        NumberFormat nf_out6 = NumberFormat.getNumberInstance(Locale.UK);
        nf_out.setMaximumFractionDigits(3);
        String pln2 = nf_out.format(val);

        NumberFormat nf_in7 = NumberFormat.getNumberInstance(Locale.GERMANY);
        double val7 = 0;
        try {
            val = nf_in.parse(usd).doubleValue();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        NumberFormat nf_out7 = NumberFormat.getNumberInstance(Locale.UK);
        nf_out.setMaximumFractionDigits(3);
        usd2 = nf_out.format(val);



        button.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                yolla();
                eur1.setText("EUR="+Float.parseFloat(sayi)/Float.parseFloat(eur2));
                chf1.setText("CHF="+Float.parseFloat(sayi)/Float.parseFloat(chf2));
                aud1.setText("AUD="+Float.parseFloat(sayi)/Float.parseFloat(aud2));
                gbp1.setText("GBP="+Float.parseFloat(sayi)/Float.parseFloat(gbp2));
                rub1.setText("RUB="+Float.parseFloat(sayi)/Float.parseFloat(rub2));
                jpy1.setText("JPY="+Float.parseFloat(sayi)/Float.parseFloat(jpy2));
                pln1.setText("PLN="+Float.parseFloat(sayi)/Float.parseFloat(pln2));
                txt.setText("USD="+Float.parseFloat(sayi)/Float.parseFloat(usd2));
            }
        });


        }
    public void yolla() {

        sayi = edit.getText().toString();

    }





    }

