package com.example.happy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private static String TAG="main";
    TextView out;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView out= findViewById(R.id.out);


        EditText inp = findViewById(R.id.inp);
        inp.getText().toString();


        TextView out1 = findViewById(R.id.out1);
        out1.getText();

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

    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId()==R.id.menu_set){
            RateItem item1 = new RateItem("aaa","1234");
            RateManager manager = new RateManager(this);
            manager.add(item1);
            manager.add(new RateItem("bbb","123"));
            Log.i(TAG,"onOP:写入数据OK");

            List<RateItem> testlist = manager.listAll();
            for (RateItem i : testlist){
                Log.i(TAG,"onOP : 取数据" + i.getId()+ " name = " +i.getCurName()+"rate ==" + i.getCurRate());
            }

        }
        return true;
    }
}
