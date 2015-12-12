package com.example.yasser.testapp;

import android.content.Context;
import android.os.Bundle;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private String[] mNavigationDrawerItemTitles;
    private DrawerLayout mDrawerLayout;
    private ListView mDrawerList;
    ActionBarDrawerToggle mDrawerToggle;
    private CharSequence mDrawerTitle;
    private CharSequence mTitle;
    // Used to hold all the user posts
    // Allows the user to post offline
    static private ArrayList<String> posts = new ArrayList<String>();




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // adding intial posts to timeLine
        posts.add("Ali has Assigned a task \"Do a market research\" to you to be fullfiled on the 2nd of december");
        posts.add("You have fullfiled a Task\"Finalize the presentation\".");

        setContentView(R.layout.activity_main);

        // intialising bundle to carry data between timeline and posts
        Bundle bundle = new Bundle();
        bundle.putStringArrayList("posts",posts);


        mTitle = mDrawerTitle = getTitle();
        mNavigationDrawerItemTitles= getResources().getStringArray(R.array.navigation_drawer_items_array);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerList = (ListView) findViewById(R.id.left_drawer);

        ObjectDrawerItem[] drawerItem = new ObjectDrawerItem[9];

        drawerItem[0] = new ObjectDrawerItem(R.drawable.ic_task, "Tasks");
        drawerItem[1] = new ObjectDrawerItem(R.drawable.ic_calendar, "Calendar");
        drawerItem[2] = new ObjectDrawerItem(R.drawable.ic_message, "Messages");
        drawerItem[3] = new ObjectDrawerItem(R.drawable.ic_events, "Events");
        drawerItem[4] = new ObjectDrawerItem(R.drawable.ic_awg, "AWGs");
        drawerItem[5] = new ObjectDrawerItem(R.drawable.ic_committee, "My Committee");
        drawerItem[6] = new ObjectDrawerItem(R.drawable.ic_profile, "My Profile");
        drawerItem[7] = new ObjectDrawerItem(R.drawable.ic_timeline, "My TimeLine");
        drawerItem[8] = new ObjectDrawerItem(R.drawable.ic_settings, "Settings");

        DrawerItemCustomAdapter adapter = new DrawerItemCustomAdapter(this, R.layout.listview_item_row, drawerItem);

        mDrawerList.setAdapter(adapter);
        mDrawerList.setOnItemClickListener(new DrawerItemClickListener());

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerToggle = new ActionBarDrawerToggle(
                this,
                mDrawerLayout,
                R.drawable.ic_drawer,
                R.string.drawer_open,
                R.string.drawer_close
        ) {

            /** Called when a drawer has settled in a completely closed state. */
            public void onDrawerClosed(View view) {
                super.onDrawerClosed(view);
                getSupportActionBar().setTitle(mTitle);
            }

            /** Called when a drawer has settled in a completely open state. */
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                getSupportActionBar().setTitle(mDrawerTitle);
            }
        };

        mDrawerLayout.setDrawerListener(mDrawerToggle);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);


        FragmentManager fragmentManager = getFragmentManager();
        Fragment temp = new Timeline();
        temp.setArguments(bundle);
        fragmentManager.beginTransaction().replace(R.id.content_frame, temp).commit();

        mDrawerList.setItemChecked(7, true);
        mDrawerList.setSelection(7);
        setTitle(mNavigationDrawerItemTitles[7]);
        mDrawerLayout.closeDrawer(mDrawerList);

        //this.posts = new ArrayList<String>();

    }

    public static void setPosts(ArrayList<String> post) {
        MainActivity.posts = posts;
    }

    public static ArrayList<String> getPosts() {
        return MainActivity.posts;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    @Override
    public void setTitle(CharSequence title) {
        mTitle = title;
        getSupportActionBar().setTitle(mTitle);
    }
    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mDrawerToggle.syncState();
    }

    public class DrawerItemCustomAdapter extends ArrayAdapter<ObjectDrawerItem> {

        Context mContext;
        int layoutResourceId;
        ObjectDrawerItem data[] = null;

        public DrawerItemCustomAdapter(Context mContext, int layoutResourceId, ObjectDrawerItem[] data) {

            super(mContext, layoutResourceId, data);
            this.layoutResourceId = layoutResourceId;
            this.mContext = mContext;
            this.data = data;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            View listItem = convertView;

            LayoutInflater inflater = ((Activity) mContext).getLayoutInflater();
            listItem = inflater.inflate(layoutResourceId, parent, false);

            ImageView imageViewIcon = (ImageView) listItem.findViewById(R.id.imageViewIcon);
            TextView textViewName = (TextView) listItem.findViewById(R.id.textViewName);

            ObjectDrawerItem folder = data[position];


            imageViewIcon.setImageResource(folder.icon);
            textViewName.setText(folder.name);

            return listItem;
        }

    }

    private class DrawerItemClickListener implements ListView.OnItemClickListener {

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            selectItem(position);
        }

    }

    private void selectItem(int position) {

        Fragment fragment = null;
        Bundle bundle = new Bundle();
        bundle.putStringArrayList("posts",posts);

        switch (position) {
            case 0:
                fragment = new Tasks();
                fragment.setArguments(bundle);
                break;
            case 1:
                fragment = new Calendar();
                fragment.setArguments(bundle);
                break;
            case 2:
                fragment = new Messages();
                fragment.setArguments(bundle);
                break;
            case 3:
                fragment = new Events();
                fragment.setArguments(bundle);
                break;
            case 4:
                fragment = new AWGs();
                fragment.setArguments(bundle);
                break;
            case 5:
                fragment = new Committee();
                fragment.setArguments(bundle);
                break;
            case 6:
                fragment = new profile();
                fragment.setArguments(bundle);
                break;
            case 7:
                fragment = new Timeline();
                fragment.setArguments(bundle);
                break;
            case 8:
                fragment = new settings();
                fragment.setArguments(bundle);
                break;

            default:
                break;
        }

        if (fragment != null) {
            FragmentManager fragmentManager = getFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.content_frame, fragment).commit();

            mDrawerList.setItemChecked(position, true);
            mDrawerList.setSelection(position);
            setTitle(mNavigationDrawerItemTitles[position]);
            mDrawerLayout.closeDrawer(mDrawerList);

        } else {
            Log.e("MainActivity", "Error in creating fragment");
        }
    }
}
