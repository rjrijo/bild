package com.rijofaith.app;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;


public class EnterGeneralDetails extends ActionBarActivity {

    Spinner spn_title;
    Spinner spn_cohort;
    Spinner spn_mission;
    Spinner spn_church;
    Spinner spn_designation;
    List<String> List_title=new ArrayList<String>();
    List<String> List_cohort=new ArrayList<String>();
    List<String> List_mission=new ArrayList<String>();
    List<String> List_chruch=new ArrayList<String>();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_general_details);
        spn_title=(Spinner)findViewById(R.id.spinner23);
        spn_cohort=(Spinner)findViewById(R.id.spinner22);
        spn_mission=(Spinner)findViewById(R.id.spinner27);
        spn_church=(Spinner)findViewById(R.id.spinner28);
        spn_designation=(Spinner)findViewById(R.id.spinner29);
        populatespinner();
    }

    public void populatespinner() {
        List_title.add("Mr.");
        List_title.add("Mrs.");


        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,List_title);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spn_title.setAdapter(adapter);
        ArrayAdapter<CharSequence> adapter2= ArrayAdapter.createFromResource(this,R.array.Cohort_name,android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spn_cohort.setAdapter(adapter2);
        ArrayAdapter<CharSequence> adapter3= ArrayAdapter.createFromResource(this,R.array.mission,android.R.layout.simple_spinner_item);
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spn_mission.setAdapter(adapter3);
        ArrayAdapter<CharSequence> adapter4= ArrayAdapter.createFromResource(this,R.array.church,android.R.layout.simple_spinner_item);
        adapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spn_church.setAdapter(adapter4);
        ArrayAdapter<CharSequence> adapter5= ArrayAdapter.createFromResource(this,R.array.designation,android.R.layout.simple_spinner_item);
        adapter5.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spn_designation.setAdapter(adapter5);
    }


}


