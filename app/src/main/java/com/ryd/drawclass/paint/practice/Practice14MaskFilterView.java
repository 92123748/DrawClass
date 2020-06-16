package com.ryd.drawclass.paint.practice;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

import com.ryd.drawclass.R;

public class Practice14MaskFilterView extends View {
    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    Bitmap bitmap;

    public Practice14MaskFilterView(Context context) {
        super(context);
    }

    public Practice14MaskFilterView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice14MaskFilterView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    {
        setLayerType(LAYER_TYPE_SOFTWARE, null);
        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.what_the_fuck);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // 用 Paint.setMaskFilter 来设置不同的 BlurMaskFilter 模糊的圆角大小 在画面上的模糊效果

        // 第一个：NORMAL
        BlurMaskFilter filter1 = new BlurMaskFilter(30, BlurMaskFilter.Blur.NORMAL);
        paint.setMaskFilter(filter1);
        canvas.drawBitmap(bitmap, 100, 50, paint);

        // 第二个：INNER
        BlurMaskFilter filter2 = new BlurMaskFilter(30, BlurMaskFilter.Blur.INNER);
        paint.setMaskFilter(filter2);
        canvas.drawBitmap(bitmap, bitmap.getWidth() + 200, 50, paint);

        // 第三个：OUTER
        BlurMaskFilter filter3 = new BlurMaskFilter(30, BlurMaskFilter.Blur.OUTER);
        paint.setMaskFilter(filter3);
        canvas.drawBitmap(bitmap, 100, bitmap.getHeight() + 100, paint);

        // 第四个：SOLID
        BlurMaskFilter filter4 = new BlurMaskFilter(30, BlurMaskFilter.Blur.SOLID);
        paint.setMaskFilter(filter4);
        canvas.drawBitmap(bitmap, bitmap.getWidth() + 200, bitmap.getHeight() + 100, paint);
    }
}
