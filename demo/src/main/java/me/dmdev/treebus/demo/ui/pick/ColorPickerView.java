package me.dmdev.treebus.demo.ui.pick;

import java.util.List;

import me.dmdev.treebus.demo.ui.base.mvp.MvpView;

/**
 * @author Dmitriy Gorbunov
 */

public interface ColorPickerView extends MvpView {
    void showColors(List<Color> colors);
}
