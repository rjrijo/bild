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
import android.widget.RadioButton;
import android.widget.RadioGroup;
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

    CheckBox cb1, cb2, cb3, cb4;

    RadioGroup rg1, rg2, rg3, rg4, rg5, rg6, rg7, rg8, rg9, rg10, rg11, rg12, rg13, rg14, rg15, rg16, rg17, rg18, rg19, rg20, rg21, rg22, rg23, rg24, rg25, rg26, rg27, rg28, rg29, rg30, rg31, rg32, rg33;

    RadioButton rb1, rb2, rb3, rb4, rb5, rb6, rb7, rb8, rb9, rb10, rb11, rb12, rb13, rb14, rb15, rb16, rb17, rb18, rb19, rb20, rb21, rb22, rb23, rb24, rb25, rb26, rb27, rb28, rb29, rb30, rb31, rb32, rb33;

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
    EditText date_of_enrollment;
    EditText date_of_assessment;
    EditText date_of_certification;
    EditText center_of_training;
    EditText no_of_book_finished;
    EditText no_of_students;
    EditText what_did_they_learn;
    EditText what_did_learn_from_teaching_fp;
    EditText date1;
    EditText date2;
    EditText date3;
    EditText attachments;
    EditText educational_qualification;
    EditText biblical_qualification;
    EditText last_bible_school_attended;
    EditText date_of_repentance;
    EditText date_of_water_baptism;
    EditText religious_social_background;
    EditText previous_ministry_experience;
    EditText previous_christian_organization;
    EditText other_support;
    EditText ministry_interest;
    EditText name_address_of_pastor_leader;
    EditText testimony;
    EditText date_of_marriage;
    EditText spouse_name;


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

        cb1 =  (CheckBox) findViewById(R.id.checkBoxB_minus_bius);
        cb2 =  (CheckBox) findViewById(R.id.checkBoxB_minus_antioch_school);
        cb3 =  (CheckBox) findViewById(R.id.checkBoxM_minus_antioch_school);
        cb4 =  (CheckBox) findViewById(R.id.checkBoxD_minus_antioch_school);


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
        date_of_enrollment = (EditText) findViewById(R.id.editText20);
        date_of_assessment = (EditText) findViewById(R.id.editText21);
        date_of_certification = (EditText) findViewById(R.id.editText22);
        center_of_training = (EditText) findViewById(R.id.editText23);
        no_of_book_finished = (EditText) findViewById(R.id.editText24);
        no_of_students = (EditText) findViewById(R.id.editText25);
        what_did_they_learn = (EditText) findViewById(R.id.editText26);
        what_did_learn_from_teaching_fp = (EditText) findViewById(R.id.editText27);
        date1 = (EditText) findViewById(R.id.editText28);
        date2 = (EditText) findViewById(R.id.editText32);
        date3 = (EditText) findViewById(R.id.editText33);
        attachments = (EditText) findViewById(R.id.editText34);
        educational_qualification = (EditText) findViewById(R.id.editText30);
        biblical_qualification = (EditText) findViewById(R.id.editText35);
        last_bible_school_attended = (EditText) findViewById(R.id.editText36);
        date_of_repentance = (EditText) findViewById(R.id.editText31);
        date_of_water_baptism = (EditText) findViewById(R.id.editText39);
        religious_social_background = (EditText) findViewById(R.id.editText37);
        previous_ministry_experience = (EditText) findViewById(R.id.editText38);
        previous_christian_organization = (EditText) findViewById(R.id.editText40);
        other_support = (EditText) findViewById(R.id.editText41);
        ministry_interest = (EditText) findViewById(R.id.editText42);
        name_address_of_pastor_leader = (EditText) findViewById(R.id.editText43);
        testimony = (EditText) findViewById(R.id.editText44);
        date_of_marriage = (EditText) findViewById(R.id.editText45);
        spouse_name = (EditText) findViewById(R.id.editText46);
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
        String q = eportfolio_username.getText().toString();
        String r = eportfolio_password.getText().toString();
        String s = date_of_enrollment.getText().toString();
        String t = date_of_assessment.getText().toString();
        String u = date_of_certification.getText().toString();
        String v = center_of_training.getText().toString();
        String w = no_of_book_finished.getText().toString();
        String x = no_of_students.getText().toString();
        String y = what_did_they_learn.getText().toString();
        String z = what_did_learn_from_teaching_fp.getText().toString();
        String a1 = date1.getText().toString();
        String b1 = date2.getText().toString();
        String c1 = date3.getText().toString();
        String d1 = attachments.getText().toString();
        String e1 = educational_qualification.getText().toString();
        String f1 = biblical_qualification.getText().toString();
        String g1 = last_bible_school_attended.getText().toString();
        String h1 = date_of_repentance.getText().toString();
        String i1 = date_of_water_baptism.getText().toString();
        String j1 = religious_social_background.getText().toString();
        String k1 = previous_ministry_experience.getText().toString();
        String l1 = previous_christian_organization.getText().toString();
        String m1 = other_support.getText().toString();
        String n1 = ministry_interest.getText().toString();
        String o1 = name_address_of_pastor_leader.getText().toString();
        String p1 = testimony.getText().toString();
        String q1 = date_of_marriage.getText().toString();
        String r1 = spouse_name.getText().toString();

        String s1 = null;
        String t1 = null;



        //checkbox
        if((cb1.isChecked()==false))
        {
            s1 = null;
        }
        else
        {
            s1 = "B Minus BIUS";
        }

        if((cb2.isChecked()==false) && (cb3.isChecked()==false) && (cb4.isChecked()==false))
        {
            t1 = null;
        }
        else
        {
            if(cb2.isChecked())
            {
                t1="B Minus Antioch School";
            }
            if(cb3.isChecked())
            {
                t1=t1.concat(" M Minus Antioch School");
            }
            if(cb4.isChecked())
            {
                t1=t1.concat(" D Minus Antioch School");
            }
        }

        insertToDatabase(a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u, v, w, x, y, z, a1, b1, c1, d1, e1, f1, g1, h1, i1, j1, k1, l1, m1, n1, o1, p1, q1, r1, s1, t1);
    }

    private void insertToDatabase(String a, String b, String c, String d, String e, String f, String g, String h, String i, String j, String k, String l, String m, String n, String o, String p, String q, String r, String s, String t, String u, String v, String w, String x, String y, String z, String a1, String b1, String c1, String d1, String e1, String f1, String g1, String h1, String i1, String j1, String k1, String l1, String m1, String n1, String o1, String p1, String q1, String r1, String s1, String t1) {
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
                String param_u = params[20];
                String param_v = params[21];
                String param_w = params[22];
                String param_x = params[23];
                String param_y = params[24];
                String param_z = params[25];
                String param_a1 = params[26];
                String param_b1 = params[27];
                String param_c1 = params[28];
                String param_d1 = params[29];
                String param_e1 = params[30];
                String param_f1 = params[31];
                String param_g1 = params[32];
                String param_h1 = params[33];
                String param_i1 = params[34];
                String param_j1 = params[35];
                String param_k1 = params[36];
                String param_l1 = params[37];
                String param_m1 = params[38];
                String param_n1 = params[39];
                String param_o1 = params[40];
                String param_p1 = params[41];
                String param_q1 = params[42];
                String param_r1 = params[43];
                String param_s1 = params[44];
                String param_t1 = params[45];


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
                String q = eportfolio_username.getText().toString();
                String r = eportfolio_password.getText().toString();
                String s = date_of_enrollment.getText().toString();
                String t = date_of_assessment.getText().toString();
                String u = date_of_certification.getText().toString();
                String v = center_of_training.getText().toString();
                String w = no_of_book_finished.getText().toString();
                String x = no_of_students.getText().toString();
                String y = what_did_they_learn.getText().toString();
                String z = what_did_learn_from_teaching_fp.getText().toString();
                String a1 = date1.getText().toString();
                String b1 = date2.getText().toString();
                String c1 = date3.getText().toString();
                String d1 = attachments.getText().toString();
                String e1 = educational_qualification.getText().toString();
                String f1 = biblical_qualification.getText().toString();
                String g1 = last_bible_school_attended.getText().toString();
                String h1 = date_of_repentance.getText().toString();
                String i1 = date_of_water_baptism.getText().toString();
                String j1 = religious_social_background.getText().toString();
                String k1 = previous_ministry_experience.getText().toString();
                String l1 = previous_christian_organization.getText().toString();
                String m1 = other_support.getText().toString();
                String n1 = ministry_interest.getText().toString();
                String o1 = name_address_of_pastor_leader.getText().toString();
                String p1 = testimony.getText().toString();
                String q1 = date_of_marriage.getText().toString();
                String r1 = spouse_name.getText().toString();


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
                nameValuePairs.add(new BasicNameValuePair("u", u));
                nameValuePairs.add(new BasicNameValuePair("v", v));
                nameValuePairs.add(new BasicNameValuePair("w", w));
                nameValuePairs.add(new BasicNameValuePair("x", x));
                nameValuePairs.add(new BasicNameValuePair("y", y));
                nameValuePairs.add(new BasicNameValuePair("z", z));
                nameValuePairs.add(new BasicNameValuePair("a1", a1));
                nameValuePairs.add(new BasicNameValuePair("b1", b1));
                nameValuePairs.add(new BasicNameValuePair("c1", c1));
                nameValuePairs.add(new BasicNameValuePair("d1", d1));
                nameValuePairs.add(new BasicNameValuePair("e1", e1));
                nameValuePairs.add(new BasicNameValuePair("f1", f1));
                nameValuePairs.add(new BasicNameValuePair("g1", g1));
                nameValuePairs.add(new BasicNameValuePair("h1", h1));
                nameValuePairs.add(new BasicNameValuePair("i1", i1));
                nameValuePairs.add(new BasicNameValuePair("j1", j1));
                nameValuePairs.add(new BasicNameValuePair("k1", k1));
                nameValuePairs.add(new BasicNameValuePair("l1", l1));
                nameValuePairs.add(new BasicNameValuePair("m1", m1));
                nameValuePairs.add(new BasicNameValuePair("n1", n1));
                nameValuePairs.add(new BasicNameValuePair("o1", o1));
                nameValuePairs.add(new BasicNameValuePair("p1", p1));
                nameValuePairs.add(new BasicNameValuePair("q1", q1));
                nameValuePairs.add(new BasicNameValuePair("r1", r1));


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
        sendPostReqAsyncTask.execute(a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z,a1,b1,c1,d1,e1,f1,g1,h1,i1,j1,k1,l1,m1,n1,o1,p1,q1,r1);
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