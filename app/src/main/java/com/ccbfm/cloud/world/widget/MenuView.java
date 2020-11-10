package com.ccbfm.cloud.world.widget;

import android.content.Context;
import android.widget.FrameLayout;

import com.ccbfm.cloud.world.model.MenuModel;

public class MenuView extends BaseView<MenuModel> {

    private static final String[] MENU_NAME = {"", "", "", "", ""};

    public MenuView(Context context, int width, int height) {
        super(context, width, height);

        int mW = width / MENU_NAME.length;
        for (int i = 0; i < MENU_NAME.length; i++) {
            FrameLayout.LayoutParams lp = new LayoutParams(mW, height);
            lp.leftMargin = i * mW;
            addView(BorderView.create(context, mW, height), lp);
        }
    }

    @Override
    public void updateView(MenuModel model) {

    }
}
