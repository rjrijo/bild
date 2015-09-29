package com.rijofaith.app;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.rijofaith.EnterTraineeDetails.EnterAdditionalInformation;
import com.rijofaith.EnterTraineeDetails.EnterAssessmentInfo1;
import com.rijofaith.EnterTraineeDetails.EnterAssessmentInfo2;
import com.rijofaith.EnterTraineeDetails.EnterFamilyDetails;
import com.rijofaith.EnterTraineeDetails.EnterGeneralDetails;
import com.rijofaith.EnterTraineeDetails.EnterOfficialDetails;
import com.rijofaith.EnterTraineeDetails.EnterTestimony;
import com.rijofaith.EnterTraineeDetails.EnterTrainingDetails;


public class EnterTraineesDetails extends FragmentActivity implements View.OnClickListener {

    final String TAG = "EnterTraineesDetails";

    int mCurrentFragmentIndex;
    public final static int FRAGMENT_ONE = 0;
    public final static int FRAGMENT_TWO = 1;
    public final static int FRAGMENT_THREE = 2;
    public final static int FRAGMENT_FOUR = 3;
    public final static int FRAGMENT_FIVE = 4;
    public final static int FRAGMENT_SIX = 5;
    public final static int FRAGMENT_SEVEN = 7;
    public final static int FRAGMENT_EIGHT = 8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_trainees_details);

        Button btnGeneral_details = (Button) findViewById(R.id.btnGeneral_details);
        btnGeneral_details.setOnClickListener(this);
        Button btnTraining_details = (Button) findViewById(R.id.btnTraining_details);
        btnTraining_details.setOnClickListener(this);
        Button btnAssessment_info_1 = (Button) findViewById(R.id.btnAssessment_info_1);
        btnAssessment_info_1.setOnClickListener(this);
        Button btnAssessment_info_2 = (Button) findViewById(R.id.btnAssessment_info_2);
        btnAssessment_info_2.setOnClickListener(this);
        Button btnOfficial_details = (Button) findViewById(R.id.btnOfficial_details);
        btnOfficial_details.setOnClickListener(this);
        Button btnAdditional_information = (Button) findViewById(R.id.btnAdditional_information);
        btnAdditional_information.setOnClickListener(this);
        Button btnTestimony = (Button) findViewById(R.id.btnTestimony);
        btnTestimony.setOnClickListener(this);
        Button btnFamily_details = (Button) findViewById(R.id.btnFamily_details);
        btnFamily_details.setOnClickListener(this);

        mCurrentFragmentIndex = FRAGMENT_ONE;

        fragmentReplace(mCurrentFragmentIndex);
    }

    public void fragmentReplace(int reqNewFragmentIndex) {

        Fragment newFragment = null;

        Log.d(TAG, "fragmentReplace " + reqNewFragmentIndex);

        newFragment = getFragment(reqNewFragmentIndex);

        // replace fragment
        final FragmentTransaction transaction = getSupportFragmentManager()
                .beginTransaction();

        transaction.replace(R.id.ll_fragment, newFragment);

        // Commit the transaction
        transaction.commit();

    }

    private Fragment getFragment(int idx) {
        Fragment newFragment = null;

        switch (idx) {
            case FRAGMENT_ONE:
                newFragment = new EnterGeneralDetails();
                break;
            case FRAGMENT_TWO:
                newFragment = new EnterTrainingDetails();
                break;
            case FRAGMENT_THREE:
                newFragment = new EnterAssessmentInfo1();
                break;
            case FRAGMENT_FOUR:
                newFragment = new EnterAssessmentInfo2();
                break;
            case FRAGMENT_FIVE:
                newFragment = new EnterOfficialDetails();
                break;
            case FRAGMENT_SIX:
                newFragment = new EnterAdditionalInformation();
                break;
            case FRAGMENT_SEVEN:
                newFragment = new EnterTestimony();
                break;
            case FRAGMENT_EIGHT:
                newFragment = new EnterFamilyDetails();
                break;
            default:
                Log.d(TAG, "Unhandle case");
                break;
        }

        return newFragment;
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.btnGeneral_details:
                mCurrentFragmentIndex = FRAGMENT_ONE;
                fragmentReplace(mCurrentFragmentIndex);
                break;
            case R.id.btnTraining_details:
                mCurrentFragmentIndex = FRAGMENT_TWO;
                fragmentReplace(mCurrentFragmentIndex);
                break;
            case R.id.btnAssessment_info_1:
                mCurrentFragmentIndex = FRAGMENT_THREE;
                fragmentReplace(mCurrentFragmentIndex);
                break;
            case R.id.btnAssessment_info_2:
                mCurrentFragmentIndex = FRAGMENT_FOUR;
                fragmentReplace(mCurrentFragmentIndex);
                break;
            case R.id.btnOfficial_details:
                mCurrentFragmentIndex = FRAGMENT_FIVE;
                fragmentReplace(mCurrentFragmentIndex);
                break;
            case R.id.btnAdditional_information:
                mCurrentFragmentIndex = FRAGMENT_SIX;
                fragmentReplace(mCurrentFragmentIndex);
                break;
            case R.id.btnTestimony:
                mCurrentFragmentIndex = FRAGMENT_SEVEN;
                fragmentReplace(mCurrentFragmentIndex);
                break;
            case R.id.btnFamily_details:
                mCurrentFragmentIndex = FRAGMENT_EIGHT;
                fragmentReplace(mCurrentFragmentIndex);
                break;

        }

    }

}
