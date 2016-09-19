package appsfactory.nanodegree.portfolio.models;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.view.View;
import android.widget.Toast;

import com.google.gson.annotations.SerializedName;

import appsfactory.nanodegree.portfolio.R;

@SuppressWarnings("unused")
public class ButtonItemViewModel extends BaseObservable {


    @Bindable
    @SerializedName("title")
    private String buttonTitle;

    @Bindable
    @SerializedName("apk")
    private String apkPath;

    public ButtonItemViewModel(String buttonTitle, String apkPath) {
        this.buttonTitle = buttonTitle;
        this.apkPath = apkPath;
    }

    public String getApkPath() {
        return apkPath;
    }

    public String getButtonTitle() {
        return buttonTitle;
    }

    public void onClicked(View button) {
        Context context = button.getContext();

        PackageManager pm = context.getPackageManager();
        Intent launchIntent = pm.getLaunchIntentForPackage(apkPath);

        if (launchIntent != null) {
            //Start the App if installed
            context.startActivity(launchIntent);
        } else {
            //shows Toast if not installed
            Toast.makeText(context, context.getString(R.string.txt_toast, buttonTitle), Toast.LENGTH_SHORT).show();
        }
    }
}
