package com.project.daicuongbachkhoa.ui.home;

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
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.project.daicuongbachkhoa.R;
import com.project.daicuongbachkhoa.ui.daiso.DaiSoFragment;
import com.project.daicuongbachkhoa.ui.vatly1.VatLy1Fragment;

public class HomeFragment extends Fragment {

    Button btnDaiSo;
    Button btnVatLy1;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        btnDaiSo = view.findViewById(R.id.btnDaiSo);
        btnDaiSo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(getActivity(), "Bạn đã chọn môn DS", Toast.LENGTH_LONG).show();
                DaiSoFragment daiSoFragment = new DaiSoFragment();
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.nav_host_fragment, daiSoFragment);
                // tuyệt vời !!!
                fragmentTransaction.addToBackStack(null);  // if written, this transaction will be added to backstack
                fragmentTransaction.commit();
            }
        });

        btnVatLy1 = view.findViewById(R.id.btnVatLy1);
        btnVatLy1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                VatLy1Fragment vatLy1Fragment = new VatLy1Fragment();
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.nav_host_fragment,vatLy1Fragment);
                fragmentTransaction.addToBackStack(null);  // if written, this transaction will be added to backstack
                fragmentTransaction.commit();
            }
        });

        return view;
    }
}