package com.baidu.idl.face.collect;

import android.app.Activity;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.baidu.idl.face.platform.LivenessTypeEnum;
import com.baidu.idl.face.platform.ui.R;

public class SettingActivity extends Activity implements CompoundButton.OnCheckedChangeListener {
    private TextView mLivenessSelect;
    private CheckBox mCbRandom;
    private CheckBox mCb1;
    private CheckBox mCb2;
    private CheckBox mCb3;
    private CheckBox mCb4;
    private CheckBox mCb5;
    private CheckBox mCb6;
    private CheckBox mCb7;

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Config.resetLivenessList();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        mLivenessSelect = (TextView) this.findViewById(R.id.settings_liveness_index);
        mCbRandom = (CheckBox) this.findViewById(R.id.settings_liveness_random);
        mCb1 = (CheckBox) this.findViewById(R.id.settings_liveness_cb1);
        mCb2 = (CheckBox) this.findViewById(R.id.settings_liveness_cb2);
        mCb3 = (CheckBox) this.findViewById(R.id.settings_liveness_cb3);
        mCb4 = (CheckBox) this.findViewById(R.id.settings_liveness_cb4);
        mCb5 = (CheckBox) this.findViewById(R.id.settings_liveness_cb5);
        mCb6 = (CheckBox) this.findViewById(R.id.settings_liveness_cb6);
        mCb7 = (CheckBox) this.findViewById(R.id.settings_liveness_cb7);

        mCbRandom.setChecked(false);

        mCb1.setTag(LivenessTypeEnum.Eye);
        mCb2.setTag(LivenessTypeEnum.Mouth);
        mCb3.setTag(LivenessTypeEnum.HeadUp);
        mCb4.setTag(LivenessTypeEnum.HeadDown);
        mCb5.setTag(LivenessTypeEnum.HeadLeft);
        mCb6.setTag(LivenessTypeEnum.HeadRight);
        mCb7.setTag(LivenessTypeEnum.HeadLeftOrRight);

        mCb1.setOnCheckedChangeListener(this);
        mCb2.setOnCheckedChangeListener(this);
        mCb3.setOnCheckedChangeListener(this);
        mCb4.setOnCheckedChangeListener(this);
        mCb5.setOnCheckedChangeListener(this);
        mCb6.setOnCheckedChangeListener(this);
        mCb7.setOnCheckedChangeListener(this);

        mCb1.setChecked(Config.containsLiveness(LivenessTypeEnum.Eye));
        mCb2.setChecked(Config.containsLiveness(LivenessTypeEnum.Mouth));
        mCb3.setChecked(Config.containsLiveness(LivenessTypeEnum.HeadUp));
        mCb4.setChecked(Config.containsLiveness(LivenessTypeEnum.HeadDown));
        mCb5.setChecked(Config.containsLiveness(LivenessTypeEnum.HeadLeft));
        mCb6.setChecked(Config.containsLiveness(LivenessTypeEnum.HeadRight));
        mCb7.setChecked(Config.containsLiveness(LivenessTypeEnum.HeadLeftOrRight));
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        LivenessTypeEnum type = (LivenessTypeEnum) buttonView.getTag();
        if (isChecked) {
            if (!Config.containsLiveness(type))
            Config.addLivenessType(type);
        } else {
            Config.removeLivenessType(type);
        }
        mLivenessSelect.setText(Config.liveness2String(" "));
    }

}
