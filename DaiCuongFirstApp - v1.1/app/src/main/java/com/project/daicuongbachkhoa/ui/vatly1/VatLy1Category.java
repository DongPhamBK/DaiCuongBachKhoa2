package com.project.daicuongbachkhoa.ui.vatly1;

public class VatLy1Category {

    // lưu các chương của môn học
    public static final int CHUONG1 = 1;
    public static final int CHUONG2 = 2;
    public static final int CHUONG3 = 3;

    private int id;
    private String name;

    public VatLy1Category() {
    }

    // khởi tạo chương
    public VatLy1Category(String name) {
        this.name = name;
    }

    public VatLy1Category(int id, String name) {
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

    // trả về tên
    @Override
    public String toString() {
        return getName();
    }
}
