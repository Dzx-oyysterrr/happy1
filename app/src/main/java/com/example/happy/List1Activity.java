package com.example.happy;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ListActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class List1Activity extends ListActivity implements AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener {

    List<String > data = new ArrayList<String>();
    private  String  TAG = "MYLIST";
    ArrayAdapter adapter ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_list1);

        ListView listView = (ListView) findViewById(R.id.mylist);
        //String data[] = {"111","222"};

        for(int i=0;i<10;i++){
            data.add("item"+i);
        }

        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,data);
        getListView().setAdapter(adapter);
        getListView().setEmptyView(findViewById(R.id.nodata));
        getListView().setOnItemClickListener(this);
        getListView().setOnItemLongClickListener(this);


    }

    @Override
    public void onItemClick(AdapterView<?> listv, View view, int position, long id) {
        Log.i(TAG,"onItemClick: parent" + listv);
        Log.i(TAG,"onItemClick: parent" + position);
        //adapter.remove(listv.getItemAtPosition(position));
        //adapter.notifyDataSetChanged();

    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        Log.i(TAG,"LONGLONG"  + position);
        return true;
    }
}
