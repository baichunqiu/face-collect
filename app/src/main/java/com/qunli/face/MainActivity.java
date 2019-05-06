package com.qunli.face;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.baidu.idl.face.collect.Route;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.activity_main).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Route.instance().startActivity(MainActivity.this,Route.Type.Liveness);
            }
        });
        findViewById(R.id.main_settings).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Route.instance().startActivity(MainActivity.this, Route.Type.Setting);
            }
        });
    }
}
