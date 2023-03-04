package com.example.googlemapsit_2023_2.adaptadores;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Icon;
import android.media.Image;
import com.bumptech.glide.Glide;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.googlemapsit_2023_2.R;
import com.example.googlemapsit_2023_2.models.Places;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Marker;

public class adaptadorplaces implements GoogleMap.InfoWindowAdapter {

    private static final String TAG = "adaptadorplaces";
    private LayoutInflater inflater;
    private Places places;

    public adaptadorplaces(LayoutInflater inflater){
        this.inflater = inflater;

    }

    @Override
    public View getInfoContents(Marker marker) {
        return null;
    }

    @Override
    public View getInfoWindow(Marker marker) {
        View v = inflater.inflate(R.layout.infowindowadapter, null);
        places = (Places) marker.getTag();
            ImageView image = (ImageView)v.findViewById(R.id.imgicono);
            ((TextView)v.findViewById(R.id.lblNombre)).setText(places.name);
            ((TextView)v.findViewById(R.id.lblDireccion)).setText(places.vicinity);
            ((TextView)v.findViewById(R.id.lblweb)).setText(places.open_now);
            Glide.with(v).load(places.icon).into(image);
            ImageView image2 = (ImageView)v.findViewById(R.id.imgUsr);
            Glide.with(v).load( "https://maps.googleapis.com/maps/api/place/photo?maxwidth=400&photo_reference=" + places.photo_reference + "&key=AIzaSyB5MkIB5lNnQH1kC1tZ3ATeEsv7z66moKs").into(image2);
            return v;
    }
}



