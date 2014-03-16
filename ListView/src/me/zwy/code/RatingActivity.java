package me.zwy.code;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

public class RatingActivity extends Activity implements OnClickListener {
	
	ImageView appimg;
	TextView app;
	RatingBar ratingBar;
	Button ok;
	Button cancel;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.rating);
		appimg = (ImageView) findViewById(R.id.appimg);
		app = (TextView) findViewById(R.id.app);
		ratingBar = (RatingBar) findViewById(R.id.ratingBar);
		ok = (Button) findViewById(R.id.ok);
		cancel = (Button) findViewById(R.id.cancel);
		Bundle bundle = getIntent().getExtras();
		ratingBar.setRating(bundle.getFloat("rate"));
		appimg.setImageResource(bundle.getInt("appimg"));
		app.setText(bundle.getCharSequence("app"));
		ok.setOnClickListener(this);
		cancel.setOnClickListener(this);
	}
	@Override
	public void onClick(View v) {
		if(v.getId() == R.id.ok){
			Intent it = new Intent();
			it.putExtra("rate", ratingBar.getRating());
			setResult(Activity.RESULT_OK, it);
			finish();
		}else if(v.getId() == R.id.cancel){
			setResult(Activity.RESULT_CANCELED);
			finish();
		}
	}

}
