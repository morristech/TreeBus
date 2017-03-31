package me.dmdev.treebus.demo.ui.pick;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import me.dmdev.treebus.R;
import me.dmdev.treebus.demo.ui.base.mvp.BasePresenterFragment;

/**
 * @author Dmitriy Gorbunov
 */

public class ColorPickerFragment extends BasePresenterFragment<ColorPickerPresenter> implements ColorPickerView {

    private ColorsAdapter adapter = new ColorsAdapter();

    private RecyclerView recyclerView;
    private Toolbar toolbar;

    @Override
    protected ColorPickerPresenter providePresenter(Bundle savedInstanceState) {
        return new ColorPickerPresenter();
    }

    @Override
    protected int getFragmentLayout() {
        return R.layout.fragment_color_picker;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        toolbar = (Toolbar) view.findViewById(R.id.toolbar);
        initViews();
    }

    private void initViews() {
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.upButtonClick();
            }
        });
    }

    @Override
    public void showColors(List<Color> colors) {
        adapter.setColors(colors);
    }

    class ColorsAdapter extends RecyclerView.Adapter<ColorsAdapter.ViewHolder> {

        private List<Color> colors;

        public void setColors(List<Color> colors) {
            this.colors = colors;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_color, parent, false));
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            holder.bind(colors.get(position));
        }

        @Override
        public int getItemCount() {
            if (colors == null) return 0;
            else return colors.size();
        }

        class ViewHolder extends RecyclerView.ViewHolder {

            private Color color;
            private TextView colorName;
            private TextView colorValue;

            public ViewHolder(View itemView) {
                super(itemView);
                colorName = (TextView) itemView.findViewById(R.id.color_name);
                colorValue = (TextView) itemView.findViewById(R.id.color_value);
                itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        presenter.chooseColor(color.intValue);
                    }
                });
            }

            public void bind(Color color) {
                this.color = color;
                itemView.setBackgroundColor(color.intValue);
                colorName.setText(color.name);
                colorValue.setText(String.format("#%06X", (0xFFFFFF & color.intValue)));
            }
        }
    }
}
