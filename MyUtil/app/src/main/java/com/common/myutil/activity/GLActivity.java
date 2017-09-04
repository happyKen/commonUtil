package com.common.myutil.activity;

import android.app.ActivityManager;
import android.content.pm.ConfigurationInfo;
import android.opengl.GLSurfaceView;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.common.myutil.R;
import com.common.myutil.utils.LogUtils;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public class GLActivity extends AppCompatActivity {
    private boolean supportsEs2;
    private GLSurfaceView glSurfaceView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        checkSupported();
        if(supportsEs2){
            LogUtils.i("支持 es2");
            glSurfaceView  =  new GLSurfaceView(this);
            glSurfaceView.setRenderer(new GLSurfaceView.Renderer() {
                @Override
                public void onSurfaceCreated(GL10 gl, EGLConfig config) {
                    gl.glClearColor(1f, 0f, 0f, 0f);
                }

                @Override
                public void onSurfaceChanged(GL10 gl, int width, int height) {
                    gl.glViewport(0, 0, width, height);
                }

                @Override
                public void onDrawFrame(GL10 gl) {
                    gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
                }
            });
            setContentView(glSurfaceView);
        }else{
            LogUtils.i("不支持 es2");
            setContentView(R.layout.activity_gl);
            Toast.makeText(this,"当前设备不支持opengl ES2",Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if(glSurfaceView != null){
            glSurfaceView.onResume();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        if(glSurfaceView != null){
            glSurfaceView.onPause();
        }
    }

    /**
     *检测是否支持gl es2
     */
    private void checkSupported() {
        ActivityManager activityManager = (ActivityManager) getSystemService(ACTIVITY_SERVICE);
        ConfigurationInfo configurationInfo = activityManager.getDeviceConfigurationInfo();
        supportsEs2 = configurationInfo.reqGlEsVersion >= 0x2000;

        boolean isEmulator = Build.VERSION.SDK_INT > Build.VERSION_CODES.ICE_CREAM_SANDWICH_MR1
                && (Build.FINGERPRINT.startsWith("generic")
                || Build.FINGERPRINT.startsWith("unknown")
                || Build.MODEL.contains("google_sdk")
                || Build.MODEL.contains("Emulator")
                || Build.MODEL.contains("Android SDK built for x86"));

        supportsEs2 = supportsEs2 || isEmulator;
    }

}
