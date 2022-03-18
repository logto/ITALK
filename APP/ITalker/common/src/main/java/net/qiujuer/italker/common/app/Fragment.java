package net.qiujuer.italker.common.app;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/**
 * @author logto
 */
public abstract class Fragment extends androidx.fragment.app.Fragment {

    protected  View mRoot;
    /**
     * 初始化相关参数
     * @param bundle  参数bundle
     * @return  参数正确返回true,参数错误返回false
     */
    protected void initArgs(Bundle bundle){

    };

    /**
     * @param context 对应Activity
     */
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        //初始化参数
        initArgs(getArguments());

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if(mRoot ==null){
            int layoutId = getContentLayoutId();
            //container 相当于时layoutId对应的myRoot的父控件
            //初始化当前的根布局，在创建时不将其添加到container中
            View root   = inflater.inflate(layoutId,container,false);
            mRoot = root;
            initWidget(root);
        }else {
            if(mRoot.getParent()!=null){
                //当fragment调用过一次后，mRoot就会被添加到父控件的container中
                //fragment被回收，再次初始化frament时，myRoot可能还没被回收，依然在container中
                //所以需要将当前的布局mRoot，从其父控件中移除掉
                ((ViewGroup) mRoot.getParent()).removeView(mRoot);
            }
        }

        //返回mRoot后，在后续的fragment的调度中，自动会将mRoot添加到container中
        return mRoot;
    }

    /**
     * 当View初始化完成后（onCreateView），再初始化数据
     * @param view
     * @param savedInstanceState
     */
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initData();
    }

    /**
     * 获取当前界面的资源ID
     * @return 资源ID
     */
    protected abstract int getContentLayoutId();

    /**
     *初始化控件
     * @param root
     */
    protected void initWidget(View root){};

    /**
     * 初始化数据
     */
    protected void initData(){};

}
