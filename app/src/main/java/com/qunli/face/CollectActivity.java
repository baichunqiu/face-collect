package com.qunli.face;

import com.bcq.oklib.base.BaseActivity;
import com.bcq.oklib.base.BaseFragment;


/**
 * @author: BaiCQ
 * @ClassName: CollectActivity
 * @Description: 人脸采集页面
 */
public class CollectActivity extends BaseActivity {
    private BaseFragment collectFragment;
    @Override
    public int setLayoutId() {
        return R.layout.activity_collect;
    }

    @Override
    public int setContainId() {
        return R.id.fl_fragment;
    }

    @Override
    public void init() {
        collectFragment = new CollectFragment();
        addFragment(collectFragment,true);
    }

}
