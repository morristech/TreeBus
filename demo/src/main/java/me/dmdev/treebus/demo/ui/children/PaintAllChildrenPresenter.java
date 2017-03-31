package me.dmdev.treebus.demo.ui.children;

import me.dmdev.treebus.demo.ui.base.PaintPresenter;
import me.dmdev.treebus.demo.ui.base.PaintView;
import me.dmdev.treebus.demo.ui.message.PaintAllChildrenMessage;

/**
 * @author Dmitriy Gorbunov
 */

class PaintAllChildrenPresenter extends PaintPresenter {

    public PaintAllChildrenPresenter(int paintColor) {
        super(paintColor);
    }

    @Override
    public void onAttachView(PaintView view) {
        super.onAttachView(view);
        view.setPaintButtonName("Paint children");
    }

    @Override
    public void paint() {
        getNode().sendTowardRoot(new PaintAllChildrenMessage(paintColor));
    }
}
