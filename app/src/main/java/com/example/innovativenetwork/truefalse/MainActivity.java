package com.example.innovativenetwork.truefalse;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnTouchListener {

    Button btn_start, btn_option;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btn_start = (Button) findViewById(R.id.btn_start);
        btn_option = (Button) findViewById(R.id.btn_options);


        btn_option.setOnTouchListener(this);
        btn_start.setOnTouchListener(this);


    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {

        switch (motionEvent.getAction()) {

            case MotionEvent.ACTION_DOWN:

                switch (view.getId()) {

                    case R.id.btn_options:
                        btn_option.setTextColor(Color.WHITE);
                        btn_option.setBackgroundResource(R.drawable.btn_red);
                        break;
                    case R.id.btn_start:
                        btn_start.setTextColor(Color.WHITE);
                        btn_start.setBackgroundResource(R.drawable.btn_red);

                        break;
                }


                break;

            case MotionEvent.ACTION_UP:
                switch (view.getId()) {

                    case R.id.btn_options:
                        btn_option.setTextColor(Color.BLACK);
                        btn_option.setBackgroundResource(R.drawable.btn_gray);
                        startActivity(new Intent(MainActivity.this,OptionsActivity.class));

                        break;
                    case R.id.btn_start:
                        btn_start.setTextColor(Color.BLACK);
                        btn_start.setBackgroundResource(R.drawable.btn_gray);
                        startActivity(new Intent(MainActivity.this,SelectDifficultyActivity.class));

                        break;
                }

                break;
        }
        return true;
    }
}
