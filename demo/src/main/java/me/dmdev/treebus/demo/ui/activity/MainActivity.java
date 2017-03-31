package me.dmdev.treebus.demo.ui.activity;

import android.os.Bundle;
import android.support.annotation.ColorInt;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.SwitchCompat;
import android.view.View;
import android.widget.CompoundButton;

import me.dmdev.treebus.Message;
import me.dmdev.treebus.NodeHolder;
import me.dmdev.treebus.R;
import me.dmdev.treebus.demo.ui.base.FillView;
import me.dmdev.treebus.demo.ui.base.mvp.BasePresenterActivity;
import me.dmdev.treebus.demo.ui.message.BackMessage;
import me.dmdev.treebus.demo.ui.message.PaintActivityMessage;
import me.dmdev.treebus.demo.ui.message.PaintAllMessage;
import me.dmdev.treebus.demo.ui.message.PickColorMessage;
import me.dmdev.treebus.demo.ui.parent.ParentFragment;
import me.dmdev.treebus.demo.ui.pick.ColorPickerFragment;

/**
 * @author Dmitriy Gorbunov
 */

public class MainActivity extends BasePresenterActivity<MainActivityPresenter> implements FillView {

    private View backgroundView;
    private SwitchCompat switchView;

    @Override
    protected MainActivityPresenter providePresenter(Bundle savedInstanceState) {
        return new MainActivityPresenter(ContextCompat.getColor(this, R.color.blue_grey));
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            showParentFragment();
        }
        initViews();
    }

    private void initViews() {
        backgroundView = findViewById(R.id.background_view);
        switchView = (SwitchCompat) findViewById(R.id.switch_view);
        switchView.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                presenter.setEnabled(isChecked);
            }
        });
    }

    @Override
    public void onBackPressed() {
        Fragment fragment = getSupportFragmentManager().findFragmentById(android.R.id.content);
        if (fragment != null) {
            super.onBackPressed();
        } else {
            fragment = getSupportFragmentManager().findFragmentById(R.id.container);
            if (fragment instanceof NodeHolder) {
                if (!((NodeHolder) fragment).handleMessage(new BackMessage())) {
                    super.onBackPressed();
                }
            }
        }
    }

    @Override
    public boolean handleMessage(Message message) {
        if (message instanceof PaintActivityMessage
            || message instanceof PaintAllMessage) {
            presenter.handleMessage(message);
        } else if (message instanceof PickColorMessage) {
            showColorPickerFragment(message.getFrom());
        } else if (message instanceof BackMessage) {
            onBackPressed();
        } else {
            return false;
        }
        return true;
    }

    private void showParentFragment() {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container, new ParentFragment())
                .commit();
    }

    private void showColorPickerFragment(String target) {
        ColorPickerFragment fragment = new ColorPickerFragment();
        fragment.getNode().setTarget(target);
        getSupportFragmentManager()
                .beginTransaction()
                .addToBackStack(null)
                .replace(android.R.id.content, fragment)
                .commit();
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
