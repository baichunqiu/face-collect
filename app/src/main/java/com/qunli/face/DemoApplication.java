package com.qunli.face;

import com.baidu.idl.face.collect.CollectApplication;
import com.baidu.idl.face.collect.Config;
import com.baidu.idl.face.platform.LivenessTypeEnum;

public class DemoApplication extends CollectApplication {
    @Override
    public void onCreate() {
        super.onCreate();
        Config.removeAllType();
        Config.addLivenessType(LivenessTypeEnum.Eye);
        Config.resetLivenessList();
    }
}
