package com.example.myportfolio;

import android.content.Context;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;



public class TextViewRegular extends AppCompatTextView {
    public TextViewRegular(Context context) {
        super(context);
        setTypeface(AppData.getTypefaceRegular(getContext()));
    }

    public TextViewRegular(Context context, AttributeSet attrs) {
        super(context, attrs);
        setTypeface(AppData.getTypefaceRegular(getContext()));
    }

    public TextViewRegular(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setTypeface(AppData.getTypefaceRegular(getContext()));
    }
}
