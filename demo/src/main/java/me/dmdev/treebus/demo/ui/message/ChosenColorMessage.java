package me.dmdev.treebus.demo.ui.message;

import me.dmdev.treebus.Message;

/**
 * @author Dmitriy Gorbunov
 */

public class ChosenColorMessage extends Message {

    public final int color;

    public ChosenColorMessage(int color) {
        this.color = color;
    }
}
