package me.zwy.code;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener {

	ImageButton[] imageButtons;
	Button button_restart;
	List<Drawable> imgs;
	Drawable init;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageButtons = new ImageButton[3];
        imageButtons[0] = (ImageButton) findViewById(R.id.imageButton1);
        imageButtons[1] = (ImageButton) findViewById(R.id.imageButton2);
        imageButtons[2] = (ImageButton) findViewById(R.id.imageButton3);
        button_restart = (Button) findViewById(R.id.button_restart);
        init = getResources().getDrawable(R.drawable.p04);
        imgs = new ArrayList<Drawable>();
        imgs.add(getResources().getDrawable(R.drawable.p01));
        imgs.add(getResources().getDrawable(R.drawable.p02));
        imgs.add(getResources().getDrawable(R.drawable.p03));
        for(int i=0;i<imageButtons.length;i++){
        	imageButtons[i].setOnClickListener(this);
        }
        button_restart.setOnClickListener(this);
    }
    
    public void getRandomButton(){
    	Random rm = new Random();
    	List<ImageButton> images = new ArrayList<ImageButton>();
    	for(int i=0;i<imageButtons.length;i++){
    		images.add(imageButtons[i]);
    	}
    	for(int i=0;i<3;i++){
    		imageButtons[i] = images.remove(rm.nextInt(images.size()));
    	}
    }

    boolean isGuessed = false;
	@Override
	public void onClick(View v) {
		if(v.getId()==R.id.button_restart){
			for(int i=0;i<imageButtons.length;i++){
				imageButtons[i].setImageDrawable(init);
				isGuessed = false;
			}
		}else{
			if(!isGuessed){
				getRandomButton();
				for(int i=0;i<imgs.size();i++){
					imageButtons[i].setImageDrawable(imgs.get(i));
				}
				if(v.getId()==imageButtons[0].getId()){
					Toast.makeText(this, "¹§Ï²Äã²Â¶ÔÁË£¡", Toast.LENGTH_SHORT).show();
				}else{
					Toast.makeText(this, "¹§Ï²Äã²Â´íÁË£¡", Toast.LENGTH_SHORT).show();
				}
				isGuessed = true;
			}
		}
	}
    
}
