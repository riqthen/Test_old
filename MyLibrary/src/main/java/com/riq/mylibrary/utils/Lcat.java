package com.riq.mylibrary.utils;

import android.util.Log;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by riq on 2017/8/7.
 */

public class Lcat {
    private static String className;//类名
    private static String methodName;//方法名
    private static int lineNumber;//行数
    private static boolean isDebuggable = true;

    private static void getMethodNames(StackTraceElement[] sElements) {
        className = sElements[1].getFileName();
        methodName = sElements[1].getMethodName();
        lineNumber = sElements[1].getLineNumber();
    }


    //-----------> String
    public static void print(String s) {
        if (isDebuggable) {
            String threadName = Thread.currentThread().getName();
            getMethodNames(new Throwable().getStackTrace());
            Log.e("[" + className + "]", "Thread:" + threadName + "／(" + className + ":" + lineNumber + ")-----> " + s);
        }
    }

    public static void print(String tag, String s) {
        if (isDebuggable) {
            String threadName = Thread.currentThread().getName();
            getMethodNames(new Throwable().getStackTrace());
            Log.e("[" + className + "]", "Thread:" + threadName + "／(" + className + ":" + lineNumber + ") " + tag + " -----> " + s);
        }
    }

    //-----------> Object
    public static void print(Object o) {
        if (isDebuggable) {
            String threadName = Thread.currentThread().getName();
            Log.e("[" + className + "]", "Thread:" + threadName + "／(" + className + ":" + lineNumber + ")-----> " + o.toString());
        }
    }

    public static void print(String tag, Object o) {
        if (isDebuggable) {
            String threadName = Thread.currentThread().getName();
            Log.e("[" + className + "]", "Thread:" + threadName + "／(" + className + ":" + lineNumber + ") " + tag + " -----> "+ o.toString());
        }
    }


    //-----------> int
    public static void print(int i) {
        if (isDebuggable) {
            String threadName = Thread.currentThread().getName();
            Log.e("[" + className + "]", "Thread:" + threadName + "／(" + className + ":" + lineNumber + ")-----> " + String.valueOf(i));
        }
    }

    public static void print(String tag, int i) {
        if (isDebuggable) {
            String threadName = Thread.currentThread().getName();
            Log.e("[" + className + "]", "Thread:" + threadName + "／(" + className + ":" + lineNumber + ") " + tag + " -----> "+ String.valueOf(i));
        }
    }

    //-----------> double
    public static void print(double d) {
        if (isDebuggable) {
            String threadName = Thread.currentThread().getName();
            Log.e("[" + className + "]", "Thread:" + threadName + "／(" + className + ":" + lineNumber + ")-----> " + String.valueOf(d));
        }
    }

    public static void print(String tag, double d) {
        if (isDebuggable) {
            String threadName = Thread.currentThread().getName();
            Log.e("[" + className + "]", "Thread:" + threadName + "／(" + className + ":" + lineNumber + ") " + tag + " -----> "+ String.valueOf(d));
        }
    }


    //-----------> long
    public static void print(long l) {
        if (isDebuggable) {
            String threadName = Thread.currentThread().getName();
            Log.e("[" + className + "]", "Thread:" + threadName + "／(" + className + ":" + lineNumber + ")-----> " + String.valueOf(l));
        }
    }

    public static void print(String tag, long l) {
        if (isDebuggable) {
            String threadName = Thread.currentThread().getName();
            Log.e("[" + className + "]", "Thread:" + threadName + "／(" + className + ":" + lineNumber + ") " + tag + " -----> "+ String.valueOf(l));
        }
    }

    //-----------> boolean
    public static void print(boolean b) {
        if (isDebuggable) {
            String threadName = Thread.currentThread().getName();
            Log.e("[" + className + "]", "Thread:" + threadName + "／(" + className + ":" + lineNumber + ")-----> " + String.valueOf(b));
        }
    }

    public static void print(String tag, boolean b) {
        if (isDebuggable) {
            String threadName = Thread.currentThread().getName();
            Log.e("[" + className + "]", "Thread:" + threadName + "／(" + className + ":" + lineNumber + ") " + tag + " -----> "+ String.valueOf(b));
        }
    }

    //----------->  String[]
    public static void print(String[] strings) {
        if (isDebuggable) {
            String threadName = Thread.currentThread().getName();
            Log.e("[" + className + "]", "Thread:" + threadName + "／(" + className + ":" + lineNumber + ")-----> " + Arrays.toString(strings));
        }
    }

    public static void print(String tag, String[] strings) {
        if (isDebuggable) {
            String threadName = Thread.currentThread().getName();
            Log.e("[" + className + "]", "Thread:" + threadName + "／(" + className + ":" + lineNumber + ") " + tag + " -----> "+ Arrays.toString(strings));
        }
    }

