package com.ryd.drawviewanimal.practice;

import android.content.Context;

import androidx.annotation.Nullable;

import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.ryd.drawviewanimal.R;

public class Practice02Rotation extends RelativeLayout {
    Button animateBt;
    ImageView imageView;
    private int statue = 1;

    public Practice02Rotation(Context context) {
        super(context);
    }

    public Practice02Rotation(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice02Rotation(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();

        animateBt = (Button) findViewById(R.id.animateBt);
        imageView = (ImageView) findViewById(R.id.imageView);

        animateBt.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(final View v) {
                // // TODO 在这里处理点击事件，通过 View.animate().rotation/X/Y() 来让 View 旋转
                switch (statue) {
                    case 1:
                        imageView.animate().rotationY(180);
                        statue = 2;
                        break;
                    case 2:
                        imageView.animate().rotationY(0);
                        statue = 3;
                        break;
                    case 3:
                        imageView.animate().rotationX(180);
                        statue = 4;
                        break;
                    case 4:
                        imageView.animate().rotationX(0);
                        statue = 5;
                        break;
                    case 5:
                        imageView.animate().rotation(180);
                        statue = 6;
                        break;
                    case 6:
                        imageView.animate().rotation(0);
                        statue = 1;
                        break;

                }
            }
        });
    }
}