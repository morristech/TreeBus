package me.dmdev.treebus.demo.ui.base;

import android.os.Bundle;
import android.support.annotation.ColorInt;
import android.support.annotation.Nullable;
import android.support.v7.widget.SwitchCompat;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;

import me.dmdev.treebus.R;
import me.dmdev.treebus.demo.ui.base.mvp.BasePresenterFragment;

/**
 * @author Dmitriy Gorbunov
 */

public abstract class BasePaintFragment<P extends PaintPresenter> extends BasePresenterFragment<P> implements PaintView {

    private View backgroundView;
    private SwitchCompat switchView;
    private View pickColorView;
    private Button paintButton;
    private View paintColor;

    @Override
    protected int getFragmentLayout() {
        return R.layout.fragment_child;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        backgroundView = view.findViewById(R.id.background_view);
        switchView = (SwitchCompat) view.findViewById(R.id.switch_view);
        pickColorView = view.findViewById(R.id.pick_color);
        paintColor = view.findViewById(R.id.paint_color);
        paintButton = (Button) view.findViewById(R.id.paint_button);
        initViews();
    }

    private void initViews() {
        switchView.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                presenter.setEnabled(isChecked);
            }
        });
        paintButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.paint();
            }
        });
        pickColorView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.pickColor();
            }
        });
    }

    @Override
    public void setPaintButtonName(String name) {
        paintButton.setText(name);
    }

    @Override
    public void setPaintColor(@ColorInt int color) {
        paintColor.setBackgroundColor(color);
    }

    @Override
    public void setEnabled(boolean enabled) {
        switchView.setChecked(enabled);
    }

    @Override
    public void fillColor(@ColorInt int color) {
        backgroundView.setBackgroundColor(color);
    }

}
