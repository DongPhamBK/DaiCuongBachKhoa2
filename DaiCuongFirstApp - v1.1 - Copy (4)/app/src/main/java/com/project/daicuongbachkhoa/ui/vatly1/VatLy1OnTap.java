package com.project.daicuongbachkhoa.ui.vatly1;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;


import com.project.daicuongbachkhoa.R;

public class VatLy1OnTap extends AppCompatActivity {

    // khởi tạo các hằng
    private static final int REQUEST_CODE_QUIZ = 1;
    public static final String VL1_THEM_MUC_DO = "vL1ThemMucDo";
    public static final String VL1_THEM_CHUONG_ID = "vL1ThemChuongId";
    public static final String VL1_THEM_CHUONG_NAME = "vL1ThemChuongName";
    public static final String VL1_SHARED_PREFS  = "vL1SharedPrefs";
    public static final String VL1_KEY_DIEM_CAO = "vL1KeyDiemCao";

    private TextView txtVL1DiemCao;
    private Spinner spVL1Chuong;
    private Spinner spVL1MucDo;

    private int vL1DiemCao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vat_ly1_on_tap);
        txtVL1DiemCao = findViewById(R.id.txtVL1DiemCao);
        spVL1Chuong = findViewById(R.id.spVL1Chuong);
        spVL1MucDo = findViewById(R.id.spVL1MucDo);

        loadVL1NhieuChuong();
        loadVL1NhieuMucDo();
        loadVL1DiemCao();

        Button btnVL1BatDau = findViewById(R.id.btnVL1BatDau);
        btnVL1BatDau.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vl1BatDau();
            }
        });
    }

    private void vl1BatDau(){

        VatLy1Chuong chonChuong = (VatLy1Chuong) spVL1Chuong.getSelectedItem();
        int chuongId = chonChuong.getId();
        String chuongName = chonChuong.getName();
        String mucDo  = spVL1MucDo.getSelectedItem().toString();

        Intent intent = new Intent(VatLy1OnTap.this, VatLy1QuizActivity.class);
        intent.putExtra(VL1_THEM_CHUONG_ID,chuongId);
        intent.putExtra(VL1_THEM_CHUONG_NAME,chuongName);
        intent.putExtra(VL1_THEM_MUC_DO,mucDo);
        startActivityForResult(intent,REQUEST_CODE_QUIZ);
        //startActivity(intent);// chuyển sang trang test nhanh
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == REQUEST_CODE_QUIZ){
            if(resultCode == RESULT_OK){
                int diem = data.getIntExtra(VatLy1QuizActivity.)
            }
        }
    }
}