package com.example.triznylarasati.incomeexpense;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.triznylarasati.incomeexpense.database.DatabaseHelper;

/**
 * Created by Trizny Larasati on 11/3/2017.
 */

public class Transaction extends Fragment implements View.OnClickListener {
    DatabaseHelper myDB;
    EditText expense_name, expense_amount, income_name, income_amount;
    Button add_expense, add_income;

    public Transaction(){}
    LinearLayout view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = (LinearLayout) inflater.inflate(R.layout.transaction, container, false);

        myDB = new DatabaseHelper(getActivity());
        expense_name = (EditText) view.findViewById(R.id.ins_desc_expenses);
        expense_amount = (EditText) view.findViewById(R.id.ins_amount_expenses);
        income_name = (EditText) view.findViewById(R.id.ins_desc_incomes);
        income_amount = (EditText) view.findViewById(R.id.ins_amount_incomes);

        add_expense = (Button) view.findViewById(R.id.add_expenses);
        add_income = (Button) view.findViewById(R.id.add_incomes);

        add_expense.setOnClickListener((View.OnClickListener) this);
        add_income.setOnClickListener((View.OnClickListener) this);


        return view;
    }

    @Override
    public void onClick(View v) {
        Log.e("tag",String.format("ini id v %s ",v.getId()));
        switch (v.getId()) {

            //case utk save expense
            case /*2131230748*/ R.id.add_expenses :
                boolean result_expense = myDB.save_expense(expense_name.getText().toString(),
                        expense_amount.getText().toString());
                if(result_expense)
                    Toast.makeText(getActivity(), "Success add expense", Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(getActivity(), "Fails add expense", Toast.LENGTH_LONG).show();
                break;

            //case utk save income
            case /*2131230749*/ R.id.add_incomes :
                boolean result_income = myDB.save_income(income_name.getText().toString(),
                        income_amount.getText().toString());
                if (result_income)
                    Toast.makeText(getActivity(), "Success add income", Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(getActivity(), "Fails add income", Toast.LENGTH_LONG).show();
                break;
        }
    }
}
