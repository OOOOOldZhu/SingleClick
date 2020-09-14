package com.zhw.mylibrary;

/*
 * ：Created by z on 2020/9/14
 */

import android.app.Activity;
import android.util.Log;
import android.view.View;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class SingleClickInjecter {

    public static void inject(final Activity activity) {
        final Class<? extends Activity> aClass = activity.getClass();
        try {
            Method findViewById = aClass.getMethod("findViewById", int.class);
            Method[] declaredMethods = aClass.getDeclaredMethods();
            for (final Method method : declaredMethods) {
                SingleClick injectClick = method.getAnnotation(SingleClick.class);
                if (injectClick != null) {
                    int clickResId = injectClick.value();//获取到注解SingleClick的资源id
                    int delay = injectClick.delay();
                    final Object invoke = findViewById.invoke(activity, clickResId);
                    ((View) invoke).setOnClickListener(new SingleClickListener(delay) {
                        @Override
                        public void onSingleClick(View v) {
                            afterClick(method,activity,v);
                        }
                    });
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void afterClick(Method method,Activity activity,View v){
        try {
            Log.i("zhu", " - - - - - - - - - - - - - - - > ");
            method.invoke(activity,v);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

}
