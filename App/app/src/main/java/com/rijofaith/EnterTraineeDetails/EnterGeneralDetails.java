package com.rijofaith.EnterTraineeDetails;

/**
 * Created by rijo on 16-Sep-15.
 */

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.os.AsyncTask;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import com.rijofaith.app.R;


public class EnterGeneralDetails extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_general_details);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
    }


    public class PlaceholderFragment extends Fragment {

        ArrayList<String> listItems = new ArrayList<>();
        ArrayAdapter<String> adapter;
        Spinner sp;

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            //Inflate the layout for this fragment

          View view = inflater.inflate(R.layout.activity_general_details, container, false);
            return view;

            public void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_main);
                sp=(Spinner)findViewById(R.id.spinner);
                adapter=new ArrayAdapter<String>(this,R.layout.spinner_layout,R.id.textView8,listItems);
                sp.setAdapter(adapter);

            }
        public void onStart(){
            super.onStart();
            BackTask bt=new BackTask();
            bt.execute();
        }
        }


    }
}

