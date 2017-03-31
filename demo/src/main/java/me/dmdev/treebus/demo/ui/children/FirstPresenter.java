package me.dmdev.treebus.demo.ui.children;

import me.dmdev.treebus.Message;
import me.dmdev.treebus.demo.ui.base.PaintPresenter;
import me.dmdev.treebus.demo.ui.base.PaintView;
import me.dmdev.treebus.demo.ui.message.PaintFirstFragmentMessage;
import me.dmdev.treebus.demo.ui.message.PaintSecondFragmentMessage;

/**
 * @author Dmitriy Gorbunov
 */

public class FirstPresenter extends PaintPresenter {

    public FirstPresenter(int paintColor) {
        super(paintColor);
    }

    @Override
    public void onAttachView(PaintView view) {
        super.onAttachView(view);
        view.setPaintButtonName("Paint second");
    }

    @Override
    public void paint() {
        node.sendTowardRoot(new PaintSecondFragmentMessage(paintColor));
    }

    @Override
    public boolean handleMessage(Message message) {
        if (message instanceof PaintFirstFragmentMessage) {
            PaintFirstFragmentMessage msg = (PaintFirstFragmentMessage) message;
            fillColor(msg.color);
            return true;
        }
        return super.handleMessage(message);
    }
}
