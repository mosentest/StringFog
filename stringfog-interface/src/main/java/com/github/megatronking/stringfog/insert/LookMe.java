package com.github.megatronking.stringfog.insert;

/**
 * 作者 : moziqi
 * 邮箱 : 709847739@qq.com
 * 时间   : 2019/3/21-15:24
 * desc   :
 * version: 1.0
 */
public class LookMe {
    public static void a() {
        if (2 == 3) {
            int i = 1;
            i++;
        } else {
            int j = 3;
            j++;
        }
        switch (2) {
            case 2:
                break;
        }
    }

    public static void b() {
        switch (2) {
            case 2:
                break;
            default:
                break;
        }
        if (3 == 2) {
            int j = 1;
            j++;
        } else {
            int k = 3;
            k++;
        }
    }

    public static void c() {
        switch (1) {
            case 1:
                break;
            default:
                break;
        }
        if (3 == 2) {
            int j = 1;
            j++;
        } else {
            int k = 3;
            k++;
        }
    }

    public static void d() {
        if (100 == 2) {
            float j = 1;
            j++;
        } else {
            float k = 3;
            k++;
        }
        switch (1) {
            case 1:
                break;
            default:
                break;
        }
    }

    public static void e() {
        switch (1) {
            case 1:
                break;
            default:
                break;
        }
        if (100 == 2) {
            double j = 1;
            j--;
        } else {
            double k = 3;
            k++;
        }
    }
}
