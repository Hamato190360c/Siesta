package com.gashfara.wikitudesample1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

/**
 * Created by takahiro on 2017/12/25.
 */

public class EventselectActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.event_all);



        ImageButton imageyear = (ImageButton) findViewById(R.id.yearevent);
        imageyear.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //  画面を起動
                Intent intent = new Intent();
                intent.setClassName("com.gashfara.wikitudesample1", "com.gashfara.wikitudesample1.YearEventActivity");
                startActivity(intent);
            }
        });

        ImageButton imagemonth = (ImageButton) findViewById(R.id.monthevent);
        imagemonth.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //  画面を起動
                Intent intent = new Intent();
                intent.setClassName("com.gashfara.wikitudesample1", "com.gashfara.wikitudesample1.MonthEventActivity");
                startActivity(intent);
            }
        });

        ImageButton imagehappy = (ImageButton) findViewById(R.id.happyevent);
        imagehappy.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //  画面を起動
                Intent intent = new Intent();
                intent.setClassName("com.gashfara.wikitudesample1", "com.gashfara.wikitudesample1.HappyActivity");
                startActivity(intent);
            }
        });
    }
}