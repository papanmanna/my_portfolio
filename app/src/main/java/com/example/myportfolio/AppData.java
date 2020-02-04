package com.example.myportfolio;

import android.content.Context;
import android.graphics.Typeface;

public class AppData {
    private static Typeface typefaceLight = null;
    private static Typeface typefaceBold = null;
    private static Typeface typefaceRegular = null;
    private static Typeface typefaceItalic = null;
    private static Typeface typefaceSemiBold = null;
    private static Typeface typefaceSemiBoldItalic = null;
    private static Typeface typefaceMWRegular = null;
    private static Typeface typefaceMWBold = null;
    private static Typeface typefaceMWLight = null;
    private static Typeface typefaceMWItalic = null;

    private AppData() {
    }

    public static Typeface getTypefaceRegular(Context context) {
        if (typefaceRegular == null) {
            typefaceRegular = Typeface.createFromAsset(context.getAssets(), "fonts/librefranklin_regular.ttf");
        }
        return typefaceRegular;
    }

    public static Typeface getTypefaceLight(Context context) {
        if (typefaceLight == null) {
            typefaceLight = Typeface.createFromAsset(context.getAssets(), "fonts/librefranklin_light.ttf");
        }
        return typefaceLight;
    }

    public static Typeface getTypefaceBold(Context context) {
        if (typefaceBold == null) {
            typefaceBold = Typeface.createFromAsset(context.getAssets(), "fonts/librefranklin_bold.ttf");
        }
        return typefaceBold;
    }

    public static Typeface getTypefaceItalic(Context context) {
        if (typefaceItalic == null) {
            typefaceItalic = Typeface.createFromAsset(context.getAssets(), "fonts/librefranklin_italic.ttf");
        }
        return typefaceItalic;
    }


    public static Typeface getTypefaceSemiBold(Context context) {
        if (typefaceSemiBold == null) {
            typefaceSemiBold = Typeface.createFromAsset(context.getAssets(), "fonts/librefranklin_semibold.ttf");
        }
        return typefaceSemiBold;
    }

    public static Typeface getTypefaceSemiBoldItalic(Context context) {
        if (typefaceSemiBoldItalic == null) {
            typefaceSemiBoldItalic = Typeface.createFromAsset(context.getAssets(), "fonts/librefranklin_semibolditalic.ttf");
        }
        return typefaceSemiBoldItalic;
    }


    public static Typeface getTypefaceMWRegular(Context context) {
        if (typefaceMWRegular == null) {
            typefaceMWRegular = Typeface.createFromAsset(context.getAssets(), "fonts/merriweather_regular.otf");
        }
        return typefaceMWRegular;
    }

    public static Typeface getTypefaceMWBold(Context context) {
        if (typefaceMWBold == null) {
            typefaceMWBold = Typeface.createFromAsset(context.getAssets(), "fonts/merriweather_bold.otf");
        }
        return typefaceMWBold;
    }

    public static Typeface getTypefaceMWLight(Context context) {
        if (typefaceMWLight == null) {
            typefaceMWLight = Typeface.createFromAsset(context.getAssets(), "fonts/merriweather_light.otf");
        }
        return typefaceMWLight;
    }

    public static Typeface getTypefaceMWItalic(Context context) {
        if (typefaceMWItalic == null) {
            typefaceMWItalic = Typeface.createFromAsset(context.getAssets(), "fonts/merriweather_italic.otf");
        }
        return typefaceMWItalic;
    }
}
