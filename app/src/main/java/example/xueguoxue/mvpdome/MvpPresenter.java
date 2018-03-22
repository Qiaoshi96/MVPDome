package example.xueguoxue.mvpdome;

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

public class MvpPresenter {
    //View接口
    private MvpView mView;
    public MvpPresenter(){
       //构造方法中不再需要View参数
    }
    //绑定View在初始化的时候调用
    public void attachView(MvpView mView){
        this.mView=mView;
    }
    //断开View在onDestroy中调用
    public void detachView() {
        this.mView= null;
    }
    //是否于View建立连接
    //每次调用业务请求的时候都要先调用方法检查是否与View建立连接

    public boolean isViewAttached(){
        return mView!= null;
    }

    /**
     * 获取网络数据
     */
    public void getData(String params){
        //加载数据时显示正在加载进度条
        mView.showLoading();
        //调用Model请求数据
        MvpModel.getNetData(params, new MvpCallback() {
            @Override
            public void onSuccess(String data) {
                //调用View接口显示数据
                //增加一层判断
                if (isViewAttached()){
                    mView.showData(data);
                }
            }

            @Override
            public void onFailure(String msg) {
                //View接口调用失败的信息
                if (isViewAttached()){
                    mView.showFailureMessage(msg);
                }
            }

            @Override
            public void onError() {
                //错误的信息
                if (isViewAttached()) {
                    mView.showErrorMessage();
                }
            }

            @Override
            public void onComplete() {
                //完成时隐藏进度条
                if (isViewAttached()){
                    mView.hideLoading();
                }


            }
        });

    }
}
