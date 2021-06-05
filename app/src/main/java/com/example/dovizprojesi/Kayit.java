package com.example.dovizprojesi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class Kayit extends AppCompatActivity implements Kayitt, OnMapReadyCallback {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kayit);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        LatLng doviz1 = new LatLng(41.0594398,28.9357236);
        LatLng doviz2 = new LatLng(41.0755254,28.920732);
        LatLng doviz3 = new LatLng(41.0791628,28.9161092);
        LatLng doviz4 = new LatLng(41.0739441,28.9170827);
        LatLng doviz5 = new LatLng(41.0690605,28.9089136);
        LatLng doviz6 = new LatLng(41.0502883,28.8759911);
        LatLng doviz7 = new LatLng(41.054732,28.8727257);

        googleMap.addMarker(new MarkerOptions().position(doviz1).title("Tellioğlu Döviz"));
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(doviz1));
        googleMap.addMarker(new MarkerOptions().position(doviz2).title("KAREL DÖVİZ İSFANBUL"));
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(doviz2));
        googleMap.addMarker(new MarkerOptions().position(doviz3).title("Singer Döviz"));
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(doviz3));
        googleMap.addMarker(new MarkerOptions().position(doviz4).title("Okurlar Döviz Bürosu"));
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(doviz4));
        googleMap.addMarker(new MarkerOptions().position(doviz5).title("Anadolu Veys Döviz"));
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(doviz5));
        googleMap.addMarker(new MarkerOptions().position(doviz6).title("Altinkemer Döviz Bürosu"));
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(doviz6));
        googleMap.addMarker(new MarkerOptions().position(doviz7).title("Yıldırım Döviz & Altin"));
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(doviz7));


        googleMap.addMarker(new MarkerOptions()
                .position(new LatLng(41.0767191,28.9294794))
                .title("BURADASINIZ")
                .snippet("Karadolap Mahallesi"));
        googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(doviz1, 12));

        googleMap.getUiSettings().setMyLocationButtonEnabled(true); // konumumu göster butonu aktif edildi
        googleMap.getUiSettings().setCompassEnabled(true); // pusula butonu aktif edildi
        googleMap.getUiSettings().setZoomControlsEnabled(true); // zoom butonları aktif edildi

        googleMap.setMapType(GoogleMap.MAP_TYPE_HYBRID); // hibrit görünümü set edildi
//        googleMap.setMapType(GoogleMap.MAP_TYPE_TERRAIN);
        googleMap.setTrafficEnabled(true); // trafik durumu aktif edildi


    }


}



