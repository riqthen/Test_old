package com.riq.mylibrary.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.TranslateAnimation;
import android.widget.ScrollView;

/**
 * Created by 锐 on 2017/6/23.
 */

/**
 * 反弹效果的ScrollView
 * 与ScrollView一样使用
 */
public class BounceScrollView extends ScrollView {

    private View childView; //子View
    private Rect normalView = new Rect();   // 矩形(只是用于判断是否需要动画)
    private float clickY;    //点击时的y坐标
    private boolean isCount = false;    //是否开始计算

    BounceScrollView bounceScrollView;

    public BounceScrollView(Context context) {
        super(context);
    }

    public BounceScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public BounceScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        if (getChildCount() > 0) {
            childView = getChildAt(0);
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        if (childView != null) {
            int action = ev.getAction();
            switch (action) {
                case MotionEvent.ACTION_DOWN:
                    break;
                case MotionEvent.ACTION_UP:
                    if (!normalView.isEmpty()) {
                        animation();
                        isCount = false;
                    }
                    break;
                case MotionEvent.ACTION_MOVE:
                    float preY = clickY;    //按下时的y
                    float currY = ev.getY();
                    int deltaY = (int) (preY - currY);  //移动的距离
                    if (!isCount) {
                        deltaY = 0;
                    }
                    clickY = currY;
                    if (isNeedMove()) {
                        if (normalView.isEmpty()) {
                            normalView.set(childView.getLeft(), childView.getTop(), childView.getRight(), childView.getBottom());
                        }
                        childView.layout(childView.getLeft(), childView.getTop() - deltaY / 2, childView.getRight(), childView.getBottom() - deltaY / 2);
                    }
                    isCount = true;
                    break;
                default:
                    break;

            }


        }
        return super.onTouchEvent(ev);
    }

    /**
     * 回缩动画
     */
    private void animation() {
        TranslateAnimation ta = new TranslateAnimation(0, 0, childView.getTop(), normalView.top);
        ta.setDuration(200);
        childView.startAnimation(ta);
        childView.layout(normalView.left, normalView.top, normalView.right, normalView.bottom);
        normalView.setEmpty();
    }

    /**
     * 是否需要移动布局
     */
    public boolean isNeedMove() {
        int offset = childView.getMeasuredHeight() - getHeight();   //控件总高 - 屏幕高度
        int scrollY = getScrollY();
        return scrollY == 0 || scrollY == offset;
    }

}
