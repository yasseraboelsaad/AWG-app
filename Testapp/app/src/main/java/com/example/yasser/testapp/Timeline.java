package com.example.yasser.testapp;

import android.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Timeline extends Fragment implements  View.OnClickListener{

    ArrayAdapter<String> timelineAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_timeline, container, false);

        Bundle bundle = getArguments();
        ArrayList<String> posts = bundle.getStringArrayList("posts");
        posts = bundle.getStringArrayList("posts");
        for(int i=0;i<posts.size();i++)
        {
            Log.v("aho aho aho = ",posts.get(i));
        }


        ListView list = (ListView) rootView.findViewById(R.id.postsList);
        List<String> myTimeline = posts;
        timelineAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, myTimeline);


        list.setAdapter(timelineAdapter);

        return rootView;
    }


    @Override
    public void onClick(View v) {

    }
}
