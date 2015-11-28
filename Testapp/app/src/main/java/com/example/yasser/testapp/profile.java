package com.example.yasser.testapp;

import android.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class profile extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_profile, container, false);

        String[] data = {
                "First Name: Batman",
                "Last Name: - ",
                "email: batman@batcave.com",
                "Country: USA",
                "City: Gotham",
                "Gender: Male"
        };
        ArrayList<String >userData = new ArrayList<String>(Arrays.asList(data));
        //ListView lv = (ListView)findViewById(R.id.list);
        //ArrayAdapter<String> myarrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, userData);
        //lv.setAdapter(myarrayAdapter);
        //lv.setTextFilterEnabled(true);

        ListView lv = (ListView)rootView.findViewById(R.id.list);
        //List<String> myList = Arrays.asList("First Name", "Last Name", "email", "Country", "City", "Gender");
        ArrayAdapter<String> myarrayAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, userData);
        lv.setAdapter(myarrayAdapter);
        lv.setTextFilterEnabled(true);
        lv.setAdapter(myarrayAdapter);
        myarrayAdapter.notifyDataSetChanged();

        return rootView;
    }

}
