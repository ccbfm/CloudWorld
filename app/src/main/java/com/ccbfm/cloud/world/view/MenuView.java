package com.ccbfm.cloud.world.view;

import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.widget.FrameLayout;

import com.ccbfm.cloud.world.model.MenuModel;
import com.ccbfm.cloud.world.util.LogUtils;

public class MenuView extends BaseView<MenuModel> {

    private static final String[] MENU_NAME = {"日志", "成就", "加载", "保存", "退出"};

    public MenuView(Context context, int width, int height) {
        super(context, width, height);
        setBackgroundColor();

        BorderView.OnClickListener clickListener = new BorderView.OnClickListener() {
            @Override
            public void onClick(String tag, View view) {
                LogUtils.w("wds", "onClick-tag=" + tag);
            }
        };

        int mW = width / MENU_NAME.length;
        for (int i = 0; i < MENU_NAME.length; i++) {
            FrameLayout.LayoutParams lp = new LayoutParams(mW, height);
            lp.leftMargin = i * mW;
            BorderView bv = BorderView.create(context, mW, height);
            bv.setGravity(Gravity.CENTER);
            bv.setText(MENU_NAME[i]);
            bv.setOnClickListener(MENU_NAME[i], clickListener);
            addView(bv, lp);
        }
    }

    @Override
    public void updateView(MenuModel model) {

    }
}
