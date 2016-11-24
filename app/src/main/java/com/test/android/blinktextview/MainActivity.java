package com.test.android.blinktextview;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;

public class MainActivity extends AppCompatActivity {

    private BlinkTextView mBlinkTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Blink by Animation
        Animation animation = new AlphaAnimation(0.0f, 1.0f);
        animation.setDuration(700L);
        animation.setRepeatMode(Animation.REVERSE);
        animation.setRepeatCount(Animation.INFINITE);
        View animationBlinkText = findViewById(R.id.animation_blink_text);
        animationBlinkText.startAnimation(animation);

        // Blink by ObjectAnimator
        View animatorBlinkText = findViewById(R.id.animator_blink_text);
        ObjectAnimator animator = ObjectAnimator.ofFloat(animatorBlinkText, "alpha", 0.0f, 1.0f);
        animator.setDuration(800L);
        animator.setRepeatCount(ValueAnimator.INFINITE);
        animator.setRepeatMode(ValueAnimator.REVERSE);
        animator.start();

        mBlinkTextView = (BlinkTextView) findViewById(R.id.blink_text);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mBlinkTextView.startBlinking(900L);
    }

    @Override
    protected void onPause() {
        super.onPause();
        mBlinkTextView.stopBlinking();
    }
}
