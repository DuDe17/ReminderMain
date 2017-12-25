package com.example.dude.remindermain;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Spinner;


/**
 * A simple {@link Fragment} subclass.
 */
public class AddFragment extends Fragment {


    public AddFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View addFragment = inflater.inflate(R.layout.fragment_add, container, false);
        final Spinner frequencySpinner = (Spinner) addFragment.findViewById(R.id.frequencySpinner);
        final Spinner weekDaySpinner = (Spinner) addFragment.findViewById(R.id.weeekdaySpinner);
        frequencySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                final String fSrt = (String) frequencySpinner.getItemAtPosition(i);
                if(fSrt.equalsIgnoreCase("Weekly"))
                {
                    weekDaySpinner.setVisibility(View.VISIBLE);
                }
                else
                {
                    weekDaySpinner.setVisibility(View.GONE);
                }
                return;
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                return;
            }
        });
        return addFragment;
    }

    public void addTask(View view) {
    }
}
