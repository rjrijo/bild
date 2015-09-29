package com.rijofaith.app;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
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

    public void logout(View view)
    {
        backButtonHandler();
    }

    public void onBackPressed() {
        //Display alert message when back button has been pressed
        backButtonHandler();
        return;
    }

    public void backButtonHandler() {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(MainActivity.this);
        // Setting Dialog Title
        alertDialog.setTitle("Logout?");
        // Setting Dialog Message
        alertDialog.setMessage("Are you sure you want to logout?");
        // Setting Positive "Yes" Button
        alertDialog.setPositiveButton("YES",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                });
        // Setting Negative "NO" Button
        alertDialog.setNegativeButton("NO",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // Write your code here to invoke NO event
                        dialog.cancel();
                    }
                });
        // Showing Alert Message
        alertDialog.show();
    }

}

