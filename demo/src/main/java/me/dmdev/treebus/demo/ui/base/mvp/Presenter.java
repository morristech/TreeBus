package me.dmdev.treebus.demo.ui.base.mvp;

/**
 * @author Dmitriy Gorbunov
 */

public interface Presenter<V extends MvpView> {
    void onCreate();
    void onAttachView(V view);
    void onDetachView();
    void onDestroy();
}
