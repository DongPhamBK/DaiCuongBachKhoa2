package com.project.daicuongbachkhoa.ui.point;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class PointViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public PointViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Đây là mục tính điểm");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
