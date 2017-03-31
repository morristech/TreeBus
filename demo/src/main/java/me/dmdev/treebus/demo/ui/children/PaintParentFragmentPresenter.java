package me.dmdev.treebus.demo.ui.children;

import me.dmdev.treebus.demo.ui.base.PaintPresenter;
import me.dmdev.treebus.demo.ui.base.PaintView;
import me.dmdev.treebus.demo.ui.message.PaintParentFragmentMessage;

/**
 * @author Dmitriy Gorbunov
 */

class PaintParentFragmentPresenter extends PaintPresenter {

    public PaintParentFragmentPresenter(int paintColor) {
        super(paintColor);
    }

    @Override
    public void onAttachView(PaintView view) {
        super.onAttachView(view);
        view.setPaintButtonName("Paint parent");
    }

    @Override
    public void paint() {
        getNode().sendTowardRoot(new PaintParentFragmentMessage(paintColor));
    }
}
