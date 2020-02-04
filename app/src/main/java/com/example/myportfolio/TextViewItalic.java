package com.example.myportfolio;

import android.content.Context;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;



public class TextViewItalic extends AppCompatTextView {
    public TextViewItalic(Context context) {
        super(context);
        setTypeface(AppData.getTypefaceItalic(getContext()));
    }

    public TextViewItalic(Context context, AttributeSet attrs) {
        super(context, attrs);
        setTypeface(AppData.getTypefaceItalic(getContext()));
    }

    public TextViewItalic(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setTypeface(AppData.getTypefaceItalic(getContext()));
    }
}
