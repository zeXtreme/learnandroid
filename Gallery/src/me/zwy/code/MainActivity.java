package me.zwy.code;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.SimpleAdapter;
import android.app.Activity;

public class MainActivity extends Activity implements OnItemSelectedListener {

	int[] images = { R.drawable.item1, R.drawable.item2, R.drawable.item3,
			R.drawable.item4, R.drawable.item5, R.drawable.item6,
			R.drawable.item7, R.drawable.item8, R.drawable.item9,
			R.drawable.item10, R.drawable.item11, R.drawable.item12,
			R.drawable.item13, R.drawable.item14, R.drawable.item15 };
	Gallery gallery;
	ImageView iv;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		gallery = (Gallery) findViewById(R.id.gallery1);
		iv = (ImageView) findViewById(R.id.imageView1);
		List<Map<String, Object>> data = new ArrayList<Map<String, Object>>();
		for (int i = 0; i < images.length; i++) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("img", images[i]);
			data.add(map);
		}
		SimpleAdapter adapter = new SimpleAdapter(this, data,
				R.layout.template, new String[] { "img" },
				new int[] { R.id.iviv });
		gallery.setAdapter(adapter);
		gallery.setOnItemSelectedListener(this);
	}

	@Override
	public void onItemSelected(AdapterView<?> parent, View view, int position,
			long id) {
		iv.setImageResource(images[position]);
	}

	@Override
	public void onNothingSelected(AdapterView<?> parent) {

	}

}
