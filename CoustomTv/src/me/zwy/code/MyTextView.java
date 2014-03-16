package me.zwy.code;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.TextView;

public class MyTextView extends TextView {

	Bitmap bitmap;
	public MyTextView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		// TODO Auto-generated constructor stub
	}

	public MyTextView(Context context, AttributeSet attrs) {
		super(context, attrs);
		int resourceId = attrs.getAttributeResourceValue(null, "pic", 0);
		if(resourceId>0){
			bitmap = BitmapFactory.decodeResource(getResources(), resourceId);
		}
		// TODO Auto-generated constructor stub
	}

	public MyTextView(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	protected void onDraw(Canvas canvas) {
		Paint paint = new Paint();
		paint.setAntiAlias(true);
		Rect src = new Rect();
		Rect dst = new Rect();
		src.left = 0;
		src.top = 0;
		src.right = bitmap.getWidth();
		src.bottom = bitmap.getHeight();
		dst.left = 0;
		dst.top = 0;
		dst.right = (int) getTextSize();
		dst.bottom = (int) getTextSize();
		canvas.drawBitmap(bitmap, src, dst, paint);
		super.onDraw(canvas);
	}

}
