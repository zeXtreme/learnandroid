package me.zwy.code;

import android.os.Bundle;
import android.app.Activity;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.TextView;

public class MainActivity extends Activity implements OnTouchListener {

	TextView tv1;
	TextView tv2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv1 = (TextView) findViewById(R.id.tv1);
        tv2 = (TextView) findViewById(R.id.tv2);
        tv1.setOnTouchListener(this);
    }
	@Override
	public boolean onTouch(View v, MotionEvent event) {
		tv2.setText("action:"+event.getAction()+"\nindex:"+event.getActionIndex()+"\nX:"+event.getX()+"\nY:"+event.getY());
		return false;
	}

}
