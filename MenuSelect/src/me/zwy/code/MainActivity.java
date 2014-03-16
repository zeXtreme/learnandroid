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
		SubMenu sm1 = menu.addSubMenu(1, 1, 1, "�Ա�").setIcon(R.drawable.gender);
		SubMenu sm2 = menu.addSubMenu(1, 2, 2, "����").setIcon(R.drawable.hobby);
		sm1.setHeaderTitle("�Ա�");
		sm1.setHeaderIcon(R.drawable.gender);
		sm1.add(2, 3, 1, "��");
		sm1.add(2, 4, 2, "Ů");
		sm1.setGroupCheckable(2, true, true);
		sm2.setHeaderTitle("����");
		sm2.setHeaderIcon(R.drawable.hobby);
		sm2.add(3, 5, 1, "��Ӿ").setCheckable(true);
		sm2.add(3, 6, 2, "����").setCheckable(true);
		sm2.add(3, 7, 3, "дjava����").setCheckable(true);
		menu.add(1, 8, 3, "ȷ��");
		return super.onCreateOptionsMenu(menu);
	}
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		String str = "";
		switch(item.getItemId()){
		case 3:
			item.setChecked(true);
			gender = "��";
			et.append("��ѡ����Ա�Ϊ��" + gender + "��\n");
			break;
		case 4:
			item.setChecked(true);
			gender = "Ů";
			et.append("��ѡ����Ա�Ϊ��" + gender + "��\n");
			break;
		case 5:
			if(item.isChecked()){
				item.setChecked(false);
				hobby.remove("��Ӿ");
			}else{
				item.setChecked(true);
				hobby.add("��Ӿ");
			}
			for(String s : hobby){
				str = str + s + "��";
			}
			et.append("��ѡ����Ա�Ϊ��" + gender + ",��ѡ��İ���Ϊ��" + str + "\n");
			break;
		case 6:
			if(item.isChecked()){
				item.setChecked(false);
				hobby.remove("����");
			}else{
				item.setChecked(true);
				hobby.add("����");
			}
			for(String s : hobby){
				str = str + s + "��";
			}
			et.append("��ѡ����Ա�Ϊ��" + gender + ",��ѡ��İ���Ϊ��" + str + "\n");
			break;
		case 7:
			if(item.isChecked()){
				item.setChecked(false);
				hobby.remove("дjava����");
			}else{
				item.setChecked(true);
				hobby.add("дjava����");
			}
			for(String s : hobby){
				str = str + s + "��";
			}
			et.append("��ѡ����Ա�Ϊ��" + gender + ",��ѡ��İ���Ϊ��" + str + "\n");
			break;
		case 8:
			for(String s : hobby){
				str = str + s + "��";
			}
			et.append("��ѡ����Ա�Ϊ��" + gender + ",��ѡ��İ���Ϊ��" + str + "\n");
			break;
		}
		return super.onOptionsItemSelected(item);
	}

}
