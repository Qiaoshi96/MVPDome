package example.xueguoxue.mvpdome.mvp.model;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import example.xueguoxue.mvpdome.mvp.basemvp.MvpCallback;
import example.xueguoxue.mvpdome.bean.User;

/**
 * Created by xueguoxue on 2018/3/22.
 * 在这里定义了具体的网络请求操作
 * 此处利用postDelayed方法模拟耗时操作
 */

public class MvpModel {

    /**
     * 实现OK网络请求
     * http://int.dpool.sina.com.cn/iplookup/iplookup.php?format=json&ip=61.135.28.118
     */
    public static void getnetdata(final String params, final MvpCallback<User> callback) {
        OkHttpClient client = new OkHttpClient();
        final Request request = new Request
                .Builder()
                .url("http://int.dpool.sina.com.cn/iplookup/iplookup.php?format=json&ip=" + params)
                .build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {
                callback.onFailure("请求失败");
            }

            @Override
            public void onResponse(Response response) throws IOException {

                try {
                    String string = response.body().string();
                    JSONObject object = new JSONObject(string);
                    String country = object.getString("country");
                    String province = object.getString("province");
                    String city = object.getString("city");
                    User user = new User();
                    user.setCity(city);
                    user.setCountry(country);
                    user.setProvince(province);

                    callback.onSuccess(user);//装入数据

                    callback.onComplete();//完成请求
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }

        });


    }

}
