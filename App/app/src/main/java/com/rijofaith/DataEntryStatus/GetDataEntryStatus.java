package com.rijofaith.DataEntryStatus;

import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;

/**
 * Created by rijo on 14-Sep-15.
 */
public class GetDataEntryStatus {

    public String getDataFromDBDataEntryStatus() {
        try {

            HttpPost httppost;
            HttpClient httpclient;
            httpclient = new DefaultHttpClient();
            httppost = new HttpPost("http://thecapitalcitychurch.16mb.com/new/DataEntryStatus.php"); // change this to your URL.....
            ResponseHandler<String> responseHandler = new BasicResponseHandler();
            final String response = httpclient.execute(httppost,
                    responseHandler);

            return response.trim();

        } catch (Exception e) {
            System.out.println("ERROR : " + e.getMessage());
            return "error";
        }
    }
}
