package me.zwy.code;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.widget.EditText;

public class MainActivity extends Activity {

	EditText et;
	String gender = "";
	List<String> hobby = new ArrayList<String>();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		et = (EditText) findViewById(R.id.et);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		SubMenu sm1 = menu.addSubMenu(1, 1, 1, "性别").setIcon(R.drawable.gender);
		SubMenu sm2 = menu.addSubMenu(1, 2, 2, "爱好").setIcon(R.drawable.hobby);
		sm1.setHeaderTitle("性别");
		sm1.setHeaderIcon(R.drawable.gender);
		sm1.add(2, 3, 1, "男");
		sm1.add(2, 4, 2, "女");
		sm1.setGroupCheckable(2, true, true);
		sm2.setHeaderTitle("爱好");
		sm2.setHeaderIcon(R.drawable.hobby);
		sm2.add(3, 5, 1, "游泳").setCheckable(true);
		sm2.add(3, 6, 2, "唱歌").setCheckable(true);
		sm2.add(3, 7, 3, "写java程序").setCheckable(true);
		menu.add(1, 8, 3, "确定");
		return super.onCreateOptionsMenu(menu);
	}
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		String str = "";
		switch(item.getItemId()){
		case 3:
			item.setChecked(true);
			gender = "男";
			et.append("您选择的性别为：" + gender + "。\n");
			break;
		case 4:
			item.setChecked(true);
			gender = "女";
			et.append("您选择的性别为：" + gender + "。\n");
			break;
		case 5:
			if(item.isChecked()){
				item.setChecked(false);
				hobby.remove("游泳");
			}else{
				item.setChecked(true);
				hobby.add("游泳");
			}
			for(String s : hobby){
				str = str + s + "、";
			}
			et.append("您选择的性别为：" + gender + ",您选择的爱好为：" + str + "\n");
			break;
		case 6:
			if(item.isChecked()){
				item.setChecked(false);
				hobby.remove("唱歌");
			}else{
				item.setChecked(true);
				hobby.add("唱歌");
			}
			for(String s : hobby){
				str = str + s + "、";
			}
			et.append("您选择的性别为：" + gender + ",您选择的爱好为：" + str + "\n");
			break;
		case 7:
			if(item.isChecked()){
				item.setChecked(false);
				hobby.remove("写java程序");
			}else{
				item.setChecked(true);
				hobby.add("写java程序");
			}
			for(String s : hobby){
				str = str + s + "、";
			}
			et.append("您选择的性别为：" + gender + ",您选择的爱好为：" + str + "\n");
			break;
		case 8:
			for(String s : hobby){
				str = str + s + "、";
			}
			et.append("您选择的性别为：" + gender + ",您选择的爱好为：" + str + "\n");
			break;
		}
		return super.onOptionsItemSelected(item);
	}

}
