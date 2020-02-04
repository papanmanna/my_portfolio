package com.example.myportfolio;

import android.content.Context;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;

public class TextViewMerrieWeatherBold  extends AppCompatTextView {

    public TextViewMerrieWeatherBold(Context context) {
        super(context);
        setTypeface(AppData.getTypefaceMWBold(getContext()));
    }

    public TextViewMerrieWeatherBold(Context context, AttributeSet attrs) {
        super(context, attrs);
        setTypeface(AppData.getTypefaceMWBold(getContext()));
    }

    public TextViewMerrieWeatherBold(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setTypeface(AppData.getTypefaceMWBold(getContext()));
    }
}
