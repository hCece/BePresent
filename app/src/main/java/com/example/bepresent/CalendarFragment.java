package com.example.bepresent;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.MaterialCalendarView;

import java.util.Calendar;
import java.util.Collection;
import java.util.HashSet;
import com.prolificinteractive.materialcalendarview.DayViewFacade;


public class CalendarFragment extends Fragment
{
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_calendar, container, false);

        HashSet<CalendarDay> setDot = new HashSet();
        setDot.add(CalendarDay.today());

        MaterialCalendarView calendarView = view.findViewById(R.id.calendarView);
        CalendarDot cd = new CalendarDot(Color.RED, setDot, requireContext());
        calendarView.addDecorator(cd);




        calendarView.state().edit()
                .setFirstDayOfWeek(Calendar.MONDAY).commit();




        return view;
    }
}
