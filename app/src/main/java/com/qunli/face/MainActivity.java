package com.qunli.face;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.baidu.idl.face.collect.Route;

public class MainActivity extends Activity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.main_register).setOnClickListener(this);
        findViewById(R.id.main_recognition).setOnClickListener(this);
        findViewById(R.id.main_settings).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.main_settings:
                Route.instance().startActivity(MainActivity.this, Route.Type.Setting);
                break;
            case R.id.main_recognition:
                Route.instance().startActivity(MainActivity.this, Route.Type.Collect);
                break;
            case R.id.main_register:
                Route.instance().startActivity(MainActivity.this, Route.Type.Liveness);
                break;
        }
    }
}
