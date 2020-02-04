package com.example.myportfolio;

import android.content.Context;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;




public class TextViewSemiBold extends AppCompatTextView {
    public TextViewSemiBold(Context context) {
        super(context);
        setTypeface(AppData.getTypefaceSemiBold(getContext()));
    }

    public TextViewSemiBold(Context context, AttributeSet attrs) {
        super(context, attrs);
        setTypeface(AppData.getTypefaceSemiBold(getContext()));
    }

    public TextViewSemiBold(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setTypeface(AppData.getTypefaceSemiBold(getContext()));
    }
}
