package com.rijofaith.EnterTraineeDetails;

        import android.os.Bundle;
        import android.support.v4.app.Fragment;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;

        import com.rijofaith.app.R;

/**
 * Created by rijo on 16-Sep-15.
 */
public class EnterAdditionalInformation extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.activity_additional_information, container, false);
        return view;
    }
}