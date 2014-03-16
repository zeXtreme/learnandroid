package me.zwy.code;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

public class Pic extends Activity implements OnClickListener {
	
	ImageView iv1;
	ImageView iv2;
	Button bt1;
	Button bt2;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.pic);
		iv1 = (ImageView) findViewById(R.id.imageView1);
		iv2 = (ImageView) findViewById(R.id.imageView2);
		bt1 = (Button) findViewById(R.id.button1);
		bt2 = (Button) findViewById(R.id.button2);
		bt1.setOnClickListener(this);
		bt2.setOnClickListener(this);
		iv1.setBackgroundResource(R.drawable.left);
	}
	@Override
	public void onClick(View v) {
		if(v.getId() == R.id.button1){
			iv1.setBackgroundResource(R.drawable.left);
		}else if(v.getId() == R.id.button2){
			iv1.setBackgroundResource(R.drawable.right);
		}
	}

}
