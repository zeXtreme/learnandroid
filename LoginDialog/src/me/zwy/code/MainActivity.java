package me.zwy.code;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {

	Button bt;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		bt = (Button) findViewById(R.id.button1);
		bt.setOnClickListener(l);
	}

	public OnClickListener l = new OnClickListener() {

		@Override
		public void onClick(View v) {
			View view = getLayoutInflater().inflate(R.layout.logindialog,
					null);
			new AlertDialog.Builder(MainActivity.this).setTitle("�û���¼")
					.setView(view).setPositiveButton("��½", null)
					.setNegativeButton("ȡ��", null).show();
		}
	};

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
