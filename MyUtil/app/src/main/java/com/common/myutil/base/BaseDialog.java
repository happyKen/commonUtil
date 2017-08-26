package com.common.myutil.base;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.common.myutil.R;


/**
 * dialog基本封装
 * Created by wangzekeng on 2017/6/23.
 */

public abstract class BaseDialog {

    protected Context mContext;
    private Dialog mDialog;
    private int mGravity = Gravity.CENTER;
    private boolean isWindowBackgroundTransparent = false;

    public BaseDialog(Context context) {
        this(context, 0);
    }

    public BaseDialog(Context context, int theme) {
        mContext = context;
        if (theme > 0) {
            mDialog = new Dialog(context, theme);
        } else {
            mDialog = new Dialog(context, R.style.BaseDialogTheme);
        }
        mDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        mDialog.setContentView(setContentView(LayoutInflater.from(context)));
    }


    private void setAttributes() {
        Window window = mDialog.getWindow();
        WindowManager.LayoutParams params = window.getAttributes();
        params.width = WindowManager.LayoutParams.WRAP_CONTENT;
        params.height = WindowManager.LayoutParams.WRAP_CONTENT;
        params.gravity = mGravity;
        if (isWindowBackgroundTransparent) {
            params.dimAmount = 0.0f;
        }
        window.setAttributes(params);
    }

    public void show() {
        setAttributes();
        mDialog.show();
    }

    public void dismiss() {
        mDialog.dismiss();
    }

    public boolean isShowing() {
        return mDialog.isShowing();
    }

    public void setCancelable(boolean b) {
        mDialog.setCancelable(b);
    }

    public void setCanceledOnTouchOutside(boolean b) {
        mDialog.setCanceledOnTouchOutside(b);
    }

    public void setGravity(int gravity) {
        mGravity = gravity;
    }

    public void setWindowBackgroundTransparent(boolean transparent) {
        isWindowBackgroundTransparent = transparent;
    }

    public void setOnCancelListener(DialogInterface.OnCancelListener listener) {
        mDialog.setOnCancelListener(listener);
    }

    /**
     * 设置输入法自动显示
     *
     * @param visible
     */
    public void setSoftInputAlwaysVisible(boolean visible) {
        if (visible) {
            mDialog.getWindow().setSoftInputMode(
                    WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
        }
    }

    public abstract View setContentView(LayoutInflater inflater);
}
