package com.example.yangyang.textviewdemo;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by yangyang on 15/10/7.
 */
public class ToDoListItemView extends TextView {
    private Paint marginPaint;
    private Paint linePaint;
    private int paperColor;
    private float margin;
    public ToDoListItemView(Context context,AttributeSet attributeSet,int ds){
        super(context,attributeSet,ds);
        init();
    }
    public ToDoListItemView(Context context){
        super(context);
        init();
    }
    public ToDoListItemView(Context context,AttributeSet attributeSet){
        super(context,attributeSet);
        init();
    }
    public void init(){
        Resources myResources=getResources();
        marginPaint=new Paint(Paint.ANTI_ALIAS_FLAG);
        marginPaint.setColor(myResources.getColor(R.color.notepad_margin));
        linePaint=new Paint(Paint.ANTI_ALIAS_FLAG);
        linePaint.setColor(myResources.getColor(R.color.notepad_lines));
        paperColor=myResources.getColor(R.color.notepad_paper);
        margin=myResources.getDimension(R.dimen.notepad_margin);




    }
    @Override
    public void onDraw(Canvas canvas){
        canvas.drawColor(paperColor);
        //绘制边缘
        canvas.drawLine(0,0,0,getMeasuredHeight(),linePaint);
        canvas.drawLine(0,getMeasuredHeight(),getMeasuredWidth(),getMeasuredHeight(),linePaint);
        canvas.drawLine(margin,0,margin,getMeasuredHeight(),marginPaint);
        canvas.save();
        //改变之后绘图的原点位置，从而使文本跨越。
        canvas.translate(margin, 0);



        super.onDraw(canvas);
        canvas.restore();
    }

}
