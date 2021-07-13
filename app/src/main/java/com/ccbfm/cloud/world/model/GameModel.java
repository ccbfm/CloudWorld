package com.ccbfm.cloud.world.model;

import android.text.TextUtils;

import java.util.HashMap;

public class GameModel extends Model {

    private String key;
    private boolean isStatus, isScenes;
    private StatusModel statusModel;
    private String scenesKey;
    private HashMap<String, ScenesModel> scenesModel;

    public GameModel() {
        scenesModel = new HashMap<>();
    }

    public StatusModel getStatusModel() {
        isStatus = false;
        return statusModel;
    }

    public void setStatusModel(StatusModel statusModel) {
        if (statusModel != null) {
            isStatus = true;
        }
        this.statusModel = statusModel;
    }

    public ScenesModel getScenesModel() {
        isScenes = false;
        return scenesModel.get(scenesKey);
    }

    public void putScenesModel(String scenesKey, ScenesModel scenesModel) {
        this.scenesModel.put(scenesKey, scenesModel);
    }

    public void setKey(String key) {
        this.key = key;
    }

    public void setScenesKey(String scenesKey) {
        if(!TextUtils.equals(scenesKey, this.scenesKey)){
            this.isScenes = true;
        }
        this.scenesKey = scenesKey;
    }

    public boolean isStatus() {
        return isStatus;
    }

    public boolean isScenes() {
        return isScenes;
    }

}
