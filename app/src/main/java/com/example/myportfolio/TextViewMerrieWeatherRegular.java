package com.example.myportfolio;

import android.content.Context;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;

public class TextViewMerrieWeatherRegular extends AppCompatTextView {
    public TextViewMerrieWeatherRegular(Context context) {
        super(context);
        setTypeface(AppData.getTypefaceMWRegular(getContext()));
    }

    public TextViewMerrieWeatherRegular(Context context, AttributeSet attrs) {
        super(context, attrs);
        setTypeface(AppData.getTypefaceMWRegular(getContext()));
    }

    public TextViewMerrieWeatherRegular(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setTypeface(AppData.getTypefaceMWRegular(getContext()));
    }
}
