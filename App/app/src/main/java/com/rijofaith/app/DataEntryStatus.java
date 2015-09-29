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

import com.rijofaith.DataEntryStatus.GetDataEntryStatus;
import com.rijofaith.DataEntryStatus.Users3;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Iterator;

public class DataEntryStatus extends Activity {

    String data = "";
    TableLayout tl;
    TableRow tr;
    TextView label;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_entry_status);

        tl = (TableLayout) findViewById(R.id.maintable2);

        final GetDataEntryStatus getdb = new GetDataEntryStatus();
        new Thread(new Runnable() {
            public void run() {
                data = getdb.getDataFromDBDataEntryStatus();
                System.out.println(data);

                runOnUiThread(new Runnable() {

                    @Override
                    public void run() {
                        ArrayList<Users3> users3 = parseJSON(data);
                        addData(users3);
                    }
                });

            }
        }).start();
    }

    public ArrayList<Users3> parseJSON(String result) {
        ArrayList<Users3> users3 = new ArrayList<Users3>();
        try {
            JSONArray jArray = new JSONArray(result);
            for (int i = 0; i < jArray.length(); i++) {
                JSONObject json_data = jArray.getJSONObject(i);
                Users3 user3 = new Users3();
                user3.setId(json_data.getInt("Id"));
                user3.setEnteredBy(json_data.getString("EnteredBy"));
                user3.setCount(json_data.getString("count"));
                users3.add(user3);
            }
        } catch (JSONException e) {
            Log.e("log_tag", "Error parsing data " + e.toString());
        }
        return users3;
    }

    void addHeader(){
        /** Create a TableRow dynamically **/
        tr = new TableRow(this);

        /** Creating a TextView to add to the row **/
        label = new TextView(this);
        label.setText("Entered By");
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
        TextView count = new TextView(this);
        count.setText("Profiles");
        count.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT,
                LayoutParams.WRAP_CONTENT));
        count.setPadding(5, 5, 5, 5);
        count.setBackgroundColor(Color.RED);
        count.setTextColor(Color.WHITE);
        Ll = new LinearLayout(this);
        params = new LinearLayout.LayoutParams(LayoutParams.FILL_PARENT,
                LayoutParams.WRAP_CONTENT);
        params.setMargins(0, 5, 5, 5);
        //Ll.setPadding(10, 5, 5, 5);
        Ll.addView(count,params);
        tr.addView((View)Ll); // Adding textview to tablerow.


        // Add the TableRow to the TableLayout
        tl.addView(tr, new TableLayout.LayoutParams(
                LayoutParams.FILL_PARENT,
                LayoutParams.WRAP_CONTENT));
    }

    @SuppressWarnings({ "rawtypes" })
    public void addData(ArrayList<Users3> users3) {

        addHeader();

        for (Iterator i = users3.iterator(); i.hasNext();) {

            Users3 p = (Users3) i.next();

            /** Create a TableRow dynamically **/
            tr = new TableRow(this);

            /** Creating a TextView to add to the row **/
            label = new TextView(this);
            label.setText(p.getEnteredBy());
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
            TextView count = new TextView(this);
            count.setText(p.getCount());
            count.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT,
                    LayoutParams.WRAP_CONTENT));
            count.setPadding(5, 5, 5, 5);
            count.setBackgroundColor(Color.GRAY);
            Ll = new LinearLayout(this);
            params = new LinearLayout.LayoutParams(LayoutParams.FILL_PARENT,
                    LayoutParams.WRAP_CONTENT);
            params.setMargins(0, 2, 2, 2);
            //Ll.setPadding(10, 5, 5, 5);
            Ll.addView(count,params);
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