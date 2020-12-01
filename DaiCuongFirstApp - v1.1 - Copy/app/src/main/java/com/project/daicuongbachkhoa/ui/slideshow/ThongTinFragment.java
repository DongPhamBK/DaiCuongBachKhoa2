package com.project.daicuongbachkhoa.ui.slideshow;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.project.daicuongbachkhoa.R;

public class ThongTinFragment extends Fragment {

    //private SlideshowViewModel slideshowViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
      /*  slideshowViewModel =
                ViewModelProviders.of(this).get(SlideshowViewModel.class);*/
        View root = inflater.inflate(R.layout.fragment_thongtin, container, false);
       /* final TextView textView = root.findViewById(R.id.text_slideshow);
        slideshowViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });*/
        return root;
    }
}