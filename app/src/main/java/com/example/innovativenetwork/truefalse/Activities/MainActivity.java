package com.example.innovativenetwork.truefalse.Activities;

import android.content.Intent;
import android.graphics.Color;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.innovativenetwork.truefalse.BuildConfig;
import com.example.innovativenetwork.truefalse.DataClasses.QuestionData;
import com.example.innovativenetwork.truefalse.R;
import com.orm.SugarContext;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.nio.channels.FileChannel;

public class MainActivity extends AppCompatActivity implements View.OnTouchListener {

    Button btn_start, btn_option;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SugarContext.init(this);
        QuestionData data = new QuestionData();
        data.save();

        btn_start = (Button) findViewById(R.id.btn_start);
        btn_option = (Button) findViewById(R.id.btn_options);


        btn_option.setOnTouchListener(this);
        btn_start.setOnTouchListener(this);



        showDebugDBAddressLogToast();
        copyDataBase();

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
    public static void showDebugDBAddressLogToast() {
        if (BuildConfig.DEBUG) {
            try {
                Class<?> debugDB = Class.forName("com.amitshekhar.DebugDB");
                Method getAddressLog = debugDB.getMethod("getAddressLog");
                Object value = getAddressLog.invoke(null);

                Log.i("=========", "showDebugDBAddressLogToast: " + (String) value);
            } catch (Exception ignore) {

            }
        }
    }

    public static  String DB_PATH = "";
    public static final String DB_NAME = "true_false.db";
    private void copyDataBase()
    {
        DB_PATH = "data/data/" + getPackageName() + "/databases/";
        Log.i("Database",
                "New database is being copied to device!");
        byte[] buffer = new byte[1024];
        OutputStream myOutput = null;
        int length;
        // Open your local db as the input stream
        InputStream myInput = null;
        try
        {
            myInput =getAssets().open(DB_NAME);
            // transfer bytes from the inputfile to the
            // outputfile
            myOutput =new FileOutputStream(DB_PATH+ DB_NAME);
            while((length = myInput.read(buffer)) > 0)
            {
                myOutput.write(buffer, 0, length);
            }
            myOutput.close();
            myOutput.flush();
            myInput.close();
            Log.i("Database",
                    "New database has been copied to device!");


        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }

}
