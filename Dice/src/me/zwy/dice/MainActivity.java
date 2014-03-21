package me.zwy.dice;

import java.util.Random;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends Activity {

	ImageView iv1,iv2;
	Button bt;
	int[] imgs = {
			R.drawable.p1,R.drawable.p2,
			R.drawable.p3,R.drawable.p4,
			R.drawable.p5,R.drawable.p6
	};
	EditText et;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		iv1 = (ImageView) findViewById(R.id.imageView1);
		iv2 = (ImageView) findViewById(R.id.imageView2);
		bt = (Button) findViewById(R.id.button1);
		et = (EditText) findViewById(R.id.editText1);
	}
	
	public void start(View v){
		Random rm = new Random();
		Animation an = AnimationUtils.loadAnimation(this, R.anim.dice);
		int point1 = rm.nextInt(imgs.length);
		int point2 = rm.nextInt(imgs.length);
		int point = point1+point2+2;
		iv1.setImageResource(imgs[point1]);
		iv2.setImageResource(imgs[point2]);
		iv1.startAnimation(an);
		iv2.startAnimation(an);
		if(!et.getText().toString().trim().equals("")&&Integer.parseInt(et.getText().toString()) == point){
			Toast.makeText(this, "πßœ≤ƒ„£¨≤¬∂‘¡À", Toast.LENGTH_LONG).show();
		}else{
			Toast.makeText(this, "∫‹“≈∫∂£¨≤¬¥Ì¡À", Toast.LENGTH_LONG).show();
		}

	}

}
