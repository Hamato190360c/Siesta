package com.gashfara.wikitudesample1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.view.MenuItem;

import android.view.Menu;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by takahiro on 2017/12/25.
 */

public class PandaActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.panda);

        Button button = (Button)findViewById(R.id.home_button);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //  Home画面を起動
                Intent intent = new Intent();
                intent.setClassName("com.gashfara.wikitudesample1", "com.gashfara.wikitudesample1.HomeActivity");
                startActivity(intent);
            }
        });


    }
}