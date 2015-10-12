package com.rijofaith.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

public class EnterTraineesDetails extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_trainees_details);
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

    public void enter_general_details(View view)
    {
        startActivity(new Intent(this, EnterGeneralDetails.class));
    }

    public void enter_training_details(View view)
    {
        startActivity(new Intent(this, EnterTrainingDetails.class));
    }

    public void enter_assessment_info_1(View view)
    {
        startActivity(new Intent(this, EnterAssessmentInfo1.class));
    }

    public void enter_assessment_info_2(View view)
    {
        startActivity(new Intent(this, EnterAssessmentInfo2.class));
    }

    public void enter_official_details(View view)
    {
        startActivity(new Intent(this, EnterOfficialDetails.class));
    }

    public void enter_additional_info(View view)
    {
        startActivity(new Intent(this, EnterAdditionalInformation.class));
    }

    public void enter_testimony(View view)
    {
        startActivity(new Intent(this, EnterTestimony.class));
    }

    public void enter_family_details(View view)
    {
        startActivity(new Intent(this, EnterFamilyDetails.class));
    }

    public void back(View view){
        onBackPressed();
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
