package com.ccbfm.cloud.world.view;

import android.content.Context;
import android.view.Gravity;
import android.widget.FrameLayout;

import com.ccbfm.cloud.world.model.MenuModel;

public class MenuView extends BaseView<MenuModel> {

    private static final String[] MENU_NAME = {"", "", "", "", ""};

    public MenuView(Context context, int width, int height) {
        super(context, width, height);
        setBackgroundColor();
        int mW = width / MENU_NAME.length;
        for (int i = 0; i < MENU_NAME.length; i++) {
            FrameLayout.LayoutParams lp = new LayoutParams(mW, height);
            lp.leftMargin = i * mW;
            BorderView bv = BorderView.create(context, mW, height);
            bv.setGravity(Gravity.CENTER);
            bv.setText(MENU_NAME[i]);
            addView(bv, lp);
        }
    }

    @Override
    public void updateView(MenuModel model) {

    }
}
