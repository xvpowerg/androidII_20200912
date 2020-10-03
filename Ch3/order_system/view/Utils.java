package tw.com.xvpower.ch2_3_ordersystem.view;

import android.content.Context;

import java.io.File;

import tw.com.xvpower.ch2_3_ordersystem.R;

public class Utils {

    public static File getJsonDir(Context context){
        String dirName = context.getString(R.string.json_dir);
        return context.getExternalFilesDir(dirName);
    }
}
