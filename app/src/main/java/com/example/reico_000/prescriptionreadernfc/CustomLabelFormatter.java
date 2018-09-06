package com.example.reico_000.prescriptionreadernfc;


import android.content.Context;
import com.jjoe64.graphview.DefaultLabelFormatter;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class CustomLabelFormatter extends DefaultLabelFormatter {
    protected final DateFormat mDateFormat;
    protected final Calendar mCalendar;

    public CustomLabelFormatter(Context context) {
        this.mDateFormat = android.text.format.DateFormat.getDateFormat(context);
        this.mCalendar = Calendar.getInstance();
    }

    public CustomLabelFormatter(Context context, DateFormat dateFormat) {
        this.mDateFormat = dateFormat;
        this.mCalendar = Calendar.getInstance();
    }

    public String formatLabel(double value, boolean isValueX) {
        if(isValueX) {
            this.mCalendar.setTimeInMillis((long) value);
            SimpleDateFormat dateFormat = new SimpleDateFormat("d MMM yyyy", java.util.Locale.US);
            return dateFormat.format(Long.valueOf(this.mCalendar.getTimeInMillis()));
//            return this.mDateFormat.format(Long.valueOf(this.mCalendar.getTimeInMillis()));
        } else {
            NumberFormat nf = NumberFormat.getInstance();
            nf.setMaximumFractionDigits(0);
            return super.formatLabel(Double.parseDouble(nf.format(value)), isValueX);
        }
    }
}
