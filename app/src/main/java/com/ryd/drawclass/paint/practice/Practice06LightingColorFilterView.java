package com.ryd.drawclass.paint.practice;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.LightingColorFilter;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

import com.ryd.drawclass.R;

public class Practice06LightingColorFilterView extends View {
    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    Bitmap bitmap;

    public Practice06LightingColorFilterView(Context context) {
        super(context);
    }

    public Practice06LightingColorFilterView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice06LightingColorFilterView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    {
        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.batman);
    }

    /**
     * colorFlter公式  mul，与add每两位对应一个颜色值
     * R' = R * 0xff / 0xff + 0x0 = R // R' = R
     * G' = G * 0xff / 0xff + 0x0 = G // G' = G
     * B' = B * 0xff / 0xff + 0x0 = B // B' = B
     *
     * @param canvas
     */
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //R=红 G=绿 b=蓝   mul=0*ffffff  add=0*000000  gong
        // 使用 Paint.setColorFilter() 来设置 LightingColorFilter
        LightingColorFilter redFilter = new LightingColorFilter(0x00ffff, 0x000000);
        // 第一个 LightingColorFilter：去掉红色部分  及R*0ff 改为  R*0 无红色值
        paint.setColorFilter(redFilter);
        canvas.drawBitmap(bitmap, 0, 0, paint);
        LightingColorFilter greenFilter = new LightingColorFilter(0x00ffff, 0x006000);
        paint.setColorFilter(greenFilter);
        // 第二个 LightingColorFilter：增强绿色部分
        canvas.drawBitmap(bitmap, bitmap.getWidth() + 100, 0, paint);
    }
}
