package android.webkit;

import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;

/**
 * Copyright (C), 2018-2020
 * Author: ziqimo
 * Date: 2020/8/27 10:53 AM
 * Description:
 * History:
 * <author> <time> <version> <desc>
 * 作者姓名 修改时间 版本号 描述
 */
public class FixWebView extends WebView {
    public FixWebView(Context context) {
        super(context);
        removeJavascriptInterface("searchBoxJavaBridge_");
        removeJavascriptInterface("accessibility");
        removeJavascriptInterface("accessibilityTraversal");
        // 不保存密码，已经废弃了该方法，以后的版本都不会保存密码
        getSettings().setSavePassword(false);
    }

    public FixWebView(Context context, AttributeSet attrs) {
        super(context, attrs);
        removeJavascriptInterface("searchBoxJavaBridge_");
        removeJavascriptInterface("accessibility");
        removeJavascriptInterface("accessibilityTraversal");
        // 不保存密码，已经废弃了该方法，以后的版本都不会保存密码
        getSettings().setSavePassword(false);
    }

    public FixWebView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        removeJavascriptInterface("searchBoxJavaBridge_");
        removeJavascriptInterface("accessibility");
        removeJavascriptInterface("accessibilityTraversal");
        // 不保存密码，已经废弃了该方法，以后的版本都不会保存密码
        getSettings().setSavePassword(false);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public FixWebView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        removeJavascriptInterface("searchBoxJavaBridge_");
        removeJavascriptInterface("accessibility");
        removeJavascriptInterface("accessibilityTraversal");
        // 不保存密码，已经废弃了该方法，以后的版本都不会保存密码
        getSettings().setSavePassword(false);
    }
}
