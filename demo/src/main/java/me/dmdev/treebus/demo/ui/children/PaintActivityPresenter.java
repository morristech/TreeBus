package me.dmdev.treebus.demo.ui.children;

import me.dmdev.treebus.demo.ui.base.PaintPresenter;
import me.dmdev.treebus.demo.ui.base.PaintView;
import me.dmdev.treebus.demo.ui.message.PaintActivityMessage;

/**
 * @author Dmitriy Gorbunov
 */

public class PaintActivityPresenter extends PaintPresenter {

    public PaintActivityPresenter(int paintColor) {
        super(paintColor);
    }

    @Override
    public void onAttachView(PaintView view) {
        super.onAttachView(view);
        view.setPaintButtonName("Paint activity");
    }

    @Override
    public void paint() {
        getNode().sendTowardRoot(new PaintActivityMessage(paintColor));
    }
}
