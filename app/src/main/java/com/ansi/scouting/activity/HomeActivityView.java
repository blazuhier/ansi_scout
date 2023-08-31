package com.ansi.scouting.activity;

public interface HomeActivityView {
    void initFields();
    void initMethods();
    void initListeners();
    void setActionBarTitleAndColor();
    void openMainAluxesActivity();
    void openMainTroopActivity(int flagGender);
}