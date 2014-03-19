package me.zwy.code;

import android.os.Bundle;
import android.app.Activity;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ContextMenu.ContextMenuInfo;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends Activity {

	ImageView iv;
	TextView tv;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		tv = (TextView) findViewById(R.id.tv);
		iv = (ImageView) findViewById(R.id.iv);
		registerForContextMenu(iv);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		return true;
	}

	@Override
	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenuInfo menuInfo) {
		MenuInflater flater = getMenuInflater();
		flater.inflate(R.menu.main, menu);
		super.onCreateContextMenu(menu, v, menuInfo);
	}

	@Override
	public boolean onContextItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case 4:
			iv.setImageResource(android.R.drawable.ic_menu_edit);
			break;
		default:
			iv.setImageResource(R.drawable.ic_launcher);
		}
		return super.onContextItemSelected(item);
	}

}
