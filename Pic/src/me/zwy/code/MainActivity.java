package me.zwy.code;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends Activity implements OnClickListener {

	TextView tv;
	ImageButton ib;
	Button b;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		tv = (TextView) findViewById(R.id.tv);
		ib = (ImageButton) findViewById(R.id.ib);
		b = (Button) findViewById(R.id.b);
		ib.setOnClickListener(this);
		b.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		if(v.getId()==R.id.ib){
			tv.setText("Í¼Æ¬°´Å¥µÄ×´Ì¬Îª£ºGot Click");
			ib.setImageResource(R.drawable.iconfull);
		}else{
			ib.setImageResource(R.drawable.iconempty);
		}
	}

}
