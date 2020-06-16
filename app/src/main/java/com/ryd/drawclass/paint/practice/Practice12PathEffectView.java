package com.ryd.drawclass.paint.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ComposePathEffect;
import android.graphics.CornerPathEffect;
import android.graphics.DashPathEffect;
import android.graphics.DiscretePathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathDashPathEffect;
import android.graphics.SumPathEffect;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class Practice12PathEffectView extends View {
    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    Path path = new Path();

    public Practice12PathEffectView(Context context) {
        super(context);
    }

    public Practice12PathEffectView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice12PathEffectView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    {
        paint.setStyle(Paint.Style.STROKE);

        path.moveTo(50, 100);
        path.rLineTo(50, 100);
        path.rLineTo(80, -150);
        path.rLineTo(100, 100);
        path.rLineTo(70, -120);
        path.rLineTo(150, 80);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // 使用 Paint.setPathEffect() 来设置不同的 PathEffect

        // 第一处：CornerPathEffect 曲线path轮廓效果 参数-圆角半径
        CornerPathEffect cornerPathEffect = new CornerPathEffect(30);
        paint.setPathEffect(cornerPathEffect);
        canvas.drawPath(path, paint);

        canvas.save();
        canvas.translate(500, 0);
        // 第二处：DiscretePathEffect 随机偏离轮廓效果 参数拼接线段长度，偏移量
        DiscretePathEffect discretePathEffect = new DiscretePathEffect(60, 30);
        paint.setPathEffect(discretePathEffect);
        canvas.drawPath(path, paint);
        canvas.restore();

        canvas.save();
        canvas.translate(0, 200);
        // 第三处：DashPathEffect 虚线轮廓效果，参数：float【实现长度,虚线长度，实线长度,虚线长度】 偏移量
        DashPathEffect dashPathEffect = new DashPathEffect(new float[]{3f, 6f, 8f, 3f}, 4);
        paint.setPathEffect(dashPathEffect);
        canvas.drawPath(path, paint);
        canvas.restore();

        canvas.save();
        canvas.translate(500, 200);
        // 第四处：PathDashPathEffect 路径 轮廓效果  参数：路径，相邻shape距离，虚线偏移，shape转弯转换方式
        // TRANSLATE：位移
        //ROTATE：旋转
        //MORPH：变体
        Path path = new Path();
        path.addCircle(100, 100, 50, Path.Direction.CW);
        PathDashPathEffect pathDashPathEffect = new PathDashPathEffect(path, 20, 8, PathDashPathEffect.Style.ROTATE);
        paint.setPathEffect(pathDashPathEffect);
        canvas.drawPath(path, paint);
        canvas.restore();

        canvas.save();
        canvas.translate(0, 400);
        // 第五处：SumPathEffect fd 两种effect 同时生效
        SumPathEffect sumPathEffect = new SumPathEffect(discretePathEffect, dashPathEffect);
        paint.setPathEffect(sumPathEffect);
        canvas.drawPath(path, paint);
        canvas.restore();

        canvas.save();
        canvas.translate(500, 400);
        // 第六处：ComposePathEffect  两个效果的集合
        ComposePathEffect composePathEffect = new ComposePathEffect(discretePathEffect, dashPathEffect);
        paint.setPathEffect(composePathEffect);
        canvas.drawPath(path, paint);
        canvas.restore();
    }
}
