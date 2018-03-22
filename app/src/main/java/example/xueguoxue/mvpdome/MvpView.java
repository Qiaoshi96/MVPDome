package example.xueguoxue.mvpdome;

/**
 * Created by xueguoxue on 2018/3/22.
 * View 接口是Activity与Presenter的中间层
 * 他的作用是根据具体的业务逻辑需要，为Presenter提供调用Activity中具体的逻辑操作方法
 */

public interface MvpView {
    /**
     * 显示正在加载的进度
     */
    void showLoading();

    /**
     * 隐藏加载的进度
     */
    void hideLoading();

    /**
     * 当数据请求成功后，调用此接口显示数据
     * @param data
     */
    void showData(String data);

    /**
     * 当数据请求失败后，调用此接口提示
     * @param msg
     */
    void showFailureMessage(String msg);

    /**
     * 当数据请求异常的时候调用这个接口
     */
    void showErrorMessage();

}
