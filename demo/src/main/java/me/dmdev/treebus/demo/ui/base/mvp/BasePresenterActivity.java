package me.dmdev.treebus.demo.ui.base.mvp;

import android.os.Bundle;
import android.support.annotation.Nullable;

import me.dmdev.treebus.demo.ui.base.NodeActivity;

/**
 * @author Dmitriy Gorbunov
 */

public abstract class BasePresenterActivity<P extends BasePresenter> extends NodeActivity implements MvpView {

    protected P presenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (presenter == null) {
            presenter = providePresenter(savedInstanceState);
            presenter.onCreate();
        }
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
        presenter.onDestroy();
    }

    protected abstract P providePresenter(Bundle savedInstanceState);
}