    //----------->  int[]
    public static void print(int[] ints) {
        if (isDebuggable) {
            String threadName = Thread.currentThread().getName();
            Log.e("[" + className + "]", "Thread:" + threadName + "／(" + className + ":" + lineNumber + ")-----> " + Arrays.toString(ints));
        }
    }

    public static void print(String tag, int[] ints) {
        if (isDebuggable) {
            String threadName = Thread.currentThread().getName();
            Log.e("[" + className + "]", "Thread:" + threadName + "／(" + className + ":" + lineNumber + ") " + tag + " -----> "+ Arrays.toString(ints));
        }
    }

    //----------->  double[]
    public static void print(double[] doubles) {
        if (isDebuggable) {
            String threadName = Thread.currentThread().getName();
            Log.e("[" + className + "]", "Thread:" + threadName + "／(" + className + ":" + lineNumber + ")-----> " + Arrays.toString(doubles));
        }
    }

    public static void print(String tag, double[] doubles) {
        if (isDebuggable) {
            String threadName = Thread.currentThread().getName();
            Log.e("[" + className + "]", "Thread:" + threadName + "／(" + className + ":" + lineNumber + ") " + tag + " -----> "+ Arrays.toString(doubles));
        }
    }

    //----------->  byte[]
    public static void print(byte[] bytes) {
        if (isDebuggable) {
            String threadName = Thread.currentThread().getName();
            Log.e("[" + className + "]", "Thread:" + threadName + "／(" + className + ":" + lineNumber + ")-----> " + Arrays.toString(bytes));
        }
    }

    public static void print(String tag, byte[] bytes) {
        if (isDebuggable) {
            String threadName = Thread.currentThread().getName();
            Log.e("[" + className + "]", "Thread:" + threadName + "／(" + className + ":" + lineNumber + ") " + tag + " -----> "+ Arrays.toString(bytes));
        }
    }


    //----------->  Object[]
    public static void print(Object[] objects) {
        if (isDebuggable) {
            String threadName = Thread.currentThread().getName();
            Log.e("[" + className + "]", "Thread:" + threadName + "／(" + className + ":" + lineNumber + ")-----> " + Arrays.toString(objects));
        }
    }

    public static void print(String tag, Object[] objects) {
        if (isDebuggable) {
            String threadName = Thread.currentThread().getName();
            Log.e("[" + className + "]", "Thread:" + threadName + "／(" + className + ":" + lineNumber + ") " + tag + " -----> "+ Arrays.toString(objects));
        }
    }

    //----------->  Long[]
    public static void print(Long[] longs) {
        if (isDebuggable) {
            String threadName = Thread.currentThread().getName();
            Log.e("[" + className + "]", "Thread:" + threadName + "／(" + className + ":" + lineNumber + ")-----> " + Arrays.toString(longs));
        }
    }

    public static void print(String tag, Long[] longs) {
        if (isDebuggable) {
            String threadName = Thread.currentThread().getName();
            Log.e("[" + className + "]", "Thread:" + threadName + "／(" + className + ":" + lineNumber + ") " + tag + " -----> "+ Arrays.toString(longs));
        }
    }


    //-----------> List
    public static <T> void print(List<T> list) {
        if (isDebuggable) {
            String threadName = Thread.currentThread().getName();
            Log.e("[" + className + "]", "Thread:" + threadName + "／(" + className + ":" + lineNumber + ")-----> " + String.valueOf(list));
        }
    }


    public static <T> void print(String tag, List<T> list) {
        if (isDebuggable) {
            String threadName = Thread.currentThread().getName();
            Log.e("[" + className + "]", "Thread:" + threadName + "／(" + className + ":" + lineNumber + ") " + tag + " -----> "+ String.valueOf(list));
        }
    }


    //-----------> Set
    public static <T> void print(Set<T> set) {
        if (isDebuggable) {
            String threadName = Thread.currentThread().getName();
            Log.e("[" + className + "]", "Thread:" + threadName + "／(" + className + ":" + lineNumber + ")-----> " + String.valueOf(set));
        }
    }

    public static <T> void print(String tag, Set<T> set) {
        if (isDebuggable) {
            String threadName = Thread.currentThread().getName();
            Log.e("[" + className + "]", "Thread:" + threadName + "／(" + className + ":" + lineNumber + ") " + tag + " -----> "+ String.valueOf(set));
        }
    }

    //-----------> Map
    public static <K, V> void print(Map<K, V> map) {
        if (isDebuggable) {
            String threadName = Thread.currentThread().getName();
            Log.e("[" + className + "]", "Thread:" + threadName + "／(" + className + ":" + lineNumber + ")-----> " + String.valueOf(map));
        }
    }

    public static <K, V> void print(String tag, Map<K, V> map) {
        if (isDebuggable) {
            String threadName = Thread.currentThread().getName();
            Log.e("[" + className + "]", "Thread:" + threadName + "／(" + className + ":" + lineNumber + ") " + tag + " -----> "+ String.valueOf(map));
        }
    }
}
