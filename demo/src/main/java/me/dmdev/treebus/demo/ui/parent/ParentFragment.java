package me.dmdev.treebus.demo.ui.parent;

import android.os.Bundle;
import android.support.annotation.ColorInt;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.SwitchCompat;
import android.view.View;
import android.widget.CompoundButton;

import me.dmdev.treebus.Message;
import me.dmdev.treebus.NodeHolder;
import me.dmdev.treebus.R;
import me.dmdev.treebus.demo.ui.base.mvp.BasePresenterFragment;
import me.dmdev.treebus.demo.ui.base.FillView;
import me.dmdev.treebus.demo.ui.message.BackMessage;
import me.dmdev.treebus.demo.ui.message.PaintAllChildrenMessage;
import me.dmdev.treebus.demo.ui.message.PaintFirstFragmentMessage;
import me.dmdev.treebus.demo.ui.message.PaintParentFragmentMessage;
import me.dmdev.treebus.demo.ui.message.PaintSecondFragmentMessage;

/**
 * @author Dmitriy Gorbunov
 */

public class ParentFragment extends BasePresenterFragment<ParentFragmentPresenter> implements FillView {

    private View backgroundView;
    private SwitchCompat switchView;

    @Override
    protected ParentFragmentPresenter providePresenter(Bundle savedInstanceState) {
        return new ParentFragmentPresenter(ContextCompat.getColor(getContext(), R.color.grey));
    }

    @Override
    protected int getFragmentLayout() {
        return R.layout.fragment_parent;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        backgroundView = view;
        switchView = (SwitchCompat) view.findViewById(R.id.switch_view);
        switchView.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                presenter.setEnabled(isChecked);
            }
        });
    }

    @Override
    public boolean handleMessage(Message message) {
        if (message instanceof PaintParentFragmentMessage) {
            presenter.handleMessage(message);
        } else if (message instanceof PaintAllChildrenMessage
                || message instanceof PaintFirstFragmentMessage
                || message instanceof PaintSecondFragmentMessage) {
            getNode().sendToDescendants(message);
        } else if (message instanceof BackMessage) {
            return handleBackMessage((BackMessage) message);
        } else {
            return super.handleMessage(message);
        }
        return true;
    }

    private boolean handleBackMessage(BackMessage message) {
        if (findChildNode(R.id.third_fragment).handleMessage(message)) {
            return true;
        } else if (findChildNode(R.id.fifth_fragment).handleMessage(message)) {
            return true;
        } else if (findChildNode(R.id.sixth_fragment).handleMessage(message)) {
            return true;
        } else if (findChildNode(R.id.fourth_fragment).handleMessage(message)) {
            return true;
        } else if (findChildNode(R.id.second_fragment).handleMessage(message)) {
            return true;
        } else if (findChildNode(R.id.first_fragment).handleMessage(message)) {
            return true;
        } else {
            return false;
        }
    }

    private NodeHolder findChildNode(int fragmentId) {
         return (NodeHolder) getChildFragmentManager().findFragmentById(fragmentId);
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
