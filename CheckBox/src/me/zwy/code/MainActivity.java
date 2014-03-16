package me.zwy.code;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.TextView;
import android.app.Activity;

public class MainActivity extends Activity implements OnClickListener {

	TextView tv;
	int cbs[] = {
			R.id.checkBox1,R.id.checkBox2,R.id.checkBox3
	};
	CheckBox[] cb;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		tv = (TextView) findViewById(R.id.textView2);
		cb = new CheckBox[cbs.length];
		for(int i=0;i<cbs.length;i++){
			cb[i] = (CheckBox) findViewById(cbs[i]);
			cb[i].setOnClickListener(this);
		}
	}
	@Override
	public void onClick(View v) {
		String str = "所选的项目为：";
		for(int i=0;i<cb.length;i++){
			if(cb[i].isChecked()){
				str += cb[i].getText() + " ";
			}
		}
		tv.setText(str);
	}

}
