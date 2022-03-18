package net.qiujuer.italker.common.app;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/**
 * @author logto
 */
public abstract class Activity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //在界面未初始化之前，先初始化窗口
        initWindow();

        if(initArgs(getIntent().getExtras())){
            getContentLayoutId();
            initWidget();
            initData();
        }else {
            finish();
        }
    }

    /**
     * 初始化窗口
     */
    protected void initWindow(){};

    /**
     * 初始化相关参数
     * @param bundle  参数bundle
     * @return  参数正确返回true,参数错误返回false
     */
     protected boolean initArgs(Bundle bundle){
        return true;
     };

    /**
     * 获取当前界面的LayoutID  每个界面对用的layout都不一样
     * @return 资源ID
     */
    protected abstract int getContentLayoutId();

    //初始化控件
    protected void initWidget(){ }

    //初始化数据
    protected void initData(){};

    @Override
    public boolean onSupportNavigateUp() {
        finish();//当点击界面导航返回时，finish当前界面；
        return super.onSupportNavigateUp();
    }

    @Override
    public void onBackPressed() {
        //返回上一个界面，而不是当前的activity
        //当前界面可能是fragment,点击返回时，只需要返回之前的fragment

        super.onBackPressed();
    }
}
