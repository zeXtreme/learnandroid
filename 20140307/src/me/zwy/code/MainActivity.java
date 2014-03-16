package me.zwy.code;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RatingBar;
import android.widget.Toast;
import android.app.Activity;

public class MainActivity extends Activity implements OnClickListener {

	CheckBox[] cb;
	RadioButton[] rb;
	Button bt;
	Button bt2;
	ProgressBar pb;
	RatingBar rab;
	int[] cbs = {
			R.id.checkBox1,R.id.checkBox2,R.id.checkBox3
	};
	int[] rbs = {
			R.id.radioButton1,R.id.radioButton2
	};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		cb = new CheckBox[cbs.length];
		rb = new RadioButton[rbs.length];
		for(int i=0;i<cbs.length;i++){
			cb[i] = (CheckBox) findViewById(cbs[i]);
		}
		for(int i=0;i<rbs.length;i++){
			rb[i] = (RadioButton) findViewById(rbs[i]);
		}
		bt = (Button) findViewById(R.id.button1);
		bt.setOnClickListener(this);
		bt2 = (Button) findViewById(R.id.button2);
		bt2.setOnClickListener(this);
		pb = (ProgressBar) findViewById(R.id.progressBar1);
		rab = (RatingBar) findViewById(R.id.ratingBar1);
	}
	@Override
	public void onClick(View v) {
		if(v.getId()==R.id.button1){
			String msg = "当前选择的是：";
			for(int i=0;i<cbs.length;i++){
				if(cb[i].isChecked()){
					msg += cb[i].getText() + " ";
				}
			}
			for(int i=0;i<rbs.length;i++){
				if(rb[i].isChecked()){
					msg += rb[i].getText() + " ";
				}
			}
			Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
		}else if(v.getId()==R.id.button2){
			int max = pb.getMax();
			int progress = pb.getProgress();
			int secondaryProgress = pb.getSecondaryProgress();
			if(progress == max){
				progress = 0;
			}else if(secondaryProgress == max){
				secondaryProgress = 0;
			}
			progress = progress + 5;
			secondaryProgress = secondaryProgress + 10;
			pb.setProgress(progress);
			pb.setSecondaryProgress(secondaryProgress);
		}
	}

}
