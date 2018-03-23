package example.xueguoxue.mvpdome.mvp.basemvp;

/**
 * Created by xueguoxue on 2018/3/23.
 * 同样定义一个BasePresenter来实现其他类共有的方法
 * 让P层与Activity共销毁
 */

public class BasePresenter<V extends IBaseView> {
    /**
     * 绑定View
     */
    private V mvpView;
    /**
     * 绑定View在初始化的时候调用
     */
    public void attachView(V mvpView) {
        this.mvpView = mvpView;
    }
    /**
     * 断开view，一般在onDestroy中调用
     */
    public void detachView() {
        this.mvpView = null;
    }
    /**
     * 是否与View建立连接
     * 每次调用业务请求的时候都要出先调用方法检查是否与View建立连接
     */
    public boolean isViewAttached(){
        return mvpView != null;
    }
    /**
     * 获取连接的view
     */
    public V getView(){
        return mvpView;
    }

}
