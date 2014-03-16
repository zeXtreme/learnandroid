package me.zwy.code;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.app.Activity;

public class MainActivity extends Activity implements OnClickListener, OnItemSelectedListener {

	Spinner sp;
	Button bt;
	String[] strs = {"第一个","第二个","第三个"};
	String selected;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		sp = (Spinner) findViewById(R.id.spinner);
		bt = (Button) findViewById(R.id.bt);
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, strs);
		sp.setAdapter(adapter);
		bt.setOnClickListener(this);
		sp.setOnItemSelectedListener(this);
	}
	@Override
	public void onClick(View v) {
		CheckedTextView ctv = (CheckedTextView) sp.getSelectedView();
		Toast.makeText(this, ctv.getText().toString(), Toast.LENGTH_SHORT).show();
	}
	@Override
	public void onItemSelected(AdapterView<?> parent, View view, int position,
			long id) {
		CheckedTextView ctv = (CheckedTextView) view;
		Toast.makeText(this, ctv.getText().toString(), Toast.LENGTH_SHORT).show();
	}
	@Override
	public void onNothingSelected(AdapterView<?> parent) {
		// TODO Auto-generated method stub
		
	}

}
