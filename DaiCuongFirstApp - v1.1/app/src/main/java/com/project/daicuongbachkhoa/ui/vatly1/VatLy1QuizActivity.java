package com.project.daicuongbachkhoa.ui.vatly1;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;

import com.project.daicuongbachkhoa.R;

public class VatLy1QuizActivity extends AppCompatActivity {

    public static final String EXTRA_SCORE = "extraScore";
    private static final long COUNTDOWN_IN_MILLIS = 15000;// thời gian lựa chọn

    private static final String KEY_SCORE = "keyScore";
    private static final String KEY_QUESTION_COUNT = "keyQuestionCount";
    private static final String KEY_MILLIS_LEFT = "keyMillisLeft";
    private static final String KEY_ANSWERED = "keyAnswered";
    private static final String KEY_QUESTION_LIST = "keyQuestionList";


    private TextView txtQuestion;
    private TextView txtScore;
    private TextView txtQuestionCount;
    private TextView txtCategory;
    private TextView txtDifficulty;

    private TextView txtCountDown;
    private RadioGroup radGroup;
    private RadioButton rad1;
    private RadioButton rad2;
    private RadioButton rad3;
    private Button btnConfirmNext;
    public TextView txtKeyAnswerTrue;


    private ColorStateList textColorDefaultRb;
    private ColorStateList textColorDefaultCd;
    private CountDownTimer countDownTimer;
    private long timeLeftInMillis;


    private ArrayList<VatLy1Question> questionList;
    private int questionCounter;// bộ đếm câu hỏi
    private int questionCountTotal;// tổng số câu hỏi
    private VatLy1Question currentQuestion;
    private int score;
    private boolean answered;

