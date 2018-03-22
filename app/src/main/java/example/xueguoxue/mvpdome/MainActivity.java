package example.xueguoxue.mvpdome;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements MvpView {
    //进度条
    ProgressDialog progressDialog;
    TextView text;
    MvpPresenter presenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text = findViewById(R.id.text);
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
        presenter.getData("normal");
    }

    // button 点击事件调用方法
    public void getDataForFailure(View view) {
        presenter.getData("failure");
    }

    // button 点击事件调用方法
    public void getDataForError(View view) {
        presenter.getData("error");
    }


    @Override
    public void showLoading() {
        if (!progressDialog.isShowing()) {
            progressDialog.show();
        }
    }

    @Override
    public void hideLoading() {
        if (progressDialog.isShowing()) {
            progressDialog.dismiss();
        }
    }

    @Override
    public void showData(String data) {
        text.setText(data);
    }

    @Override
    public void showFailureMessage(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
        text.setText(msg);
    }

    @Override
    public void showErrorMessage() {
        Toast.makeText(this, "网络请求数据出现异常", Toast.LENGTH_SHORT).show();
        text.setText("网络请求数据出现异常");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //在Activity销毁的时候解除对Presenter的绑定
        presenter.detachView();
    }
}

