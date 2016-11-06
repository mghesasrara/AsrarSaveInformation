package com.mg.asrar.asrarsaveinformation;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RatingBar;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Addaccount extends AppCompatActivity {
 protected EditText etemail;
    protected EditText etpass;
    protected Button btnsave1;



    protected DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_account);
    etemail=(EditText)findViewById(R.id.etemail);
       etpass=(EditText)findViewById(R.id.etpass);
        btnsave1=(Button)findViewById(R.id.btnsave1);



        reference= FirebaseDatabase.getInstance().getReference();

        eventHandler();
    }

    private void dataHandler()
    {
        boolean isok=true;
        String stpass=etpass.getText().toString();
        String stemail=etemail.getText().toString();
        if(stemail.length()==0) {
            etemail.setError("there is no text");
            isok = false;
        }

      if (isok)
      {
        accounts m=new accounts();
          m.setEmail(stemail);
          m.setPassword(stpass);

           String stemail3= FirebaseAuth.getInstance().getCurrentUser().getEmail();
          stemail3=stemail3.replace(".","_");
          reference.child(stemail3).child("accounts").push().setValue(m, new DatabaseReference.CompletionListener() {

              @Override
              public void onComplete(DatabaseError databaseError, DatabaseReference databaseReference) {
                  if (databaseError == null) {
                      Toast.makeText(getBaseContext(), "save ok", Toast.LENGTH_LONG).show();

                  } else {
                      Toast.makeText(getBaseContext(), "save Err" + databaseError.getMessage(), Toast.LENGTH_LONG).show();
                      databaseError.toException().printStackTrace();

                  }


              }
          });
        


      }

    }
private void eventHandler()
{


    btnsave1.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            dataHandler();

        }
    });

}


}
