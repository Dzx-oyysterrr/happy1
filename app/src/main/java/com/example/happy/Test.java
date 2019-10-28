package com.example.happy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.renderscript.ScriptGroup;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class Test extends AppCompatActivity implements Runnable {

    private static final String TAG = "ALL";
    Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        //kaiqi
        Thread t =new Thread(this);
        t.start();

        handler = new Handler(){
            @Override
            public void handleMessage(@NonNull Message msg) {
                if(msg.what == 5){
                    String str = (String) msg.obj;
                    Log.i(TAG,"You can see the msg :" + str);
                    //使用

                }
                super.handleMessage(msg);
            }
        };
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
        Log.i(TAG,"run.........");
        for (int i=1;i<6;i++){
            Log.i(TAG,"run = "+ i);
            try {
                Thread.sleep(200);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }

        Message msg = handler.obtainMessage();
        msg.what = 5;
        msg.obj = "Long Long way";
        handler.sendMessage(msg);

        URL url = null;
        try {
            url = new URL("http://www.boc.cn/sourcedb/whpj/");
            HttpURLConnection http = (HttpURLConnection) url.openConnection();
            InputStream in  = http.getInputStream();

            String html = inputString2String(in);
            Log.i(TAG,"run : HTML : =============="+ html);

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String inputString2String(InputStream inputStream) throws IOException {

        final int bufferSize = 1024;
        final char[] buffer = new char[bufferSize];
        final StringBuilder out = new StringBuilder();
        Reader in = new InputStreamReader(inputStream,"UTF-8");
        for (; ; ){
            int rsz = in.read(buffer, 0 ,buffer.length);
            if(rsz<0)
                break;
            out.append(buffer, 0,rsz);
        }
        return out.toString();
    }

}
