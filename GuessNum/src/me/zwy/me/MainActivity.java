package me.zwy.me;

import java.util.Random;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity implements OnClickListener {
	
	private int[] randnum = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button_start = (Button) findViewById(R.id.button_start);
        Button button_exit = (Button) findViewById(R.id.button_exit);
        button_start.setOnClickListener(this);
        button_exit.setOnClickListener(this);
    }

    public void getRandomNum(){
    	randnum = new int[4];
    	Random rm = new Random();
    	for(int i=0;i<randnum.length;i++){
    		randnum[i] = rm.nextInt(10);
    		if(i==0&&randnum[i]==0){
    			i--;
    			continue;
    		}
    		boolean flag = false;
    		for(int j=0;j<i;j++){
    			if(randnum[i]==randnum[j]){
    				flag = true;
    			}
    		}
    		if(flag){
    			i--;
    			continue;
    		}
    	}
    }
    
    public int[] getInputNum(int num){
    	int[] inputNum = new int[4];
    	inputNum[0] = num/1000;
    	inputNum[1] = num%1000/100;
    	inputNum[2] = num%100/10;
    	inputNum[3] = num%10;
    	return inputNum;
    }
    
    public int getA(int[] rand, int[] input){
    	int count = 0;
    	for(int i=0;i<rand.length;i++){
    		if(rand[i]==input[i]){
    			count++;
    		}
    	}
    	return count;
    }
    
    public int getB(int[] rand, int[] input){
    	int count = 0;
    	for(int i=0;i<rand.length;i++){
    		for(int j=0;j<input.length;j++){
    			if(rand[i]==input[j]){
    				count++;
    			}
    		}
    	}
    	return count;
    }


    int gameCount = 0;
    TextView textView_game = null;
    EditText editText_input = null;
    Button button_submit = null;
    TextView textView_result = null;
    Button button_giveup = null;
    TextView textView_num = null;
	@Override
	public void onClick(View v) {
		if(v.getId()==R.id.button_exit){
			System.exit(0);
		}else if(v.getId()==R.id.button_start){
			setContentView(R.layout.game);
			getRandomNum();
			textView_game = (TextView) findViewById(R.id.textView_game);
			editText_input = (EditText) findViewById(R.id.editText_input);
			button_submit = (Button) findViewById(R.id.button_submit);
			textView_result = (TextView) findViewById(R.id.textView_result);
			button_giveup = (Button) findViewById(R.id.button_giveup);
			textView_num = (TextView) findViewById(R.id.textView_num);
			button_submit.setOnClickListener(this);
			button_giveup.setOnClickListener(this);
		}else if(v.getId()==R.id.button_submit){
			gameCount++;
			textView_game.setText("你已经猜了" + gameCount + "次");
			int input = Integer.parseInt(editText_input.getText().toString());
			int a = getA(randnum, getInputNum(input));
			int b = getB(randnum, getInputNum(input));
			if(a == 4&&b == 4){
				textView_result.setText("恭喜你已经猜出这个数字！");
				textView_num.setText("生成的数字是：" + getRandNum(randnum));
			}else{
				textView_result.setText(a + " A " + b + " B");
			}
		}else if(v.getId()==R.id.button_giveup){
			textView_num.setText("上次生成的数字是：" + getRandNum(randnum));
			gameCount = 0;
			textView_game.setText("你已经猜了" + gameCount + "次");
			getRandomNum();
		}
	}
	
	public int getRandNum(int[] randnum){
		int randNum;
		randNum = randnum[0]*1000 + randnum[1]*100 + randnum[2]*10 + randnum[3];
		return randNum;
	}
    
}
