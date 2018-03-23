package example.xueguoxue.mvpdome.mvp.basemvp;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Toast;


/**
 * Created by xueguoxue on 2018/3/23.
 * 创建一个BaseActivity负责实现BaseView中通用的的UI逻辑方法
 */

public abstract class BaseActivity extends Activity implements IBaseView {
    //重写onCreate方法
    private ProgressDialog mProgressDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mProgressDialog = new ProgressDialog(this);
        mProgressDialog.setCancelable(false);
    }
    //显示弹框

    @Override
    public void showLoading() {
        if (!mProgressDialog.isShowing()) {
            mProgressDialog.show();
        }
    }

    //隐藏弹框
    @Override
    public void hideLoading() {
        if (mProgressDialog.isShowing()) {
            mProgressDialog.dismiss();
        }

    }

    //显示提示
    @Override
    public void showToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    //错误处理
    @Override
    public void showErr() {

    }
    //获取上下文
    @Override
    public Context getContext() {
        return BaseActivity.this;
    }
}
