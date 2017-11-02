package com.example.triznylarasati.navigationview;

import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

public class Synchronize extends Fragment {

    public Synchronize(){}
    RelativeLayout view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = (RelativeLayout) inflater.inflate(R.layout.synchronize, container, false);

        getActivity().setTitle("Synchronize");

        return view;
    }
}
