package me.zwy.code;

import android.os.Bundle;
import android.app.Activity;
import android.text.InputFilter;
import android.text.Spanned;
import android.util.Log;
import android.widget.EditText;

public class MainActivity extends Activity implements InputFilter {

	EditText et;
	InputFilter[] filter;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		et = (EditText) findViewById(R.id.editText1);
		filter = new InputFilter[1];
		filter[0] = this;
		et.setFilters(filter);
	}

	@Override
	public CharSequence filter(CharSequence source, int start, int end,
			Spanned dest, int dstart, int dend) {
		Log.d("source", source.toString().substring(start, end));
		Log.d("dest", dest.toString().substring(dstart, dend)+" "+dstart+" "+dend);
		return "newer.com";
	}

}
