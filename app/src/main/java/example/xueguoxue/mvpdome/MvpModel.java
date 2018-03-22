package example.xueguoxue.mvpdome;

import android.os.Handler;

/**
 * Created by xueguoxue on 2018/3/22.
 * 在这里定义了具体的网络请求操作
 * 此处利用postDelayed方法模拟耗时操作
 */

public class MvpModel {
    public static void getNetData(final String param, final MvpCallback callback) {
        //利用postdelay来模拟网络请求
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                switch (param) {
                    case "normal":

                        callback.onSuccess("根据参数" + param + "请求成功！");

                        break;
                    case "failure":

                        callback.onFailure("请求失败参数有误");


                        break;
                    case "error":

                        callback.onError();
                        break;
                }
                //请求完成
                callback.onComplete();

            }
        }, 2000);

    }

}
