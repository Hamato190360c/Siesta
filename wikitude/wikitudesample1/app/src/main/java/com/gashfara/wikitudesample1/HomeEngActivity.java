package com.gashfara.wikitudesample1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.content.Context;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.PopupWindow;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.WindowManager;

/**
 * Created by takahiro on 2017/12/28.
 */

public class HomeEngActivity extends Activity implements View.OnClickListener {
    PopupWindow popupWindow;
    Handler mHandler = new Handler();
    View view;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_eng);

        // LayoutInflaterインスタンスを取得
        LayoutInflater inflater = (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        // ポップアップ用のViewをpopupxmlから読み込む
        View popupView = (View)inflater.inflate(R.layout.popup, null);

        // レイアウトパラメータをセット
        popupView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT));

        // PopupWindowを紐づけるViewのインスタンスを取得
        view = findViewById(R.id.button6);

        // viewに紐づけたPopupWindowインスタンスを生成
        popupWindow = new PopupWindow(view);

        // ポップアップ用のViewをpopupWindowにセットする
        popupWindow.setContentView(popupView);

        // サイズ(幅)を設定
        popupWindow.setWidth(530);

        // サイズ(高さ)を設定
        popupWindow.setHeight(800);

        // 切替ボタンにリスナーを設定
        ImageButton btn = (ImageButton) findViewById(R.id.button6);
        btn.setOnClickListener(this);

        // 言語切り替えボタン
        popupView.findViewById(R.id.japanese).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClassName("com.gashfara.wikitudesample1", "com.gashfara.wikitudesample1.HomeActivity");
                startActivity(intent);
            }
        });
        ImageButton animaleng = (ImageButton)findViewById(R.id.animalengButton);
        animaleng.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // どうぶつ 画面を起動
                Intent intent = new Intent();
                intent.setClassName("com.gashfara.wikitudesample1", "com.gashfara.wikitudesample1.AreaEngActivity");
                startActivity(intent);
            }
        });
    }
    public void onClick(View view) {
        // 切替ボタン押下時にポップアップウィンドウの表示、非表示を切り替える
        if(popupWindow.isShowing()){
            popupWindow.dismiss();
        }else{
            popupWindow.showAsDropDown(view, 0, 0);
        }
    }
}
