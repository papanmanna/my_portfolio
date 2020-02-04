package com.example.myportfolio;

import android.content.Context;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;



public class TextViewBold extends AppCompatTextView {
    public TextViewBold(Context context) {
        super(context);
        setTypeface(AppData.getTypefaceBold(getContext()));
    }

    public TextViewBold(Context context, AttributeSet attrs) {
        super(context, attrs);
        setTypeface(AppData.getTypefaceBold(getContext()));
    }

    public TextViewBold(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setTypeface(AppData.getTypefaceBold(getContext()));
    }
}
