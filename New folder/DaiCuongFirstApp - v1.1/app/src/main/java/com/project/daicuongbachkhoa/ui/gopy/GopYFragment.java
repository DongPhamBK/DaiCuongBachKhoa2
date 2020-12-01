package com.project.daicuongbachkhoa.ui.gopy;

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

public class GopYFragment extends Fragment {


    Button btnFace,btnEmail;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_gopy, container, false);

        btnFace = view.findViewById(R.id.btnFace);
        btnFace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openUrlLink("https://www.facebook.com/profile.php?id=100012086771102");
            }
        });

        btnEmail  = view.findViewById(R.id.btnEmail);
        btnEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openUrlLink("https://mail.google.com/mail/u/0/?tab=rm#inbox");
            }
        });
        return view;
    }

    public void openUrlLink(String url) {
        Uri uri = Uri.parse(url);
        Intent goFace = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(goFace);
    }
}

