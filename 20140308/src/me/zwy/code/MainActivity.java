package me.zwy.code;

import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;

public class MainActivity extends Activity implements OnClickListener {

	Button bt;
	Button bt2;
	Button btp;
	ImageView iv;
	static final int N = 1;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		bt = (Button) findViewById(R.id.button1);
		bt.setOnClickListener(this);
		bt2 = (Button) findViewById(R.id.button2);
		bt2.setOnClickListener(this);
		btp = (Button) findViewById(R.id.buttonp);
		btp.setOnClickListener(this);
		iv = (ImageView) findViewById(R.id.imageView1);
	}
	@Override
	public void onClick(View v) {
		if(v.getId()==R.id.button1){
			Intent it = new Intent(this, SecondActivity.class);
			startActivity(it);
		}else if(v.getId()==R.id.button2){
			Intent it = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.com"));
			startActivity(it);
		}else if(v.getId()==R.id.buttonp){
			Intent it = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
			startActivityForResult(it, MainActivity.N);
		}
	}
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if(requestCode == MainActivity.N){
			if(resultCode == Activity.RESULT_OK){
				Bitmap bitmap = (Bitmap) data.getExtras().get("data");
				iv.setImageBitmap(bitmap);
			}
		}
	}

}
