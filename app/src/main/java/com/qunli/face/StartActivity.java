/*
 * Copyright (C) 2017 Baidu, Inc. All Rights Reserved.
 */
package com.qunli.face;


import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.view.View;
import android.widget.Button;

import com.bcq.oklib.UI;
import com.bcq.oklib.base.BaseActivity;

public class StartActivity extends Activity implements View.OnClickListener {

    private Button mTrackBtn;
    private Button mAttrBtn;
    private Button mDetectBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);
        initView();
        addListener();
//        UI.postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                UI.startActivity(StartActivity.this,MainActivity.class);
//            }
//        },500);
    }

    private void initView() {
        mTrackBtn = (Button) findViewById(R.id.track_btn);
        mAttrBtn = (Button) findViewById(R.id.attr_btn);
        mDetectBtn = (Button) findViewById(R.id.detect_btn);
    }

    private void addListener() {
        mTrackBtn.setOnClickListener(this);
        mAttrBtn.setOnClickListener(this);
        mDetectBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CAMERA)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA}, 100);
            return;
        }

        switch (v.getId()) {
            case R.id.track_btn:
//                Intent itTrack = new Intent(StartActivity.this, TrackActivity.class);
//                startActivity(itTrack);
                UI.startActivity(StartActivity.this,MainActivity.class);
                break;
            case R.id.attr_btn:
//                Intent itAttr = new Intent(StartActivity.this, AttrActivity.class);
//                startActivity(itAttr);
                break;
            case R.id.detect_btn:
                Intent itDetect = new Intent(StartActivity.this, CollectActivity.class);
                startActivity(itDetect);
                break;
            default:
                break;
        }

    }
}
