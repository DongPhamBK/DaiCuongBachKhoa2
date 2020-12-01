package com.project.daicuongbachkhoa.ui.vatly1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

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

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

import com.project.daicuongbachkhoa.R;

public class VatLy1QuizActivity extends AppCompatActivity {

    public static final String VL1_THEM_DIEM = "vL1ThemDiem";
    public static final long DEM_NGUOC_TIME = 30000;// thời gian lựa chọn đáp án

    public static final String VL1_KEY_DIEM = "vL1KeyDiem";
    public static final String VL1_KEY_DEM_CAU_HOI = "vL1DemCauHoi";
    public static final String VL1_KEY_DEM_GIAY = "vL1KeyDemGiay";
    public static final String VL1_KEY_TRA_LOI = "vL1KeyTraLoi";
    public static final String VL1_KEY_DANH_SACH_CAU_TRA_LOI =

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vat_ly1_quiz);
    }
}