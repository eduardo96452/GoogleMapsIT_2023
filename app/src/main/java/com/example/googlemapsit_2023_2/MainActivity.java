package com.example.googlemapsit_2023_2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MainActivity
        extends AppCompatActivity
        implements OnMapReadyCallback, GoogleMap.OnMapClickListener
{

    GoogleMap Mapa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SupportMapFragment mapFragment =
                (SupportMapFragment) getSupportFragmentManager()
               .findFragmentById(R.id.map);

        mapFragment.getMapAsync(this);

    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        Mapa = googleMap;

        Mapa.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        Mapa.getUiSettings().setZoomControlsEnabled(true);

        //Mover el Mapa a Quevedo
        CameraUpdate camUpd1 = CameraUpdateFactory
                    .newLatLngZoom(new
                            LatLng(-1.0227893720763475, -79.4628673782913),
                            15);
        Mapa.moveCamera(camUpd1);

        Mapa.setOnMapClickListener(this);
    }

    @Override
    public void onMapClick(@NonNull LatLng latLng) {

        Mapa.addMarker(new MarkerOptions().position(latLng)
                .title("Centro del Universo!!"));

        CircleOptions circulo = new CircleOptions();
        circulo.center(latLng);
        circulo.radius(1500);
        Mapa.addCircle(circulo);
    }



    public void onClickSatelite(View view) {
        Mapa.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
        Mapa.getUiSettings().setZoomControlsEnabled(true);
    }
    public void onClickHibrido(View view) {
        Mapa.setMapType(GoogleMap.MAP_TYPE_HYBRID);
        Mapa.getUiSettings().setZoomControlsEnabled(true);
    }
    public void onClickNormal(View view) {
        Mapa.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        Mapa.getUiSettings().setZoomControlsEnabled(true);
    }
    public void onClickTerrenal(View view) {
        Mapa.setMapType(GoogleMap.MAP_TYPE_TERRAIN);
        Mapa.getUiSettings().setZoomControlsEnabled(true);
    }


}