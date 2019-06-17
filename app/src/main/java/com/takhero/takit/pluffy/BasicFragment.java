package com.takhero.takit.pluffy;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class BasicFragment extends Fragment implements View.OnClickListener{
    private Button fragment_btn_1;
    private Button fragment_btn_2;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_basic, container, false);
        fragment_btn_1 = (Button) view.findViewById(R.id.fragment_button_1);
        fragment_btn_2 = (Button) view.findViewById(R.id.fragment_button_2);
        fragment_btn_1.setOnClickListener(this);
        fragment_btn_2.setOnClickListener(this);
        return view;
    }
    @Override
    public void onClick(View v) {
    }


    private FragmentManager getSupportFragmentManager() {
        return null;
    }
}

// BURASI TAMAMEN COP