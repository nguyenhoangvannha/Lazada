package com.nhanhv.lazada.customview;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.EditText;

import com.nhanhv.lazada.R;

public class ClearableEdittext extends android.support.v7.widget.AppCompatEditText {
    Drawable clearDrawable;
    Drawable[] drawables;
    public ClearableEdittext(Context context) {
        super(context);
        init();
    }

    public ClearableEdittext(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public ClearableEdittext(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        drawables = getCompoundDrawables();
        clearDrawable = ContextCompat.getDrawable(getContext(), R.drawable.ic_clear_black_24dp).mutate();
        setCompoundDrawablesWithIntrinsicBounds(drawables[0], drawables[1], clearDrawable, drawables[3]);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int width = getWidth() - clearDrawable.getBounds().width();
        if (event.getRawX() >= width && event.getAction() == MotionEvent.ACTION_DOWN){
            setText("");
        }
        return super.onTouchEvent(event);
    }
}
