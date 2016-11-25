package com.test.android.blinktextview;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.widget.TextView;


public class BlinkTextView extends TextView {

    private static final int MESSAGE_CODE = 100;

    private final Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            if (msg.what == MESSAGE_CODE) {
                mVisible = !mVisible;
                if (mVisible) {
                    setAlpha(0.0f);
                } else {
                    setAlpha(1.0f);
                }

                if (mBlinking) {
                    sendEmptyMessageDelayed(MESSAGE_CODE, mInterval);
                }
            }
        }
    };

    private boolean mBlinking = false;
    private boolean mVisible;
    private long mInterval = 500L;


    public BlinkTextView(Context context) {
        super(context);
    }

    public BlinkTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public BlinkTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    public void startBlinking(long intervalMillis) {
        // Do nothing if already blinking
        if (mHandler.hasMessages(MESSAGE_CODE)) {
            return;
        }

        mInterval = intervalMillis;
        mBlinking = true;

        mHandler.sendEmptyMessageDelayed(MESSAGE_CODE, mInterval);
    }

    public void stopBlinking() {
        mBlinking = false;
        mHandler.removeMessages(MESSAGE_CODE);
    }
}
