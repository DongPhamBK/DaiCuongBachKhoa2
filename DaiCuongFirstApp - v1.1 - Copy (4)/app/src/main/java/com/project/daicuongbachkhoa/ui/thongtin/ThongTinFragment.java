package com.project.daicuongbachkhoa.ui.thongtin;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.project.daicuongbachkhoa.R;

public class ThongTinFragment extends Fragment {

    Button btnBlog;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_tacgia, container, false);

        btnBlog = view.findViewById(R.id.btnBlog);
        btnBlog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openBlog("https://ptdonghust.blogspot.com");
            }
        });
        return view;
    }

    private void openBlog(String url) {
        Uri uri = Uri.parse(url);
        Intent goWeb = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(goWeb);
    }
}