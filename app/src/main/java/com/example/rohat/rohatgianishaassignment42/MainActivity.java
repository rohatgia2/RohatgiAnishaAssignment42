package com.example.rohat.rohatgianishaassignment42;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    DatabaseHelper helper = new DatabaseHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void onButtonClick(View v)
    {
        if (v.getId() == R.id.enterValues)
        {

           Intent i = new Intent(MainActivity.this, Display.class);
           startActivity(i);
        }
    }

    public void onViewAntonym (View vAntonym)
    {
        if (vAntonym.getId() == R.id.viewAntonym)
        {

            Intent i = new Intent(MainActivity.this, Results.class);
            startActivity(i);

            //EditText searchWord = (EditText)findViewById(R.id.searchWord);
            //String str = searchWord.getText().toString();

            //String antonym = helper.searchSearchWord(str);


        }
    }
}


