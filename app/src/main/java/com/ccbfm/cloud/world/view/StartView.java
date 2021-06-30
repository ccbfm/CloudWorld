package com.ccbfm.cloud.world.view;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;

import com.ccbfm.cloud.world.Config;
import com.ccbfm.cloud.world.MainActivity;
import com.ccbfm.cloud.world.util.LogUtils;


public class StartView extends RelativeLayout {

    private final Activity mActivity;

    public StartView(@NonNull Activity context) {
        super(context);
        mActivity = context;
        setBackgroundColor(Config.COLOR_BG);
        init(context);
        setGravity(Gravity.CENTER);
    }

    private void init(Context context) {
        DisplayMetrics metrics = getResources().getDisplayMetrics();
        int width = metrics.widthPixels;
        int height = metrics.heightPixels;

        int w2 = width >> 1;
        int h2 = (int) (w2 * 0.382f);

        BorderView bv = BorderView.create(context, w2, h2);
        bv.setGravity(Gravity.CENTER);
        bv.setText("进入");
        bv.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                //LogUtils.w("wds", "onClick=" + getWidth() + "," + getHeight());
                MainActivity.start(getContext(), getWidth(), getHeight());
                if(mActivity != null) {
                    mActivity.finish();
                }
            }
        });
        addView(bv);
    }

}
