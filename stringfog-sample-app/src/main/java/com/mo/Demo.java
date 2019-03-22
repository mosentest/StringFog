package com.mo;

import android.content.Context;
import android.net.ConnectivityManager;

import java.lang.reflect.Method;

/**
 * 作者 : moziqi
 * 邮箱 : 709847739@qq.com
 * 时间   : 2019/3/22-10:26
 * desc   :
 * version: 1.0
 */
public class Demo {

    public void test(Context context) throws ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        ConnectivityManager mConnectivityManager =
                (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        Class cls = Class.forName("android.net.ConnectivityManager$OnStartTetheringCallback");
        Object o = cls.newInstance();
        Method startTethering = mConnectivityManager.getClass()
                .getDeclaredMethod("startTethering", Integer.class, Boolean.class, cls);

    }
}
