package com.project.daicuongbachkhoa.ui.vatly1;

import android.os.Parcel;
import android.os.Parcelable;


public class VatLy1CauHoi implements Parcelable {
    public static final String VL1_MUC_DO_DE = "Dễ";
    public static final String VL1_MUC_DO_VUA = "Vừa";
    public static final String VL1_MUC_DO_KHO = "Khó";


    private int id;// chuong
    private  String cauHoi;// câu hỏi
    private String option1;
    private String option2;
    private String option3;// lựa chọn
    private int traLoi;// câu trả lời
    private String doKho;// độ khó

    private int chuongId;

    public VatLy1CauHoi(){
    }

    public VatLy1CauHoi(String cauHoi, String option1, String option2, String option3, int traLoi, String doKho, int chuongId) {
        this.cauHoi = cauHoi;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.traLoi = traLoi;
        this.doKho = doKho;
        this.chuongId = chuongId;
    }

    protected VatLy1CauHoi(Parcel in) {
        id = in.readInt();
        cauHoi = in.readString();
        option1 = in.readString();
        option2 = in.readString();
        option3 = in.readString();
        traLoi = in.readInt();
        doKho = in.readString();
        chuongId = in.readInt();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(cauHoi);
        dest.writeString(option1);
        dest.writeString(option2);
        dest.writeString(option3);
        dest.writeInt(traLoi);
        dest.writeString(doKho);
        dest.writeInt(chuongId);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<VatLy1CauHoi> CREATOR = new Creator<VatLy1CauHoi>() {
        @Override
        public VatLy1CauHoi createFromParcel(Parcel in) {
            return new VatLy1CauHoi(in);
        }

        @Override
        public VatLy1CauHoi[] newArray(int size) {
            return new VatLy1CauHoi[size];
        }
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCauHoi() {
        return cauHoi;
    }

    public void setCauHoi(String cauHoi) {
        this.cauHoi = cauHoi;
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

    public int getTraLoi() {
        return traLoi;
    }

    public void setTraLoi(int traLoi) {
        this.traLoi = traLoi;
    }

    public String getDoKho() {
        return doKho;
    }

    public void setDoKho(String doKho) {
        this.doKho = doKho;
    }

    public int getChuongId() {
        return chuongId;
    }

    public void setChuongId(int chuongId) {
        this.chuongId = chuongId;
    }

    // hàm lấy mức độ câu hỏi, chính là getAllDifficultyLevels
    public static String[] getToanBoMucDo(){
        return new String[]{
                VL1_MUC_DO_DE,
                VL1_MUC_DO_VUA,
                VL1_MUC_DO_KHO
        };
    }
}
