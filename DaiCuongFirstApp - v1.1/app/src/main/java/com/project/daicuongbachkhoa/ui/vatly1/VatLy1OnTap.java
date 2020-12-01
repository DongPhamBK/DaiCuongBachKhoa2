package com.project.daicuongbachkhoa.ui.vatly1;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.project.daicuongbachkhoa.R;

import java.util.List;


public class VatLy1OnTap extends AppCompatActivity {

    private static final int REQUEST_CODE_QUIZ = 1;
    public static final String EXTRA_DIFFICULTY = "extraDifficulty";
    public static final String EXTRA_CATEGORY_ID = "extraCategoryId";
    public static final String EXTRA_CATEGORY_NAME = "extraCategoryName";
    public static final String SHARED_PREFS = "sharedPrefs";
    public static final String KEY_HIGHSCORE = "keyHighscore";

    private TextView txtHighScore;
    private Spinner spCategory;
    private Spinner spDifficulty;
    private int highscore;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vat_ly1_on_tap);
        txtHighScore = findViewById(R.id.txtHighScore);
        spCategory = findViewById(R.id.spCategory);
        spDifficulty = findViewById(R.id.spDifficulty);


        loadCategories();
        loadDifficultyLevels();
        /*
        String[] difficultyLevels = Question.getAllDifficultyLevels();
        ArrayAdapter<String> adaperDifficulty = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,difficultyLevels);
        adaperDifficulty.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spDifficulty.setAdapter(adaperDifficulty);*/

        loadHighscore();
        Button btnStartQuiz = findViewById(R.id.btnStartQuiz);
        btnStartQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startQuiz();
            }
        });

        //QuizDbHelper.getInstace(this).addCategory();// cái này là mở rộng ứng dụng
    }

    // bắt đầu
    private void startQuiz() {

        VatLy1Category selectedCategory = (VatLy1Category) spCategory.getSelectedItem();
        int categoryId = selectedCategory.getId();
        String categoryName = selectedCategory.getName();
        String difficulty = spDifficulty.getSelectedItem().toString();
        Intent intent = new Intent(VatLy1OnTap.this, VatLy1QuizActivity.class);
        intent.putExtra(EXTRA_CATEGORY_ID, categoryId);// để lưu trữ trong máy !
        intent.putExtra(EXTRA_CATEGORY_NAME, categoryName);
        intent.putExtra(EXTRA_DIFFICULTY, difficulty);
        startActivityForResult(intent, REQUEST_CODE_QUIZ);
    }

    // cập nhật màn hình !
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE_QUIZ) {
            if (resultCode == RESULT_OK) {
                int score = data.getIntExtra(VatLy1QuizActivity.EXTRA_SCORE, 0);

                if (score > highscore) {

                    updateHighscore(score);
                }

            }
        }
    }

    //lấy chương
    private void loadCategories() {

        VatLy1QuizDbHelper dbHelper = VatLy1QuizDbHelper.getInstace(this);
        List<VatLy1Category> categories = dbHelper.getAllCategories();
        ArrayAdapter<VatLy1Category> adapterCategories = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, categories);
        adapterCategories.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spCategory.setAdapter(adapterCategories);
    }

    // lấy mức độ
    private void loadDifficultyLevels() {
        String[] difficultyLevels = VatLy1Question.getAllDifficultyLevels();
        ArrayAdapter<String> adaperDifficulty = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, difficultyLevels);
        adaperDifficulty.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spDifficulty.setAdapter(adaperDifficulty);
    }

    // Lấy điểm cao !
    private void loadHighscore() {
        SharedPreferences prefs = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        highscore = prefs.getInt(KEY_HIGHSCORE, 0);
        txtHighScore.setText("Điểm cao nhất: " + highscore);


    }

    // cập nhật điểm cao nhất !
    private void updateHighscore(int highscoreNew) {


        highscore = highscoreNew;// cập nhật điểm cao
        txtHighScore.setText("Điểm cao nhất: " + highscore);
        SharedPreferences prefs = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt(KEY_HIGHSCORE, highscore);
        editor.apply();
    }
}