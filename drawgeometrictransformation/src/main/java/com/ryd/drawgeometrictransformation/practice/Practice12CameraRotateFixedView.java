package com.ryd.drawgeometrictransformation.practice;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Camera;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;

import androidx.annotation.Nullable;

import android.util.AttributeSet;
import android.view.View;

import com.ryd.drawgeometrictransformation.R;

public class Practice12CameraRotateFixedView extends View {
    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    Bitmap bitmap;
    Point point1 = new Point(200, 200);
    Point point2 = new Point(600, 200);

    public Practice12CameraRotateFixedView(Context context) {
        super(context);
    }

    public Practice12CameraRotateFixedView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice12CameraRotateFixedView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    {
        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.maps);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.save();
        Camera camera = new Camera();
        camera.save();
        camera.rotateX(30);
        canvas.translate(point1.x + bitmap.getWidth() / 2, point1.y + bitmap.getHeight() / 2);//移动旋转的中心点到改图的中心点
        camera.applyToCanvas(canvas);
        canvas.translate(-(point1.x + bitmap.getWidth() / 2), -(point1.y + bitmap.getHeight() / 2));//恢复原样
        camera.restore();
        canvas.drawBitmap(bitmap, point1.x, point1.y, paint);
        canvas.restore();

        canvas.save();
        camera.save();
        camera.rotateY(30);
        canvas.translate(point2.x + bitmap.getWidth() / 2, point2.y + bitmap.getHeight() / 2);
        camera.applyToCanvas(canvas);
        canvas.translate(-(point2.x + bitmap.getWidth() / 2), -(point2.y + bitmap.getHeight() / 2));

        camera.restore();
        canvas.drawBitmap(bitmap, point2.x, point2.y, paint);
        canvas.restore();
    }
}
