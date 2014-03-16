package me.zwy.code;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity implements OnClickListener {

	EditText editTextIn;
	Button buttonQuery;
	TextView textViewShow;
	static final int N = 2;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		editTextIn = (EditText) findViewById(R.id.editTextIn);
		buttonQuery = (Button) findViewById(R.id.buttonQuery);
		textViewShow = (TextView) findViewById(R.id.textViewShow);
		buttonQuery.setOnClickListener(this);
	}
	@Override
	public void onClick(View v) {
		if(editTextIn.getText().toString().length()==11){
			Intent it = new Intent(MainActivity.this, QueryActivity.class);
			it.putExtra("phoneNumber", editTextIn.getText().toString());
			this.startActivityForResult(it, MainActivity.N);
		}else{
			textViewShow.setText("输入的手机号码不符合要求！请重新输入！");
		}
	}
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if(resultCode == Activity.RESULT_OK){
			if(requestCode == MainActivity.N){
				textViewShow.setText(data.getExtras().getString("text"));
			}
		}
	}
	
}
