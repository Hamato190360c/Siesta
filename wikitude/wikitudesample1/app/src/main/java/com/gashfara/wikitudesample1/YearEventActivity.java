package com.gashfara.wikitudesample1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.net.Uri;

/**
 * Created by takahiro on 2017/12/25.
 */

public class YearEventActivity extends Activity {
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.yearevent);

        ImageButton imagenewevent1 = (ImageButton)findViewById(R.id.new_1);
        imagenewevent1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // どうぶつ 画面を起動
                Uri uri1 = Uri.parse("http://www.noichizoo.or.jp/2017125s.htm");
                Intent intent = new Intent(Intent.ACTION_VIEW,uri1);
                startActivity(intent);
            }
        });

        ImageButton imagenewevent2 = (ImageButton)findViewById(R.id.new_2);
        imagenewevent2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // どうぶつ 画面を起動
                Uri uri2 = Uri.parse("http://www.noichizoo.or.jp/2017124kd.htm");
                Intent intent = new Intent(Intent.ACTION_VIEW,uri2);
                startActivity(intent);
            }
        });

        ImageButton imagenewevent3 = (ImageButton)findViewById(R.id.new_3);
        imagenewevent3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // どうぶつ 画面を起動
                Uri uri3 = Uri.parse("http://www.noichizoo.or.jp/noichieto2018.htm");
                Intent intent = new Intent(Intent.ACTION_VIEW,uri3);
                startActivity(intent);
            }
        });

        ImageButton imagejan1 = (ImageButton)findViewById(R.id.jan_1);
        imagejan1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // どうぶつ 画面を起動
                Uri uri4 = Uri.parse("http://www.noichizoo.or.jp/info/documents/osyougatu.pdf");
                Intent intent = new Intent(Intent.ACTION_VIEW,uri4);
                startActivity(intent);
            }
        });


    }
}