package me.dmdev.treebus.demo.ui.parent;

import me.dmdev.treebus.Message;
import me.dmdev.treebus.demo.ui.base.FillPresenter;
import me.dmdev.treebus.demo.ui.message.PaintMessage;
import me.dmdev.treebus.demo.ui.message.PaintParentFragmentMessage;

/**
 * @author Dmitriy Gorbunov
 */

class ParentFragmentPresenter extends FillPresenter {

    public ParentFragmentPresenter(int fillColor) {
        super(fillColor);
    }

    @Override
    public boolean handleMessage(Message message) {
        if (message instanceof PaintParentFragmentMessage) {
            fillColor(((PaintMessage) message).color);
            return true;
        } else {
            return super.handleMessage(message);
        }
    }
}
