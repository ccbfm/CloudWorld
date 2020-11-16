package com.ccbfm.cloud.world.model;

import java.util.HashMap;
import java.util.LinkedList;

public class ScenesModel extends Model {

    public int[][] map;
    public int initX;
    public int initY;
    private HashMap<String, LinkedList<ActiveModel>> mActiveMap;

    public ScenesModel() {
        mActiveMap = new HashMap<>();
    }

    public LinkedList<ActiveModel> getActiveModels(int x, int y){
        String key = y + "_" + x;
        return mActiveMap.get(key);
    }

    public void addActive(int x, int y, ActiveModel active){
        String key = y + "_" + x;
        LinkedList<ActiveModel> activeModels = mActiveMap.get(key);
        if(activeModels == null){
            activeModels = new LinkedList<>();
            mActiveMap.put(key, activeModels);
        }
        activeModels.add(active);
    }

    public void removeActive(int x, int y, ActiveModel active){
        String key = y + "_" + x;
        LinkedList<ActiveModel> activeModels = mActiveMap.get(key);
        if(activeModels != null){
            activeModels.remove(active);
            if(activeModels.size() == 0){
                mActiveMap.remove(key);
            }
        }
    }
}
