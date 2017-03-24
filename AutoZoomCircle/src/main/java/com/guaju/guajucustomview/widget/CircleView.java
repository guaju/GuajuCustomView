package com.guaju.guajucustomview.widget;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import com.guaju.guajucustomview.R;
import com.guaju.guajucustomview.utils.MeasureUtils;

/**
 * Created by guaju on 2017/3/24.
 */

public class CircleView extends View implements   Runnable{
    private Context mContext;
    private int screenHeight;
    private int screenWidth;
    public int contentHeight;
    private Paint paint;
    private int radius=50;



    public CircleView(Context context) {
        super(context);
        if (context instanceof Activity) {
           Activity mCon=(Activity)context;
        initEnv(mCon);
        }
    }

    public CircleView(Context context, AttributeSet attrs) {
        super(context, attrs);
        if (context instanceof Activity) {
            Activity mCon=(Activity)context;
            initEnv(mCon);
        }
    }

    public CircleView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    void initEnv(Activity activity) {
        mContext=activity;
        screenHeight = MeasureUtils.getScreenHeight(mContext);
        screenWidth = MeasureUtils.getScreenWidth(mContext);
        contentHeight=screenHeight-MeasureUtils.getStatusBarHeight(activity)-MeasureUtils.getToolBarHeight(activity);
        //init paint
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setStyle(Paint.Style.STROKE);//draw corner
        paint.setStrokeWidth(getResources().getDimensionPixelSize(R.dimen.stroke_width));

    }



    @Override
    protected void onDraw(final Canvas canvas) {
        canvas.drawCircle( screenWidth*0.5f,contentHeight*0.5f,radius,paint);
    }

    @Override
    public void run() {
                while(true){
                    if (radius<=200){
                        radius+=10;
                    }else{
                        radius=50;
                    }
                    try {
                        Thread.sleep(50);
                        postInvalidate();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }

            }
}
