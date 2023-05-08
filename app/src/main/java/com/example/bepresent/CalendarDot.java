package com.example.bepresent;



import android.content.Context;
import android.graphics.Color;

import androidx.core.content.ContextCompat;

import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.DayViewDecorator;
import com.prolificinteractive.materialcalendarview.DayViewFacade;
import com.prolificinteractive.materialcalendarview.spans.DotSpan;
import java.util.Collection;
import java.util.HashSet;

public class CalendarDot implements DayViewDecorator {

    private final int color;
    private final HashSet<CalendarDay> dates;
    private final Context context;

    public CalendarDot(int color, Collection<CalendarDay> dates, Context context) {
        this.color = color;
        this.dates = new HashSet<>(dates);
        this.context = context;
    }

    @Override
    public boolean shouldDecorate(CalendarDay day) {
       boolean lol = dates.contains(day);

        return lol;
    }

    @Override
    public void decorate(DayViewFacade view) {
        view.addSpan(new DotSpan(10, color));

    }
}