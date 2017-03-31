package me.dmdev.treebus.demo.ui.pick;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

import me.dmdev.treebus.demo.DemoApplication;
import me.dmdev.treebus.R;
import me.dmdev.treebus.demo.ui.base.mvp.BasePresenter;
import me.dmdev.treebus.demo.ui.message.BackMessage;
import me.dmdev.treebus.demo.ui.message.ChosenColorMessage;

/**
 * @author Dmitriy Gorbunov
 */

public class ColorPickerPresenter extends BasePresenter<ColorPickerView> {

    private Context context = DemoApplication.getInstance();
    private List<Color> colorList = new ArrayList<>();

    @Override
    public void onCreate() {
        super.onCreate();
        int[] colors = context.getResources().getIntArray(R.array.material_colors);
        String[] names = context.getResources().getStringArray(R.array.material_color_names);

        for (int i = 0; i < colors.length; i++) {
            colorList.add(new Color(colors[i], names[i]));
        }
    }

    @Override
    public void onAttachView(ColorPickerView view) {
        super.onAttachView(view);
        view.showColors(colorList);
    }

    public void chooseColor(int color) {
        getNode().sendResultMessage(new ChosenColorMessage(color));
        getNode().sendTowardRoot(new BackMessage());
    }

    public void upButtonClick() {
        getNode().sendTowardRoot(new BackMessage());
    }
}
