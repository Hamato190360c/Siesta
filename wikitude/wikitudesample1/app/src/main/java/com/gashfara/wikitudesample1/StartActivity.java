package com.gashfara.wikitudesample1;

/**
 * Created by mizuki on 2017/12/23.
 */

import android.support.v7.app.AppCompatActivity;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class StartActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start);



        ImageButton imageButton1 = (ImageButton)findViewById(R.id.imageButton1);
        imageButton1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //  Home画面を起動
                Intent intent = new Intent();
                intent.setClassName("com.gashfara.wikitudesample1", "com.gashfara.wikitudesample1.HomeActivity");
                startActivity(intent);
            }
        });
    }
}

