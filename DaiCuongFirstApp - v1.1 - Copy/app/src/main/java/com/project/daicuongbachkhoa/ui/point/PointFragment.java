package com.project.daicuongbachkhoa.ui.point;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
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

    //public PointViewModel pointViewModel;

    EditText txtGiuaKi, txtCuoiKi, txtHs1, txtHs2;
    TextView txtKq;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
      /*  pointViewModel =
                ViewModelProviders.of(this).get(PointViewModel.class);*/
        final View view = inflater.inflate(R.layout.fragment_point, container, false);
       /* final TextView textView = root.findViewById(R.id.text_point);
        pointViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });*/

        Button btnKq = view.findViewById(R.id.btnKq);
        btnKq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                txtCuoiKi = view.findViewById(R.id.txtCuoiKi);
                txtGiuaKi = view.findViewById(R.id.txtGiuaKi);
                txtHs1 = view.findViewById(R.id.txtHs1);
                txtHs2 = view.findViewById(R.id.txtHs2);
                txtKq = view.findViewById(R.id.txtKq);

                try {
                    // chuyển dạng số thập phân
                    float giuaKi =0;giuaKi = Float.parseFloat(txtGiuaKi.getText().toString());
                    float cuoiKi =0;cuoiKi =  Float.parseFloat(txtCuoiKi.getText().toString());
                    float hs1 = Float.parseFloat(txtHs1.getText().toString());
                    float hs2 = Float.parseFloat(txtHs2.getText().toString());
                    float kq = giuaKi * hs1 + cuoiKi * hs2;
                    String strKq = String.valueOf(kq);
                    // hiện ra màn hình
                    txtKq.setText("Kết quả của bạn: "+ strKq);
                    Toast.makeText(getActivity(), "Cố gắng đạt mục tiêu nhé ! ", Toast.LENGTH_LONG).show();
                }catch (Exception e){
                    txtKq.setText("Hmmm ! Có vẻ bạn chưa nhập đủ điểm và trọng số !");
                    Toast.makeText(getActivity(), "Vui lòng nhập đủ thông tin ! ", Toast.LENGTH_LONG).show();
                }


            }
        });
        return view;


    }
}
