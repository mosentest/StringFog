package com.github.megatronking.stringfog.plugin;

/**
 * Copyright (C), 2018-2020
 * Author: ziqimo
 * Date: 2020/8/27 1:19 PM
 * Description:
 * History:
 * <author> <time> <version> <desc>
 * 作者姓名 修改时间 版本号 描述
 */
public class ClassWebViewField {
    //    public static final String STRING_DESC = "Ljava/lang/String;";
    public static final String STRING_DESC = "Landroid/webkit/WebView;";

    /* package */ ClassWebViewField(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public String name;
    public Object value;
}
