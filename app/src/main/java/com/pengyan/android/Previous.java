package com.pengyan.android;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by Administrator on 2015/12/5.
 */
public class Previous extends Activity implements View.OnClickListener{
    private Button first;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pre);
        first=(Button)findViewById(R.id.first);
        first.setOnClickListener(this);
    }
    @Override
    public void onClick(View v){
        if (v.getId()==R.id.first){
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }
    }
}
