package com.ryd.drawclass.paint.practice;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

import com.ryd.drawclass.R;

public class Practice04BitmapShaderView extends View {
    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);

    public Practice04BitmapShaderView(Context context) {
        super(context);
    }

    public Practice04BitmapShaderView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice04BitmapShaderView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    {
        // 用 Paint.setShader(shader) 设置一个 BitmapShader
        // Bitmap: R.drawable.batman

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        drawBitmapShader(canvas, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP, 200);
        drawBitmapShader(canvas, Shader.TileMode.MIRROR, Shader.TileMode.MIRROR, 600);
        drawBitmapShader(canvas, Shader.TileMode.REPEAT, Shader.TileMode.REPEAT, 1000);

    }

    private void drawBitmapShader(Canvas canvas, Shader.TileMode x, Shader.TileMode y, float cx) {
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.batman);
        Shader shader = new BitmapShader(bitmap, x, y);
        paint.setShader(shader);
        canvas.drawCircle(cx, 200, 200, paint);

    }
}
