package com.pengyan.android;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by Administrator on 2015/12/5.
 */
public class End extends Activity implements View.OnClickListener{

    private Button previous;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.next);
        previous=(Button)findViewById(R.id.previous);
        previous.setOnClickListener(this);
    }
    @Override
    public void onClick(View v){
        if(v.getId()==R.id.previous){
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }
    }
}
