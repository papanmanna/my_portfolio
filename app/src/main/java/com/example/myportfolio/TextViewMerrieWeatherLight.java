package com.example.myportfolio;

import android.content.Context;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;

public class TextViewMerrieWeatherLight extends AppCompatTextView {

    public TextViewMerrieWeatherLight(Context context) {
        super(context);
        setTypeface(AppData.getTypefaceMWLight(getContext()));
    }

    public TextViewMerrieWeatherLight(Context context, AttributeSet attrs) {
        super(context, attrs);
        setTypeface(AppData.getTypefaceMWLight(getContext()));
    }

    public TextViewMerrieWeatherLight(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setTypeface(AppData.getTypefaceMWLight(getContext()));
    }
}
