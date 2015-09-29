package com.rijofaith.app;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TableRow.LayoutParams;
import android.widget.TextView;

import com.rijofaith.Cohort.GetCohorts;
import com.rijofaith.Cohort.Users;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Iterator;

public class Cohorts extends Activity {

    String data = "";
    TableLayout tl;
    TableRow tr;
    TextView label;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cohorts);

        tl = (TableLayout) findViewById(R.id.maintable);

        final GetCohorts getdb = new GetCohorts();
        new Thread(new Runnable() {
            public void run() {
                data = getdb.getDataFromDB();
                System.out.println(data);

                runOnUiThread(new Runnable() {

                    @Override
                    public void run() {
                        ArrayList<Users> users = parseJSON(data);
                        addData(users);
                    }
                });

            }
        }).start();
    }

    public ArrayList<Users> parseJSON(String result) {
        ArrayList<Users> users = new ArrayList<Users>();
        try {
            JSONArray jArray = new JSONArray(result);
            for (int i = 0; i < jArray.length(); i++) {
                JSONObject json_data = jArray.getJSONObject(i);
                Users user = new Users();
                user.setId(json_data.getInt("ID"));
                user.setC_id(json_data.getString("Cohort_ID"));
                user.setName(json_data.getString("Cohort_Name"));
                user.setLeader(json_data.getString("Cohort_Leader"));
                user.setCert_leader(json_data.getString("Certified_Leader"));
                user.setFaculty(json_data.getString("Associate_Faculty"));
                user.setLocation(json_data.getString("Cohort_Location"));
                users.add(user);
            }
        } catch (JSONException e) {
            Log.e("log_tag", "Error parsing data " + e.toString());
        }
        return users;
    }

    void addHeader(){
        /** Create a TableRow dynamically **/
        tr = new TableRow(this);

        /** Creating a TextView to add to the row **/
        label = new TextView(this);
        label.setText("Cohort ID");
        label.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT,
                LayoutParams.WRAP_CONTENT));
        label.setPadding(5, 5, 5, 5);
        label.setBackgroundColor(Color.RED);
        label.setTextColor(Color.WHITE);
        LinearLayout Ll = new LinearLayout(this);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LayoutParams.FILL_PARENT,
                LayoutParams.WRAP_CONTENT);
        params.setMargins(5, 5, 5, 5);
        //Ll.setPadding(10, 5, 5, 5);
        Ll.addView(label,params);
        tr.addView((View)Ll); // Adding textView to tablerow.

        /** Creating Qty Button **/
        TextView name = new TextView(this);
        name.setText("Cohort Name");
        name.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT,
                LayoutParams.WRAP_CONTENT));
        name.setPadding(5, 5, 5, 5);
        name.setBackgroundColor(Color.RED);
        name.setTextColor(Color.WHITE);
        Ll = new LinearLayout(this);
        params = new LinearLayout.LayoutParams(LayoutParams.FILL_PARENT,
                LayoutParams.WRAP_CONTENT);
        params.setMargins(0, 5, 5, 5);
        //Ll.setPadding(10, 5, 5, 5);
        Ll.addView(name,params);
        tr.addView((View)Ll); // Adding textview to tablerow.

        /** Creating Qty Button **/
        TextView leader = new TextView(this);
        leader.setText("Cohort Leader");
        leader.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT,
                LayoutParams.WRAP_CONTENT));
        leader.setPadding(5, 5, 5, 5);
        leader.setBackgroundColor(Color.RED);
        leader.setTextColor(Color.WHITE);
        Ll = new LinearLayout(this);
        params = new LinearLayout.LayoutParams(LayoutParams.FILL_PARENT,
                LayoutParams.WRAP_CONTENT);
        params.setMargins(0, 5, 5, 5);
        //Ll.setPadding(10, 5, 5, 5);
        Ll.addView(leader,params);
        tr.addView((View)Ll); // Adding textview to tablerow.

        /** Creating Qty Button **/
        TextView cert_leader = new TextView(this);
        cert_leader.setText("Certified Leader");
        cert_leader.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT,
                LayoutParams.WRAP_CONTENT));
        cert_leader.setPadding(5, 5, 5, 5);
        cert_leader.setBackgroundColor(Color.RED);
        cert_leader.setTextColor(Color.WHITE);
        Ll = new LinearLayout(this);
        params = new LinearLayout.LayoutParams(LayoutParams.FILL_PARENT,
                LayoutParams.WRAP_CONTENT);
        params.setMargins(0, 5, 5, 5);
        //Ll.setPadding(10, 5, 5, 5);
        Ll.addView(cert_leader,params);
        tr.addView((View)Ll); // Adding textview to tablerow.

        /** Creating Qty Button **/
        TextView faculty = new TextView(this);
        faculty.setText("Associate Faculty");
        faculty.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT,
                LayoutParams.WRAP_CONTENT));
        faculty.setPadding(5, 5, 5, 5);
        faculty.setBackgroundColor(Color.RED);
        faculty.setTextColor(Color.WHITE);
        Ll = new LinearLayout(this);
        params = new LinearLayout.LayoutParams(LayoutParams.FILL_PARENT,
                LayoutParams.WRAP_CONTENT);
        params.setMargins(0, 5, 5, 5);
        //Ll.setPadding(10, 5, 5, 5);
        Ll.addView(faculty,params);
        tr.addView((View)Ll); // Adding textview to tablerow.

        /** Creating Qty Button **/
        TextView location = new TextView(this);
        location.setText("Cohort Location");
        location.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT,
                LayoutParams.WRAP_CONTENT));
        location.setPadding(5, 5, 5, 5);
        location.setBackgroundColor(Color.RED);
        location.setTextColor(Color.WHITE);
        Ll = new LinearLayout(this);
        params = new LinearLayout.LayoutParams(LayoutParams.FILL_PARENT,
                LayoutParams.WRAP_CONTENT);
        params.setMargins(0, 5, 5, 5);
        //Ll.setPadding(10, 5, 5, 5);
        Ll.addView(location,params);
        tr.addView((View)Ll); // Adding textview to tablerow.

        // Add the TableRow to the TableLayout
        tl.addView(tr, new TableLayout.LayoutParams(
                LayoutParams.FILL_PARENT,
                LayoutParams.WRAP_CONTENT));
    }

    @SuppressWarnings({ "rawtypes" })
    public void addData(ArrayList<Users> users) {

        addHeader();

        for (Iterator i = users.iterator(); i.hasNext();) {

            Users p = (Users) i.next();

            /** Create a TableRow dynamically **/
            tr = new TableRow(this);

            /** Creating a TextView to add to the row **/
            label = new TextView(this);
            label.setText(p.getC_id());
            label.setId(p.getId());
            label.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT,
                    LayoutParams.WRAP_CONTENT));
            label.setPadding(5, 5, 5, 5);
            label.setBackgroundColor(Color.GRAY);
            LinearLayout Ll = new LinearLayout(this);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LayoutParams.FILL_PARENT,
                    LayoutParams.WRAP_CONTENT);
            params.setMargins(5, 2, 2, 2);
            //Ll.setPadding(10, 5, 5, 5);
            Ll.addView(label,params);
            tr.addView((View)Ll); // Adding textView to tablerow.

            /** Creating Qty Button **/
            TextView name = new TextView(this);
            name.setText(p.getName());
            name.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT,
                    LayoutParams.WRAP_CONTENT));
            name.setPadding(5, 5, 5, 5);
            name.setBackgroundColor(Color.GRAY);
            Ll = new LinearLayout(this);
            params = new LinearLayout.LayoutParams(LayoutParams.FILL_PARENT,
                    LayoutParams.WRAP_CONTENT);
            params.setMargins(0, 2, 2, 2);
            //Ll.setPadding(10, 5, 5, 5);
            Ll.addView(name,params);
            tr.addView((View)Ll); // Adding textview to tablerow.

            /** Creating Qty Button **/
            TextView leader = new TextView(this);
            leader.setText(p.getLeader());
            leader.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT,
                    LayoutParams.WRAP_CONTENT));
            leader.setPadding(5, 5, 5, 5);
            leader.setBackgroundColor(Color.GRAY);
            Ll = new LinearLayout(this);
            params = new LinearLayout.LayoutParams(LayoutParams.FILL_PARENT,
                    LayoutParams.WRAP_CONTENT);
            params.setMargins(0, 2, 2, 2);
            //Ll.setPadding(10, 5, 5, 5);
            Ll.addView(leader,params);
            tr.addView((View)Ll); // Adding textview to tablerow.

            /** Creating Qty Button **/
            TextView cert_leader = new TextView(this);
            cert_leader.setText(p.getCert_leader());
            cert_leader.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT,
                    LayoutParams.WRAP_CONTENT));
            cert_leader.setPadding(5, 5, 5, 5);
            cert_leader.setBackgroundColor(Color.GRAY);
            Ll = new LinearLayout(this);
            params = new LinearLayout.LayoutParams(LayoutParams.FILL_PARENT,
                    LayoutParams.WRAP_CONTENT);
            params.setMargins(0, 2, 2, 2);
            //Ll.setPadding(10, 5, 5, 5);
            Ll.addView(cert_leader,params);
            tr.addView((View)Ll); // Adding textview to tablerow.

            /** Creating Qty Button **/
            TextView faculty = new TextView(this);
            faculty.setText(p.getFaculty());
            faculty.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT,
                    LayoutParams.WRAP_CONTENT));
            faculty.setPadding(5, 5, 5, 5);
            faculty.setBackgroundColor(Color.GRAY);
            Ll = new LinearLayout(this);
            params = new LinearLayout.LayoutParams(LayoutParams.FILL_PARENT,
                    LayoutParams.WRAP_CONTENT);
            params.setMargins(0, 2, 2, 2);
            //Ll.setPadding(10, 5, 5, 5);
            Ll.addView(faculty,params);
            tr.addView((View)Ll); // Adding textview to tablerow.

            /** Creating Qty Button **/
            TextView location = new TextView(this);
            location.setText(p.getLocation());
            location.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT,
                    LayoutParams.WRAP_CONTENT));
            location.setPadding(5, 5, 5, 5);
            location.setBackgroundColor(Color.GRAY);
            Ll = new LinearLayout(this);
            params = new LinearLayout.LayoutParams(LayoutParams.FILL_PARENT,
                    LayoutParams.WRAP_CONTENT);
            params.setMargins(0, 2, 2, 2);
            //Ll.setPadding(10, 5, 5, 5);
            Ll.addView(location,params);
            tr.addView((View)Ll); // Adding textview to tablerow.

            // Add the TableRow to the TableLayout
            tl.addView(tr, new TableLayout.LayoutParams(
                    LayoutParams.FILL_PARENT,
                    LayoutParams.WRAP_CONTENT));
        }
    }
    public void back(View view){
        onBackPressed();
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}