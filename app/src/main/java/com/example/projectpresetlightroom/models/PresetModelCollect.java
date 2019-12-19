package com.example.projectpresetlightroom.models;

public class PresetModelCollect {

        public String presetNamecoll;
        public int presetGambarcoll;
        private String key;
        public String desc;

//    public PresetModelCollect(String presetNamecoll, int presetGambarcoll) {
//        this.presetNamecoll = presetNamecoll;
//        this.presetGambarcoll = presetGambarcoll;
//
//    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getPresetNamecoll() {
        return presetNamecoll;
    }

    public void setPresetNamecoll(String presetNamecoll) {
        this.presetNamecoll = presetNamecoll;
    }

    public int getPresetGambarcoll() {
        return presetGambarcoll;
    }

    public void setPresetGambarcoll(int presetGambarcoll) {
        this.presetGambarcoll = presetGambarcoll;
    }
}
