package com.example.happy;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private static String TAG="main";
    TextView out;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView out= findViewById(R.id.out);
        out.setText("hello sio");

        EditText inp = findViewById(R.id.inp);
        inp.getText().toString();
        inp.setText("121421421");

        Button btn = findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                out.setText("shdhsjdhsj");
            }
        });

    }

    @Override
    public void onClick(View v) {


    }
}
