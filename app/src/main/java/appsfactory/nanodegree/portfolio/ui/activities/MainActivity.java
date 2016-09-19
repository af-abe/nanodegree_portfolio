package appsfactory.nanodegree.portfolio.ui.activities;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;

import java.util.List;

import appsfactory.nanodegree.portfolio.R;
import appsfactory.nanodegree.portfolio.databinding.ActivityMainBinding;
import appsfactory.nanodegree.portfolio.logic.loader.DataLoader;
import appsfactory.nanodegree.portfolio.models.ButtonItemViewModel;
import appsfactory.nanodegree.portfolio.models.MainModel;

public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<List<ButtonItemViewModel>> {
    private MainModel mainModel;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainModel = new MainModel();
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setModel(mainModel);

        loadContent();
    }

    private void loadContent(){
        getSupportLoaderManager().initLoader(0, null, this)
                .forceLoad();
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        //unset adapter to avoid memory leeks
        binding.recyclerView.setAdapter(null);
    }

    @Override
    public Loader<List<ButtonItemViewModel>> onCreateLoader(int id, Bundle args) {
        return new DataLoader(this);
    }

    @Override
    public void onLoadFinished(Loader<List<ButtonItemViewModel>> loader, List<ButtonItemViewModel> data) {
        if(data != null){
            mainModel.appList.clear();
            mainModel.appList.addAll(data);
        }
    }

    @Override
    public void onLoaderReset(Loader<List<ButtonItemViewModel>> loader) {

    }
}
