package com.example.bepresent.fragments;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.bepresent.calendar.CalendarDot;
import com.example.bepresent.R;
import com.example.bepresent.database.friends.Friend;
import com.example.bepresent.database.friends.FriendRepository;
import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.MaterialCalendarView;

import java.util.Calendar;
import java.util.HashSet;
import java.util.List;


public class CalendarFragment extends Fragment
{
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_calendar, container, false);


        /* Code to set a new dot on a date.
        TODO: Encapsulate this stuff and call it whenever there a re gifts to make
         */

        MaterialCalendarView calendarView = view.findViewById(R.id.calendarView);
        HashSet<CalendarDay> datesWithDots = getBirthdaysDB();
        datesWithDots = eachYear(datesWithDots);
        CalendarDot dot = new CalendarDot(Color.RED, datesWithDots, requireContext());
        calendarView.addDecorator(dot);

        /* End of code to encapsulate
         */



        //change the calendar the be the first day of the week monday
        calendarView.state().edit()
                .setFirstDayOfWeek(Calendar.MONDAY).commit();




        return view;
    }

    private HashSet<CalendarDay> eachYear(HashSet<CalendarDay> birthdays) {
        HashSet<CalendarDay> rtrn = new HashSet<CalendarDay>(birthdays);
        //We go two years into the future
        CalendarDay cal = CalendarDay.today();
        int yearToday = cal.getYear()+2;


        for(CalendarDay birthday : birthdays){
               //add a year cause the first is already inserted
               int year = birthday.getYear()+1;
               int month = birthday.getMonth();
               int day = birthday.getDay();

               for(; yearToday>=year; year++){
                   rtrn.add(cal.from(year, month, day));
               }
        }
        return  rtrn;
    }

    private HashSet<CalendarDay> getBirthdaysDB() {

        HashSet<CalendarDay> rtrn = new HashSet<>();
        CalendarDay cd = CalendarDay.today();
        List<Friend> friends = FriendRepository.getInstance().getAllFriends();
        Calendar cal = Calendar.getInstance();

        for(Friend f : friends){
            cal.setTime(f.getBirthday());
            cd = cd.from(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH));
            rtrn.add(cd);
        }
        return rtrn;
    }
}
