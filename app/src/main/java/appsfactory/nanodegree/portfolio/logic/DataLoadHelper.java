package appsfactory.nanodegree.portfolio.logic;

import android.content.Context;
import android.content.res.AssetManager;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.List;

import appsfactory.nanodegree.portfolio.models.ButtonItemViewModel;

public class DataLoadHelper {
    public static List<ButtonItemViewModel> getAppListDataFromAssets(Context context) throws IOException {
        Gson gson = new Gson();
        Type typeOfObjectsList = new TypeToken<List<ButtonItemViewModel>>() {}.getType();
        AssetManager assetManager = context.getAssets();
        InputStream ims = assetManager.open("data.json");
        Reader reader = new InputStreamReader(ims);

        return gson.fromJson(reader, typeOfObjectsList);
    }
}
