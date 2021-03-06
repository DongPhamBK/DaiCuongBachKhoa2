package com.project.daicuongbachkhoa.ui.vatly1;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.project.daicuongbachkhoa.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link VatLy1Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class VatLy1Fragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    Button btnVatLy1TracNghiem;
    Button btnVatLy1DeThi;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public VatLy1Fragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment VatLy1Fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static VatLy1Fragment newInstance(String param1, String param2) {
        VatLy1Fragment fragment = new VatLy1Fragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_vat_ly1, container, false);

        btnVatLy1TracNghiem = view.findViewById(R.id.btnVatLy1TracNghiem);
        btnVatLy1TracNghiem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                VatLy1TracNghiemFragment vatLy1TracNghiemFragment = new VatLy1TracNghiemFragment();
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.nav_host_fragment,vatLy1TracNghiemFragment);
                fragmentTransaction.addToBackStack(null);  // if written, this transaction will be added to backstack
                fragmentTransaction.commit();
            }
        });


        btnVatLy1DeThi = view.findViewById(R.id.btnVatLy1DeThi);
        btnVatLy1DeThi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DSDeThiVatLyFragment dsDeThiVatLyFragment =  new DSDeThiVatLyFragment();
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.nav_host_fragment,dsDeThiVatLyFragment);
                fragmentTransaction.addToBackStack(null);  // if written, this transaction will be added to backstack
                fragmentTransaction.commit();
            }
        });
        return view;
    }
}