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
		menu.add(1, 1, 1, "关于");
		menu.add(1, 2, 2, "检查更新");
		menu.add(1, 3, 3, "设置");
		menu.add(1, 4, 4, "状态").setCheckable(true).setChecked(true);
		menu.add(1, 5, 5, "更多");
		menu.add(2, 6, 6, "选择").setChecked(true);
		menu.add(2, 7, 7, "不选择");
		menu.setGroupCheckable(2, true, true);
		SubMenu sm = menu.addSubMenu(3, 8, 0, "更更多");
		sm.setHeaderTitle("更更多");
		sm.add(4, 9, 1, "复制");
		sm.add(4, 10, 2, "粘贴");
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
