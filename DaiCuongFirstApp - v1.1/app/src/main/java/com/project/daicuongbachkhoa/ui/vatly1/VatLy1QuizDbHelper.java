package com.project.daicuongbachkhoa.ui.vatly1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

import com.project.daicuongbachkhoa.R;
import com.project.daicuongbachkhoa.ui.vatly1.VatLy1QuizContract.*;

import java.util.ArrayList;
import java.util.List;

// sử dụng class với SQLite
public class VatLy1QuizDbHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "VatLy1OnTapQuiz.db";// tạo database
    private static final int DATABASE_VERSION = 1;// PHIÊN BẢN
    private static VatLy1QuizDbHelper instace;

    private SQLiteDatabase db;// tạo database sqlite

    private VatLy1QuizDbHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public static synchronized VatLy1QuizDbHelper getInstace(Context context){
        if(instace == null){
            instace =  new VatLy1QuizDbHelper(context.getApplicationContext());
        }
        return instace;
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        this.db = db;

        final String SQL_CREATE_CATEGORIES_TABLE = "CREATE TABLE " +
                CategoriesTable.TABLE_NAME + "( " +
                CategoriesTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                CategoriesTable.COLUMN_NAME + " TEXT " +
                ")";
        final String SQL_CREATE_QUESTIONS_TABLE = "CREATE TABLE " +
                QuestionTable.TABLE_NAME + " ( " +
                QuestionTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                QuestionTable.COLUMN_QUESTION + " TEXT, " +
                QuestionTable.COLUMN_OPTION1 + " TEXT, " +
                QuestionTable.COLUMN_OPTION2 + " TEXT, " +
                QuestionTable.COLUMN_OPTION3 + " TEXT, " +
                QuestionTable.COLUMN_ANSWER_NUM + " INTEGER, " +
                QuestionTable.COLUMN_DIFFICULTY + " TEXT, " +
                QuestionTable.COLUMN_CATEGORY_ID + " INTEGER," +
                "FOREIGN KEY(" + QuestionTable.COLUMN_CATEGORY_ID + ") REFERENCES " +
                CategoriesTable.TABLE_NAME + "(" + CategoriesTable._ID + ")" + "ON DELETE CASCADE" +
                ")";
        db.execSQL(SQL_CREATE_CATEGORIES_TABLE);
        db.execSQL(SQL_CREATE_QUESTIONS_TABLE);
        fillCategoriesTable();
        fillQuestionsTable();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        // chú ý lệnh sql cần chính xác
        db.execSQL("DROP TABLE IF EXISTS " + CategoriesTable.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + QuestionTable.TABLE_NAME);
        onCreate(db);
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void onConfigure(SQLiteDatabase db) {
        super.onConfigure(db);
        db.setForeignKeyConstraintsEnabled(true);
        // cái này nó bắt api cái trên, khi nào lỗi thì cần xem lại !
        /*

        ***********************************


        NHỚ KIỂM TRA LẠI CHỖ NÀY NHÉ !


        ********************************


         */
    }

    //bảng chương học
    private void fillCategoriesTable() {
        VatLy1Category c1 = new VatLy1Category("Động học chất điểm");
        insertCategory(c1);
        VatLy1Category c2 = new VatLy1Category("Động lực học chất điểm");
        insertCategory(c2);
        VatLy1Category c3 = new VatLy1Category("Động lực học vật rắn");
        insertCategory(c3);
    }

    public void addCategory(VatLy1Category category){
        db = getWritableDatabase();
        insertCategory(category);
    }

    public void addCategories(List<VatLy1Category> categories ){
        db = getWritableDatabase();
        for(VatLy1Category category:categories){
            insertCategory(category);
        }
    }

    private void insertCategory(VatLy1Category category) {
        
        ContentValues cv = new ContentValues();
        cv.put(CategoriesTable.COLUMN_NAME, category.getName());
        db.insert(CategoriesTable.TABLE_NAME, null, cv);

    }


    // bảng phương án
    private void fillQuestionsTable() {
        VatLy1Question q1 = new VatLy1Question("Trường hợp nào dưới đây có thể coi vật chuyển động như một chất điểm ?", "A.Chiếc ô tô trong bến xe.", "B.Mặt Trăng quanh Trái Đất", "C.Con cá trong chậu", 2, VatLy1Question.DIFFICULTY_EASY, VatLy1Category.CHUONG1);
        insertQuestion(q1);
        VatLy1Question q2 = new VatLy1Question("Nếu nói \"Trái Đất quay quanh Mặt Trời\" thì trong câu nói này vật nào được chọn làm vật mốc?", "A.Trái Đất", "B.Mặt Trăng", "C.Mặt Trời", 3, VatLy1Question.DIFFICULTY_EASY, VatLy1Category.CHUONG1);
        insertQuestion(q2);
        VatLy1Question q3 = new VatLy1Question("Hệ quy chiếu gồm:", "A.Vật làm mốc, hệ toạ độ, mốc thời gian.", "B.Hệ toạ độ, mốc thời gian, đồng hồ.", "C.Vật làm mốc, hệ toạ độ, mốc thời gian và đồng hồ.", 3, VatLy1Question.DIFFICULTY_EASY, VatLy1Category.CHUONG1);
        insertQuestion(q3);
        VatLy1Question q4 = new VatLy1Question("Công thức tính vận tốc", "A. v = s/t", "B. v = t/s", "C. v = s*t", 1, VatLy1Question.DIFFICULTY_EASY, VatLy1Category.CHUONG1);
        insertQuestion(q4);
        VatLy1Question q5 = new VatLy1Question("Công thức quãng đường đi được của chuyển động thẳng nhanh dần đều là:", "A. s = v0t + at2/2 (a và v0 cùng dấu).", "B. s = v0t + at2/2 (a và v0 trái dấu).", "C. x = x0 + v0t + at2/2 (a và v0 trái dấu).", 1, VatLy1Question.DIFFICULTY_MEDIUM, VatLy1Category.CHUONG1);
        insertQuestion(q5);
        VatLy1Question q6 = new VatLy1Question("Tại một nơi nhất định trên Trái Đất và ở gần mặt đất, các vật đều rơi tự do với:", "A.Cùng một gia tốc g.", "B.Gia tốc khác nhau.", "C.Gia tốc bằng 0", 1, VatLy1Question.DIFFICULTY_MEDIUM, VatLy1Category.CHUONG1);
        insertQuestion(q6);

        VatLy1Question q7 = new VatLy1Question("Trường hợp nào dưới đây có thể coi vật chuyển động như một chất điểm ?", "A.Chiếc ô tô trong bến xe.", "B.Mặt Trăng quanh Trái Đất", "C.Con cá trong chậu", 2, VatLy1Question.DIFFICULTY_MEDIUM, VatLy1Category.CHUONG1);
        insertQuestion(q7);
        VatLy1Question q8 = new VatLy1Question("Nếu nói \"Trái Đất quay quanh Mặt Trời\" thì trong câu nói này vật nào được chọn làm vật mốc?", "A.Trái Đất", "B.Mặt Trăng", "C.Mặt Trời", 3, VatLy1Question.DIFFICULTY_MEDIUM, VatLy1Category.CHUONG1);
        insertQuestion(q8);
        VatLy1Question q9 = new VatLy1Question("Hệ quy chiếu gồm:", "A.Vật làm mốc, hệ toạ độ, mốc thời gian.", "B.Hệ toạ độ, mốc thời gian, đồng hồ.", "C.Vật làm mốc, hệ toạ độ, mốc thời gian và đồng hồ.", 3, VatLy1Question.DIFFICULTY_MEDIUM, VatLy1Category.CHUONG1);
        insertQuestion(q9);
        VatLy1Question q10 = new VatLy1Question("Công thức tính vận tốc", "A. v = s/t", "B. v = t/s", "C. v = s*t", 1, VatLy1Question.DIFFICULTY_MEDIUM, VatLy1Category.CHUONG1);
        insertQuestion(q10);
        VatLy1Question q11 = new VatLy1Question("Công thức quãng đường đi được của chuyển động thẳng nhanh dần đều là:", "A. s = v0t + at2/2 (a và v0 cùng dấu).", "B. s = v0t + at2/2 (a và v0 trái dấu).", "C. x = x0 + v0t + at2/2 (a và v0 trái dấu).", 1, VatLy1Question.DIFFICULTY_MEDIUM, VatLy1Category.CHUONG1);
        insertQuestion(q11);
        VatLy1Question q12 = new VatLy1Question("Tại một nơi nhất định trên Trái Đất và ở gần mặt đất, các vật đều rơi tự do với:", "A.Cùng một gia tốc g.", "B.Gia tốc khác nhau.", "C.Gia tốc bằng 0", 1, VatLy1Question.DIFFICULTY_MEDIUM, VatLy1Category.CHUONG1);
        insertQuestion(q12);

        VatLy1Question q13 = new VatLy1Question("Trường hợp nào dưới đây có thể coi vật chuyển động như một chất điểm ?", "A.Chiếc ô tô trong bến xe.", "B.Mặt Trăng quanh Trái Đất", "C.Con cá trong chậu", 2, VatLy1Question.DIFFICULTY_HARD, VatLy1Category.CHUONG1);
        insertQuestion(q13);
        VatLy1Question q14 = new VatLy1Question("Nếu nói \"Trái Đất quay quanh Mặt Trời\" thì trong câu nói này vật nào được chọn làm vật mốc?", "A.Trái Đất", "B.Mặt Trăng", "C.Mặt Trời", 3, VatLy1Question.DIFFICULTY_HARD, VatLy1Category.CHUONG1);
        insertQuestion(q14);
        VatLy1Question q15 = new VatLy1Question("Hệ quy chiếu gồm:", "A.Vật làm mốc, hệ toạ độ, mốc thời gian.", "B.Hệ toạ độ, mốc thời gian, đồng hồ.", "C.Vật làm mốc, hệ toạ độ, mốc thời gian và đồng hồ.", 3, VatLy1Question.DIFFICULTY_HARD, VatLy1Category.CHUONG1);
        insertQuestion(q15);
        VatLy1Question q16 = new VatLy1Question("Công thức tính vận tốc", "A. v = s/t", "B. v = t/s", "C. v = s*t", 1, VatLy1Question.DIFFICULTY_HARD, VatLy1Category.CHUONG1);
        insertQuestion(q16);
        VatLy1Question q17 = new VatLy1Question("Công thức quãng đường đi được của chuyển động thẳng nhanh dần đều là:", "A. s = v0t + at2/2 (a và v0 cùng dấu).", "B. s = v0t + at2/2 (a và v0 trái dấu).", "C. x = x0 + v0t + at2/2 (a và v0 trái dấu).", 1, VatLy1Question.DIFFICULTY_HARD, VatLy1Category.CHUONG1);
        insertQuestion(q17);
        VatLy1Question q18 = new VatLy1Question("Tại một nơi nhất định trên Trái Đất và ở gần mặt đất, các vật đều rơi tự do với:", "A.Cùng một gia tốc g.", "B.Gia tốc khác nhau.", "C.Gia tốc bằng 0", 1, VatLy1Question.DIFFICULTY_HARD, VatLy1Category.CHUONG1);
        insertQuestion(q18);


    }


    public void addQuestion(VatLy1Question question){
        db = getWritableDatabase();
        insertQuestion(question);
    }

    public void addQuestions(List<VatLy1Question> questions){
        db = getWritableDatabase();
        for(VatLy1Question question:questions){
            insertQuestion(question);
        }
    }

    private void insertQuestion(VatLy1Question question) {
        ContentValues cv = new ContentValues();
        cv.put(QuestionTable.COLUMN_QUESTION, question.getQuestion());
        cv.put(QuestionTable.COLUMN_OPTION1, question.getOption1());
        cv.put(QuestionTable.COLUMN_OPTION2, question.getOption2());
        cv.put(QuestionTable.COLUMN_OPTION3, question.getOption3());
        cv.put(QuestionTable.COLUMN_ANSWER_NUM, question.getAnswerNum());
        cv.put(QuestionTable.COLUMN_DIFFICULTY, question.getDifficulty());
        cv.put(QuestionTable.COLUMN_CATEGORY_ID, question.getCategoryId());
        db.insert(QuestionTable.TABLE_NAME, null, cv);
    }

    public List<VatLy1Category> getAllCategories() {
        List<VatLy1Category> categoryList = new ArrayList<>();
        db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM " + CategoriesTable.TABLE_NAME, null);
        if (c.moveToFirst()) {
            do {
                VatLy1Category category = new VatLy1Category();
                category.setId(c.getInt(c.getColumnIndex(CategoriesTable._ID)));
                category.setName(c.getString(c.getColumnIndex(CategoriesTable.COLUMN_NAME)));
                categoryList.add(category);

            } while (c.moveToNext());
        }
        c.close();
        return categoryList;
    }

    // nhập list câu hỏi
    public ArrayList<VatLy1Question> getAllQuestions() {
        ArrayList<VatLy1Question> questionList = new ArrayList<>();
        db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM " + QuestionTable.TABLE_NAME, null);

        if (c.moveToFirst()) {
            do {
                VatLy1Question question = new VatLy1Question();
                question.setId(c.getInt(c.getColumnIndex(QuestionTable._ID)));
                question.setQuestion(c.getString(c.getColumnIndex(QuestionTable.COLUMN_QUESTION)));
                question.setOption1(c.getString(c.getColumnIndex(QuestionTable.COLUMN_OPTION1)));
                question.setOption2(c.getString(c.getColumnIndex(QuestionTable.COLUMN_OPTION2)));
                question.setOption3(c.getString(c.getColumnIndex(QuestionTable.COLUMN_OPTION3)));
                question.setAnswerNum(c.getInt(c.getColumnIndex(QuestionTable.COLUMN_ANSWER_NUM)));
                question.setDifficulty(c.getString(c.getColumnIndex(QuestionTable.COLUMN_DIFFICULTY)));
                question.setCategoryId(c.getInt(c.getColumnIndex(QuestionTable.COLUMN_CATEGORY_ID)));
                questionList.add(question);

            } while (c.moveToNext());
        }
        c.close();// đừng quên khoá lại !
        return questionList;

    }

    public ArrayList<VatLy1Question> getQuestions(int categoryId, String difficulty) {
        ArrayList<VatLy1Question> questionList = new ArrayList<>();
        db = getReadableDatabase();

        String selection = QuestionTable.COLUMN_CATEGORY_ID + " = ? " +
                " AND " + QuestionTable.COLUMN_DIFFICULTY + " = ? ";
        String[] selectionArgs = new String[]{String.valueOf(categoryId),difficulty};
        Cursor c = db.query(
                QuestionTable.TABLE_NAME,
                null,
                selection,
                selectionArgs,
                null,
                null,
                null
        );

       /* String[] selectionArgs = new String[]{difficulty};
        Cursor c = db.rawQuery("SELECT * FROM " + QuestionTable.TABLE_NAME +
                " WHERE " + QuestionTable.COLUMN_DIFFICULTY + " = ?", selectionArgs);
*/

        if (c.moveToFirst()) {
            do {
                VatLy1Question question = new VatLy1Question();
                question.setId(c.getInt(c.getColumnIndex(QuestionTable._ID)));
                question.setQuestion(c.getString(c.getColumnIndex(QuestionTable.COLUMN_QUESTION)));
                question.setOption1(c.getString(c.getColumnIndex(QuestionTable.COLUMN_OPTION1)));
                question.setOption2(c.getString(c.getColumnIndex(QuestionTable.COLUMN_OPTION2)));
                question.setOption3(c.getString(c.getColumnIndex(QuestionTable.COLUMN_OPTION3)));
                question.setAnswerNum(c.getInt(c.getColumnIndex(QuestionTable.COLUMN_ANSWER_NUM)));
                question.setDifficulty(c.getString(c.getColumnIndex(QuestionTable.COLUMN_DIFFICULTY)));
                question.setCategoryId(c.getInt(c.getColumnIndex(QuestionTable.COLUMN_CATEGORY_ID)));
                questionList.add(question);
            } while (c.moveToNext());
        }
        c.close();// đừng quên khoá lại !
        return questionList;

    }
}
