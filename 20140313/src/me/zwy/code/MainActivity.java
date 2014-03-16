package me.zwy.code;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;
import android.app.Activity;

public class MainActivity extends Activity {

	Object[] images = new Object[] { R.drawable.item1, R.drawable.item2,
			R.drawable.item3, R.drawable.item4, R.drawable.item5,
			R.drawable.item6, R.drawable.item7, R.drawable.item8,
			R.drawable.item9, R.drawable.item10 };
	ListView lv;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		lv = (ListView) findViewById(R.id.listView1);
		List<Map<String, Object>> data = new ArrayList<Map<String, Object>>();
		for (int i = 0; i < images.length; i++) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("image", images[i]);
			map.put("num", "µÚ" + (i + 1) + "·ù");
			data.add(map);
		}
		SimpleAdapter adapter = new SimpleAdapter(this, data,
				R.layout.image_template, new String[] { "image", "num" },
				new int[] { R.id.iviv, R.id.tvtv });
		lv.setAdapter(adapter);
		lv.setOnItemClickListener(listener);
	}
	OnItemClickListener listener = new OnItemClickListener() {
		
		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position,
				long id) {
			TextView tv = (TextView) view.findViewById(R.id.tvtv);
			Toast.makeText(MainActivity.this, tv.getText().toString(), Toast.LENGTH_SHORT).show();
		}
	};
	
}
