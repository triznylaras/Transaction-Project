package com.example.triznylarasati.incomeexpense;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Trizny Larasati on 11/3/2017.
 */

public class Root extends Fragment {
    public Root(){}
    View rootView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        rootView = inflater.inflate(R.layout.root, container, false);

        getActivity().setTitle("Transaction");

        return rootView;
    }
}
