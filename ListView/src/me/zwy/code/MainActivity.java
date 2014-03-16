package me.zwy.code;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.app.Activity;
import android.content.Intent;

public class MainActivity extends Activity {

	int[] images = {R.drawable.calendar,R.drawable.eoemarket,R.drawable.brick,R.drawable.whitesociety,R.drawable.terminater};
	String[] strs = {"多功能日历","eoeMarket客户端","耐玩的重力消砖块","白社会","程序终结者"};
	ListView lv;
	RatingBar rb;
	static final int RC = 123;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		lv = (ListView) findViewById(R.id.listView);
		List<Map<String, Object>> data = new ArrayList<Map<String,Object>>();
		for(int i=0;i<images.length;i++){
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("image", images[i]);
			map.put("str", strs[i]);
			data.add(map);
		}
		String[] from = {"image","str"};
		int[] to = {R.id.iv,R.id.tv};
		SimpleAdapter adapter = new SimpleAdapter(this, data, R.layout.listview_template, from, to);
		lv.setAdapter(adapter);
		lv.setOnItemClickListener(listener);
	}
	OnItemClickListener listener = new OnItemClickListener() {

		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position,
				long id) {
			rb = (RatingBar) view.findViewById(R.id.rb);
			Intent it = new Intent(MainActivity.this, RatingActivity.class);
			it.putExtra("rate", rb.getRating());
			it.putExtra("appimg", images[position]);
			it.putExtra("app", strs[position]);
			MainActivity.this.startActivityForResult(it, MainActivity.RC);
		}
	};
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if(requestCode == MainActivity.RC){
			if(resultCode == Activity.RESULT_OK){
				rb.setRating(data.getExtras().getFloat("rate"));
			}
		}
	}

}
