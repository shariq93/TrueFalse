package com.example.innovativenetwork.truefalse;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

public class OptionsActivity extends AppCompatActivity implements View.OnTouchListener{

    Button btn_ranking,btn_instruction,btn_musicon,btn_credits,btn_moreapps,btn_moregames;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options);


        btn_ranking = (Button) findViewById(R.id.btn_ranking);
        btn_instruction = (Button) findViewById(R.id.btn_instruction);
        btn_musicon = (Button) findViewById(R.id.btn_musicon);
        btn_credits = (Button) findViewById(R.id.btn_credits);
        btn_moreapps = (Button) findViewById(R.id.btn_moreapps);
        btn_moregames = (Button) findViewById(R.id.btn_moregames);


        btn_ranking.setOnTouchListener(this);
        btn_instruction.setOnTouchListener(this);
        btn_musicon.setOnTouchListener(this);
        btn_credits.setOnTouchListener(this);
        btn_moreapps.setOnTouchListener(this);
        btn_moregames.setOnTouchListener(this);
    }


    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {

        switch (motionEvent.getAction()) {

            case MotionEvent.ACTION_DOWN:

                switch (view.getId()) {

                    case R.id.btn_ranking:
                        btn_ranking.setTextColor(Color.WHITE);
                        btn_ranking.setBackgroundResource(R.drawable.btn_red);
                        break;
                    case R.id.btn_instruction:
                        btn_instruction.setTextColor(Color.WHITE);
                        btn_instruction.setBackgroundResource(R.drawable.btn_red);
                        break;
                    case R.id.btn_musicon:
                        btn_musicon.setTextColor(Color.WHITE);
                        btn_musicon.setBackgroundResource(R.drawable.btn_red);
                        break;
                    case R.id.btn_credits:
                        btn_credits.setTextColor(Color.WHITE);
                        btn_credits.setBackgroundResource(R.drawable.btn_red);
                        break;
                    case R.id.btn_moreapps:
                        btn_moreapps.setTextColor(Color.WHITE);
                        btn_moreapps.setBackgroundResource(R.drawable.btn_red);
                        break;
                    case R.id.btn_moregames:
                        btn_moregames.setTextColor(Color.WHITE);
                        btn_moregames.setBackgroundResource(R.drawable.btn_red);

                        break;
                }


                break;

            case MotionEvent.ACTION_UP:
                switch (view.getId()) {

                    case R.id.btn_ranking:
                        btn_ranking.setTextColor(Color.BLACK);
                        btn_ranking.setBackgroundResource(R.drawable.btn_gray);
//                        startActivity(new Intent(SelectDifficultyActivity.this,SelectCatagoryActivity.class));

                        break;
                    case R.id.btn_instruction:
                        btn_instruction.setTextColor(Color.BLACK);
                        btn_instruction.setBackgroundResource(R.drawable.btn_gray);
                        // startActivity(new Intent(SelectDifficultyActivity.this,SelectCatagoryActivity.class));

                        break;

                    case R.id.btn_musicon:
                        btn_musicon.setTextColor(Color.BLACK);
                        btn_musicon.setBackgroundResource(R.drawable.btn_gray);
                        //  startActivity(new Intent(SelectDifficultyActivity.this,SelectCatagoryActivity.class));

                        break;
                    case R.id.btn_credits:
                        btn_credits.setTextColor(Color.BLACK);
                        btn_credits.setBackgroundResource(R.drawable.btn_gray);
                        //  startActivity(new Intent(SelectDifficultyActivity.this,SelectCatagoryActivity.class));

                        break;
                    case R.id.btn_moreapps:
                        btn_moreapps.setTextColor(Color.BLACK);
                        btn_moreapps.setBackgroundResource(R.drawable.btn_gray);
                        //  startActivity(new Intent(SelectDifficultyActivity.this,SelectCatagoryActivity.class));

                        break;
                    case R.id.btn_moregames:
                        btn_moregames.setTextColor(Color.BLACK);
                        btn_moregames.setBackgroundResource(R.drawable.btn_gray);
                        //   startActivity(new Intent(SelectDifficultyActivity.this,SelectCatagoryActivity.class));

                        break;
                }

                break;
        }
        return true;
    }
}
