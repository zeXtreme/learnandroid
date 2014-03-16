package me.zwy.code;

import bsh.EvalError;
import bsh.Interpreter;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity implements OnClickListener {
	
	private EditText editText_result;
	
	private int[] ids= {
			R.id.button_0,R.id.button_1,R.id.button_2,R.id.button_3,R.id.button_4,R.id.button_5,
			R.id.button_6,R.id.button_7,R.id.button_8,R.id.button_9,R.id.button_plus,R.id.button_minus,
			R.id.button_multiply,R.id.button_division,R.id.button_point,R.id.button_equal,R.id.button_clear
	};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText_result = (EditText) findViewById(R.id.editText_result);
        for(int i=0;i<ids.length;i++){
        	Button btn = (Button) findViewById(ids[i]);
        	btn.setOnClickListener(this);
        }
    }

	@Override
	public void onClick(View v) {
		if(editText_result.getText().toString().equals("0")){
			editText_result.setText("");
		}
		switch(v.getId()){
		case R.id.button_0:
			editText_result.append("0");
			break;
		case R.id.button_1:
			editText_result.append("1");
			break;
		case R.id.button_2:
			editText_result.append("2");
			break;
		case R.id.button_3:
			editText_result.append("3");
			break;
		case R.id.button_4:
			editText_result.append("4");
			break;
		case R.id.button_5:
			editText_result.append("5");
			break;
		case R.id.button_6:
			editText_result.append("6");
			break;
		case R.id.button_7:
			editText_result.append("7");
			break;
		case R.id.button_8:
			editText_result.append("8");
			break;
		case R.id.button_9:
			editText_result.append("9");
			break;
		case R.id.button_plus:
			editText_result.append("+");
			break;
		case R.id.button_minus:
			editText_result.append("-");
			break;
		case R.id.button_multiply:
			editText_result.append("*");
			break;
		case R.id.button_division:
			editText_result.append("/");
			break;
		case R.id.button_point:
			if(editText_result.getText().toString().equals("")){
				editText_result.append("0");
			}
			editText_result.append(".");
			break;
		case R.id.button_equal:
			Interpreter bsh = new Interpreter();
			try {
				bsh.eval("result=" + editText_result.getText().toString());
				editText_result.setText(bsh.get("result").toString());
			} catch (EvalError e) {
				e.printStackTrace();
			}
			break;
		case R.id.button_clear:
			editText_result.setText("0");
		}
	}
    
}
