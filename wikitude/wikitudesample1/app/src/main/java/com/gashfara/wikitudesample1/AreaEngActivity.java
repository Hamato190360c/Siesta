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


public class AreaEngActivity extends AppCompatActivity {
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.area_eng);
        NavigationView mNavigationView = (NavigationView) findViewById(R.id.nav_view);
        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {

                Intent intent = new Intent();
                switch (menuItem.getItemId()) {
                    case R.id.menu_home:
                        //メニュー：ホームがタップされた場合の動作を記述する
                        intent.setClassName("com.gashfara.wikitudesample1", "com.gashfara.wikitudesample1.HomeEngActivity");
                        startActivity(intent);
                        break;

                    case R.id.menu_ar:
                        //メニュー：ホームがタップされた場合の動作を記述する
                        intent.setClassName("com.gashfara.wikitudesample1", "com.gashfara.wikitudesample1.ArActivity");
                        startActivity(intent);
                        break;

                    case R.id.menu_map:

                        break;

                    case R.id.menu_animal:
                        //メニュー：ホームがタップされた場合の動作を記述する
                        intent.setClassName("com.gashfara.wikitudesample1", "com.gashfara.wikitudesample1.AnimalEngActivity");
                        startActivity(intent);
                        break;

                    case R.id.menu_event:
//                        intent.setClassName("com.gashfara.wikitudesample1", "com.gashfara.wikitudesample1.EventselectActivity");
//                        startActivity(intent);
                        break;

                    default:
                        break;
                }

                return false;
            }
        });

        ImageButton imageButtonontaieng = (ImageButton) findViewById(R.id.Buttonontaieng);
        imageButtonontaieng.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //  画面を起動
                Intent intent = new Intent();
                intent.setClassName("com.gashfara.wikitudesample1", "com.gashfara.wikitudesample1.AnimalEngActivity");
                startActivity(intent);
            }
        });
    }
}