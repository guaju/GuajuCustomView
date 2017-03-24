package com.guaju.guajucustomview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.guaju.guajucustomview.widget.CircleView;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    private CircleView cv;
    private int height;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        ViewGroup ll = (ViewGroup) LayoutInflater.from(this)
//                .inflate(R.layout.activity_main, null, false);
//        CircleView circleView = new CircleView(this);
//        ll.addView(circleView);
        setContentView(R.layout.activity_main);
        CircleView cv= (CircleView) findViewById(R.id.mcircleview);
        new Thread(cv).start();
    }
}
