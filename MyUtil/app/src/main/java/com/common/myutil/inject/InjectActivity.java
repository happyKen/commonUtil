package com.common.myutil.inject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.common.myutil.R;
import com.common.myutil.utils.LogUtils;

public class InjectActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inject);



//        Button button1 = (Button) findViewById(R.id.button1);
//        Button button2 = (Button) findViewById(R.id.button2);

        //绑定注解处理
        ViewInjectUtils.inject(this);

    }
    //注解
    @OnClick({R.id.button1,R.id.button2})
    public void clickBtnInvoked(View view){
        switch (view.getId()){
            case R.id.button1:
                Toast.makeText(this,"button1 is clicked!!!",Toast.LENGTH_LONG).show();
                LogUtils.d("button1 is clicked!");
                break;
            case R.id.button2:
                Toast.makeText(this,"button2 is clicked!!!",Toast.LENGTH_LONG).show();
                LogUtils.d("button2 is clicked!");
                break;
            default:
                break;
        }
    }
}
