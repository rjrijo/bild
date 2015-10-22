package com.rijofaith.app;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class EnterTraineesDetails extends Activity {

    Spinner spn_title;
    Spinner spn_cohort;
    Spinner spn_mission;
    Spinner spn_church;
    Spinner spn_designation;

    CheckBox c1, c2, c3, c4;

    List<String> List_title = new ArrayList<String>();
    List<String> List_cohort = new ArrayList<String>();
    List<String> List_mission = new ArrayList<String>();
    List<String> List_chruch = new ArrayList<String>();

    EditText cohort_leader;
    EditText associate_faculty;
    EditText cohort_location;
    EditText current_cohort_id;
    EditText certified_leader;
    EditText volunteer_id;
    EditText fullname;
    EditText date_of_birth;
    EditText age;
    EditText email_id;
    EditText home_phone;
    EditText mobile_phone;
    EditText present_address;
    EditText pin;
    EditText permanent_address;
    EditText personal_identification;
    EditText eportfolio_username;
    EditText eportfolio_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_trainees_details);

        spn_title = (Spinner) findViewById(R.id.spinner23);
        spn_cohort = (Spinner) findViewById(R.id.spinner22);
        spn_mission = (Spinner) findViewById(R.id.spinner27);
        spn_church = (Spinner) findViewById(R.id.spinner28);
        spn_designation = (Spinner) findViewById(R.id.spinner29);

        populatespinner();

        c1 =  (CheckBox) findViewById(R.id.checkBoxB_minus_bius);
        c2 =  (CheckBox) findViewById(R.id.checkBoxB_minus_antioch_school);
        c3 =  (CheckBox) findViewById(R.id.checkBoxM_minus_antioch_school);
        c4 =  (CheckBox) findViewById(R.id.checkBoxD_minus_antioch_school);


        cohort_leader = (EditText) findViewById(R.id.editText47);
        associate_faculty = (EditText) findViewById(R.id.editText48);
        cohort_location = (EditText) findViewById(R.id.editText49);
        current_cohort_id = (EditText) findViewById(R.id.editText50);
        certified_leader = (EditText) findViewById(R.id.editText51);
        volunteer_id = (EditText) findViewById(R.id.editText52);
        fullname = (EditText) findViewById(R.id.editText53);
        date_of_birth = (EditText) findViewById(R.id.editText54);
        age = (EditText) findViewById(R.id.editText55);
        email_id = (EditText) findViewById(R.id.editText56);
        home_phone = (EditText) findViewById(R.id.editText57);
        mobile_phone = (EditText) findViewById(R.id.editText58);
        present_address = (EditText) findViewById(R.id.editText59);
        pin = (EditText) findViewById(R.id.editText60);
        permanent_address = (EditText) findViewById(R.id.editText61);
        personal_identification = (EditText) findViewById(R.id.editText62);
        eportfolio_username = (EditText) findViewById(R.id.editText20);
        eportfolio_password = (EditText) findViewById(R.id.editText21);
    }

    public void populatespinner() {
        List_title.add("Mr.");
        List_title.add("Mrs.");


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, List_title);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spn_title.setAdapter(adapter);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this, R.array.Cohort_name, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spn_cohort.setAdapter(adapter2);
        ArrayAdapter<CharSequence> adapter3 = ArrayAdapter.createFromResource(this, R.array.mission, android.R.layout.simple_spinner_item);
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spn_mission.setAdapter(adapter3);
        ArrayAdapter<CharSequence> adapter4 = ArrayAdapter.createFromResource(this, R.array.church, android.R.layout.simple_spinner_item);
        adapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spn_church.setAdapter(adapter4);
        ArrayAdapter<CharSequence> adapter5 = ArrayAdapter.createFromResource(this, R.array.designation, android.R.layout.simple_spinner_item);
        adapter5.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spn_designation.setAdapter(adapter5);
    }

    public void insert(View view) {
        String a = cohort_leader.getText().toString();
        String b = associate_faculty.getText().toString();
        String c = cohort_location.getText().toString();
        String d = current_cohort_id.getText().toString();
        String e = certified_leader.getText().toString();
        String f = volunteer_id.getText().toString();
        String g = fullname.getText().toString();
        String h = date_of_birth.getText().toString();
        String i = age.getText().toString();
        String j = email_id.getText().toString();
        String k = home_phone.getText().toString();
        String l = mobile_phone.getText().toString();
        String m = present_address.getText().toString();
        String n = pin.getText().toString();
        String o = permanent_address.getText().toString();
        String p = personal_identification.getText().toString();
        String q = null;
        String r = null;
        String s = eportfolio_username.getText().toString();
        String t = eportfolio_password.getText().toString();

        //checkbox
        if((c1.isChecked()==false))
        {
            q = null;
        }
        else
        {
            q = "B Minus BIUS";
        }

        if((c2.isChecked()==false) && (c3.isChecked()==false) && (c4.isChecked()==false))
        {
            r = null;
        }
        else
        {
            if(c2.isChecked())
            {
                r="B Minus Antioch School";
            }
            if(c3.isChecked())
            {
                r=r.concat(" M Minus Antioch School");
            }
            if(c4.isChecked())
            {
                r=r.concat(" D Minus Antioch School");
            }
        }

        insertToDatabase(a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r,s,t);
    }

    private void insertToDatabase(String a, String b, String c, String d, String e, String f, String g, String h, String i, String j, String k, String l, String m, String n, String o, String p, String q, String r, String s, String t) {
        class SendPostReqAsyncTask extends AsyncTask<String, Void, String> {
            @Override
            protected String doInBackground(String... params) {
                String param_a = params[0];
                String param_b = params[1];
                String param_c = params[2];
                String param_d = params[3];
                String param_e = params[4];
                String param_f = params[5];
                String param_g = params[6];
                String param_h = params[7];
                String param_i = params[8];
                String param_j = params[9];
                String param_k = params[10];
                String param_l = params[11];
                String param_m = params[12];
                String param_n = params[13];
                String param_o = params[14];
                String param_p = params[15];
                String param_q = params[16];
                String param_r = params[17];
                String param_s = params[18];
                String param_t = params[19];


                String a = cohort_leader.getText().toString();
                String b = associate_faculty.getText().toString();
                String c = cohort_location.getText().toString();
                String d = current_cohort_id.getText().toString();
                String e = certified_leader.getText().toString();
                String f = volunteer_id.getText().toString();
                String g = fullname.getText().toString();
                String h = date_of_birth.getText().toString();
                String i = age.getText().toString();
                String j = email_id.getText().toString();
                String k = home_phone.getText().toString();
                String l = mobile_phone.getText().toString();
                String m = present_address.getText().toString();
                String n = pin.getText().toString();
                String o = permanent_address.getText().toString();
                String p = personal_identification.getText().toString();
                String q = null;
                String r = null;
                String s = eportfolio_username.getText().toString();
                String t = eportfolio_password.getText().toString();

                List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
                nameValuePairs.add(new BasicNameValuePair("a", a));
                nameValuePairs.add(new BasicNameValuePair("b", b));
                nameValuePairs.add(new BasicNameValuePair("c", c));
                nameValuePairs.add(new BasicNameValuePair("d", d));
                nameValuePairs.add(new BasicNameValuePair("e", e));
                nameValuePairs.add(new BasicNameValuePair("f", f));
                nameValuePairs.add(new BasicNameValuePair("g", g));
                nameValuePairs.add(new BasicNameValuePair("h", h));
                nameValuePairs.add(new BasicNameValuePair("i", i));
                nameValuePairs.add(new BasicNameValuePair("j", j));
                nameValuePairs.add(new BasicNameValuePair("k", k));
                nameValuePairs.add(new BasicNameValuePair("l", l));
                nameValuePairs.add(new BasicNameValuePair("m", m));
                nameValuePairs.add(new BasicNameValuePair("n", n));
                nameValuePairs.add(new BasicNameValuePair("o", o));
                nameValuePairs.add(new BasicNameValuePair("p", p));
                nameValuePairs.add(new BasicNameValuePair("q", q));
                nameValuePairs.add(new BasicNameValuePair("r", r));
                nameValuePairs.add(new BasicNameValuePair("s", s));
                nameValuePairs.add(new BasicNameValuePair("t", t));

                try {
                    HttpClient httpClient = new DefaultHttpClient();
                    HttpPost httpPost = new HttpPost(
                            "http://thecapitalcitychurch.16mb.com/new/InsertDetails.php");
                    httpPost.setEntity(new UrlEncodedFormEntity(nameValuePairs));

                    HttpResponse response = httpClient.execute(httpPost);

                    HttpEntity entity = response.getEntity();


                } catch (ClientProtocolException excep) {

                } catch (IOException excep) {

                }
                return "success";

            }

            @Override
            protected void onPostExecute(String result) {
                super.onPostExecute(result);

                Toast.makeText(getApplicationContext(), result, Toast.LENGTH_LONG).show();

            }
        }
        SendPostReqAsyncTask sendPostReqAsyncTask = new SendPostReqAsyncTask();
        sendPostReqAsyncTask.execute(a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }



    public void back(View view){
        onBackPressed();
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}