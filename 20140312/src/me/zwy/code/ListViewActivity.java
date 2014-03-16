package me.zwy.code;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

public class ListViewActivity extends Activity {
	
	ListView lv;
	String[] contents = {
			"HelloWorld","Hello,World","WorldHello"
	};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.listview);
		lv = (ListView) findViewById(R.id.lv1);
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.listview_temp, R.id.tt1, contents);
		List<Map<String, Object>> data = new ArrayList<Map<String,Object>>();
		for(int i=0;i<contents.length;i++){
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("key1", contents[i]);
			map.put("key2", "É¾³ý");
			data.add(map);
		}
		SimpleAdapter adapter2 = new SimpleAdapter(this, data, R.layout.listview_temp, new String[]{"key1","key2"}, new int[]{R.id.tt1,R.id.bb1});
		lv.setAdapter(adapter2);
		lv.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				Toast.makeText(ListViewActivity.this, contents[position], Toast.LENGTH_SHORT).show();
			}
			
		});
	}

}
