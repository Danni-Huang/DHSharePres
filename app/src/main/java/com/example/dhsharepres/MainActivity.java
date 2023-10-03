package com.example.dhsharepres;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    Button button;

    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        button = findViewById(R.id.button);
        editText = findViewById(R.id.editText);

        DisplaySavedText();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String inputName = editText.getText().toString();
                DisplayAndSavedText(inputName);
            }
        });

    }

    private void DisplaySavedText(){
        SharedPreferences sharedPreferences =
                getSharedPreferences("MySharedPref", MODE_PRIVATE);

        String s1 = sharedPreferences.getString("name", " ");

        textView.setText(s1);

    }

    private void DisplayAndSavedText(String enteredText){
        textView.setText(enteredText);

        SharedPreferences sharedPreferences =
                getSharedPreferences("MySharedPref", MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("name", enteredText);
        editor.commit();

    }
}