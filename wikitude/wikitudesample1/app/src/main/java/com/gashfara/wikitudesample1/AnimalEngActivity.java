package com.gashfara.wikitudesample1;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.support.design.widget.NavigationView;
import android.view.Menu;
import android.view.MenuItem;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by takahiro on 2017/12/25.
 */


public class AnimalEngActivity extends AppCompatActivity {
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.animal_eng);



        ImageButton imageMizudorieng = (ImageButton)findViewById(R.id.mizudorieng);
        imageMizudorieng.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // どうぶつ 画面を起動
                Intent intent = new Intent();
                intent.setClassName("com.gashfara.wikitudesample1", "com.gashfara.wikitudesample1.MizudoriEngActivity");
                startActivity(intent);
            }
        });
    }
}