package com.example.innovativenetwork.truefalse;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

public class SelectCatagoryActivity extends AppCompatActivity implements View.OnTouchListener{

    Button btn_color,btn_number,btn_animal,btn_fruit,btn_object,btn_language;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_catagory);



        btn_color = (Button) findViewById(R.id.btn_color);
        btn_number = (Button) findViewById(R.id.btn_number);
        btn_animal = (Button) findViewById(R.id.btn_animal);
        btn_fruit = (Button) findViewById(R.id.btn_fruit);
        btn_object = (Button) findViewById(R.id.btn_object);
        btn_language = (Button) findViewById(R.id.btn_language);


        btn_color.setOnTouchListener(this);
        btn_number.setOnTouchListener(this);
        btn_animal.setOnTouchListener(this);
        btn_fruit.setOnTouchListener(this);
        btn_object.setOnTouchListener(this);
        btn_language.setOnTouchListener(this);

    }






    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {

        switch (motionEvent.getAction()) {

            case MotionEvent.ACTION_DOWN:

                switch (view.getId()) {

                    case R.id.btn_color:
                        btn_color.setTextColor(Color.WHITE);
                        btn_color.setBackgroundResource(R.drawable.btn_red);
                        break;
                    case R.id.btn_number:
                        btn_number.setTextColor(Color.WHITE);
                        btn_number.setBackgroundResource(R.drawable.btn_red);
                        break;
                    case R.id.btn_animal:
                        btn_animal.setTextColor(Color.WHITE);
                        btn_animal.setBackgroundResource(R.drawable.btn_red);
                        break;
                    case R.id.btn_fruit:
                        btn_fruit.setTextColor(Color.WHITE);
                        btn_fruit.setBackgroundResource(R.drawable.btn_red);
                        break;
                    case R.id.btn_object:
                        btn_object.setTextColor(Color.WHITE);
                        btn_object.setBackgroundResource(R.drawable.btn_red);
                        break;
                    case R.id.btn_language:
                        btn_language.setTextColor(Color.WHITE);
                        btn_language.setBackgroundResource(R.drawable.btn_red);

                        break;
                }


                break;

            case MotionEvent.ACTION_UP:
                switch (view.getId()) {

                    case R.id.btn_color:
                        btn_color.setTextColor(Color.BLACK);
                        btn_color.setBackgroundResource(R.drawable.btn_gray);
                        startActivity(new Intent(SelectCatagoryActivity.this,GameActivity.class));

                        break;
                    case R.id.btn_number:
                        btn_number.setTextColor(Color.BLACK);
                        btn_number.setBackgroundResource(R.drawable.btn_gray);
                        startActivity(new Intent(SelectCatagoryActivity.this,GameActivity.class));

                        break;

                    case R.id.btn_animal:
                        btn_animal.setTextColor(Color.BLACK);
                        btn_animal.setBackgroundResource(R.drawable.btn_gray);
                        startActivity(new Intent(SelectCatagoryActivity.this,GameActivity.class));

                        break;
                    case R.id.btn_fruit:
                        btn_fruit.setTextColor(Color.BLACK);
                        btn_fruit.setBackgroundResource(R.drawable.btn_gray);
                        startActivity(new Intent(SelectCatagoryActivity.this,GameActivity.class));

                        break;
                    case R.id.btn_object:
                        btn_object.setTextColor(Color.BLACK);
                        btn_object.setBackgroundResource(R.drawable.btn_gray);
                        startActivity(new Intent(SelectCatagoryActivity.this,GameActivity.class));

                        break;
                    case R.id.btn_language:
                        btn_language.setTextColor(Color.BLACK);
                        btn_language.setBackgroundResource(R.drawable.btn_gray);
                        startActivity(new Intent(SelectCatagoryActivity.this,GameActivity.class));

                        break;
                }

                break;
        }
        return true;
    }
}
