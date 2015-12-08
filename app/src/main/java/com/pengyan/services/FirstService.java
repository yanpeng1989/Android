package com.pengyan.services;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;


/**
 * Created by Administrator on 2015/12/8.
 */
public class FirstService extends Service {
    public  final String TAG="Servvice----------->";
    private final IBinder binder = new MyBind();

    public class MyBind extends Binder implements FristServiceInterface{
        @Override
        public void show(){
            Toast.makeText(FirstService.this, "MyName is Service_01", Toast.LENGTH_LONG).show();
        }
        public FirstService  getService(){
            return FirstService.this;
        }

    }

    @Override
    public IBinder onBind(Intent intent){
        Log.d(TAG,"onBind");
        return binder;
    }
    @Override
    public void onCreate(){
        super.onCreate();
        Log.d(TAG,"onCreate");
    }
    @Override
    public void onDestroy(){
        super.onDestroy();
        Log.d(TAG, "onDestroy");
    }
    @Override
    public void onLowMemory(){
        super.onLowMemory();
        onDestroy();
    }
    @Override
    public void onRebind(Intent intent){
        super.onRebind(intent);
        Log.d(TAG, "onRebind");
    }
    @Override
    public void onStart(Intent intent,int startId){
        super.onStart(intent, startId);
        Log.d(TAG, "onStart");
    }
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(TAG, "onStartCommand-->flags=" + flags + "  startId=" + startId);
        return super.onStartCommand(intent, flags, startId);
    }
    @Override
    public boolean onUnbind(Intent intent) {
        Log.d(TAG, "onUnbind");
        return super.onUnbind(intent);
    }
}
