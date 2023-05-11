package com.example.bepresent.calendar;

import android.app.DatePickerDialog;
import android.content.Context;
import android.widget.Button;
import android.widget.DatePicker;

import androidx.appcompat.app.AppCompatDialogFragment;

import java.util.Calendar;
import java.util.Date;


/**
 * DatePickerConcrete is used to be able to pick a date, using the DatePickerDialog, and the UI to open the Dialog is a Button.
 * The class contains a single public method, called init(Context, Button) to set everything up, ready to go.
 */
public class DatePickerConcrete {
      private DatePickerDialog datePickerDialog;

    /** The method set's up the two lister, for the button to open the DatePickerDialog
     *  and for the DatePickerDialog to change the text of the button once a user picked a date.
     *  In the second part of the code all parameters are set, the DatePickerDialog is initialized
     *  and the button get's the value of the current date.
     */
    public void init(Context context, Button dateButton) {

        dateButton.setOnClickListener(viewLambda -> datePickerDialog.show());

        DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener()
        {
            @Override
            public void onDateSet(android.widget.DatePicker datePicker, int year, int month, int day)
            {
                month = month + 1;
                String date = makeDateString(day, month, year);
                dateButton.setText(date);
            }
        };

        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);
        int style = AppCompatDialogFragment.STYLE_NO_INPUT;

        datePickerDialog = new DatePickerDialog(context, style, dateSetListener, year, month, day);

        //have to add a +1 on month cause it starts at 0
        dateButton.setText(makeDateString(day, month+1, year));
        //That way a birthday can't be set into the future
        datePickerDialog.getDatePicker().setMaxDate(System.currentTimeMillis());



    }

    private String makeDateString(int day, int month, int year)
    {
        return addZero(day) + " / " + addZero(month) + " / " + year;
    }


    /**
     * https://stackoverflow.com/questions/8409043/getdate-from-datepicker-android
     */
    public Date getDate(){
        int day = datePickerDialog.getDatePicker().getDayOfMonth();
        int month = datePickerDialog.getDatePicker().getMonth();
        int year =  datePickerDialog.getDatePicker().getYear();

        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, day);

        return calendar.getTime();
    }

    //simple logic to add a zero if the day or the month is smaller then 10
    private String addZero(int monthOrDay){
        String rtrn ="";
        if(monthOrDay <= 9)
            rtrn += "0" + monthOrDay;
        else
            rtrn +=monthOrDay;
        return rtrn;
    }

}
