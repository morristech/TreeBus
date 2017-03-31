package me.dmdev.treebus.demo.ui.base;

import android.support.v7.app.AppCompatActivity;

import me.dmdev.treebus.Message;
import me.dmdev.treebus.Node;
import me.dmdev.treebus.NodeHolder;

/**
 * @author Dmitriy Gorbunov
 */

public class NodeActivity extends AppCompatActivity implements NodeHolder {

    private Node node = new Node(this);

    public Node getNode() {
        return node;
    }

    @Override
    public boolean handleMessage(Message message) {
        return false;
    }
}
