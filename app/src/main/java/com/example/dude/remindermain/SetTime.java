package com.example.dude.remindermain;

import android.app.TimePickerDialog;
import android.content.Context;
import android.icu.util.Calendar;
import android.view.View;
import android.widget.EditText;
import android.widget.TimePicker;

/**
 * Created by ashukla on 12/28/2017.
 */

public class SetTime implements View.OnFocusChangeListener, TimePickerDialog.OnTimeSetListener{

    private EditText editText;
    private Calendar myCalendar;
    private Context context;

    public SetTime(EditText editText, Context context) {
        this.editText = editText;
        this.editText.setOnFocusChangeListener(this);
        this.myCalendar = Calendar.getInstance();
        this.context = context;
    }

    @Override
    public void onTimeSet(TimePicker timePicker, int hourOfDay, int minutes) {
        this.editText.setText(hourOfDay + ":" + minutes);
    }

    @Override
    public void onFocusChange(View view, boolean hasFocus) {
        if(hasFocus){
            int hour = myCalendar.get(Calendar.HOUR_OF_DAY);
            int minute = myCalendar.get(Calendar.MINUTE);
            new TimePickerDialog(context, this, hour, minute, true).show();
        }
    }
}
