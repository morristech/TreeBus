package me.dmdev.treebus;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @author Dmitriy Gorbunov
 */
public class Node {

    private final MessageHandler messageHandler;
    private final List<Node> children = new ArrayList<>();
    private Node parent;
    private String tag = UUID.randomUUID().toString();
    private String target;

    public Node(MessageHandler messageHandler) {
        this.messageHandler = messageHandler;
    }

    public void sendTowardRoot(Message message) {
        message.from = tag;
        Node node = parent;
        while (node != null) {
            if (node.messageHandler.handleMessage(message)) {
                break;
            }
            node = node.parent;
        }
    }

    public void sendResultMessage(Message message) {
        message.from = tag;
        if (target != null) {
            message.to = target;
            findTheRoot().dispatchResultMessage(message);
        } else {
            if (parent != null) {
                parent.sendResultMessage(message);
            }
        }
    }

    public void sendToAll(Message message) {
        message.from = tag;
        Node root = findTheRoot();
        root.messageHandler.handleMessage(message);
        root.sendToDescendants(message);
    }

    public void sendToDescendants(Message message) {
        message.from = tag;
        for (Node node : children) {
            node.messageHandler.handleMessage(message);
            node.sendToDescendants(message);
        }
    }

    public void attachToParent(Node parent) {
        this.parent = parent;
        parent.addChildNode(this);
    }

    public void detachFromParent() {
        if (parent != null) {
            parent.removeChildNode(this);
            parent = null;
        }
    }

    public void setTarget(String target) {
        this.target = target;
    }

    private void addChildNode(Node node) {
        children.add(node);
    }

    private void removeChildNode(Node node) {
        children.remove(node);
    }

    private boolean dispatchResultMessage(Message message) {
        if (message.to.equals(tag)) {
            messageHandler.handleMessage(message);
            return true;
        } else {
            for (Node node : children) {
                if (node.dispatchResultMessage(message)) {
                    return true;
                }
            }
        }
        return false;
    }

    private Node findTheRoot() {
        Node root = this;
        while (root.parent != null) {
            root = root.parent;
        }
        return root;
    }
}
