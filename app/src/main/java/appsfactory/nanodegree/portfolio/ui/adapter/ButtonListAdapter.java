package appsfactory.nanodegree.portfolio.ui.adapter;

import android.databinding.DataBindingUtil;
import android.databinding.ObservableList;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import appsfactory.nanodegree.portfolio.BR;
import appsfactory.nanodegree.portfolio.R;
import appsfactory.nanodegree.portfolio.models.ButtonItemViewModel;

public class ButtonListAdapter extends RecyclerView.Adapter<ButtonListAdapter.ButtonViewHolder> {

    private final ObservableList<ButtonItemViewModel> list;

    public ButtonListAdapter(ObservableList<ButtonItemViewModel> list) {
        this.list = list;

        this.list.addOnListChangedCallback(new ObservableList.OnListChangedCallback<ObservableList<ButtonItemViewModel>>() {
            @Override
            public void onChanged(ObservableList<ButtonItemViewModel> buttonItemViewModels) {
                notifyDataSetChanged();
            }

            @Override
            public void onItemRangeChanged(ObservableList<ButtonItemViewModel> buttonItemViewModels, int i, int i1) {
                ButtonListAdapter.this.notifyItemRangeChanged(i,i1);
            }

            @Override
            public void onItemRangeInserted(ObservableList<ButtonItemViewModel> buttonItemViewModels, int i, int i1) {
                ButtonListAdapter.this.notifyItemRangeInserted(i, i1);
            }

            @Override
            public void onItemRangeMoved(ObservableList<ButtonItemViewModel> buttonItemViewModels, int i, int i1, int i2) {
                ButtonListAdapter.this.notifyItemMoved(i, i1);
            }

            @Override
            public void onItemRangeRemoved(ObservableList<ButtonItemViewModel> buttonItemViewModels, int i, int i1) {
                ButtonListAdapter.this.notifyItemRangeRemoved(i, i1);
            }
        });
    }

    @Override
    public ButtonViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ButtonViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_button, parent, false));
    }

    @Override
    public void onBindViewHolder(ButtonViewHolder holder, int position) {
        ButtonItemViewModel item = list.get(position);
        holder.binding.setVariable(BR.item, item);
        holder.binding.executePendingBindings();
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class ButtonViewHolder extends RecyclerView.ViewHolder {
        int itemId;
        public ViewDataBinding binding;

        public ButtonViewHolder(View itemView) {
            super(itemView);
            this.itemId = BR.item;
            binding = DataBindingUtil.bind(itemView);
        }
    }
}
