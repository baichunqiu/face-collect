package com.baidu.idl.face.collect;


import com.baidu.idl.face.platform.FaceConfig;
import com.baidu.idl.face.platform.FaceEnvironment;
import com.baidu.idl.face.platform.FaceSDKManager;
import com.baidu.idl.face.platform.LivenessTypeEnum;

import java.util.ArrayList;
import java.util.List;

public class Config {
    public static String apiKey = "9ZGM6kcbhumIRSVCtE8MHIup";
    public static String secretKey = "bXhsciCFZu3rmFHWeWum36gY8cd03HzZ";
    public static String licenseID = "qunli-baicq-face-android";
    public static String licenseFileName = "idl-license.face-android";
    public static String groupID = "qunli_smartvideo";

    private static List<LivenessTypeEnum> livenessList = new ArrayList<LivenessTypeEnum>();
    private static boolean isLivenessRandom = false;

    static {
        livenessList.add(LivenessTypeEnum.Eye);
        livenessList.add(LivenessTypeEnum.Mouth);
        livenessList.add(LivenessTypeEnum.HeadUp);
        livenessList.add(LivenessTypeEnum.HeadDown);
        livenessList.add(LivenessTypeEnum.HeadLeft);
        livenessList.add(LivenessTypeEnum.HeadRight);
        livenessList.add(LivenessTypeEnum.HeadLeftOrRight);
    }

    public static void initDefaultConfig() {
        FaceConfig config = FaceSDKManager.getInstance().getFaceConfig();
        // SDK初始化已经设置完默认参数（推荐参数），您也根据实际需求进行数值调整
        config.setLivenessTypeList(livenessList);
        config.setLivenessRandom(isLivenessRandom);
        config.setBlurnessValue(FaceEnvironment.VALUE_BLURNESS);
        config.setBrightnessValue(FaceEnvironment.VALUE_BRIGHTNESS);
        config.setCropFaceValue(FaceEnvironment.VALUE_CROP_FACE_SIZE);
        config.setHeadPitchValue(FaceEnvironment.VALUE_HEAD_PITCH);
        config.setHeadRollValue(FaceEnvironment.VALUE_HEAD_ROLL);
        config.setHeadYawValue(FaceEnvironment.VALUE_HEAD_YAW);
        config.setMinFaceSize(FaceEnvironment.VALUE_MIN_FACE_SIZE);
        config.setNotFaceValue(FaceEnvironment.VALUE_NOT_FACE_THRESHOLD);
        config.setOcclusionValue(FaceEnvironment.VALUE_OCCLUSION);
        config.setCheckFaceQuality(true);
        config.setFaceDecodeNumberOfThreads(2);
        FaceSDKManager.getInstance().setFaceConfig(config);
    }

    public static void resetLivenessList() {
        FaceConfig config = FaceSDKManager.getInstance().getFaceConfig();
        // SDK初始化已经设置完默认参数（推荐参数），您也根据实际需求进行数值调整
        config.setLivenessTypeList(livenessList);
        config.setLivenessRandom(isLivenessRandom);
        FaceSDKManager.getInstance().setFaceConfig(config);
    }

    public static boolean containsLiveness(LivenessTypeEnum type) {
        return livenessList.contains(type);
    }

    public static void addLivenessType(LivenessTypeEnum type){
        if (!containsLiveness(type)){
            livenessList.add(type);
        }
    }
    public static void removeLivenessType(LivenessTypeEnum type){
        if (containsLiveness(type)){
            livenessList.remove(type);
        }
    }

    public static void removeAllType(){
        livenessList.clear();
    }

    public static String liveness2String(String split){
        StringBuilder sb = new StringBuilder();
        for (LivenessTypeEnum type : livenessList) {
            sb.append(type.name() + split);
        }
        return sb.toString();
    }


}