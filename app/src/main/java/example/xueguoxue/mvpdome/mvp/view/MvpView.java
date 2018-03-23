package example.xueguoxue.mvpdome.mvp.view;

import example.xueguoxue.mvpdome.mvp.basemvp.IBaseView;
import example.xueguoxue.mvpdome.bean.User;

/**
 * Created by xueguoxue on 2018/3/22.
 * View 接口是Activity与Presenter的中间层
 * 他的作用是根据具体的业务逻辑需要，为Presenter提供调用Activity中具体的逻辑操作方法
 */

public interface MvpView extends IBaseView{
    /**
     * 这个是每个类自己要实现的写法
     * @param data
     */
    void showData(User data);
}
