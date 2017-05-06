package com.example.innovativenetwork.truefalse.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.innovativenetwork.truefalse.DataClasses.QuestionData;
import com.example.innovativenetwork.truefalse.R;
import com.example.innovativenetwork.truefalse.Utills.LevelDataHolder;
import com.orm.query.Condition;
import com.orm.query.Select;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class GameActivity extends AppCompatActivity {
    int difficulty = 0;
    int category = 0;
    @BindView(R.id.iv_questin_image)
    ImageView ivQuestinImage;
    @BindView(R.id.tv_question_text)
    TextView tvQuestionText;
    @BindView(R.id.btn_true)
    Button btnTrue;
    @BindView(R.id.btn_false)
    Button btnFalse;
    ///List<QuestionData> questionsList;
    int index = 0;
    @BindView(R.id.iv_ans_status)
    ImageView ivAnsStatus;
    @BindView(R.id.pb_game_progress)
    ProgressBar pbGameProgress;
    @BindView(R.id.tv_question_progress)
    TextView tvQuestionProgress;
    @BindView(R.id.activity_game)
    RelativeLayout activityGame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        ButterKnife.bind(this);
        difficulty = getIntent().getIntExtra("diff", 0);
        category = getIntent().getIntExtra("cat", 0);
        // Toast.makeText(this, "difficulty: " + difficulty + ", category: " + category, Toast.LENGTH_SHORT).show();
        Log.i("=====", "onCreate: " + "difficulty: " + difficulty + ", category: " + category);
        LevelDataHolder.questionsList = Select.from(QuestionData.class)
                .where(Condition.prop("CATEGORY").eq(String.valueOf(category)),
                        Condition.prop("DIFICULTY").eq(String.valueOf(difficulty))).list();
        LevelDataHolder.falseQuestionsCount = 0;
        LevelDataHolder.trueQuestionsCount = 0;
        if (LevelDataHolder.questionsList.size() > 0) {
            QuestionData data = LevelDataHolder.questionsList.get(index);
            if (data != null) {
                Glide.with(this).load(data.getImageBase64()).placeholder(R.drawable.placeholder2).into(ivQuestinImage);
                tvQuestionText.setText(data.getQuestionText());
            }
        }

    }

    @OnClick({R.id.btn_true, R.id.btn_false})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_true:
                if (LevelDataHolder.questionsList.size() > 0) {

                    moveToNextQuestion(LevelDataHolder.questionsList.get(index), true);
                }
                break;
            case R.id.btn_false:
                if (LevelDataHolder.questionsList.size() > 0) {
                    moveToNextQuestion(LevelDataHolder.questionsList.get(index), false);
                }
                break;
        }
    }

    public void moveToNextQuestion(QuestionData currentData, boolean answerBtn) {
        if (currentData.isAnswer() == answerBtn) {
            showAnsStatusImage(true);
        } else {
            showAnsStatusImage(false);
        }
        index++;
        updateProgressBar();


        new Thread() {
            @Override
            public void run() {
                super.run();
                try {
                    sleep(1500);
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            hideAnsStatusImage();
                            if (index >= LevelDataHolder.questionsList.size()) {
                                //Toast.makeText(GameActivity.this, "All QuestionsDone", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(GameActivity.this, QuizResultActivity.class));
                                finish();
                            } else {
                                QuestionData data = LevelDataHolder.questionsList.get(index);
                                if (data != null) {
                                    Glide.with(GameActivity.this).load(data.getImageBase64()).placeholder(R.drawable.placeholder2).into(ivQuestinImage);
                                    tvQuestionText.setText(data.getQuestionText());

                                }
                            }

                        }
                    });
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }

    public void showAnsStatusImage(boolean answerIsTrue) {
        if (answerIsTrue) {
            LevelDataHolder.trueQuestionsCount++;
            ivAnsStatus.setImageResource(R.drawable.ico_check);
            ivAnsStatus.setVisibility(View.VISIBLE);
        } else {
            LevelDataHolder.falseQuestionsCount++;
            ivAnsStatus.setImageResource(R.drawable.ico_close);
            ivAnsStatus.setVisibility(View.VISIBLE);
        }
    }

    public void hideAnsStatusImage() {

        ivAnsStatus.setVisibility(View.GONE);


    }

    public void updateProgressBar() {
        pbGameProgress.setMax(LevelDataHolder.questionsList.size());
        pbGameProgress.setProgress(index);
        tvQuestionProgress.setText(index + "/" + LevelDataHolder.questionsList.size());
    }
}
