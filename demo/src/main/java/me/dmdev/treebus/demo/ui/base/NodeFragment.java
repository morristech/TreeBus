package me.dmdev.treebus.demo.ui.base;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.Fragment;

import me.dmdev.treebus.Message;
import me.dmdev.treebus.Node;
import me.dmdev.treebus.NodeHolder;

/**
 * @author Dmitriy Gorbunov
 */

public class NodeFragment extends Fragment implements NodeHolder {

    private Node node = new Node(this);

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        node.attachToParent(getParentNode());
    }

    @Override
    public void onDetach() {
        super.onDetach();
        node.detachFromParent();
    }

    private Node getParentNode() {
        Fragment parentFragment = getParentFragment();
        if (parentFragment instanceof NodeHolder) {
            return ((NodeHolder) parentFragment).getNode();
        } else {
            Activity activity = getActivity();
            if (activity instanceof NodeHolder) {
                return ((NodeHolder) activity).getNode();
            } else {
                return null;
            }
        }
    }

    public Node getNode() {
        return node;
    }

    @Override
    public boolean handleMessage(Message message) {
        return false;
    }
}
