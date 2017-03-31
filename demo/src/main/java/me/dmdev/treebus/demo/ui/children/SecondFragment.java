package me.dmdev.treebus.demo.ui.children;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;

import me.dmdev.treebus.R;
import me.dmdev.treebus.demo.ui.base.BasePaintFragment;
import me.dmdev.treebus.demo.ui.base.PaintPresenter;

/**
 * @author Dmitriy Gorbunov
 */

public class SecondFragment extends BasePaintFragment {

    @Override
    protected PaintPresenter providePresenter(Bundle savedInstanceState) {
        return new SecondPresenter(ContextCompat.getColor(getContext(), R.color.orange));
    }
}
