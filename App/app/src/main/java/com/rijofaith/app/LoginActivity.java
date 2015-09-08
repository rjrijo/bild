package com.rijofaith.app;

/**
 * Created by rijo on 31-Aug-15.
 */

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class LoginActivity extends Activity {
    // LogCat tag

    EditText inputUserid;
    EditText inputPassword;
    String login_name,login_pass;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        inputUserid = (EditText) findViewById(R.id.userid);
        inputPassword = (EditText) findViewById(R.id.password);

    }

    public void userReg(View view)
    {


    }

    public void userLogin(View view)
    {
        login_name = inputUserid.getText().toString();
        login_pass = inputPassword.getText().toString();
        String method = "login";
        BackgroundTask backgroundTask = new BackgroundTask(this);
        backgroundTask.execute(method, login_name, login_pass);

    }

    }