package com.ccbfm.cloud.world.model;

import com.ccbfm.cloud.world.util.LogUtils;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class ScenesModel extends Model {

    public int[][] map;
    public int initX;
    public int initY;
    private HashMap<String, LinkedList<ActiveModel>> mActiveMap;

    public ScenesModel() {
        mActiveMap = new HashMap<>();
    }

    public LinkedList<ActiveModel> getActiveModels(int x, int y) {
        String key = y + "_" + x;
        /*LogUtils.w("wds", "getActiveModels-key=" + key);
        for (Map.Entry<String, LinkedList<ActiveModel>> entry : mActiveMap.entrySet()) {
            LogUtils.w("wds", "getActiveModels" + entry.getKey() + "," + entry.getValue());
        }*/
        return mActiveMap.get(key);
    }

    public void addActive(int x, int y, ActiveModel active) {
        String key = y + "_" + x;
        LinkedList<ActiveModel> activeModels = mActiveMap.get(key);
        if (activeModels == null) {
            activeModels = new LinkedList<>();
            mActiveMap.put(key, activeModels);
        }
        activeModels.add(active);
    }

    public void removeActive(int x, int y, ActiveModel active) {
        String key = y + "_" + x;
        LinkedList<ActiveModel> activeModels = mActiveMap.get(key);
        if (activeModels != null) {
            activeModels.remove(active);
            if (activeModels.size() == 0) {
                mActiveMap.remove(key);
            }
        }
    }
}
