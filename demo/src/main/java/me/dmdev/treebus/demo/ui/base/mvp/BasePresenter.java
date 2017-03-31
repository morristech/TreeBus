package me.dmdev.treebus.demo.ui.base.mvp;

import me.dmdev.treebus.Node;
import me.dmdev.treebus.Message;
import me.dmdev.treebus.NodeHolder;

/**
 * @author Dmitriy Gorbunov
 */

public class BasePresenter<V extends MvpView> implements Presenter<V>, NodeHolder {

    protected final Node node = new Node(this);
    protected V view;

    @Override
    public void onCreate() {}

    public void attachParentNode(Node parent) {
        node.attachToParent(parent);
    }

    @Override
    public void onAttachView(V view) {
        this.view = view;
    }

    @Override
    public void onDetachView() {
        view = null;
    }

    public void detachParentNode() {
        node.detachFromParent();
    }

    @Override
    public void onDestroy() {}

    public Node getNode() {
        return node;
    }

    @Override
    public boolean handleMessage(Message message) {
        return false;
    }
}
