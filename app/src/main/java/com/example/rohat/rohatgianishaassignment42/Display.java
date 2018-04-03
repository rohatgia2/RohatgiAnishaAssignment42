package com.example.rohat.rohatgianishaassignment42;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;


public class Display extends Activity {

    DatabaseHelper helper = new DatabaseHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display);

        //final Button button = (Button) findViewById(R.id.submitButton);
    }


    public void onSubmitClick(View v) {
        if (v.getId() == R.id.submitButton) {

            EditText originalWord = (EditText) findViewById(R.id.originalWord);
            EditText antonymWord = (EditText) findViewById(R.id.antonymWord);

            String originalWordString = originalWord.getText().toString();
            String antonymWordString = antonymWord.getText().toString();

            WordPair w = new WordPair();
            w.setOriginalWord(originalWordString);
            w.setAntonymWord(antonymWordString);

            helper.insertWordPair(w);
        }
    }

}



