package com.example.yasser.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Sign_up extends AppCompatActivity implements View.OnClickListener {

    Button button1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        button1 = (Button) findViewById(R.id.button3);
        button1.setOnClickListener(this);
    }

    private void button1_click() {
        startActivity(new Intent("android.intent.action.NavDraw"));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button3:
                button1_click();
                break;
        }
    }
}
