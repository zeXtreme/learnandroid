package me.zwy.code;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends Activity implements OnClickListener {

	Button btn;
	LinearLayout ll;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        System.out.println("load...");
        setContentView(R.layout.activity_main);
        btn = (Button) findViewById(R.id.button1);
        btn.setOnClickListener(this);
        ll = (LinearLayout) getLayoutInflater().inflate(R.layout.activity_main, null);
        System.out.println("load...");
    }
	@Override
	public void onClick(View v) {
		System.out.println("clicked");
		Button bt = new Button(this);
		bt.setText("new");
		ll.addView(bt, new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
		setContentView(ll);
	}

}
