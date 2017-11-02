package com.example.triznylarasati.navigationview;

import android.database.Cursor;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.triznylarasati.navigationview.database.DatabaseHelper;

public class Homepage extends Fragment {
    public Homepage(){}
    LinearLayout view;
    DatabaseHelper myDB;
    private TextView tv_expense_name, tv_expense_amount, tv_income_name, tv_income_amount, tv_total_expense,tv_total_income;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = (LinearLayout) inflater.inflate(R.layout.homepage, container, false);
        myDB = new DatabaseHelper(getActivity());

        tv_expense_name = (TextView) view.findViewById(R.id.tv_expense_name);
        tv_expense_amount = (TextView) view.findViewById(R.id.tv_expense_amount);
        tv_total_expense = (TextView) view.findViewById(R.id.tv_total_expense);

        tv_income_name = (TextView) view.findViewById(R.id.tv_income_name);
        tv_expense_amount = (TextView) view.findViewById(R.id.tv_income_amount);
        tv_total_income = (TextView) view.findViewById(R.id.tv_total_income);

        Cursor list_expense = myDB.list_expense();

        //jika belum ada data expense yang dimasukkan
        if (list_expense.getCount() == 0) {
            alert_message("Message", "No expense data found");
        }

        //untuk menghitung total expense
        Integer total_expense = 0;
        while (list_expense.moveToNext()) {
            Log.e("tag",String.valueOf(list_expense.getString(2)));
            String amount = list_expense.getString(2);
            total_expense = total_expense + Integer.parseInt(amount);

        }

        Cursor list_income = myDB.list_income();

        //jika belum ada data expense yang dimasukkan
        if (list_income.getCount() == 0) {
            alert_message("Message", "No income data found");
        }

        //untuk menghitung total expense
        Integer total_income = 0;
        while (list_expense.moveToNext()) {
            Log.e("tag",String.valueOf(list_expense.getString(2)));
            String amount = list_expense.getString(2);
            total_income = total_income + Integer.parseInt(amount);

        }

        Log.e("jumlah expense",String.valueOf(total_expense));
        return view;
    }

    public void alert_message(String title, String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }
}
