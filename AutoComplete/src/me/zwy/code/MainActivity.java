package me.zwy.code;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.MultiAutoCompleteTextView;
import android.app.Activity;

public class MainActivity extends Activity {

	AutoCompleteTextView actv;
	MultiAutoCompleteTextView mactv;
	String[] strs = { "zhang san", "li si", "wang wu", "zhao liu", "ÖÐÎÄ" };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		actv = (AutoCompleteTextView) findViewById(R.id.actv);
		mactv = (MultiAutoCompleteTextView) findViewById(R.id.mactv);
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_dropdown_item_1line, strs);
		actv.setAdapter(adapter);
		mactv.setAdapter(adapter);
	}

}
