package com.ryd.drawclass.paint.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class Practice01LinearGradientView extends View {
    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);

    public Practice01LinearGradientView(Context context) {
        super(context);
    }

    public Practice01LinearGradientView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice01LinearGradientView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    {
        // 用 Paint.setShader(shader) 设置一个 LinearGradient
        // LinearGradient 的参数：坐标：(100, 100) 到 (500, 500) ；颜色：#E91E63 到 #2196F3

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //画三个TileMode不同的圆，看他们的效果是怎样的
        drawLinerGradient(canvas, Shader.TileMode.CLAMP, 300, 300);
        drawLinerGradient(canvas, Shader.TileMode.MIRROR, 700, 300);
        drawLinerGradient(canvas, Shader.TileMode.REPEAT, 1100, 300);
    }

    private void drawLinerGradient(Canvas canvas, Shader.TileMode mode, float cx, float cy) {
        Shader shader = new LinearGradient(cx - 200, cy - 200, cy + 200, cy + 200, Color.parseColor("#E91E63"), Color.parseColor("#2196F3"), mode);
        paint.setShader(shader);
        canvas.drawCircle(cx, cy, 200, paint);
    }
}
