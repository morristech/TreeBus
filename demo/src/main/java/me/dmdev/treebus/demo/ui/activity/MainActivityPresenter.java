package me.dmdev.treebus.demo.ui.activity;

import me.dmdev.treebus.Message;
import me.dmdev.treebus.demo.ui.base.FillPresenter;
import me.dmdev.treebus.demo.ui.message.PaintActivityMessage;
import me.dmdev.treebus.demo.ui.message.PaintMessage;

/**
 * @author Dmitriy Gorbunov
 */

public class MainActivityPresenter extends FillPresenter {

    public MainActivityPresenter(int fillColor) {
        super(fillColor);
    }

    @Override
    public boolean handleMessage(Message message) {
        if (message instanceof PaintActivityMessage) {
            fillColor(((PaintMessage) message).color);
        }
        return super.handleMessage(message);
    }
}
