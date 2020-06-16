package com.ryd.drawclass.paint.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.graphics.SweepGradient;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class Practice03SweepGradientView extends View {
    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);

    public Practice03SweepGradientView(Context context) {
        super(context);
    }

    public Practice03SweepGradientView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice03SweepGradientView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    {
        // 用 Paint.setShader(shader) 设置一个 SweepGradient
        // SweepGradient 的参数：圆心坐标：(300, 300)；颜色：#E91E63 到 #2196F3
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        drawSweepGradient(canvas, 300, 300);
        drawSweepGradient(canvas, 700, 300);
        drawSweepGradient(canvas, 1100, 300);
    }

    //画扫描型着色器的方法
    private void drawSweepGradient(Canvas canvas, float cx, float cy) {
        Shader shader = new SweepGradient(cx, cy, Color.parseColor("#E91E63"), Color.parseColor("#2196F3"));
        paint.setShader(shader);
        canvas.drawCircle(cx, cy, 200, paint);
    }
}
