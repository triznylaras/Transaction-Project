package com.example.triznylarasati.incomeexpense;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

/**
 * Created by Trizny Larasati on 11/3/2017.
 */

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
