/*
 * (C) Copyright 2011-2013 li.jamling@gmail.com. 
 *
 * This software is the property of li.jamling@gmail.com.
 * You have to accept the terms in the license file before use.
 *
 */
package cn.ieclipse.af.util;

import android.os.Environment;

import java.io.File;

/**
 * 无论是使用 getExternalStoragePublicDirectory()
 * 来存储可以共享的文件，还是使用 getExternalFilesDir()
 * 来储存那些对于我们的app来说是私有的文件，有一点很重要，
 * 那就是要使用那些类似DIRECTORY_PICTURES 的API的常量。
 * 那些目录类型参数可以确保那些文件被系统正确的对待。
 * 例如，那些以DIRECTORY_RINGTONES 类型保存的文件就会被系统的media scanner认为是ringtone而不是音乐。
 *
 * @author Jamling
 */
public class SDUtils {
    
    private SDUtils() {
    }
    
    /**
     * 获取SD卡的状态
     */
    public static String getState() {
        return Environment.getExternalStorageState();
    }


    /**
     * SD卡是否可用
     *
     * @return 只有当SD卡已经安装并且准备好了才返回true
     */
    public static boolean isAvailable() {
        return getState().equals(Environment.MEDIA_MOUNTED);
    }


    /**
     * 获取SD卡的根目录
     *
     * @return null：不存在SD卡
     */
    public static File getRootDirectory() {
        return isAvailable() ? Environment.getExternalStorageDirectory() : null;
    }

    public static File getExternalStoragePublicDirectory(String type) {
        return isAvailable() ? Environment.getExternalStoragePublicDirectory(type) : null;
    }
}
