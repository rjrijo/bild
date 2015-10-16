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

import com.rijofaith.TraineesList.GetTraineesList;
import com.rijofaith.TraineesList.Users2;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Iterator;

public class TraineesList extends Activity {

    String data = "";
    TableLayout tl;
    TableRow tr;
    TextView label;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trainees_list);

        tl = (TableLayout) findViewById(R.id.maintable1);

        final GetTraineesList getdb = new GetTraineesList();
        new Thread(new Runnable() {
            public void run() {
                data = getdb.getDataFromDBTraineesList();
                System.out.println(data);

                runOnUiThread(new Runnable() {

                    @Override
                    public void run() {
                        ArrayList<Users2> users2 = parseJSON(data);
                        addData(users2);
                    }
                });

            }
        }).start();
    }

    public ArrayList<Users2> parseJSON(String result) {
        ArrayList<Users2> users2 = new ArrayList<Users2>();
        try {
            JSONArray jArray = new JSONArray(result);
            for (int i = 0; i < jArray.length(); i++) {
                JSONObject json_data = jArray.getJSONObject(i);
                Users2 user2 = new Users2();
                user2.setId(json_data.getInt("Id"));
                user2.setTrainee_id(json_data.getString("Trainee_ID"));
                user2.setName(json_data.getString("Full_Name"));
                user2.setAge(json_data.getString("Age"));
                user2.setSex(json_data.getString("Gender"));
                user2.setCurr_c_id(json_data.getString("Current_Cohort_ID"));
                user2.setC_name(json_data.getString("Current_Cohort_Name"));
                user2.setState(json_data.getString("State"));
                user2.setDistrict(json_data.getString("District"));
                users2.add(user2);
            }
        } catch (JSONException e) {
            Log.e("log_tag", "Error parsing data " + e.toString());
        }
        return users2;
    }

    void addHeader(){
        /** Create a TableRow dynamically **/
        tr = new TableRow(this);

        /** Creating a TextView to add to the row **/
        label = new TextView(this);
        label.setText("ID");
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
        name.setText("Name");
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
        TextView age = new TextView(this);
        age.setText("Age");
        age.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT,
                LayoutParams.WRAP_CONTENT));
        age.setPadding(5, 5, 5, 5);
        age.setBackgroundColor(Color.RED);
        age.setTextColor(Color.WHITE);
        Ll = new LinearLayout(this);
        params = new LinearLayout.LayoutParams(LayoutParams.FILL_PARENT,
                LayoutParams.WRAP_CONTENT);
        params.setMargins(0, 5, 5, 5);
        //Ll.setPadding(10, 5, 5, 5);
        Ll.addView(age,params);
        tr.addView((View)Ll); // Adding textview to tablerow.

        /** Creating Qty Button **/
        TextView sex = new TextView(this);
        sex.setText("Sex");
        sex.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT,
                LayoutParams.WRAP_CONTENT));
        sex.setPadding(5, 5, 5, 5);
        sex.setBackgroundColor(Color.RED);
        sex.setTextColor(Color.WHITE);
        Ll = new LinearLayout(this);
        params = new LinearLayout.LayoutParams(LayoutParams.FILL_PARENT,
                LayoutParams.WRAP_CONTENT);
        params.setMargins(0, 5, 5, 5);
        //Ll.setPadding(10, 5, 5, 5);
        Ll.addView(sex,params);
        tr.addView((View)Ll); // Adding textview to tablerow.

        /** Creating Qty Button **/
        TextView curr_c_id = new TextView(this);
        curr_c_id.setText("Current Cohort ID");
        curr_c_id.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT,
                LayoutParams.WRAP_CONTENT));
        curr_c_id.setPadding(5, 5, 5, 5);
        curr_c_id.setBackgroundColor(Color.RED);
        curr_c_id.setTextColor(Color.WHITE);
        Ll = new LinearLayout(this);
        params = new LinearLayout.LayoutParams(LayoutParams.FILL_PARENT,
                LayoutParams.WRAP_CONTENT);
        params.setMargins(0, 5, 5, 5);
        //Ll.setPadding(10, 5, 5, 5);
        Ll.addView(curr_c_id,params);
        tr.addView((View)Ll); // Adding textview to tablerow.

        /** Creating Qty Button **/
        TextView curr_c_name = new TextView(this);
        curr_c_name.setText("Current Cohort Name");
        curr_c_name.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT,
                LayoutParams.WRAP_CONTENT));
        curr_c_name.setPadding(5, 5, 5, 5);
        curr_c_name.setBackgroundColor(Color.RED);
        curr_c_name.setTextColor(Color.WHITE);
        Ll = new LinearLayout(this);
        params = new LinearLayout.LayoutParams(LayoutParams.FILL_PARENT,
                LayoutParams.WRAP_CONTENT);
        params.setMargins(0, 5, 5, 5);
        //Ll.setPadding(10, 5, 5, 5);
        Ll.addView(curr_c_name,params);
        tr.addView((View)Ll); // Adding textview to tablerow.

        /** Creating Qty Button **/
        TextView state = new TextView(this);
        state.setText("State");
        state.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT,
                LayoutParams.WRAP_CONTENT));
        state.setPadding(5, 5, 5, 5);
        state.setBackgroundColor(Color.RED);
        state.setTextColor(Color.WHITE);
        Ll = new LinearLayout(this);
        params = new LinearLayout.LayoutParams(LayoutParams.FILL_PARENT,
                LayoutParams.WRAP_CONTENT);
        params.setMargins(0, 5, 5, 5);
        //Ll.setPadding(10, 5, 5, 5);
        Ll.addView(state,params);
        tr.addView((View)Ll); // Adding textview to tablerow.

        /** Creating Qty Button **/
        TextView district = new TextView(this);
        district.setText("District");
        district.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT,
                LayoutParams.WRAP_CONTENT));
        district.setPadding(5, 5, 5, 5);
        district.setBackgroundColor(Color.RED);
        district.setTextColor(Color.WHITE);
        Ll = new LinearLayout(this);
        params = new LinearLayout.LayoutParams(LayoutParams.FILL_PARENT,
                LayoutParams.WRAP_CONTENT);
        params.setMargins(0, 5, 5, 5);
        //Ll.setPadding(10, 5, 5, 5);
        Ll.addView(district,params);
        tr.addView((View)Ll); // Adding textview to tablerow.


        // Add the TableRow to the TableLayout
        tl.addView(tr, new TableLayout.LayoutParams(
                LayoutParams.FILL_PARENT,
                LayoutParams.WRAP_CONTENT));
    }

    @SuppressWarnings({ "rawtypes" })
    public void addData(ArrayList<Users2> users2) {

        addHeader();

        for (Iterator i = users2.iterator(); i.hasNext();) {

            Users2 p = (Users2) i.next();

            /** Create a TableRow dynamically **/
            tr = new TableRow(this);

            /** Creating a TextView to add to the row **/
            label = new TextView(this);
            label.setText(p.getTrainee_id());
            label.setId(p.getId());
            label.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT,
                    LayoutParams.WRAP_CONTENT));
            label.setPadding(5, 5, 5, 5);
            label.setBackgroundColor(Color.WHITE);
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
            name.setBackgroundColor(Color.WHITE);
            Ll = new LinearLayout(this);
            params = new LinearLayout.LayoutParams(LayoutParams.FILL_PARENT,
                    LayoutParams.WRAP_CONTENT);
            params.setMargins(0, 2, 2, 2);
            //Ll.setPadding(10, 5, 5, 5);
            Ll.addView(name,params);
            tr.addView((View)Ll); // Adding textview to tablerow.


            /** Creating Qty Button **/
            TextView age = new TextView(this);
            age.setText(p.getAge());
            age.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT,
                    LayoutParams.WRAP_CONTENT));
            age.setPadding(5, 5, 5, 5);
            age.setBackgroundColor(Color.WHITE);
            Ll = new LinearLayout(this);
            params = new LinearLayout.LayoutParams(LayoutParams.FILL_PARENT,
                    LayoutParams.WRAP_CONTENT);
            params.setMargins(0, 2, 2, 2);
            //Ll.setPadding(10, 5, 5, 5);
            Ll.addView(age,params);
            tr.addView((View)Ll); // Adding textview to tablerow.

            /** Creating Qty Button **/
            TextView sex = new TextView(this);
            sex.setText(p.getSex());
            sex.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT,
                    LayoutParams.WRAP_CONTENT));
            sex.setPadding(5, 5, 5, 5);
            sex.setBackgroundColor(Color.WHITE);
            Ll = new LinearLayout(this);
            params = new LinearLayout.LayoutParams(LayoutParams.FILL_PARENT,
                    LayoutParams.WRAP_CONTENT);
            params.setMargins(0, 2, 2, 2);
            //Ll.setPadding(10, 5, 5, 5);
            Ll.addView(sex,params);
            tr.addView((View)Ll); // Adding textview to tablerow.

            /** Creating Qty Button **/
            TextView curr_c_id = new TextView(this);
            curr_c_id.setText(p.getCurr_c_id());
            curr_c_id.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT,
                    LayoutParams.WRAP_CONTENT));
            curr_c_id.setPadding(5, 5, 5, 5);
            curr_c_id.setBackgroundColor(Color.WHITE);
            Ll = new LinearLayout(this);
            params = new LinearLayout.LayoutParams(LayoutParams.FILL_PARENT,
                    LayoutParams.WRAP_CONTENT);
            params.setMargins(0, 2, 2, 2);
            //Ll.setPadding(10, 5, 5, 5);
            Ll.addView(curr_c_id,params);
            tr.addView((View)Ll); // Adding textview to tablerow.

            /** Creating Qty Button **/
            TextView c_name = new TextView(this);
            c_name.setText(p.getC_name());
            c_name.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT,
                    LayoutParams.WRAP_CONTENT));
            c_name.setPadding(5, 5, 5, 5);
            c_name.setBackgroundColor(Color.WHITE);
            Ll = new LinearLayout(this);
            params = new LinearLayout.LayoutParams(LayoutParams.FILL_PARENT,
                    LayoutParams.WRAP_CONTENT);
            params.setMargins(0, 2, 2, 2);
            //Ll.setPadding(10, 5, 5, 5);
            Ll.addView(c_name,params);
            tr.addView((View)Ll); // Adding textview to tablerow.

            /** Creating Qty Button **/
            TextView state = new TextView(this);
            state.setText(p.getState());
            state.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT,
                    LayoutParams.WRAP_CONTENT));
            state.setPadding(5, 5, 5, 5);
            state.setBackgroundColor(Color.WHITE);
            Ll = new LinearLayout(this);
            params = new LinearLayout.LayoutParams(LayoutParams.FILL_PARENT,
                    LayoutParams.WRAP_CONTENT);
            params.setMargins(0, 2, 2, 2);
            //Ll.setPadding(10, 5, 5, 5);
            Ll.addView(state,params);
            tr.addView((View)Ll); // Adding textview to tablerow.

            /** Creating Qty Button **/
            TextView district = new TextView(this);
            district.setText(p.getDistrict());
            district.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT,
                    LayoutParams.WRAP_CONTENT));
            district.setPadding(5, 5, 5, 5);
            district.setBackgroundColor(Color.WHITE);
            Ll = new LinearLayout(this);
            params = new LinearLayout.LayoutParams(LayoutParams.FILL_PARENT,
                    LayoutParams.WRAP_CONTENT);
            params.setMargins(0, 2, 2, 2);
            //Ll.setPadding(10, 5, 5, 5);
            Ll.addView(district,params);
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