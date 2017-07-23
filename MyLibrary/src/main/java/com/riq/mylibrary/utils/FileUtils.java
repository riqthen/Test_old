package com.riq.mylibrary.utils;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import static android.content.Context.MODE_PRIVATE;

public class FileUtils {
    /**
     * 创建指定的文件路径
     *
     * @param path
     */
    public static void createFolder(String path) {
        File file;
        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
            file = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + path);
            if (!file.exists()) {
                file.mkdirs();
            }
        }
    }

    /**
     * 文件路径转换成Uri
     *
     * @param filePath
     * @return 输出格式以“file:///”开头
     */
    public static Uri path2Uri(String filePath) {
        return Uri.fromFile(new File(filePath));
    }

    /**
     * Try to return the absolute file path from the given Uri  兼容了file:///开头的 和 content://开头的情况
     *
     * @param context
     * @param uri
     * @return the file path or null
     */
    public static String getRealFilePathFromUri(final Context context, final Uri uri) {
        if (null == uri) return null;
        final String scheme = uri.getScheme();
        String data = null;
        if (scheme == null)
            data = uri.getPath();
        else if (ContentResolver.SCHEME_FILE.equals(scheme)) {
            data = uri.getPath();
        } else if (ContentResolver.SCHEME_CONTENT.equals(scheme)) {
            Cursor cursor = context.getContentResolver().query(uri, new String[]{MediaStore.Images.ImageColumns.DATA}, null, null, null);
            if (null != cursor) {
                if (cursor.moveToFirst()) {
                    int index = cursor.getColumnIndex(MediaStore.Images.ImageColumns.DATA);
                    if (index > -1) {
                        data = cursor.getString(index);
                    }
                }
                cursor.close();
            }
        }
        return data;
    }

    /**
     * 获取字符串
     *
     * @param inputStream
     * @return
     */
    public static String getString(InputStream inputStream) {
        if (null == inputStream) return "";
        InputStreamReader inputStreamReader = null;
        try {
            inputStreamReader = new InputStreamReader(inputStream, "utf-8");
        } catch (UnsupportedEncodingException e1) {
            e1.printStackTrace();
        }
        BufferedReader reader = new BufferedReader(inputStreamReader);
        StringBuilder sb = new StringBuilder("");
        String line;
        try {
            while ((line = reader.readLine()) != null) {
                sb.append(line);
                sb.append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    /**
     * 获取字符串(按行读取)
     *
     * @param inputStream
     * @return 返回读取后的一行一行文本集合
     */
    public static ArrayList<String> getStrings(InputStream inputStream) {
        if (null == inputStream) return null;
        InputStreamReader inputStreamReader = null;
        try {
            inputStreamReader = new InputStreamReader(inputStream, "utf-8");
        } catch (UnsupportedEncodingException e1) {
            e1.printStackTrace();
        }
        assert inputStreamReader != null;
        BufferedReader reader = new BufferedReader(inputStreamReader);
        ArrayList<String> str = new ArrayList<>();
        String line;
        try {
            while ((line = reader.readLine()) != null) {
                str.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }

    //===============================

    /**
     * 保存文本到文件 /data/data/packageName/files
     *
     * @param context
     * @param filename
     * @param content
     */

    public void saveFile(Context context, String filename, String content) {
        saveFile(context, filename, content, MODE_PRIVATE);

    }

    /**
     * @param context
     * @param filename 文件名
     * @param content  保存的内容
     * @param mode     保存的方式 MODE_PRIVATE/MODE_APPEND
     */
    public void saveFile(Context context, String filename, String content, int mode) {
        FileOutputStream fos;
        BufferedWriter writer = null;
        try {
            fos = context.openFileOutput(filename, mode);
            writer = new BufferedWriter(new OutputStreamWriter(fos));
            writer.write(content);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (writer != null) {
                    writer.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    /**
     * 读取文件中的内容
     *
     * @param context
     * @param filename 文件名
     * @return 文件的内容
     */
    public String readFile(Context context, String filename) {
        FileInputStream fis;
        BufferedReader reader = null;
        StringBuffer sb = new StringBuffer();
        try {
            fis = context.openFileInput(filename);
            reader = new BufferedReader(new InputStreamReader(fis));
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return sb.toString();
    }


}
