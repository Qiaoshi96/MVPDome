package example.xueguoxue.mvpdome;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import example.xueguoxue.mvpdome.mvp.basemvp.BaseActivity;
import example.xueguoxue.mvpdome.bean.User;
import example.xueguoxue.mvpdome.mvp.presenter.MvpPresenter;
import example.xueguoxue.mvpdome.mvp.view.MvpView;

public class MainActivity extends BaseActivity implements MvpView {
    //进度条
    ProgressDialog progressDialog;
    TextView text;
    EditText editor;
    MvpPresenter presenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text = findViewById(R.id.text);
        editor = findViewById(R.id.editor);

        //初始化进度条
        progressDialog = new ProgressDialog(this);
        progressDialog.setCancelable(false);
        progressDialog.setMessage("正在加载数据");
        //初始化Presenter拿到数据  绑定生命周期方式Activity异常销毁造成内存泄漏
        presenter = new MvpPresenter();
        presenter.attachView(this);

    }

    // button 点击事件调用方法
    public void getData(View view) {

        String s = editor.getText().toString();
        if (s != null) {
            presenter.getData(s);
        }
    }

    @Override
    public void showData(final User data) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                text.setText("国家:" + data.getCountry() + "\n省份:" + data.getProvince() + "\n城市：" + data.getCity());
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //在Activity销毁的时候解除对Presenter的绑定
        presenter.detachView();
    }
}

