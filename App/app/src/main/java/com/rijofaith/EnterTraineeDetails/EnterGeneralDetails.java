package com.rijofaith.EnterTraineeDetails;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.rijofaith.app.R;

public class EnterGeneralDetails extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_general_details);


    }


    public void back(View view){
        onBackPressed();
    }

    public void onBackPressed() {
        super.onBackPressed();
    }


}
