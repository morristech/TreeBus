package me.dmdev.treebus.demo.ui.children;

import me.dmdev.treebus.demo.ui.base.PaintPresenter;
import me.dmdev.treebus.demo.ui.base.PaintView;
import me.dmdev.treebus.demo.ui.message.PaintAllMessage;

/**
 * @author Dmitriy Gorbunov
 */

class PaintAllPresenter extends PaintPresenter {

    public PaintAllPresenter(int paintColor) {
        super(paintColor);
    }

    @Override
    public void onAttachView(PaintView view) {
        super.onAttachView(view);
        view.setPaintButtonName("Paint all");
    }

    @Override
    public void paint() {
        getNode().sendToAll(new PaintAllMessage(paintColor));
    }
}
