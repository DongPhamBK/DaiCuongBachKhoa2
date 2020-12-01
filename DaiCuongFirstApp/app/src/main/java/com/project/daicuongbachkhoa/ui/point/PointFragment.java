package com.project.daicuongbachkhoa.ui.point;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.project.daicuongbachkhoa.R;
import com.project.daicuongbachkhoa.ui.home.HomeViewModel;

public class PointFragment extends Fragment {

    public PointViewModel pointViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        pointViewModel =
                ViewModelProviders.of(this).get(PointViewModel.class);
        View view = inflater.inflate(R.layout.fragment_point, container, false);
       /* final TextView textView = root.findViewById(R.id.text_point);
        pointViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });*/

       Button btnKq  = view.findViewById(R.id.btnKq);
       btnKq.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Toast.makeText(getActivity(),"Kết quả chính là đây !",Toast.LENGTH_LONG).show();
           }
       });
        return view;



    }
}
