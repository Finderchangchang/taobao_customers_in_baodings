package gy.myproject.config;

import android.os.Environment;

import java.io.File;

public class FileHelper {

    public static String getDownloadApkCachePath() {

        String appCachePath = null;


        if (checkSDCard()) {
            appCachePath = Environment.getExternalStorageDirectory() + "/WQCNCCB/file_path/";
        } else {
            appCachePath = Environment.getDataDirectory().getPath() + "/WQCNCCB/file_path/";
        }
        File file = new File(appCachePath);
        if (!file.exists()) {
            file.mkdirs();
        }
        return appCachePath;
    }

    public static String getDownloadImageCachePath() {

        String imageCachePath = null;

        if (checkSDCard()) {
            imageCachePath = Environment.getExternalStorageDirectory() + "/WQCNCCB/file_path/";
        } else {
            imageCachePath = Environment.getDataDirectory().getPath() + "/WQCNCCB/file_path/";
        }
        File file = new File(imageCachePath);
        if (!file.exists()) {
            file.mkdirs();
        }
        return imageCachePath;
    }


    /**
     *
     */
    public static boolean checkSDCard() {
        boolean sdCardExist = Environment.getExternalStorageState().equals(
                Environment.MEDIA_MOUNTED);

        return sdCardExist;

    }
}
