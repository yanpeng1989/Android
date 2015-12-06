package com.pengyan.android;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity implements View.OnClickListener {

    private Button previous;
    private Button next;
    private Button middle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        middle = (Button)findViewById(R.id.middle);
        previous=(Button)findViewById(R.id.pre);
        next=(Button)findViewById(R.id.next);
        middle.setOnClickListener(this);
        previous.setOnClickListener(this);
        next.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.middle) {
            middle.setBackgroundColor(Color.RED);
        }else if (v.getId()==R.id.pre){
            Intent intent = new Intent(this, Previous.class);
            startActivity(intent);
        }else if(v.getId()==R.id.next){
            Intent intent = new Intent(this, End.class);
            startActivity(intent);
        }
    }
}
