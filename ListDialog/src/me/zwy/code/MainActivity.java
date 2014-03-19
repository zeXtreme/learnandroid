package me.zwy.code;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnMultiChoiceClickListener;
import android.view.View;

public class MainActivity extends Activity {

	String[] provinces = Resouces.provinces;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		for (int i = 0; i < provinces.length; i++) {
			isSelected[i] = false;
		}
	}

	public void list(View v) {
		OnClickListener listener = new OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {
				new AlertDialog.Builder(MainActivity.this).setMessage(
						"你选择了：" + Resouces.provinces[which]).show();
			}
		};
		new AlertDialog.Builder(this).setTitle("选择省份")
				.setIcon(android.R.drawable.ic_menu_more)
				.setItems(provinces, listener).show();
	}

	int selected = -1;

	public void single(View v) {
		OnClickListener listener = new OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {
				MainActivity.this.selected = which;
			}
		};
		new AlertDialog.Builder(this).setTitle("选择省份")
				.setIcon(android.R.drawable.ic_menu_more)
				.setSingleChoiceItems(provinces, selected, listener)
				.setPositiveButton("确定", new OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which) {
						new AlertDialog.Builder(MainActivity.this).setMessage(
								"你选择了：" + Resouces.provinces[MainActivity.this.selected]).show();
					}
				}).setNegativeButton("取消", null).show();
	}

	List<String> selectedList = new ArrayList<String>();
	boolean[] isSelected = new boolean[provinces.length];

	public void multi(View v) {
		OnMultiChoiceClickListener listener = new OnMultiChoiceClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which,
					boolean isChecked) {
				if (isChecked) {
					MainActivity.this.isSelected[which] = true;
					MainActivity.this.selectedList
							.add(Resouces.provinces[which]);
				} else {
					MainActivity.this.isSelected[which] = false;
					MainActivity.this.selectedList
							.remove(Resouces.provinces[which]);
				}
			}
		};
		new AlertDialog.Builder(this).setTitle("选择省份")
				.setIcon(android.R.drawable.ic_menu_more)
				.setMultiChoiceItems(provinces, isSelected, listener)
				.setPositiveButton("确定", new OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which) {
						String str = "";
						for (String s : MainActivity.this.selectedList) {
							str += s + " ";
						}
						new AlertDialog.Builder(MainActivity.this).setMessage(
								"你选择了：" + str).show();
					}
				}).setNegativeButton("取消", null).show();
	}

}
