package com.example.yasser.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.Arrays;
import java.util.List;

public class Profile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        ListView lv = (ListView)findViewById(R.id.list);
        List<String> myList = Arrays.asList("First Name", "Last Name", "email", "Country", "City","Gender");
        ArrayAdapter<String> myarrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, myList);
        lv.setAdapter(myarrayAdapter);
        lv.setTextFilterEnabled(true);

        myarrayAdapter.notifyDataSetChanged();

    }
}
