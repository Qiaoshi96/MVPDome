package example.xueguoxue.mvpdome.mvp.presenter;

import example.xueguoxue.mvpdome.mvp.model.MvpModel;
import example.xueguoxue.mvpdome.mvp.basemvp.BasePresenter;
import example.xueguoxue.mvpdome.mvp.basemvp.MvpCallback;
import example.xueguoxue.mvpdome.bean.User;
import example.xueguoxue.mvpdome.mvp.view.MvpView;

/**
 * Created by xueguoxue on 2018/3/22.
 * Presenter用来处理具体的业务逻辑
 * Presenter类构造方法中有一个View接口参数，是为了能够通过View接口通过Activity来通知界面更新
 *
 * ——————————————————————————————————————————————————————————————————————————————————
 * 考虑到在请求过程中Activity销毁而造成空指针异常 想要避免这种情况的发生每次调用View前都应该知道当前Activity的状态
 * 让Activity接口和宿主View工存亡
 *
 */

public class MvpPresenter extends BasePresenter<MvpView>{

    /**
     * 获取网络数据
     * @param params 参数
     *  在P层里面来写具体的逻辑
     */

    public void getData(String params) {

        if (!isViewAttached()) {
            //如果没有View引用就不加载数据
            return;
        }
        //显示正在加载进度条
        getView().showLoading();

        //调用model请求数据
        MvpModel.getnetdata(params, new MvpCallback<User>() {
            @Override
            public void onSuccess(User data) {
                //调用view接口显示数据
                if(isViewAttached()){
                    getView().showData(data);
                }
            }

            @Override
            public void onFailure(String msg) {
                //调用view接口提示失败信息
                if(isViewAttached()){
                    getView().showToast(msg);
                }
            }

            @Override
            public void onError() {
                //调用view接口提示请求异常
                if(isViewAttached()){
                    getView().showErr();
                }
            }

            @Override
            public void onComplete() {
                // 隐藏正在加载进度条
                if(isViewAttached()){
                    getView().hideLoading();

                }
            }
        });

    }

}
