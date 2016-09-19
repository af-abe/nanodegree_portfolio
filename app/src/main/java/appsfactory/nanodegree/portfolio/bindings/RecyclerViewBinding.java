package appsfactory.nanodegree.portfolio.bindings;

import android.databinding.BindingAdapter;
import android.databinding.ObservableList;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import appsfactory.nanodegree.portfolio.ui.adapter.ButtonListAdapter;
import appsfactory.nanodegree.portfolio.models.ButtonItemViewModel;

@SuppressWarnings("unused")
public class RecyclerViewBinding {

    @BindingAdapter({"bind:items"})
    public static void setRecyclerViewAdapter(RecyclerView recyclerView, ObservableList<ButtonItemViewModel> items) {
        RecyclerView.Adapter adapter = recyclerView.getAdapter();
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();

        if(adapter == null){
            adapter = new ButtonListAdapter(items);
            recyclerView.setAdapter(adapter);
        }

        if(layoutManager == null){
            layoutManager = new LinearLayoutManager(recyclerView.getContext());
            recyclerView.setLayoutManager(layoutManager);
        }
    }
}
