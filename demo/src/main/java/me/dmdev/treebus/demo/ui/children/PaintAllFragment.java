package me.dmdev.treebus.demo.ui.children;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;

import me.dmdev.treebus.R;
import me.dmdev.treebus.demo.ui.base.BasePaintFragment;

/**
 * @author Dmitriy Gorbunov
 */

public class PaintAllFragment extends BasePaintFragment<PaintAllPresenter> {
    @Override
    protected PaintAllPresenter providePresenter(Bundle savedInstanceState) {
        return new PaintAllPresenter(ContextCompat.getColor(getContext(), R.color.red));
    }
}
