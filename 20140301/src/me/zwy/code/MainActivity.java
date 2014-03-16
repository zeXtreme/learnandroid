package me.zwy.code;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity implements OnClickListener {

	private Button buttonChange;
	private EditText editInput;
	private Button buttonExit;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.event);
        buttonChange = (Button) findViewById(R.id.buttonChange);
        editInput = (EditText) findViewById(R.id.editInput);
        buttonExit = (Button) findViewById(R.id.buttonExit);
        editInput.setText("Hello,World");
        buttonChange.setOnClickListener(this);
        buttonExit.setOnClickListener(this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }


	@Override
	public void onClick(View v) {
		if(v.getId() == R.id.buttonExit){
			System.exit(0);
		}
		editInput.setBackgroundColor(Color.argb(127, 255, 255, 0));
		editInput.setText("World,Hello");
	}
    
}
