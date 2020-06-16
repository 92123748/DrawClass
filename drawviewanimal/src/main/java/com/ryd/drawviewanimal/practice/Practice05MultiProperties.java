package com.ryd.drawviewanimal.practice;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.ryd.drawviewanimal.R;

public class Practice05MultiProperties extends ConstraintLayout {
    Button animateBt;
    ImageView imageView;
    private boolean isShow;

    public Practice05MultiProperties(Context context) {
        super(context);
    }

    public Practice05MultiProperties(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice05MultiProperties(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();

        animateBt = (Button) findViewById(R.id.animateBt);
        imageView = (ImageView) findViewById(R.id.imageView);
        imageView.setScaleX(0);
        imageView.setScaleY(0);
        imageView.setAlpha(0f);
        animateBt.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO 在这里处理点击事件，同时对多个属性做动画
                if (isShow) {
                    imageView.animate().translationX(0).rotation(0).alpha(0).scaleX(0).scaleY(0);
                    isShow = false;
                } else {
                    imageView.animate().translationX(200).rotation(720).alpha(1).scaleX(1).scaleY(1);
                    isShow = true;
                }
            }
        });
    }
}
