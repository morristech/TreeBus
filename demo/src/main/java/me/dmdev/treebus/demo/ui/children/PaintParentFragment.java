package me.dmdev.treebus.demo.ui.children;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;

import me.dmdev.treebus.R;
import me.dmdev.treebus.demo.ui.base.BasePaintFragment;

/**
 * @author Dmitriy Gorbunov
 */

public class PaintParentFragment extends BasePaintFragment<PaintParentFragmentPresenter> {

    @Override
    protected PaintParentFragmentPresenter providePresenter(Bundle savedInstanceState) {
        return new PaintParentFragmentPresenter(ContextCompat.getColor(getContext(), R.color.light_blue));
    }
}
