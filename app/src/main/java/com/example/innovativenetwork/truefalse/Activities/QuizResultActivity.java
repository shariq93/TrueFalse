package com.example.innovativenetwork.truefalse.Activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.innovativenetwork.truefalse.R;
import com.example.innovativenetwork.truefalse.Utills.LevelDataHolder;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class QuizResultActivity extends AppCompatActivity {

    @BindView(R.id.tv_correct_ans)
    TextView tvCorrectAns;
    @BindView(R.id.tv_wrong_ans)
    TextView tvWrongAns;
    @BindView(R.id.cont)
    LinearLayout cont;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_quiz_result);
        ButterKnife.bind(this);

        tvCorrectAns.setText(String.valueOf(LevelDataHolder.trueQuestionsCount));
        tvWrongAns.setText(String.valueOf(LevelDataHolder.falseQuestionsCount));

    }


}
