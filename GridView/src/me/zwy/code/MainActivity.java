package me.zwy.code;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.SimpleAdapter;
import android.app.Activity;

public class MainActivity extends Activity {

	GridView gv;
	ImageView iv;
	int[] images = { R.drawable.item1, R.drawable.item2, R.drawable.item3,
			R.drawable.item4, R.drawable.item5, R.drawable.item6,
			R.drawable.item7, R.drawable.item8, R.drawable.item9,
			R.drawable.item10, R.drawable.item11, R.drawable.item12,
			R.drawable.item13, R.drawable.item14, R.drawable.item15 };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		gv = (GridView) findViewById(R.id.gv);
		iv = (ImageView) findViewById(R.id.iv);
		List<Map<String, Object>> data = new ArrayList<Map<String,Object>>();
		for(int i=0;i<images.length;i++){
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("image", images[i]);
			data.add(map);
		}
		SimpleAdapter adapter = new SimpleAdapter(this, data, R.layout.gridview_template, new String[]{"image"}, new int[]{R.id.iviv});
		gv.setAdapter(adapter);
		gv.setOnItemClickListener(listener);
	}
	OnItemClickListener listener = new OnItemClickListener() {

		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position,
				long id) {
			iv.setBackgroundResource(images[position]);
		}
	};

}
