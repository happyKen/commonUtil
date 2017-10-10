package com.common.myutil.view;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

/**
 * Created by wangzekeng on 2017/10/9.
 */

public class AnimateActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new DemoSurfaceView(this));
    }
}
