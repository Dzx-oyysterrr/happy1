package com.example.happy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import java.util.List;

public class Test extends AppCompatActivity implements Runnable {

    private static final String TAG = "main";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        //kaiqi
        Thread t =new Thread(this);
        //t.start();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.test,menu);
        return true;
    }

    @Override
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

    @Override
    public void run() {
        Log.i(TAG,"run");
    }
}
