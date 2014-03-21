package me.zwy.code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener {

	ImageView[] ivs;
	int[] imgs = {
			R.drawable.item1
	};
	Drawable draw;
	int[] iv_ids = {
		R.id.imageView1,R.id.imageView2,R.id.imageView3,
		R.id.imageView4,R.id.imageView5,R.id.imageView6,
		R.id.imageView7,R.id.imageView8,R.id.imageView9
	};
	List<Bitmap> sources = new ArrayList<Bitmap>();
	List<Bitmap> randoms = new ArrayList<Bitmap>();
	Gallery gallery;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ivs = new ImageView[iv_ids.length];
		gallery = (Gallery) findViewById(R.id.gallery1);
		List<Map<String, Object>> data = new ArrayList<Map<String,Object>>();
		for(int i=0;i<imgs.length;i++){
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("img", imgs[i]);
			data.add(map);
		}
		SimpleAdapter adapter = new SimpleAdapter(this, data, R.layout.gallery_template, new String[]{"img"}, new int[]{R.id.iviv});
		gallery.setAdapter(adapter);
		gallery.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> parent, View view,
					int position, long id) {
				draw = getResources().getDrawable(imgs[position]);
			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {
				draw = getResources().getDrawable(imgs[0]);
			}
		});
		genBitmaps();
		getRandom();
		for(int i=0;i<iv_ids.length;i++){
			ivs[i] = (ImageView) findViewById(iv_ids[i]);
			ivs[i].setImageBitmap(randoms.get(i));
			ivs[i].setPadding(1, 1, 1, 1);
			ivs[i].setOnClickListener(this);
		}
	}
	
	public void genBitmaps(){
		Bitmap source = ((BitmapDrawable)draw).getBitmap();
		int width = source.getWidth()/3;
		int height = source.getHeight()/3;
		for(int i=0;i<3;i++){
			for(int j=0;j<3;j++){
				Bitmap bm = Bitmap.createBitmap(source, j*width, i*height, width, height);
				sources.add(bm);
				randoms.add(bm);
			}
		}
	}
	
	public void getRandom(){
		Random rm = new Random();
		for(int i=0;i<randoms.size();i++){
			int index = rm.nextInt(randoms.size());
			randoms.add(0, randoms.remove(index));
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onClick(View v) {
		for(int i=0;i<ivs.length;i++){
			if(v.getId() == iv_ids[i]){
				Bitmap tmp = randoms.get(0);
				randoms.set(0, randoms.get(i));
				randoms.set(i, tmp);
				ivs[0].setImageBitmap(randoms.get(0));
				ivs[i].setImageBitmap(randoms.get(i));
			}
		}
		if(Arrays.equals(sources.toArray(), randoms.toArray())){
			Toast.makeText(this, "¹§Ï²Äã", Toast.LENGTH_SHORT).show();
			for(int i=0;i<ivs.length;i++){
				ivs[i].setPadding(0, 0, 0, 0);
			}
		}
	}

}
