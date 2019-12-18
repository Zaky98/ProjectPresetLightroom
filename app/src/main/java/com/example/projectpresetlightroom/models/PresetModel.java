package com.example.projectpresetlightroom.models;

public class PresetModel {

        public String presetName;
        public int presetGambar;

    public PresetModel(String presetName, int presetGambar) {
        this.presetName = presetName;
        this.presetGambar = presetGambar;

    }

    public String getPresetName() {
        return presetName;
    }

    public void setPresetName(String presetName) {
        this.presetName = presetName;
    }

    public int getPresetGambar() {
        return presetGambar;
    }

    public void setPresetGambar(int presetGambar) {
        this.presetGambar = presetGambar;
    }
}
