package com.ryd.drawclasstext.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import androidx.annotation.Nullable;

import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;

public class Practice13GetTextBoundsView extends View {
    Paint paint1 = new Paint(Paint.ANTI_ALIAS_FLAG);
    Paint paint2 = new Paint(Paint.ANTI_ALIAS_FLAG);
    String text1 = "A";
    String text2 = "a";
    String text3 = "J";
    String text4 = "j";
    String text5 = "Â";
    String text6 = "â";
    int top = 200;
    int bottom = 400;

    public Practice13GetTextBoundsView(Context context) {
        super(context);
    }

    public Practice13GetTextBoundsView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice13GetTextBoundsView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    {
        paint1.setStyle(Paint.Style.STROKE);
        paint1.setStrokeWidth(20);
        paint1.setColor(Color.parseColor("#E91E63"));
        paint2.setTextSize(160);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawRect(50, top, getWidth() - 50, bottom, paint1);

        // 使用 Paint.getTextBounds() 计算出文字的显示区域
        // 然后计算出文字的绘制位置，从而让文字上下居中
        // 这种居中算法的优点是，可以让文字精准地居中，分毫不差
        //
        Rect rect1 = new Rect();
        paint2.getTextBounds(text1, 0, text1.length(), rect1);
        int middle1 = (rect1.bottom + rect1.top) / 2; //这个为该字的一个y轴矩阵中间大小
        Rect rect2 = new Rect();
        paint2.getTextBounds(text2, 0, text2.length(), rect2);
        int middle2 = (rect2.bottom + rect2.top) / 2;
        Rect rect3 = new Rect();
        paint2.getTextBounds(text3, 0, text3.length(), rect3);
        int middle3 = (rect3.bottom + rect3.top) / 2;
        Rect rect4 = new Rect();
        paint2.getTextBounds(text4, 0, text4.length(), rect4);
        int middle4 = (rect4.bottom + rect4.top) / 2;
        Rect rect5 = new Rect();
        paint2.getTextBounds(text5, 0, text5.length(), rect5);
        int middle5 = (rect5.bottom + rect5.top) / 2;
        Rect rect6 = new Rect();
        paint2.getTextBounds(text6, 0, text6.length(), rect6);
        int middle6 = (rect6.bottom + rect6.top) / 2;
        int middle = (top + bottom) / 2;
        canvas.drawText(text1, 100, middle + (-middle1), paint2);//相当于将个字符的baseline移动半个该字符的距离，及在所以就显示在中间了
        canvas.drawText(text2, 200, middle + (-middle2), paint2);
        canvas.drawText(text3, 300, middle + (-middle3), paint2);
        canvas.drawText(text4, 400, middle + (-middle4), paint2);
        canvas.drawText(text5, 500, middle + (-middle5), paint2);
        canvas.drawText(text6, 600, middle + (-middle6), paint2);
    }
}