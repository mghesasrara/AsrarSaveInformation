package com.mg.asrar.asrarsaveinformation;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RatingBar;
import android.widget.TextView;

/**
 * Created by user on 10/30/2016.
 */
public class MyAdapterAccount extends ArrayAdapter<accounts> {
    public MyAdapterAccount(Context context, int resource) {
        super(context, resource);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(getContext()).
                inflate(R.layout.item_my_account, parent, false);
        TextView textView1 = (TextView) convertView.findViewById(R.id.textView1);
       TextView textView2 = (TextView) convertView.findViewById(R.id.textView2);
        final accounts accounts = getItem(position);
        textView1.setText(accounts.getEmail());
        textView2.setText(accounts.getPassword());


        return convertView;


    }


}
