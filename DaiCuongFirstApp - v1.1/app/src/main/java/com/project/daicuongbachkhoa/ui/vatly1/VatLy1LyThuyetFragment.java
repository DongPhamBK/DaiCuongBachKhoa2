package com.project.daicuongbachkhoa.ui.vatly1;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.project.daicuongbachkhoa.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link VatLy1LyThuyetFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class VatLy1LyThuyetFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    int n[] = {R.drawable.vl1lt00, R.drawable.vl1lt01, R.drawable.vl1lt02, R.drawable.vl1lt03, R.drawable.vl1lt04, R.drawable.vl1lt05};
    int i = 0;

    Button btnVatLy1LT2;
    Button btnVatLy1LT1;
    ImageView imgVatLy1LT;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public VatLy1LyThuyetFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment VatLy1LyThuyetFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static VatLy1LyThuyetFragment newInstance(String param1, String param2) {
        VatLy1LyThuyetFragment fragment = new VatLy1LyThuyetFragment();
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
        View view = inflater.inflate(R.layout.fragment_vat_ly1_ly_thuyet, container, false);

        btnVatLy1LT1 = view.findViewById(R.id.btnVatLy1LT1);
        btnVatLy1LT2 = view.findViewById(R.id.btnVatLy1LT2);
        imgVatLy1LT = view.findViewById(R.id.imgVatLy1LT);


        /*    Đoạn này xử lí cũ thôi !*/
        btnVatLy1LT1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                prev();// tôi đánh giá đoạn này hay !!!
            }
        });

        btnVatLy1LT2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //Toast.makeText(getActivity(),"Test",Toast.LENGTH_LONG).show();
                next();

            }
        });


        // hay thực sự khi mà thiết lập View, có thể sửa chữa rất nhiều lỗi hệ thống !
        return view;
        //return inflater.inflate(R.layout.fragment_vat_ly1_ly_thuyet, container, false);
    }


    private void prev() {
        if (i > 0) {
            i--;
            imgVatLy1LT.setImageResource(n[i]);// cũng là 1 cách !
        } else {
            i = n.length;
            Toast.makeText(getActivity(),"Nhấn 1 lần nữa !",Toast.LENGTH_SHORT).show();
        }
    }

    private void next() {
        if (i < n.length - 1) {
            i++;
            imgVatLy1LT.setImageResource(n[i]);// cũng là 1 cách !
        } else {
            i = -1;
            Toast.makeText(getActivity(),"Nhấn 1 lần nữa !",Toast.LENGTH_SHORT).show();
        }
    }


}