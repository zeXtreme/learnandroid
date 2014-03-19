package me.zwy.code;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public void dialog(View view) {
		int id = view.getId();
		if (id == R.id.button1) {
			new AlertDialog.Builder(this).setTitle("This is a Dialog")
					.setMessage("This is content in Dialog")
					.setIcon(android.R.drawable.ic_dialog_info).show();
		} else if (id == R.id.button2) {
			new AlertDialog.Builder(this).setTitle("ɾ������")
//			.setMessage("�����ܳ���")
					.setIcon(android.R.drawable.ic_delete)
					.setPositiveButton("ȷ��", new OnClickListener() {

						@Override
						public void onClick(DialogInterface dialog, int which) {

						}
					}).setNegativeButton("ȡ��", null)
					.setNeutralButton("�м�", null)
//					.setItems(new String[]{"aaa","bbbb"}, null)
					.show();
		}
	}

//	@Override
//	public void onBackPressed() {
//		new AlertDialog.Builder(this).setTitle("ȷ���˳�")
//				.setIcon(android.R.drawable.ic_dialog_alert)
//				.setMessage("ȷ���˳�����").setPositiveButton("ȷ��", listener)
//				.setNegativeButton("ȡ��", listener).show();
//	}
	OnClickListener listener = new OnClickListener() {
		
		@Override
		public void onClick(DialogInterface dialog, int which) {
			if(which == DialogInterface.BUTTON_POSITIVE){
				finish();
			}
		}
	};
	
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if(keyCode == KeyEvent.KEYCODE_BACK){
			new AlertDialog.Builder(this).setTitle("ȷ���˳�")
			.setIcon(android.R.drawable.ic_dialog_alert)
			.setMessage("ȷ���˳�����").setPositiveButton("ȷ��", listener)
			.setNegativeButton("ȡ��", listener).show();
		}
		return false;
	};

}
