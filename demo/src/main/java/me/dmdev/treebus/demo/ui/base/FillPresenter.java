package me.dmdev.treebus.demo.ui.base;

import android.support.annotation.ColorRes;

import me.dmdev.treebus.Message;
import me.dmdev.treebus.demo.ui.base.mvp.BasePresenter;
import me.dmdev.treebus.demo.ui.message.PaintAllMessage;
import me.dmdev.treebus.demo.ui.message.PaintMessage;

/**
 * @author Dmitriy Gorbunov
 */

public abstract class FillPresenter extends BasePresenter<FillView> {

    protected boolean enabled = true;
    protected int fillColor;

    public FillPresenter(@ColorRes int fillColor) {
        this.fillColor = fillColor;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    @Override
    public void onAttachView(FillView view) {
        super.onAttachView(view);
        view.setEnabled(enabled);
        view.fillColor(fillColor);
    }

    protected void fillColor(int color) {
        if (enabled) {
            fillColor = color;
            if (view != null) {
                view.fillColor(color);
            }
        }
    }

    @Override
    public boolean handleMessage(Message message) {
        if (message instanceof PaintAllMessage) {
            fillColor(((PaintMessage) message).color);
        }
        return super.handleMessage(message);
    }
}
