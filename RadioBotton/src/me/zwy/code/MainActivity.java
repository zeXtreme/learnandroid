package me.zwy.code;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RadioButton;
import android.widget.TextView;
import android.app.Activity;

public class MainActivity extends Activity implements OnClickListener {

	TextView tv;
	int[] rbs = {
			R.id.radion,R.id.radiov
	};
	RadioButton[] rb;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		tv = (TextView) findViewById(R.id.textView1);
		rb = new RadioButton[rbs.length];
		for(int i=0;i<rbs.length;i++){
			rb[i] = (RadioButton) findViewById(rbs[i]);
			rb[i].setOnClickListener(this);
		}
	}
	@Override
	public void onClick(View v) {
		for(int i=0;i<rb.length;i++){
			if(rb[i].isChecked()){
				tv.setText(rb[i].getText());
			}
		}
	}

}
