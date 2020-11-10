package com.ccbfm.cloud.world.widget;

import android.content.Context;
import android.widget.FrameLayout;

import com.ccbfm.cloud.world.model.GameModel;
import com.ccbfm.cloud.world.util.CheckUtils;


public class GameView extends BaseView<GameModel> {
    private BaseView mStatusView, mScenesView, mActiveView, mMenuView;

    public GameView(Context context, int width, int height) {
        super(context, width, height);
        int h2 = height >> 2;
        int h3 = height >> 3;
        int h4 = height >> 4;

        int statusH = h3;
        StatusView statusView = new StatusView(context, width, statusH);
        FrameLayout.LayoutParams statusLp = new LayoutParams(width, statusH);
        addView(statusView, statusLp);
        mStatusView = statusView;

        int scenesH = height - h2 - h3;
        ScenesView scenesView = new ScenesView(context, width, scenesH);
        FrameLayout.LayoutParams scenesLp = new LayoutParams(width, scenesH);
        scenesLp.topMargin = statusH;
        addView(scenesView, scenesLp);
        mScenesView = scenesView;

        int activeH = h3 + h4;
        ActiveView activeView = new ActiveView(context, width, activeH);
        FrameLayout.LayoutParams activeLp = new LayoutParams(width, activeH);
        activeLp.topMargin = scenesH + statusH;
        addView(activeView, activeLp);
        mActiveView = activeView;

        int menuH = h3 - h4;
        MenuView menuView = new MenuView(context, width, menuH);
        FrameLayout.LayoutParams menuLp = new LayoutParams(width, menuH);
        menuLp.topMargin = scenesH + statusH + activeH;
        addView(menuView, menuLp);
        mMenuView = menuView;
    }

    @Override
    @SuppressWarnings("unchecked")
    public void updateView(GameModel model) {
        CheckUtils.checkNotNull(model);
        if (mStatusView != null && model.isStatus()) {
            mStatusView.updateView(model.getStatusModel());
        }
        if (mScenesView != null && model.isScenes()) {
            mScenesView.updateView(model.getScenesModel());
        }
        if (mActiveView != null && model.isActive()) {
            mActiveView.updateView(model.getActiveModel());
        }
        if (mMenuView != null && model.isMenu()) {
            mMenuView.updateView(model.getMenuModel());
        }
    }
}
