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
import android.widget.Toast;

import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by user on 10/30/2016.
 */
public class MyAdapterAccount extends ArrayAdapter<accounts> {
    private DatabaseReference refernce;
    public MyAdapterAccount(Context context, int resource) {
        super(context, resource);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(getContext()).
                inflate(R.layout.item_my_account, parent, false);
        TextView textView1 = (TextView) convertView.findViewById(R.id.textView1);
       TextView textView2 = (TextView) convertView.findViewById(R.id.textView2);
        ImageButton btndel=(ImageButton)convertView.findViewById(R.id.btndel);
        final accounts accounts = getItem(position);
        textView1.setText(accounts.getEmail());
        textView2.setText(accounts.getPassword());
         refernce= FirebaseDatabase.getInstance().getReference();
         btndel.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 refernce.child(accounts.getId()).removeValue(new DatabaseReference.CompletionListener() {
                     @Override
                     public void onComplete(DatabaseError databaseError, DatabaseReference databaseReference) {
                         if(databaseError==null)//*delleted
                         {
                             Toast.makeText(getContext(),"Deleted!",Toast.LENGTH_LONG).show();
                             remove(accounts);
                             setNotifyOnChange(true);//*to update the list view
                         }
                     }
                 })
             }
         });
        return convertView;


    }


}
