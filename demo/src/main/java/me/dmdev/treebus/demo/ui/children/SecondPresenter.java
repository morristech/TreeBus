package me.dmdev.treebus.demo.ui.children;

import me.dmdev.treebus.Message;
import me.dmdev.treebus.demo.ui.base.PaintPresenter;
import me.dmdev.treebus.demo.ui.base.PaintView;
import me.dmdev.treebus.demo.ui.message.PaintFirstFragmentMessage;
import me.dmdev.treebus.demo.ui.message.PaintSecondFragmentMessage;

/**
 * @author Dmitriy Gorbunov
 */

public class SecondPresenter extends PaintPresenter {

    public SecondPresenter(int paintColor) {
        super(paintColor);
    }

    @Override
    public void onAttachView(PaintView view) {
        super.onAttachView(view);
        view.setPaintButtonName("Paint first");
    }

    @Override
    public void paint() {
        node.sendTowardRoot(new PaintFirstFragmentMessage(paintColor));
    }

    @Override
    public boolean handleMessage(Message message) {
        if (message instanceof PaintSecondFragmentMessage) {
            PaintSecondFragmentMessage msg = (PaintSecondFragmentMessage) message;
            fillColor(msg.color);
            return true;
        }
        return super.handleMessage(message);
    }
}
