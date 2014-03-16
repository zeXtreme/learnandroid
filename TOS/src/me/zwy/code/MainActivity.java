package me.zwy.code;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.TextView;
import android.app.Activity;

public class MainActivity extends Activity implements OnClickListener {

	TextView tv;
	CheckBox cb;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		tv = (TextView) findViewById(R.id.textView1);
		cb = (CheckBox) findViewById(R.id.checkBox1);
		cb.setOnClickListener(this);
	}
	@Override
	public void onClick(View v) {
		if(cb.isChecked()){
			tv.setText("已同意");
		}else{
			tv.setText("服务条款：");
		}
	}

}
