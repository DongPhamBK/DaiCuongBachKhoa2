package com.project.daicuongbachkhoa.ui.vatly1;

public class VatLy1Chuong {

    public static final int CHUONG1 = 1;
    public static final int CHUONG2 = 2;
    public static final int CHUONG3 = 3;

    private int id;
    private String name;

    public VatLy1Chuong() {
    }

    public VatLy1Chuong(String name) {
        this.name = name;
    }

    public VatLy1Chuong(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return getName();
    }
}
