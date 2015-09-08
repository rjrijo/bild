package com.rijofaith.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {

    TextView txtName;
    TextView txtEmail;
    Button btnLogout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtEmail = (TextView) findViewById(R.id.userid);
        btnLogout = (Button) findViewById(R.id.btnLogout);

    }
    public void cohorts(View view)
    {
        startActivity(new Intent(this, Cohorts.class));
    }

    public void trainees(View view)
    {
        startActivity(new Intent(this, Trainees.class));
    }

    public void data_entry_status(View view)
    {
        startActivity(new Intent(this, DataEntryStatus.class));
    }

    public void training_status(View view)
    {
        startActivity(new Intent(this, TrainingStatus.class));
    }
}