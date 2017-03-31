package me.dmdev.treebus.demo.ui.message;

import me.dmdev.treebus.Message;

/**
 * @author Dmitriy Gorbunov
 */

public class PaintMessage extends Message {
    public final int color;
    public PaintMessage(int color) {
        this.color = color;
    }
}
