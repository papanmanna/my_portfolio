package com.example.myportfolio;

import android.content.Context;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;

public class TextViewMerrieWeatherItalic extends AppCompatTextView {
    public TextViewMerrieWeatherItalic(Context context) {
        super(context);
        setTypeface(AppData.getTypefaceMWItalic(getContext()));
    }

    public TextViewMerrieWeatherItalic(Context context, AttributeSet attrs) {
        super(context, attrs);
        setTypeface(AppData.getTypefaceMWItalic(getContext()));
    }

    public TextViewMerrieWeatherItalic(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setTypeface(AppData.getTypefaceMWItalic(getContext()));
    }
}
