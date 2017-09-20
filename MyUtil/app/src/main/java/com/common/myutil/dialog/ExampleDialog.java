package com.common.myutil.dialog;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.common.myutil.R;
import com.common.myutil.base.BaseDialog;
import com.common.myutil.utils.LogUtils;

/**
 * dialog demo
 * Created by wangzekeng on 2017/8/26.
 */

public class ExampleDialog extends BaseDialog implements View.OnClickListener{
    private EditText editView;
    private Button btnSure;
    private EnterRoomDialogListener mListener;
    public ExampleDialog(Context context) {
        super(context);
        setSoftInputAlwaysVisible(true);
    }


    @Override
    public View setContentView(LayoutInflater inflater) {
        View view = inflater.inflate(R.layout.dialog_enter_room, null);
        editView = (EditText) view.findViewById(R.id.dlg_enter_room_edit);
        btnSure = (Button) view.findViewById(R.id.dlg_enter_room_btn_sure);
        btnSure.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        if (v == btnSure) {
            String roomId = editView.getText().toString();
            if (TextUtils.isEmpty(roomId)) {
                LogUtils.toastCover(mContext, "房间号不能为空");
                return;
            }
            if (mListener != null) {
                mListener.onComplete(roomId);
            }
            dismiss();
        }
    }

    public void setListener(EnterRoomDialogListener listener) {
        mListener = listener;
    }

    public interface EnterRoomDialogListener {
        public void onComplete(String roomId);
    }



}
