package me.zwy.code;

import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.EditText;
import android.app.Activity;

public class MainActivity extends Activity implements OnClickListener {

	EditText et;
	CheckBox cb;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		et = (EditText) findViewById(R.id.editText_pwd);
		cb = (CheckBox) findViewById(R.id.checkBox);
		cb.setOnClickListener(this);
	}
	@Override
	public void onClick(View v) {
		if(cb.isChecked()){
			et.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
		}else if(!cb.isChecked()){
			et.setTransformationMethod(PasswordTransformationMethod.getInstance());
		}
	}

}
