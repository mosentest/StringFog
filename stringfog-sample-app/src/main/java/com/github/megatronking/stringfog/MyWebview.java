package com.github.megatronking.stringfog;

import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;

/**
 * Copyright (C), 2018-2020
 * Author: ziqimo
 * Date: 2020/8/27 10:49 AM
 * Description:
 * History:
 * <author> <time> <version> <desc>
 * 作者姓名 修改时间 版本号 描述
 */
public class MyWebview extends WebView {
    public MyWebview(Context context) {
        super(context);
    }

    public MyWebview(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyWebview(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public MyWebview(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    private void a(WebView webView) {
        //webView.removeJavascriptInterface("ccccc");
        webView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("TAG", v.toString());
            }
        });
    }
}
