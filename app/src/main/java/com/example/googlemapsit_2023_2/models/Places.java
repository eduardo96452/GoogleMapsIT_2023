package com.example.googlemapsit_2023_2.models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Places {
    public String location_lat;
    public String location_lng;
    public String icon;
    public String name;
    public String vicinity;
    public String photo_reference;
    public String open_now;

    public String getLocation_lat() { return location_lat; }

    public void setLocation_lat(String location_lat) { this.location_lat = location_lat; }

    public String getLocation_lng() { return location_lng; }

    public void setLocation_lng(String location_lng) { this.location_lng = location_lng; }

    public String getIcon() { return icon; }

    public void setIcon(String icon) { this.icon = icon; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getVicinity() { return vicinity; }

    public void setVicinity(String vicinity) { this.vicinity = vicinity; }

    public String getPhoto() { return photo_reference; }

    public void setPhoto(String photo) { this.photo_reference = photo; }

    public Places(JSONObject a) throws JSONException {
        JSONObject geometry = a.getJSONObject("geometry");
        JSONObject location = geometry.getJSONObject("location");
        location_lat = location.getString("lat").toString();
        location_lng = location.getString("lng").toString();
        icon = a.getString("icon").toString();
        name = a.getString("name").toString();
        vicinity = a.getString("vicinity").toString();

        if(!a.isNull("opening_hours")){
            JSONObject horario = a.getJSONObject("opening_hours");
            if(horario.getString("open_now")=="true")
                open_now = ("Esta Abierto");
            else open_now = ("Esta Cerrado");
        }else
        {
            open_now = "No tiene horario";
        }
        System.out.println("Hola aqui el horario = " + open_now);

        //para sacar las photos
        JSONObject JSONlista = null;
        JSONlista = a;

        if(!JSONlista.isNull("photos")   ){
            JSONArray JSONlistaphoto = JSONlista.getJSONArray("photos");
            JSONObject photreferen = JSONlistaphoto.getJSONObject(0);
            photo_reference = photreferen.getString("photo_reference").toString();
        }else
        {
            photo_reference = "No tiene foto";
        }
        System.out.println("Hola aqui la foto = " + photo_reference);
    }

    public static ArrayList<Places> JsonObjectsBuild(JSONArray datos) throws JSONException {
        ArrayList<Places> places = new ArrayList<>();

        for (int i = 0; i < datos.length() && i<20; i++) {
            places.add(new Places(datos.getJSONObject(i)));
        }
        return places;
    }
}
