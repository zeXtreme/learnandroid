package me.zwy.code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements OnItemSelectedListener,
		OnClickListener {

	Gallery gallery;
	ImageView iv;
	int[] imgs = { R.drawable.item1, R.drawable.item2, R.drawable.item3,
			R.drawable.item4, R.drawable.item5, R.drawable.item6,
			R.drawable.item7, R.drawable.item8, R.drawable.item9,
			R.drawable.item10, R.drawable.item11, R.drawable.item12,
			R.drawable.item13, R.drawable.item14, R.drawable.item15 };
	List<ImageView> ivs;
	List<Bitmap> sources;
	List<Bitmap> randoms;
	TextView tv;
	int count;
	LinearLayout main;
	int n = 3;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		main = (LinearLayout) findViewById(R.id.pics);
		gallery = (Gallery) findViewById(R.id.gallery);
		tv = (TextView) findViewById(R.id.tv);
		List<Map<String, Object>> data = new ArrayList<Map<String, Object>>();
		for (int i = 0; i < imgs.length; i++) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("img", imgs[i]);
			data.add(map);
		}
		SimpleAdapter adapter = new SimpleAdapter(this, data,
				R.layout.gallery_tmplate, new String[] { "img" },
				new int[] { R.id.iv });
		gallery.setAdapter(adapter);
		gallery.setOnItemSelectedListener(this);
		iv = new ImageView(this);
		iv.setImageResource(imgs[0]);
		initGame();
	}

	public void initGame() {
		main.removeAllViews();
		ivs = new ArrayList<ImageView>();
		for (int i = 0; i < n; i++) {
			LinearLayout ll = new LinearLayout(this);
			LayoutParams lp = new LayoutParams(LayoutParams.MATCH_PARENT,
					LayoutParams.WRAP_CONTENT);
			ll.setLayoutParams(lp);
			ll.setGravity(Gravity.CENTER_HORIZONTAL);
			for (int j = 0; j < n; j++) {
				ImageView iv = new ImageView(this);
				lp = new LayoutParams(LayoutParams.WRAP_CONTENT,
						LayoutParams.WRAP_CONTENT);
				iv.setLayoutParams(lp);
				ll.addView(iv);
				ivs.add(iv);
			}
			main.addView(ll);
		}
		tv.setText("");
		count = 0;
		sources = new ArrayList<Bitmap>();
		randoms = new ArrayList<Bitmap>();
		genBitmaps();
		getRandom();
		for (int i = 0; i < ivs.size(); i++) {
			ivs.get(i).setImageBitmap(randoms.get(i));
			ivs.get(i).setPadding(1, 1, 1, 1);
			ivs.get(i).setOnClickListener(this);
		}
	}

	public void genBitmaps() {
		Bitmap source = ((BitmapDrawable) iv.getDrawable()).getBitmap();
		int width = source.getWidth() / n;
		int height = source.getHeight() / n;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				Bitmap bm = Bitmap.createBitmap(source, j * width, i * height,
						width, height);
				sources.add(bm);
				randoms.add(bm);
			}
		}
	}

	public void getRandom() {
		Random rm = new Random();
		for (int i = 0; i < randoms.size(); i++) {
			int index = rm.nextInt(randoms.size());
			randoms.add(0, randoms.remove(index));
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		menu.add(1, 1, 1, "难度");
		menu.add(1, 2, 2, "退出");
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		if (item.getItemId() == 1) {
			new AlertDialog.Builder(this)
					.setTitle("选择难度")
					.setItems(new String[] { "3X3", "4X4" },
							new DialogInterface.OnClickListener() {

								@Override
								public void onClick(DialogInterface dialog,
										int which) {
									if (which == 0) {
										n = 3;
									} else if (which == 1) {
										n = 4;
									}
									initGame();
								}
							}).show();
		} else if (item.getItemId() == 2) {
			finish();
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onItemSelected(AdapterView<?> parent, View view, int position,
			long id) {
		iv = (ImageView) view.findViewById(R.id.iv);
		initGame();
	}

	@Override
	public void onNothingSelected(AdapterView<?> parent) {

	}

	@Override
	public void onClick(View v) {
		if (!v.equals(ivs.get(0))) {
			count++;
		}
		tv.setText("你已经用了" + count + "步");
		for (int i = 0; i < ivs.size(); i++) {
			if (v.equals(ivs.get(i))) {
				Bitmap tmp = randoms.get(0);
				randoms.set(0, randoms.get(i));
				randoms.set(i, tmp);
				ivs.get(0).setImageBitmap(randoms.get(0));
				ivs.get(i).setImageBitmap(randoms.get(i));
			}
		}
		if (Arrays.equals(sources.toArray(), randoms.toArray())) {
			Toast.makeText(this, "You win!!!", Toast.LENGTH_SHORT).show();
			tv.setText("你一共用了" + count + "步");
			for (int i = 0; i < ivs.size(); i++) {
				ivs.get(i).setPadding(0, 0, 0, 0);
				ivs.get(i).setOnClickListener(null);
			}
		}
	}

}
