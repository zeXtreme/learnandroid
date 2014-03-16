package me.zwy.code;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class QueryActivity extends Activity implements OnClickListener {

	Button buttonReturn;
	String[] str={"0　　　　神人",
			"1　　　　大展鸿图．可获成功　吉", 
			"2　　　　一盛一衰．劳而无功　凶 ",
			"3　　　　蒸蒸日上．百事顺遂　吉 ",
			"4　　　　坎坷前途．苦难折磨　凶 ",
			"5　　　　生意欣荣．名利双收　吉 ",
			"6　　　　天降幸运．可成大功　吉 ",
			"7　　　　和气致祥．必获成功　吉 ",
			"8　　　　贯彻志望．成功可期　吉 ",
			"9　　　　独营无力．财利无望　凶 ",
			"10　　　 空费心力．徒劳无功　凶 ",
			"11　　　 稳健着实．必得人望　吉 ",
			"12　　　 薄弱无力．谋事难成　凶 ",
			"13　　　 天赋吉运．能得人望　吉 ",
			"14　　　 是成是败．惟靠坚毅　凶 ",
			"15　　　 大事成就．一定兴隆　吉 ",
			"16　　　 成就大业．名利双收　吉 ",
			"17　　　 有贵人助．可得成功　吉 ",
			"18　　　 顺利昌隆．百事亨通　吉 ",
			"19　　　 内外不合．障碍重重　凶 ",
			"20　　　 历尽艰难．焦心忧劳　凶 ",
			"21　　　 专心经营．善用智慧　吉 ",
			"22　　　 怀才不遇．事不如意　凶 ",
			"23　　　 名显四方．终成大业　吉 ",
			"24　　　 须靠自力．能奏大功　吉 ",
			"25　　　 天时地利．再得人格　吉 ",
			"26　　　 波澜起伏．凌驾万难　凶 ",
			"27　　　 一盛一衰．可守成功　凶带吉 ",
			"28　　　 青云直上．才略奏功　吉 ",
			"29　　　 吉凶参半．得失相伴　凶 ",
			"30　　　 名利双收．大业成就　吉 ",
			"31　　　 池中之龙．成功可望　吉 ",
			"32　　　 智慧慎始．必可昌隆　吉 ",
			"33　　　 灾难不绝．难望成功　凶 ",
			"34　　　 中吉之数．进退保守　吉 ",
			"35　　　 波澜重叠．常陷穷困　凶 ",
			"36　　　 逢凶化吉．风调雨顺　吉 ",
			"37　　　 名虽可得．利则难获　凶带吉 ",
			"38　　　 光明坦途．指日可待　吉 ",
			"39　　　 一盛一衰．浮沉不定　吉带凶 ",
			"40　　　 天赋吉运．前途无限　吉 ",
			"41　　　 事业不专．十九不成　吉带凶 ",
			"42　　　 忍耐自重．转凶为吉　吉带凶 ",
			"43　　　 事难遂愿．贪功好进　凶 ",
			"44　　　 绿叶发枝．一举成名　吉 ",
			"45　　　 坎坷不平．艰难重重　凶 ",
			"46　　　 有贵人助．可成大业　吉 ",
			"47　　　 名利俱全．繁荣富贵　吉 ",
			"48　　　 遇吉则吉．遇凶则凶　凶 ",
			"49　　　 吉凶互见．一成一败　吉带凶 ",
			"50　　　 一盛一衰．浮沉不常　吉带凶 ",
			"51　　　 雨过天青．即获成功　吉 ",
			"52　　　 盛衰参半．先吉後凶　吉带凶 ",
			"53　　　 虽倾全力．难望成功　凶 ",
			"54　　　 外观隆昌．内隐祸患　吉带凶 ",
			"55　　　 事与愿违．终难成功　凶 ",
			"56　　　 努力经营．时来运转　吉 ",
			"57　　　 浮沉多端．始凶终吉　凶带吉 ",
			"58　　　 遇事犹疑．难望成事　凶 ",
			"59　　　 心迷意乱．难定方针　凶 ",
			"60　　　 云遮半月．百隐风波　吉带凶 ",
			"61　　　 烦闷懊恼．事事难展　凶 ",
			"62　　　 万物化育．繁荣之象　吉 ",
			"63　　　 十九不成．徒劳无功　凶 ",
			"64　　　 吉运自来．能享盛名　吉 ",
			"65　　　 内外不和．信用缺乏　凶 ",
			"66　　　 事事如意．富贵自来　吉 ",
			"67　　　 不失先机．可望成功　吉 ",
			"68　　　 动摇不安．常陷逆境　凶 ",
			"69　　　 惨淡经营．难免贫困　凶 ",
			"70　　　 吉凶参半．惟赖勇气　吉带凶 ",
			"71　　　 得而复失．难以安顺　凶 ",
			"72　　　 安乐自来．自然吉祥　吉 ",
			"73　　　 如无智谋．难望成功　凶 ",
			"74　　　 吉中带凶．进不如守　吉带凶 ",
			"75　　　 此数大凶．破产之象　凶 ",
			"76　　　 先苦後甘．不致失败　吉带凶 ",
			"77　　　 有得有失．华而不实　吉带凶 ",
			"78　　　 前途无光．希望不大　凶 ",
			"79　　　 得而复失．枉费心机　吉带凶 ",
			"80　　　 最极之数．能得成功"				
	};
	String text;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.query);
		buttonReturn = (Button) findViewById(R.id.buttonReturn);
		buttonReturn.setOnClickListener(this);
		text = getText();
	}
	@Override
	public void onClick(View v) {
		Intent it = new Intent();
		it.putExtra("text", text);
		setResult(Activity.RESULT_OK, it);
		finish();
	}
	public int getResult(){
		String phoneNumber = getIntent().getExtras().getString("phoneNumber");
		String str = phoneNumber.substring(phoneNumber.length()-4);
		int num = Integer.parseInt(str);
		Double tmp = num/80.0;
		tmp = Double.parseDouble("0." + tmp.toString().split("\\.")[1]);
		num = (int) (tmp*80);
		return num;
	}
	public String getText(){
		int num = getResult();
		for(String s : str){
			String[] ss = s.split("(　)+");
			for(int i=0;i<ss.length;i++){
				int j = Integer.parseInt(ss[0]);
				if(num == 0||num == 80){
					return ss[1];
				}else if(num == j){
					return ss[1] + "\n" + ss[2];
				}
			}
		}
		return null;
	}
	
}
