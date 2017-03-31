package me.dmdev.treebus.demo.ui.children;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;

import me.dmdev.treebus.R;
import me.dmdev.treebus.demo.ui.base.BasePaintFragment;

/**
 * @author Dmitriy Gorbunov
 */
public class PaintActivityFragment extends BasePaintFragment<PaintActivityPresenter> {

    @Override
    protected PaintActivityPresenter providePresenter(Bundle savedInstanceState) {
        return new PaintActivityPresenter(ContextCompat.getColor(getContext(), R.color.deep_purple));
    }
}
