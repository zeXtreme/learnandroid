package me.zwy.code;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.app.Activity;
import android.graphics.Color;

public class MainActivity extends Activity implements OnClickListener {

	int[] ivs = {
			R.id.iv1,R.id.iv2,R.id.iv3,R.id.iv4,R.id.iv5
	};
	List<ImageView> iv;
	int[] colors = {
			Color.BLUE,Color.GREEN,Color.RED,Color.YELLOW,Color.DKGRAY
	};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		iv = new ArrayList<ImageView>();
		for(int i=0;i<ivs.length;i++){
			ImageView im = (ImageView) findViewById(ivs[i]);
			iv.add(im);
			im.setBackgroundColor(colors[i]);
			im.setOnClickListener(this);
		}
	}
	@Override
	public void onClick(View v) {
		iv.add(0, iv.remove(iv.size()-1));
		for(int i=0;i<iv.size();i++){
			iv.get(i).setBackgroundColor(colors[i]);
		}
	}

}
