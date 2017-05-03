package com.example.innovativenetwork.truefalse;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

public class SelectDifficultyActivity extends AppCompatActivity implements View.OnTouchListener{

    Button btn_baby,btn_easy,btn_medium,btn_high,btn_superHigh,btn_megaHigh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_difficulty);

        btn_baby = (Button) findViewById(R.id.btn_baby);
        btn_easy = (Button) findViewById(R.id.btn_easy);
        btn_medium = (Button) findViewById(R.id.btn_medium);
        btn_high = (Button) findViewById(R.id.btn_high);
        btn_superHigh = (Button) findViewById(R.id.btn_superHigh);
        btn_megaHigh = (Button) findViewById(R.id.btn_megaHigh);


        btn_baby.setOnTouchListener(this);
        btn_easy.setOnTouchListener(this);
        btn_medium.setOnTouchListener(this);
        btn_high.setOnTouchListener(this);
        btn_superHigh.setOnTouchListener(this);
        btn_megaHigh.setOnTouchListener(this);


    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {

        switch (motionEvent.getAction()) {

            case MotionEvent.ACTION_DOWN:

                switch (view.getId()) {

                    case R.id.btn_baby:
                        btn_baby.setTextColor(Color.WHITE);
                        btn_baby.setBackgroundResource(R.drawable.btn_red);
                        break;
                    case R.id.btn_easy:
                        btn_easy.setTextColor(Color.WHITE);
                        btn_easy.setBackgroundResource(R.drawable.btn_red);
                        break;
                    case R.id.btn_medium:
                        btn_medium.setTextColor(Color.WHITE);
                        btn_medium.setBackgroundResource(R.drawable.btn_red);
                        break;
                    case R.id.btn_high:
                        btn_high.setTextColor(Color.WHITE);
                        btn_high.setBackgroundResource(R.drawable.btn_red);
                        break;
                    case R.id.btn_superHigh:
                        btn_superHigh.setTextColor(Color.WHITE);
                        btn_superHigh.setBackgroundResource(R.drawable.btn_red);
                        break;
                    case R.id.btn_megaHigh:
                        btn_megaHigh.setTextColor(Color.WHITE);
                        btn_megaHigh.setBackgroundResource(R.drawable.btn_red);

                        break;
                }


                break;

            case MotionEvent.ACTION_UP:
                switch (view.getId()) {

                    case R.id.btn_baby:
                        btn_baby.setTextColor(Color.BLACK);
                        btn_baby.setBackgroundResource(R.drawable.btn_gray);
                        startActivity(new Intent(SelectDifficultyActivity.this,SelectCatagoryActivity.class));

                        break;
                    case R.id.btn_easy:
                        btn_easy.setTextColor(Color.BLACK);
                        btn_easy.setBackgroundResource(R.drawable.btn_gray);
                        startActivity(new Intent(SelectDifficultyActivity.this,SelectCatagoryActivity.class));

                        break;

                    case R.id.btn_medium:
                        btn_medium.setTextColor(Color.BLACK);
                        btn_medium.setBackgroundResource(R.drawable.btn_gray);
                        startActivity(new Intent(SelectDifficultyActivity.this,SelectCatagoryActivity.class));

                        break;
                    case R.id.btn_high:
                        btn_high.setTextColor(Color.BLACK);
                        btn_high.setBackgroundResource(R.drawable.btn_gray);
                        startActivity(new Intent(SelectDifficultyActivity.this,SelectCatagoryActivity.class));

                        break;
                    case R.id.btn_superHigh:
                        btn_superHigh.setTextColor(Color.BLACK);
                        btn_superHigh.setBackgroundResource(R.drawable.btn_gray);
                        startActivity(new Intent(SelectDifficultyActivity.this,SelectCatagoryActivity.class));

                        break;
                    case R.id.btn_megaHigh:
                        btn_megaHigh.setTextColor(Color.BLACK);
                        btn_megaHigh.setBackgroundResource(R.drawable.btn_gray);
                        startActivity(new Intent(SelectDifficultyActivity.this,SelectCatagoryActivity.class));

                        break;
                }

                break;
        }
        return true;
    }
}
