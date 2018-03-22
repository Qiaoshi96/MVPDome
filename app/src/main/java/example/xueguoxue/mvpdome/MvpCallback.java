package example.xueguoxue.mvpdome;

/**
 * Created by xueguoxue on 2018/3/22.
 * Callback接口是Model层给Presenter层反馈信息的载体所以需要在Callback中定义数据请求的各种反馈状态
 * 增加泛型让每个model可以复用
 */

public interface MvpCallback<T>  {
    /**
     * 数据请求成
     * @param data
     */
    void onSuccess(T data);

    /**
     * 使用网络API接口请求方式时，虽然已经请求成功但是由
     * 于{@code msg}的原因无法正常返回数据。
     * @param msg
     */
    void onFailure(String msg);

    /**
     * 请求数据失败，指在请求网络API接口请求方式时，出现无法联网
     * 缺少权限，内存泄漏等原因导致无法连接到请求数据源
     */
    void onError();

    /**
     * 当请求结束时，无论请求是成功还是失败或是抛出异常都会执行此方法给用户做处理，
     * 通常网络请求时可以在此处影藏正在加载的等待控件
     */
    void onComplete();
}
