package me.dmdev.treebus.demo.ui.base.mvp;

import android.os.Bundle;
import android.support.annotation.Nullable;

import me.dmdev.treebus.Message;
import me.dmdev.treebus.demo.ui.base.BaseFragment;
import me.dmdev.treebus.demo.ui.message.BackMessage;

/**
 * @author Dmitriy Gorbunov
 */

public abstract class BasePresenterFragment<P extends BasePresenter> extends BaseFragment implements MvpView {

    protected P presenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (presenter == null) {
            presenter = providePresenter(savedInstanceState);
            presenter.onCreate();
        }
        presenter.attachParentNode(getNode());
    }

    @Override
    public void onResume() {
        super.onResume();
        presenter.onAttachView(this);
    }

    @Override
    public void onPause() {
        super.onPause();
        presenter.onDetachView();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        presenter.detachParentNode();
        presenter.onDestroy();
    }

    @Override
    public boolean handleMessage(Message message) {
        if (message instanceof BackMessage) {
            return presenter.handleMessage(message);
        }
        return false;
    }

    protected abstract P providePresenter(Bundle savedInstanceState);
}
