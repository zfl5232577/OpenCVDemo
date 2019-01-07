package com.mark.opencvdemo;

import android.graphics.Bitmap;

/**
 * <pre>
 *     author : Mark
 *     e-mail : makun.cai@aorise.org
 *     time   : 2018/12/12
 *     desc   : TODO
 *     version: 1.0
 * </pre>
 */
public class FaceDetection {

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }

    public native void cannyCheck(Bitmap bitmap);
    public native void loadCascade(String filePath);
}
