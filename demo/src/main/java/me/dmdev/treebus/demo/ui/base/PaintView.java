package me.dmdev.treebus.demo.ui.base;

import android.support.annotation.ColorInt;

import me.dmdev.treebus.demo.ui.base.mvp.MvpView;

/**
 * @author Dmitriy Gorbunov
 */

public interface PaintView extends MvpView {
    void setPaintButtonName(String name);
    void setPaintColor(@ColorInt int color);
    void setEnabled(boolean enabled);
    void fillColor(@ColorInt int color);
}
