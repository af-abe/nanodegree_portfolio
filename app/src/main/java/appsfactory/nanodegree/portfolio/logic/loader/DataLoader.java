package appsfactory.nanodegree.portfolio.logic.loader;

import android.content.Context;
import android.support.v4.content.AsyncTaskLoader;

import java.io.IOException;
import java.util.List;

import appsfactory.nanodegree.portfolio.logic.DataLoadHelper;
import appsfactory.nanodegree.portfolio.models.ButtonItemViewModel;

public class DataLoader extends AsyncTaskLoader<List<ButtonItemViewModel>>{

    public DataLoader(Context context) {
        super(context);
    }

    @Override
    public List<ButtonItemViewModel> loadInBackground() {
        try {
            return DataLoadHelper.getAppListDataFromAssets(getContext());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
