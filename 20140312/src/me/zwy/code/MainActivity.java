package me.zwy.code;

import android.app.TabActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TabHost;

public class MainActivity extends TabActivity implements OnClickListener {

	TabHost tabs;
	Button bt;
	Button bt2;
	ProgressBar pb;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		tabs = getTabHost();
		View v1 = LayoutInflater.from(this).inflate(R.layout.tab1, tabs.getTabContentView(), true);
		View v2 = LayoutInflater.from(this).inflate(R.layout.tab2, tabs.getTabContentView(), true);
		View v3 = LayoutInflater.from(this).inflate(R.layout.tab3, tabs.getTabContentView(), true);
		tabs.addTab(tabs.newTabSpec("tab1")
				.setIndicator("TH1", getResources().getDrawable(R.drawable.ic_launcher))
				.setContent(R.id.tab1));
		tabs.addTab(tabs.newTabSpec("tab2")
				.setIndicator("TH2", getResources().getDrawable(R.drawable.ic_launcher))
				.setContent(R.id.tab2));
		tabs.addTab(tabs.newTabSpec("tab3")
				.setIndicator("TH3", getResources().getDrawable(R.drawable.ic_launcher))
				.setContent(R.id.tab3));
		bt = (Button) findViewById(R.id.button1);
		bt.setOnClickListener(this);
		pb = (ProgressBar) findViewById(R.id.progressBar1);
		pb.setOnClickListener(this);
		bt2 = (Button) findViewById(R.id.button12);
		bt2.setOnClickListener(this);
	}
	boolean onClick = false;
	@Override
	public void onClick(View v) {
		if(v.getId() == R.id.button1){
			if(onClick){
				bt.setText("点我");
				onClick = false;
			}else{
				bt.setText("别点我");
				onClick = true;
			}
		}else if(v.getId() == R.id.progressBar1){
			pb.setMax(100);
			pb.setProgress(50);
		}else if(v.getId() == R.id.button12){
			bt2.setText("Clicked!");
		}
	}

}
