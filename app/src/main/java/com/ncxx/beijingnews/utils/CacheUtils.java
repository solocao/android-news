package com.ncxx.beijingnews.utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.ncxx.beijingnews.SplashActivity;

// 缓存的一些参数和数据
public class CacheUtils {

    /**
     * 得到缓存值
     * @param context 上下文
     * @param key
     * @return
     */
    public static boolean getBoolean(Context context, String key) {
        SharedPreferences sp =context.getSharedPreferences("atguigu",Context.MODE_PRIVATE);
        return  sp.getBoolean(key,false);
    }
}
