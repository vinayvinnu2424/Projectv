package com.example.projectv.Fragments;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.projectv.R;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;


public class Bottom_sheet_Fragment extends BottomSheetDialogFragment {
    private FragmentActivity myContext;
    TextView txt_vinay;
    TextView txt_venkata;
    TextView txt_kumar;

    @Override
    public void onAttach(Activity activity) {
        myContext=(FragmentActivity) activity;
        super.onAttach(activity);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(STYLE_NORMAL, R.style. BottomSheetSearchDialogTheme);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_bottom_sheet_, container, false);
        txt_vinay = view.findViewById(R.id.txt_vinay);
        txt_venkata = view.findViewById(R.id.txt_venkata);
        txt_kumar = view.findViewById(R.id.txt_kumar);

        txt_vinay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(myContext, "vinay", Toast.LENGTH_SHORT).show();

            }
        });
        txt_venkata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(myContext, "venkata", Toast.LENGTH_SHORT).show();
            }
        });
        txt_kumar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(myContext, "kumar", Toast.LENGTH_SHORT).show();
            }
        });


        return view;

    }
}