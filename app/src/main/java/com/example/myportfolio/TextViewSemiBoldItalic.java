package com.example.myportfolio;

import android.content.Context;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;



public class TextViewSemiBoldItalic extends AppCompatTextView {
    public TextViewSemiBoldItalic(Context context) {
        super(context);
        setTypeface(AppData.getTypefaceSemiBoldItalic(getContext()));
    }

    public TextViewSemiBoldItalic(Context context, AttributeSet attrs) {
        super(context, attrs);
        setTypeface(AppData.getTypefaceSemiBoldItalic(getContext()));
    }

    public TextViewSemiBoldItalic(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setTypeface(AppData.getTypefaceSemiBoldItalic(getContext()));
    }
}
