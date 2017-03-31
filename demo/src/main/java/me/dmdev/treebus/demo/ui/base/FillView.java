package me.dmdev.treebus.demo.ui.base;

import android.support.annotation.ColorInt;

import me.dmdev.treebus.demo.ui.base.mvp.MvpView;

/**
 * @author Dmitriy Gorbunov
 */

public interface FillView extends MvpView {
    void setEnabled(boolean enabled);
    void fillColor(@ColorInt int color);
}
