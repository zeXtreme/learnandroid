package me.zwy.code;

import android.os.Bundle;
import android.app.Activity;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    @Override
    protected void onStart() {
    	System.out.println("start...");
    	super.onStart();
    }
    @Override
    protected void onPause() {
    	System.out.println("pause...");
    	super.onPause();
    }
    @Override
    protected void onRestart() {
    	System.out.println("restart...");
    	super.onRestart();
    }
    @Override
    protected void onResume() {
    	System.out.println("resume...");
    	super.onResume();
    }
    @Override
    protected void onStop() {
    	System.out.println("stop...");
    	super.onStop();
    }
    @Override
    protected void onDestroy() {
    	System.out.println("destroy...");
    	super.onDestroy();
    }
    
}
