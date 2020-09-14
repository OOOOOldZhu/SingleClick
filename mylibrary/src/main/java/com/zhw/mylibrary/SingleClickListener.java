package com.zhw.mylibrary;

import android.view.View;

/**
 * Created by z on 2017/3/13.
 */

public abstract class SingleClickListener implements View.OnClickListener {

    long delayTime = 1500;

    public SingleClickListener() {

    }

    public SingleClickListener(long delayTime) {
        if(delayTime == 0){
            return;
        }
        this.delayTime = delayTime;
    }

    @Override
    public void onClick(final View v) {

        onSingleClick(v);
        v.setClickable(false);
        new android.os.Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                v.setClickable(true);
            }
        }, delayTime);
    }

    public abstract void onSingleClick(View v);

}
