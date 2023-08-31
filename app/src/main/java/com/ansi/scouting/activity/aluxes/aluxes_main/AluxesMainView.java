package com.ansi.scouting.activity.aluxes.aluxes_main;

import android.view.View;

public interface AluxesMainView {
    void initFields();
    void initMethods();
    void initListeners();
    void setActionBarTitleAndColor();
    void showPopupWindow(View view);
    void openNewAluxeRegisterActivity();
}
