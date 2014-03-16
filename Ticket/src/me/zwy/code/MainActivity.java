package me.zwy.code;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.app.Activity;

public class MainActivity extends Activity implements OnClickListener {

	EditText editText_num;
	Button button_gen;
	LinearLayout gens;
	TextView textView_title;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText_num = (EditText) findViewById(R.id.editText_num);
        button_gen = (Button) findViewById(R.id.button_gen);
        gens = (LinearLayout) findViewById(R.id.gens);
        button_gen.setOnClickListener(this);
        textView_title = (TextView) findViewById(R.id.textView_title);
    }
	@Override
	public void onClick(View v) {
		if(!editText_num.getText().toString().equals("")){
			gens.removeAllViews();
			textView_title.setText("随机彩票生成器：" + editText_num.getText().toString() + "组");
			List<TextView> tvs = getTickets();
			for(int i=0;i<tvs.size();i++){
				gens.addView(tvs.get(i), LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
			}
		}
	}
	public List<TextView> getTickets(){
		List<TextView> list = new ArrayList<TextView>();
		int ticketNum = Integer.parseInt(editText_num.getText().toString());
		for(int i=0;i<ticketNum;i++){
			TextView tv = new TextView(this);
			tv.setText((i+1) + "." + getTicket());
			tv.setTextSize(25.0f);
			list.add(tv);
		}
		return list;
	}
	public String getTicket(){
		String str = "";
		Random rm = new Random();
		List<Integer> ary = new ArrayList<Integer>();
		for(int i=1;i<=36;i++){
			ary.add(i);
		}
		Integer[] nums = new Integer[7];
		for(int i=0;i<nums.length;i++){
			nums[i] = ary.remove(rm.nextInt(ary.size()));
		}
		Log.d("ary", ary.toString());
		for(int i=0;i<nums.length;i++){
			if(i==nums.length-2){
				str += nums[i].toString() + "-";
			}else{
				str += nums[i].toString() + " ";
			}
		}
		return str;
	}


}
