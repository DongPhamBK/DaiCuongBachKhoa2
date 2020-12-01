package com.project.quizapptest;

//tạo các hằng số cần thiết
import android.provider.BaseColumns;

public  final  class QuizContract {
    public QuizContract() {
    }

    public static  class QuestionTable implements BaseColumns {
        //bảng câu hỏi
        public static  final  String TABLE_NAME = "quiz_questions";
        public static  final  String COLUMN_QUESTION = "question";
        public static  final  String COLUMN_OPTION1 = "option1";
        public static  final  String COLUMN_OPTION2 = "option2";
        public static  final  String COLUMN_OPTION3 = "option3";
        public static  final  String COLUMN_ANSWER_NUM = "answer_num";
        public static  final  String COLUMN_DIFFICULTY = "difficulty";




    }

}