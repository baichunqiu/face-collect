package com.baidu.idl.face.collect;

import android.app.Application;

import com.baidu.idl.face.platform.FaceSDKManager;

public class CollectApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        FaceSDKManager.getInstance().initialize(this, Config.licenseID, Config.licenseFileName);
        Config.initDefaultConfig();
    }

}
