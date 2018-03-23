package example.xueguoxue.mvpdome.mvp.basemvp;

import android.content.Context;

/**
 * Created by xueguoxue on 2018/3/23.
 * 定义BaseView 让任何一个Activity都可以复用
 */

public interface IBaseView {
    /**
     * 显示正在加载view
     */
    void showLoading();
    /**
     * 关闭正在加载view
     */
    void hideLoading();
    /**
     * 显示提示
     * @param msg
     */
    void showToast(String msg);
    /**
     * 显示请求错误提示
     */
    void showErr();
    /**
     * 获取上下文
     * @return 上下文
     */
    Context getContext();
}
