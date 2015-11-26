package com.example.yasser.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button button1;
    Button button2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button1 = (Button)findViewById(R.id.button2);
        button1.setOnClickListener(this);
        button2 = (Button)findViewById(R.id.button);
        button2.setOnClickListener(this);
    }

    private void button1_click(){
        startActivity(new Intent("android.intent.action.Sign_up"));
    }
    private void button2_click(){
        startActivity(new Intent("android.intent.action.NavDraw"));
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.button2:
                button1_click();
                break;
            case R.id.button:
                button2_click();
                break;
        }
    }
}
