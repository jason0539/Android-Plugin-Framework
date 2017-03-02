package com.example.plugintest.activity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.pluginsharelib.BaseActivity;
import com.example.plugintest.R;

/**
 * Created by liuzhenhui on 2017/2/14.
 */

public class PluginForResultActivity extends BaseActivity {

    EditText etInput;
    Button btnSetResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(android.R.layout.activity_list_item);
        etInput = (EditText) findViewById(R.id.et_input_result);
        btnSetResult = (Button) findViewById(R.id.btn_set_result);

        btnSetResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input = etInput.getText().toString().trim();
                if (!TextUtils.isDigitsOnly(input)) {
                    Toast.makeText(PluginForResultActivity.this, "请输入数字", Toast.LENGTH_SHORT);
                    return;
                }
                setResult(Integer.valueOf(input));
                finish();
            }
        });
    }
}
