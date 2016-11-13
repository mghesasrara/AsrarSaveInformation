package com.mg.asrar.asrarsaveinformation;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;

import com.google.firebase.auth.FirebaseAuth;

public class AccountsListActivity extends AppCompatActivity {
    protected ImageButton btnplus;
    protected EditText ettext;
    protected ListView Listviewaccounts;
    protected MyAdapterAccount myadabter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accounts_list);
        btnplus = (ImageButton) findViewById(R.id.btnplus);
        ettext = (EditText) findViewById(R.id.ettext);
        Listviewaccounts = (ListView) findViewById(R.id.listViewaccounts);
        myadabter=new MyAdapterAccount(this, R.layout.item_my_account);
        Listviewaccounts.setAdapter(myadabter);
        eventHandler();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.mymenue, menu);

        return true;
    }




    private void Handler()
    {
        String sttext=ettext.getText().toString();
    }
    private void eventHandler()
    {
        btnplus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i3=new Intent(AccountsListActivity.this,Addaccount.class);
                startActivity(i3);

            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId()) {
            case R.id.logout:
                FirebaseAuth.getInstance().signOut();
                Intent i3=new Intent(AccountsListActivity.this,logInActivity.class);
                startActivity(i3);
                break;
            case R.id.setting:
                break;
        }
        return true;
    }
}
