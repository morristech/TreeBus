package me.dmdev.treebus.demo.ui.children;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;

import me.dmdev.treebus.R;
import me.dmdev.treebus.demo.ui.base.BasePaintFragment;

/**
 * @author Dmitriy Gorbunov
 */

public class PaintAllChildrenFragment extends BasePaintFragment<PaintAllChildrenPresenter> {

    @Override
    protected PaintAllChildrenPresenter providePresenter(Bundle savedInstanceState) {
        return new PaintAllChildrenPresenter(ContextCompat.getColor(getContext(), R.color.cyan));
    }
}
