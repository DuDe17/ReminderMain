package com.example.dude.remindermain;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;


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
        final AddLogicUnit addLogicUnit = new AddLogicUnit();
        //Inflate the layout for this fragment
        final View addFragment = inflater.inflate(R.layout.fragment_add, container, false);
        //Inflate the layout for this fragment

        //Edit Text UI validations
        EditText taskName = (EditText)addFragment.findViewById(R.id.EditTaskName);
        EditText resetTime = (EditText)addFragment.findViewById(R.id.timeEdit);
        EditText totalTime = (EditText)addFragment.findViewById(R.id.totalTimeEdit);
        taskName.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void afterTextChanged(Editable editable) {
                activateTaskButton(addFragment, addLogicUnit);
            }
        });
        resetTime.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void afterTextChanged(Editable editable) {
                activateTaskButton(addFragment, addLogicUnit);
            }
        });
        totalTime.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void afterTextChanged(Editable editable) {
                activateTaskButton(addFragment, addLogicUnit);
            }
        });
        //Edit Text UI validations

        //Time related UI Changes
        EditText editText = (EditText) addFragment.findViewById(R.id.timeEdit);
        SetTime fromTime = new SetTime(editText, getContext());
        //Time Related UI Changes

        //Spinner default selection
        final Spinner frequency = (Spinner) addFragment.findViewById(R.id.frequencySpinner);

        frequency.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                final String value = (String) frequency.getItemAtPosition(i);
                if(value.equalsIgnoreCase("Weekly"))
                    addLogicUnit.setResetFrequency(2);
                else
                    addLogicUnit.setResetFrequency(1);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                Toast.makeText(getContext(), "Cheers", Toast.LENGTH_SHORT).show();
            }
        });
        return addFragment;
    }

    private void activateTaskButton(View view, AddLogicUnit addLogicUnit){
        EditText taskName = (EditText) view.findViewById(R.id.EditTaskName);
        EditText resetTime = (EditText) view.findViewById(R.id.timeEdit);
        EditText totalTimeEdit = (EditText) view.findViewById(R.id.totalTimeEdit);
        Button addTask = (Button) view.findViewById(R.id.addButton);

        if(taskName.getText().toString().matches("") || resetTime.getText().toString().matches("") || totalTimeEdit.getText().toString().matches("")) {
            Toast.makeText(getContext(), "Fill all the details", Toast.LENGTH_SHORT).show();
            addTask.setEnabled(false);
        }
        else {
            Toast.makeText(getContext(), "Fill ", Toast.LENGTH_SHORT).show();
            addTask.setEnabled(true);
        }
    }

    public void addTask(View view) {
    }
}
