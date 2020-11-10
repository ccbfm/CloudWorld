package com.ccbfm.cloud.world.model;

public class GameModel extends Model{

    public String key;
    private boolean isStatus, isScenes, isActive, isMenu;
    private StatusModel statusModel;
    private ScenesModel scenesModel;
    private ActiveModel activeModel;
    private MenuModel menuModel;

    public StatusModel getStatusModel() {
        isStatus = false;
        return statusModel;
    }

    public void setStatusModel(StatusModel statusModel) {
        if(statusModel != null) {
            isStatus = true;
        }
        this.statusModel = statusModel;
    }

    public ScenesModel getScenesModel() {
        isScenes = false;
        return scenesModel;
    }

    public void setScenesModel(ScenesModel scenesModel) {
        if(scenesModel != null) {
            isScenes = true;
        }
        this.scenesModel = scenesModel;
    }

    public ActiveModel getActiveModel() {
        isActive = false;
        return activeModel;
    }

    public void setActiveModel(ActiveModel activeModel) {
        if(activeModel != null) {
            isActive = true;
        }
        this.activeModel = activeModel;
    }

    public MenuModel getMenuModel() {
        isMenu = false;
        return menuModel;
    }

    public void setMenuModel(MenuModel menuModel) {
        if(menuModel != null) {
            isMenu = true;
        }
        this.menuModel = menuModel;
    }

    public boolean isStatus() {
        return isStatus;
    }

    public boolean isScenes() {
        return isScenes;
    }

    public boolean isActive() {
        return isActive;
    }

    public boolean isMenu() {
        return isMenu;
    }
}
