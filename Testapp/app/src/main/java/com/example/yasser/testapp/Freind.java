package com.example.yasser.testapp;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;


public class Freind extends Fragment implements View.OnClickListener {


    public String passable;
    Button post;
    EditText postBox;

    @Override

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_freind, container, false);
        String[] data = {
                "First Name: Apple",
                "Last Name: droid",
                "email: ayhaga@droid.com",
                "Country: USA",
                "City: Mountain View",
                "Gender: Male",
                "Date of Birth: 16/5/2994"
        };
        ArrayList<String> userData = new ArrayList<String>(Arrays.asList(data));


        ListView lv = (ListView) rootView.findViewById(R.id.list);
        ArrayAdapter<String> myarrayAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, userData);
        lv.setAdapter(myarrayAdapter);
        lv.setTextFilterEnabled(true);
        lv.setAdapter(myarrayAdapter);
        myarrayAdapter.notifyDataSetChanged();


        return rootView;
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        post = (Button) this.getActivity().findViewById(R.id.postBtnF);
        post.setOnClickListener(this);

        postBox = (EditText) this.getView().findViewById(R.id.postBoxF);

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.postBtnF) {
            Bundle bundle = this.getArguments();
            ArrayList<String> post = bundle.getStringArrayList("posts");
            if (!postBox.getText().toString().equals("Write a Post!")) {
                //post.add("Batman - " + postBox.getText().toString());
            }


            // need to append the new post to the end of the list
            MainActivity.setPosts(post);


        }
    }
}
