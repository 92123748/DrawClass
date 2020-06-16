package com.ryd.drawclass.paint.practice;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.BlendMode;
import android.graphics.Canvas;
import android.graphics.ComposeShader;
import android.graphics.Paint;
import android.graphics.Shader;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

import com.ryd.drawclass.R;

public class Practice05ComposeShaderView extends View {
    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);

    public Practice05ComposeShaderView(Context context) {
        super(context);
    }

    public Practice05ComposeShaderView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice05ComposeShaderView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    {
        setLayerType(LAYER_TYPE_SOFTWARE, null); // 硬件加速下 ComposeShader 不能使用两个同类型的 Shader

        // 用 Paint.setShader(shader) 设置一个 ComposeShader
        // Shader 1: BitmapShader 图片：R.drawable.batman
        // Shader 2: BitmapShader 图片：R.drawable.batman_logo

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            drawComposeShader(canvas, 200, 200, BlendMode.DST);
            drawComposeShader(canvas, 600, 200, BlendMode.DST_IN);
            drawComposeShader(canvas, 1000, 200, BlendMode.DST_ATOP);
            drawComposeShader(canvas, 200, 600, BlendMode.DST_OUT);
            drawComposeShader(canvas, 600, 600, BlendMode.DST_OVER);
            drawComposeShader(canvas, 1000, 600, BlendMode.SRC_OUT);
        }
    }

    private void drawComposeShader(Canvas canvas, float cx, float cy, BlendMode mode) {
        Bitmap bitmap1 = BitmapFactory.decodeResource(getResources(), R.drawable.batman);
        Bitmap bitmap2 = BitmapFactory.decodeResource(getResources(), R.drawable.batman_logo);
        Shader shader1 = new BitmapShader(bitmap1, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        Shader shader2 = new BitmapShader(bitmap2, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.Q) {
            Shader compseShader = new ComposeShader(shader1, shader2, mode);
            paint.setShader(compseShader);
            canvas.drawCircle(cx, cy, 200, paint);
        }

    }
}
