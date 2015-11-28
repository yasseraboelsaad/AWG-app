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
                "First Name: Bat",
                "Last Name: man",
                "email: batman@batcave.com",
                "Country: USA",
                "City: Gotham",
                "Gender: Male",
                "Date of Birth: 16/5/1984"
        };
        ArrayList<String >userData = new ArrayList<String>(Arrays.asList(data));


        ListView lv = (ListView)rootView.findViewById(R.id.list);
        ArrayAdapter<String> myarrayAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, userData);
        lv.setAdapter(myarrayAdapter);
        lv.setTextFilterEnabled(true);
        lv.setAdapter(myarrayAdapter);
        myarrayAdapter.notifyDataSetChanged();

        return rootView;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        post = (Button) this.getActivity().findViewById(R.id.postBtn);
        post.setOnClickListener(this);

        postBox = (EditText)this.getView().findViewById(R.id.postBox);

    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.postBtn)
        {
            Bundle bundle = this.getArguments();
            ArrayList<String> post = bundle.getStringArrayList("posts");
            if(!postBox.getText().toString().equals("Write a Post!"))
            {
                post.add("Batman - " + postBox.getText().toString());
            }


            // need to append the new post to the end of the list
            MainActivity.setPosts(post);


           /* for(int i=0; i<post.size();i++)
            {
                Log.v("aho aho aho = ",post.get(i));
            }*/
        }
    }

}
