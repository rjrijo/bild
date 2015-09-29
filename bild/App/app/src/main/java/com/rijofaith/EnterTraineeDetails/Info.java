package com.rijofaith.EnterTraineeDetails;

/**
 * Created by Rijo.Raju on 22-Sep-15.
 */
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rijofaith.app.R;

public class Info extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //Inflate the layout for this fragment
        return inflater.inflate(
                R.layout.activity_info, container, false);
    }
}
