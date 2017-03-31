package me.dmdev.treebus.demo.ui.base;

import android.graphics.Color;

import me.dmdev.treebus.Message;
import me.dmdev.treebus.demo.ui.base.mvp.BasePresenter;
import me.dmdev.treebus.demo.ui.message.BackMessage;
import me.dmdev.treebus.demo.ui.message.ChosenColorMessage;
import me.dmdev.treebus.demo.ui.message.PaintAllChildrenMessage;
import me.dmdev.treebus.demo.ui.message.PaintAllMessage;
import me.dmdev.treebus.demo.ui.message.PaintMessage;
import me.dmdev.treebus.demo.ui.message.PickColorMessage;

/**
 * @author Dmitriy Gorbunov
 */

public abstract class PaintPresenter extends BasePresenter<PaintView> {

    private int DEFAULT_FILL_COLOR = Color.WHITE;
    protected boolean enabled = true;
    protected int paintColor;
    protected int fillColor;

    public PaintPresenter(int paintColor) {
        this.paintColor = paintColor;
        this.fillColor = DEFAULT_FILL_COLOR;
    }

    @Override
    public void onAttachView(PaintView view) {
        super.onAttachView(view);
        view.setEnabled(enabled);
        view.fillColor(fillColor);
        view.setPaintColor(paintColor);
    }

    public void pickColor() {
        getNode().sendTowardRoot(new PickColorMessage());
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    protected void setPaintColor(int color) {
        paintColor = color;
        if (view != null) {
            view.setPaintColor(paintColor);
        }
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
        if (message instanceof ChosenColorMessage) {
            setPaintColor(((ChosenColorMessage) message).color);
            return true;
        } else if (message instanceof PaintAllMessage
                || message instanceof PaintAllChildrenMessage) {
            fillColor(((PaintMessage) message).color);
            return true;
        } else if (message instanceof BackMessage){
            if (fillColor != DEFAULT_FILL_COLOR) {
                if (enabled) {
                    fillColor(DEFAULT_FILL_COLOR);
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        } else {
            return super.handleMessage(message);
        }
    }

    public abstract void paint();

}
