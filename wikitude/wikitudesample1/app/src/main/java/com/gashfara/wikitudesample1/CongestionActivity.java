package com.gashfara.wikitudesample1;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

/**
 * Created by mizuki on 2018/01/11.
 */

public class CongestionActivity extends AppCompatActivity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.congestion);

        ImageButton honkan = (ImageButton)findViewById(R.id.honkan);
        honkan.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // 本館の混雑を起動
                Intent intent = new Intent();
                intent.setClassName("com.gashfara.wikitudesample1", "com.gashfara.wikitudesample1.HonkanCongestionActivity");
                startActivity(intent);
            }
        });
        ImageButton gym = (ImageButton)findViewById(R.id.gym);
        gym.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // 体育館の混雑を起動
                Intent intent = new Intent();
                intent.setClassName("com.gashfara.wikitudesample1", "com.gashfara.wikitudesample1.GymCongestionActivity");
                startActivity(intent);
            }
        });
        ImageButton ground = (ImageButton)findViewById(R.id.ground);
        ground.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // グラウンドの混雑を起動
                Intent intent = new Intent();
                intent.setClassName("com.gashfara.wikitudesample1", "com.gashfara.wikitudesample1.GroundCongestionActivity");
                startActivity(intent);
            }
        });
    }
}
