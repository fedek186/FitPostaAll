package com.example.fitpostaall;

import android.app.Fragment;
import android.app.Fragment;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.applandeo.materialcalendarview.CalendarView;
import com.applandeo.materialcalendarview.EventDay;

import java.util.ArrayList;
import java.util.List;

public class fragCalendario extends Fragment {
    com.applandeo.materialcalendarview.CalendarView calendarView;
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View vista;
        vista=inflater.inflate(R.layout.layout_calendario,container,false);
        calendarView = (CalendarView) vista.findViewById(R.id.calendarView);
        List<EventDay> events = new ArrayList<>();
        //Puedo añadir al dia de hoy un evento o una marca. Mientras mas grande sea el numero mas dias adelantes. Lo mismo al reves.
        java.util.Calendar calendar1 = java.util.Calendar.getInstance();
        calendar1.add(java.util.Calendar.DAY_OF_MONTH,1);
        events.add(new EventDay(calendar1, R.drawable.circ_rutina));
        calendarView.setEvents(events);
        return vista;
    }







}
