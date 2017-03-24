package com.guaju.guajucustomview.utils;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Display;
import android.view.Window;
import android.view.WindowManager;

/**
 * Created by guaju on 2017/3/24.
 */

public class MeasureUtils {
    public static DisplayMetrics  getDefaultDisplay(Context context){
        WindowManager wm= (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Display defaultDisplay = wm.getDefaultDisplay();
        DisplayMetrics dm = new DisplayMetrics();
        defaultDisplay.getMetrics(dm);
        return  dm;
    }

    public static int  getScreenHeight(Context context){
        return  getDefaultDisplay(context).heightPixels;
    }
    public static int  getScreenWidth(Context context){
        return  getDefaultDisplay(context).widthPixels;
    }
    public static int  getStatusBarHeight(Context context){
        int statusBarHeight=-1;
        try {
            Class<?> clazz = Class.forName("com.android.internal.R$dimen");
            Object o = clazz.newInstance();
            int status_bar_height = Integer.parseInt(clazz.getField("status_bar_height").get(o).toString());
            statusBarHeight = context.getResources().getDimensionPixelSize(status_bar_height);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        if (statusBarHeight>0){

            return statusBarHeight;
        }
        else
        {
            return 0;
        }
    }
    public static int getTopHeight(Activity activity){
        int top = activity.getWindow().findViewById(Window.ID_ANDROID_CONTENT).getTop();
        return  top;
    }

    //resovled by stackoverflow
    public static int getToolBarHeight(Activity activity){
        int toolBarHeight=0;
        TypedValue tv = new TypedValue();
        if (activity.getTheme().resolveAttribute(android.R.attr.actionBarSize, tv, true))
        {
            toolBarHeight = TypedValue.complexToDimensionPixelSize(tv.data,activity.getResources().getDisplayMetrics());
        }
        return toolBarHeight;
    }


}
