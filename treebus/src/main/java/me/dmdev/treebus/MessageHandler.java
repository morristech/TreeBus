package me.dmdev.treebus;

/**
 * @author Dmitriy Gorbunov
 */

public interface MessageHandler {
    boolean handleMessage(Message message);
}
