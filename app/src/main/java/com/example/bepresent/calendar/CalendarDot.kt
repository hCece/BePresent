package com.example.bepresent.calendar

import android.content.Context
import com.prolificinteractive.materialcalendarview.CalendarDay
import com.prolificinteractive.materialcalendarview.DayViewDecorator
import com.prolificinteractive.materialcalendarview.DayViewFacade
import com.prolificinteractive.materialcalendarview.spans.DotSpan

class CalendarDot(private val color: Int, dates: Collection<CalendarDay>?, context: Context) : DayViewDecorator {
    private val dates: HashSet<CalendarDay>
    private val context: Context

    init {
        this.dates = HashSet(dates)
        this.context = context
    }

    override fun shouldDecorate(day: CalendarDay): Boolean {
        return dates.contains(day)
    }

    override fun decorate(view: DayViewFacade) {
        view.addSpan(DotSpan(5.0F, color))
    }
}