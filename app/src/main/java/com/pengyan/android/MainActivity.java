package com.pengyan.android;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.graphics.Color;
import android.os.IBinder;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.pengyan.services.FirstService;
import com.pengyan.services.FristServiceInterface;


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
            Intent bindIntent = new Intent(MainActivity.this, FirstService.class);
            bindService(bindIntent, sconnection, Context.BIND_AUTO_CREATE);
        }else if (v.getId()==R.id.pre){
            Intent intent = new Intent(this, Previous.class);
            startActivity(intent);
        }else if(v.getId()==R.id.next){
            Intent intent = new Intent(this, End.class);
            startActivity(intent);
        }
    }
    private FirstService serviceBinder;
    FristServiceInterface mService = null;
    ServiceConnection sconnection = new ServiceConnection(){
        /*当绑定时执行*/
        public void onServiceConnected(ComponentName name, IBinder service) {
            Log.d("activity--->", "已绑定到service");
            mService = (FristServiceInterface) service;
            if (mService != null) {
                mService.show();//测试方法
            }
            Intent intent = new Intent();//这里只是为了下面传intent对象而构建的，没有实际意义
            /*绑定后就可以使用Service的相关方法和属性来开始你对Service的操作*/
            serviceBinder = ((FirstService.MyBind) service).getService();
            /*比如：你可以掉用Service的onStartCommand()方法*/
            serviceBinder.onStartCommand(intent, 0, 0);//0,0是我随意的参数

        }
        /*当断开绑定时执行，但调用unbindService()时不会触发改方法*/
        public void onServiceDisconnected(ComponentName name) {
            Log.d("activity--->", "已断开绑定service");
        }
    };

}
