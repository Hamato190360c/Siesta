package com.gashfara.wikitudesample1;

/**
 * Created by mizuki on 2017/12/21.
 */


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.support.design.widget.NavigationView;
import android.view.MenuItem;
import android.support.v7.app.AppCompatActivity;


public class AreaActivity extends AppCompatActivity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.area);



        ImageButton imageButtonontai = (ImageButton) findViewById(R.id.imageButtonontai);
        imageButtonontai.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //  画面を起動
                Intent intent = new Intent();
                intent.setClassName("com.gashfara.wikitudesample1", "com.gashfara.wikitudesample1.AnimalActivity");
                startActivity(intent);
            }
        });

        ImageButton imageButtonkut = (ImageButton) findViewById(R.id.imageButtonkut);
        imageButtonkut.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //  画面を起動
                Intent intent = new Intent();
                intent.setClassName("com.gashfara.wikitudesample1", "com.gashfara.wikitudesample1.KutActivity");
                startActivity(intent);
            }
        });
    }
}

