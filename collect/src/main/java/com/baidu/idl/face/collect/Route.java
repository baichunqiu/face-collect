package com.baidu.idl.face.collect;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;

public class Route {

    public enum Type {
        Collect,
        Liveness,
        Setting
    }

    private Type routeType = Type.Liveness;

    private static Route instance = new Route();

    public static Route instance() {
        return instance;
    }

    public void startActivity(Activity act) {
        startActivityForResult(act, routeType,-1);
    }


    public void startActivity(Activity act, Type type) {
        startActivityForResult(act,type,-1);
    }

    public void startActivityForResult(Activity act, Type type, int requestCode) {
        act.startActivityForResult(getIntent(act,type), requestCode);
    }


    private Intent getIntent(Context c, Type route) {
        Intent intent = new Intent();
        switch (route) {
            case Collect:
                intent.setClass(c, FaceCollectActivity.class);
                break;
            case Setting:
                intent.setClass(c, SettingActivity.class);
                break;
            default:
                intent.setClass(c, FaceCollectLivenessActivity.class);
                break;
        }
        return intent;
    }
}