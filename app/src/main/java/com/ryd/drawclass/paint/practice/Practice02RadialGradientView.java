package com.ryd.drawclass.paint.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class Practice02RadialGradientView extends View {
    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);

    public Practice02RadialGradientView(Context context) {
        super(context);
    }

    public Practice02RadialGradientView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice02RadialGradientView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    {
        // 用 Paint.setShader(shader) 设置一个 RadialGradient
        // RadialGradient 的参数：圆心坐标：(300, 300)；半径：200；颜色：#E91E63 到 #2196F3
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        drawRadiaGradient(canvas, Shader.TileMode.CLAMP, 300, 300);
        drawRadiaGradient(canvas, Shader.TileMode.MIRROR, 700, 300);
        drawRadiaGradient(canvas, Shader.TileMode.REPEAT, 1100, 300);

    }

    //画放射型着色器的方法
    private void drawRadiaGradient(Canvas canvas, Shader.TileMode mode, float cx, float cy) {
        Shader shader = new RadialGradient(cx, cy, 20, Color.parseColor("#E91E63"), Color.parseColor("#2196F3"), mode);
        paint.setShader(shader);
        canvas.drawCircle(cx, cy, 200, paint);
    }
}
