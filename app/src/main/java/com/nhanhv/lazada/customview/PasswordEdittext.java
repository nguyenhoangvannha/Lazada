package com.nhanhv.lazada.customview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.design.widget.TextInputLayout;
import android.support.v4.content.ContextCompat;
import android.text.InputType;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import com.nhanhv.lazada.R;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordEdittext extends android.support.v7.widget.AppCompatEditText {
    Drawable eye, eyeStrike;
    boolean visible = false;
    boolean errorEnable = false;
    boolean passwordToggle = false;
    public static final String PASSWORD_PATTERN = "((?=.*\\d)(?=.*[A-Z])(?=.*[a-z]).{6,20})";
    public PasswordEdittext(Context context) {
        super(context);
        init(null);
    }

    public PasswordEdittext(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public PasswordEdittext(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }

    private void init(AttributeSet attrs) {
        if (attrs != null){
            TypedArray typedArray = getContext().getTheme().obtainStyledAttributes(attrs, R.styleable.PasswordEdittext, 0, 0);
            this.passwordToggle = typedArray.getBoolean(R.styleable.PasswordEdittext_passwordToggle, false);
            this.errorEnable = typedArray.getBoolean(R.styleable.PasswordEdittext_errorEnable, false);
            eye = ContextCompat.getDrawable(getContext(), R.drawable.ic_visibility_black_24dp).mutate();
            eyeStrike = ContextCompat.getDrawable(getContext(), R.drawable.ic_visibility_off_black_24dp).mutate();
            if (errorEnable){
                setOnFocusChangeListener(new OnFocusChangeListener() {
                    @Override
                    public void onFocusChange(View v, boolean hasFocus) {
                        if (!hasFocus){
                            TextInputLayout textInputLayout = (TextInputLayout) v.getParent().getParent();
                            Pattern pattern = Pattern.compile(PASSWORD_PATTERN);
                            Matcher matcher = pattern.matcher(getText());
                            if (!matcher.matches()){
                                textInputLayout.setErrorEnabled(true);
                                textInputLayout.setError(getContext().getString(R.string.title_password_require));
                            } else {
                                textInputLayout.setErrorEnabled(false);
                            }
                        }
                    }
                });
            }
            setup();
        }
    }

    private void setup(){
        setInputType(InputType.TYPE_CLASS_TEXT|(visible?InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD:InputType.TYPE_TEXT_VARIATION_PASSWORD));
        if (passwordToggle){
            Drawable[] drawables =  getCompoundDrawables();
            if (visible){
                setCompoundDrawablesWithIntrinsicBounds(drawables[0], drawables[1], eye, drawables[3]);
            } else {
                setCompoundDrawablesWithIntrinsicBounds(drawables[0], drawables[1], eyeStrike, drawables[3]);
            }
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int editWidth = getWidth();
        int drawableWidth = eye.getBounds().width();
        int width = editWidth - drawableWidth;
        if (event.getRawX() >= width){
            if (passwordToggle && event.getAction() == MotionEvent.ACTION_DOWN){
                Drawable[] drawables =  getCompoundDrawables();
                visible = !visible;
                if (visible){
                    setInputType(InputType.TYPE_CLASS_TEXT|InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                    setCompoundDrawablesWithIntrinsicBounds(drawables[0], drawables[1], eye, drawables[3]);
                } else {
                    setInputType(InputType.TYPE_CLASS_TEXT|InputType.TYPE_TEXT_VARIATION_PASSWORD);
                    setCompoundDrawablesWithIntrinsicBounds(drawables[0], drawables[1], eyeStrike, drawables[3]);
                }
            }
        }
        return super.onTouchEvent(event);
    }
}
