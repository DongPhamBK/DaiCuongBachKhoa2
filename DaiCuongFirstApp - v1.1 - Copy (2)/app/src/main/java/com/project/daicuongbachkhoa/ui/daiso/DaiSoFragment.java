package com.project.daicuongbachkhoa.ui.daiso;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.project.daicuongbachkhoa.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DaiSoFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DaiSoFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    Button btnDaiSoLyThuyet;
    Button btnDaiSoBaiTap;
    Button btnDaiSoDeThi;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public DaiSoFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment DaiSoFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static DaiSoFragment newInstance(String param1, String param2) {
        DaiSoFragment fragment = new DaiSoFragment();
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
        View view = inflater.inflate(R.layout.fragment_daiso, container, false);

        btnDaiSoLyThuyet = view.findViewById(R.id.btnDaiSoLyThuyet);
        btnDaiSoLyThuyet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Toast.makeText(getActivity(),"Ban da chon Ly thuyet",Toast.LENGTH_LONG).show();
                DaiSoLyThuyetFragment daiSoLyThuyetFragment = new DaiSoLyThuyetFragment();
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.nav_host_fragment, daiSoLyThuyetFragment);
                // gần như đều dùng nav_host_fragment, mình hiểu đây là vùng nền !
                fragmentTransaction.addToBackStack(null);  // if written, this transaction will be added to backstack
                fragmentTransaction.commit();
            }
        });

        btnDaiSoBaiTap = view.findViewById(R.id.btnDaiSoBaiTap);
        btnDaiSoBaiTap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DaiSoBaiTapFragment daiSoBaiTapFragment = new DaiSoBaiTapFragment();
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.nav_host_fragment, daiSoBaiTapFragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();

            }
        });

        btnDaiSoDeThi = view.findViewById(R.id.btnDaiSoDeThi);
        btnDaiSoDeThi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DaiSoDeThiFragment daiSoDeThiFragment = new DaiSoDeThiFragment();
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.nav_host_fragment,daiSoDeThiFragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });
        return view;
    }
}