    private long backPressdTime;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vat_ly1_quiz);

        txtQuestion = findViewById(R.id.txtQuestion);
        txtScore = findViewById(R.id.txtScore);
        txtCountDown = findViewById(R.id.txtCountDown);
        txtQuestionCount = findViewById(R.id.txtQuestionCount);
        txtCategory = findViewById(R.id.txtCategory);
        txtDifficulty = findViewById(R.id.txtDifficulty);
        radGroup = findViewById(R.id.radGroup);
        rad1 = findViewById(R.id.radButton1);
        rad2 = findViewById(R.id.radButton2);
        rad3 = findViewById(R.id.radButton3);
        btnConfirmNext = findViewById(R.id.btnConfirmNext);
        txtKeyAnswerTrue  = findViewById(R.id.txtKeyAnswerTrue);

        textColorDefaultRb = rad1.getTextColors();
        textColorDefaultCd = txtCountDown.getTextColors();

        Intent intent = getIntent();
        int categoryId = intent.getIntExtra(VatLy1OnTap.EXTRA_CATEGORY_ID, 0);
        String categoryName = intent.getStringExtra(VatLy1OnTap.EXTRA_CATEGORY_NAME);
        String difficulty = intent.getStringExtra(VatLy1OnTap.EXTRA_DIFFICULTY);

        txtCategory.setText("Chương: " + categoryName);
        txtDifficulty.setText("Mức độ: " + difficulty);
        if (savedInstanceState == null) {
            VatLy1QuizDbHelper dbHelper = VatLy1QuizDbHelper.getInstace(this);// chỗ này sửa lại từ nguyên mẫu, vì để dạng instance
            questionList = dbHelper.getQuestions(categoryId, difficulty);// chèn độ khó
            questionCountTotal = questionList.size();
            Collections.shuffle(questionList);
            showNextQuestion();
        } else {
            questionList = savedInstanceState.getParcelableArrayList(KEY_QUESTION_LIST);
            questionCountTotal = questionList.size();
            questionCounter = savedInstanceState.getInt(KEY_QUESTION_COUNT);
            currentQuestion = questionList.get(questionCounter - 1);
            score = savedInstanceState.getInt(KEY_SCORE);
            timeLeftInMillis = savedInstanceState.getLong(KEY_MILLIS_LEFT);
            answered = savedInstanceState.getBoolean(KEY_ANSWERED);

            if (!answered) {
                startCountDown();
            } else {
                updateCountDownText();
                showSolution();
            }
        }
        btnConfirmNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!answered) {
                    if (rad1.isChecked() || rad2.isChecked() || rad3.isChecked()) {
                        checkAnswer();
                    } else {
                        Toast.makeText(VatLy1QuizActivity.this, "Vui lòng chọn đáp án !", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    showNextQuestion();// câu hỏi tiếp theo
                }
            }
        });

    }

    // hàm hiển thị câu hỏi tiếp theo
    private void showNextQuestion() {
        txtKeyAnswerTrue.setText(" ");
        txtQuestion.setBackgroundColor(Color.rgb(221,221,221));// thêm mới, đổi lại màu của câu hỏi
        rad1.setTextColor(textColorDefaultRb);
        rad2.setTextColor(textColorDefaultRb);
        rad3.setTextColor(textColorDefaultRb);
        radGroup.clearCheck();
        if (questionCounter < questionCountTotal) {// nếu vẫn còn câu hỏi

            currentQuestion = questionList.get(questionCounter);

            txtQuestion.setText(currentQuestion.getQuestion());// hiển thị câu hỏi tiếp theo
            rad1.setText(currentQuestion.getOption1());
            rad2.setText(currentQuestion.getOption2());
            rad3.setText(currentQuestion.getOption3());
            questionCounter++;// tăng bộ đếm
            txtQuestionCount.setText("Câu hỏi: " + questionCounter + "/" + questionCountTotal);
            answered = false;
            btnConfirmNext.setBackgroundColor(Color.YELLOW);
            btnConfirmNext.setText("XÁC NHẬN");
            timeLeftInMillis = COUNTDOWN_IN_MILLIS;
            startCountDown();

        } else {
            finishQuiz();
        }
    }

    // bộ đếm thời gian
    private void startCountDown() {
        countDownTimer = new CountDownTimer(timeLeftInMillis, 1000) {
            @Override
            public void onTick(long l) {
                timeLeftInMillis = l;
                updateCountDownText();
            }

            @Override
            public void onFinish() {
                timeLeftInMillis = 0;
                updateCountDownText();
                checkAnswer();
            }
        }.start();
    }

    // định dạng bộ đếm thời gian
    private void updateCountDownText() {
        int minutes = (int) (timeLeftInMillis / 1000) / 60;
        int seconds = (int) (timeLeftInMillis / 1000) % 60;

        String timeFormatted = String.format(Locale.getDefault(), "%02d:%02d", minutes, seconds);

        txtCountDown.setText(timeFormatted);
        if (timeLeftInMillis < 10000) {
            txtCountDown.setTextColor(Color.RED);
        } else {
            txtCountDown.setTextColor(textColorDefaultCd);
        }
    }

    // kiểm tra kết quả
    private void checkAnswer() {
        answered = true;
        countDownTimer.cancel();
        RadioButton rbSelected = findViewById(radGroup.getCheckedRadioButtonId());
        int answerNum = radGroup.indexOfChild(rbSelected) + 1;

        if (answerNum == currentQuestion.getAnswerNum()) {
            txtQuestion.setBackgroundColor(Color.GREEN);// nếu trả lời đúng sẽ có màu xanh
            score++;
            txtScore.setText("Điểm của bạn: " + score);
                }
        else{
            txtQuestion.setBackgroundColor(Color.RED);// trả lời sai
        }
        showSolution();


    }

    // hiển thị lời giải
    private void showSolution() {

        // đáp án nào đúng sẽ có màu xanh
        rad1.setTextColor(Color.RED);
        rad2.setTextColor(Color.RED);
        rad3.setTextColor(Color.RED);

        switch (currentQuestion.getAnswerNum()) {
            case 1:
                rad1.setTextColor(Color.GREEN);
                txtKeyAnswerTrue.setText("Đáp án đúng: A");
                break;
            case 2:
                rad2.setTextColor(Color.GREEN);
                txtKeyAnswerTrue.setText("Đáp án đúng: B");
                break;
            case 3:
                rad3.setTextColor(Color.GREEN);
                txtKeyAnswerTrue.setText("Đáp án đúng: C");
                break;


        }
        if (questionCounter < questionCountTotal) {
            btnConfirmNext.setText("Tiếp theo");
            btnConfirmNext.setBackgroundColor(Color.rgb(100, 132, 124));
        } else {
            txtScore.setBackgroundColor(Color.YELLOW);
            btnConfirmNext.setText("Hoàn thành");
            btnConfirmNext.setBackgroundColor(Color.CYAN);
        }
    }

    private void finishQuiz() {
        Intent resultIntent = new Intent();
        resultIntent.putExtra(EXTRA_SCORE, score);
        setResult(RESULT_OK, resultIntent);

        finish();
    }

    @Override
    public void onBackPressed() {

        if (backPressdTime + 1000 > System.currentTimeMillis()) {
            finishQuiz();
        } else {
            Toast.makeText(this, "Nhấn lại để thoát", Toast.LENGTH_SHORT).show();
        }
        backPressdTime = System.currentTimeMillis();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(KEY_SCORE, score);
        outState.putInt(KEY_QUESTION_COUNT, questionCounter);
        outState.putLong(KEY_MILLIS_LEFT, timeLeftInMillis);
        outState.putBoolean(KEY_ANSWERED, answered);
        outState.putParcelableArrayList(KEY_QUESTION_LIST, questionList);


    }
}