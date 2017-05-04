package com.example.innovativenetwork.truefalse.Activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.innovativenetwork.truefalse.DataClasses.QuestionData;
import com.example.innovativenetwork.truefalse.R;
import com.example.innovativenetwork.truefalse.Utills.ImageBinaryConvertor;
import com.orm.query.Condition;
import com.orm.query.Select;

import butterknife.BindView;
import butterknife.ButterKnife;

public class GameActivity extends AppCompatActivity {
    int difficulty = 0;
    int category = 0;
    @BindView(R.id.iv_questin_image)
    ImageView ivQuestinImage;
    @BindView(R.id.tv_question_text)
    TextView tvQuestionText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        // this code is from minhaj PC
        ButterKnife.bind(this);
        difficulty = getIntent().getIntExtra("diff", 0);
        category = getIntent().getIntExtra("cat", 0);
        Toast.makeText(this, "difficulty: " + difficulty + ", category: " + category, Toast.LENGTH_SHORT).show();
        Log.i("=====", "onCreate: " + "difficulty: " + difficulty + ", category: " + category);
        QuestionData data = Select.from(QuestionData.class)
                .where(Condition.prop("CATEGORY").eq(String.valueOf(category)),
                        Condition.prop("DIFICULTY").eq(String.valueOf(difficulty)))
                .first();
        if (data != null) {
            Log.i("=====", "onCreate: " + data.toString());
//            ivQuestinImage.setImageBitmap(ImageBinaryConvertor.getBitmapFromBase64String());
            Glide.with(this).load(data.getImageBase64()).into(ivQuestinImage);
            tvQuestionText.setText(data.getQuestionText());
        }
    }
}
