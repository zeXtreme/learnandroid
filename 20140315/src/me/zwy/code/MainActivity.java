package me.zwy.code;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		menu.add(1, 1, 1, "����");
		menu.add(1, 2, 2, "������");
		menu.add(1, 3, 3, "����");
		menu.add(1, 4, 4, "״̬").setCheckable(true).setChecked(true);
		menu.add(1, 5, 5, "����");
		menu.add(2, 6, 6, "ѡ��").setChecked(true);
		menu.add(2, 7, 7, "��ѡ��");
		menu.setGroupCheckable(2, true, true);
		SubMenu sm = menu.addSubMenu(3, 8, 0, "������");
		sm.setHeaderTitle("������");
		sm.add(4, 9, 1, "����");
		sm.add(4, 10, 2, "ճ��");
		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		if(item.getItemId() == 3){
			Toast.makeText(this, item.getTitle().toString(), Toast.LENGTH_SHORT).show();
		}
		return super.onOptionsItemSelected(item);
	}
	
	@Override
	public boolean onMenuItemSelected(int featureId, MenuItem item) {
		// TODO Auto-generated method stub
		return super.onMenuItemSelected(featureId, item);
	}

}
