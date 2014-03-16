package me.zwy.code;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class SecondActivity extends Activity implements OnClickListener {

	Button bt;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.second);
		bt = (Button) findViewById(R.id.buttona);
		bt.setOnClickListener(this);
	}
	@Override
	public void onClick(View v) {
		Intent it = new Intent(this, MainActivity.class);
		startActivity(it);
	}
	
}
