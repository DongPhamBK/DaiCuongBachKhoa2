package com.project.quizapptest;

import android.os.Parcel;
import android.os.Parcelable;

// câu hỏi và các đáp án, trả lời
public class Question implements Parcelable {

    public static final String DIFFICULTY_EASY = "Easy";
    public static final String DIFFICULTY_MEDIUM = "Medium";
    public static final String DIFFICULTY_HARD = "Hard";


    private  String question;// câu hỏi
    private String option1;
    private String option2;
    private String option3;// lựa chọn
    private int answerNum;// câu trả lời
    private String difficulty;// độ khó


    public Question() {
    }

    public Question(String question, String option1, String option2, String option3, int answerNum,String difficulty) {
        this.question = question;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.answerNum = answerNum;
        this.difficulty = difficulty;
    }

    protected Question(Parcel in) {
        question = in.readString();
        option1 = in.readString();
        option2 = in.readString();
        option3 = in.readString();
        answerNum = in.readInt();
        difficulty = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(question);
        dest.writeString(option1);
        dest.writeString(option2);
        dest.writeString(option3);
        dest.writeInt(answerNum);
        dest.writeString(difficulty);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Question> CREATOR = new Creator<Question>() {
        @Override
        public Question createFromParcel(Parcel in) {
            return new Question(in);
        }

        @Override
        public Question[] newArray(int size) {
            return new Question[size];
        }
    };

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getOption1() {
        return option1;
    }

    public void setOption1(String option1) {
        this.option1 = option1;
    }

    public String getOption2() {
        return option2;
    }

    public void setOption2(String option2) {
        this.option2 = option2;
    }

    public String getOption3() {
        return option3;
    }

    public void setOption3(String option3) {
        this.option3 = option3;
    }

    public int getAnswerNum() {
        return answerNum;
    }

    public void setAnswerNum(int answerNum) {
        this.answerNum = answerNum;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public static String[] getAllDifficultyLevels(){
        return new String[]{
                DIFFICULTY_EASY,
                DIFFICULTY_MEDIUM,
                DIFFICULTY_HARD
        };
    }
}
