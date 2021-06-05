package com.example.dovizprojesi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    public TextView usd,eur,chf,aud,gbp,rub,jpy,pln;
    private RequestQueue mQueue;
    public String alıs;


    ArrayList<String> listeAd = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

     Intent intent=new Intent(this,MyService.class);
     if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){
         startForegroundService(intent);
     }
     else{
         startService(intent);
     }
        eur = findViewById(R.id.eur);
        chf = findViewById(R.id.chf);
        aud = findViewById(R.id.aud);
        gbp = findViewById(R.id.gbp);
        rub = findViewById(R.id.rub);
        jpy = findViewById(R.id.jpy);
        pln = findViewById(R.id.pln);
        usd = findViewById(R.id.usd);
        Button buttonParse = findViewById(R.id.button);
        Button buttonn=findViewById(R.id.button2);
        Button kayit=findViewById(R.id.button4);
        mQueue = Volley.newRequestQueue(this);


        hesap();


        kayit.setOnClickListener(v -> {
            Intent Kayit=new Intent(MainActivity.this,Kayit.class);
            startActivity(Kayit);

        });
        buttonn.setOnClickListener(v -> {
            Intent Convert=new Intent(MainActivity.this, Convert.class);

            Convert.putExtra("usd",listeAd.get(0));
            Convert.putExtra("eur",listeAd.get(1));
            Convert.putExtra("chf",listeAd.get(2));
            Convert.putExtra("aud",listeAd.get(3));
            Convert.putExtra("gbp",listeAd.get(4));
            Convert.putExtra("rub",listeAd.get(5));
            Convert.putExtra("jpy",listeAd.get(6));
            Convert.putExtra("pln",listeAd.get(7));

            startActivity(Convert);
        });
        buttonParse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                hesap();


            }
        });

    }

    public void hesap() {

            jsonParse(usd, "USD");
            jsonParse(eur, "EUR");
        jsonParse(chf, "CHF");
        jsonParse(aud, "AUD");
        jsonParse(gbp, "GBP");
        jsonParse(rub, "RUB");
        jsonParse(jpy, "JPY");
        jsonParse(pln, "PLN");

    }

    public void jsonParse(View view,String money) {
        String url = "https://finans.truncgil.com/today.json";
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
//                                textView.setBackgroundColor(Color.parseColor("#000000"));
                            JSONObject resultJsonArray = response.getJSONObject(money);
                            alıs=resultJsonArray.getString("Alış");
                            String satıs=resultJsonArray.getString("Satış");
                            String degisim=resultJsonArray.getString("Değişim");
                            if( view instanceof TextView ) {
                                TextView textView = (TextView) view;
                                textView.setText(""+ money + "   \n          " + alıs + "            " + satıs + "  " + degisim+"\n");
                                listeAd.add(alıs);

                            }



                        } catch (JSONException e) {
                            e.printStackTrace();

                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });
        mQueue.add(request);

    }


}