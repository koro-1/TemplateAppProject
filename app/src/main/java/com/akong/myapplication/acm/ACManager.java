package com.akong.myapplication.acm;

import android.content.Context;

import androidx.annotation.NonNull;

import com.akong.acmanager.acm.AccountInfo;
import com.akong.acmanager.acm.AccountManger;
import com.akong.acmanager.acm.LoginResultCallback;
import com.akong.acmanager.acm.LogoutResultCallback;

public class ACManager extends AccountManger {


    public ACManager(@NonNull Context context) {
        super(context);
    }
    @Override
    public void doInLogin(String username, String password, LoginResultCallback callback) {
        //网络请求尝试登陆 获取用户数据保留本地缓存
        //todo 实现登陆逻辑 成功时候封装 AccountInfo 存储Room
        new Thread(new Runnable(){
            @Override
            public void run() {
                // 休眠三秒 模拟耗时
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                callback.onSuccess(new AccountInfo("akong",username,"akong",""),new MyLoggedInUserView());

            }
        }).start();

    }
    public static  void init(Context context) {
       ACManager.getInstance(context);
    }
    @Override
    public void doInLogout( LogoutResultCallback callback) {
        //todo 实现登出逻辑
        callback.onSuccess();

        // 1. 清除用户会话数据

        // 如果使用了第三方库，调用其提供的登出方法
        // 如 authProvider.signOut();

        // 2. 更新应用状态


        // 3. 关闭关联服务
        // 取决于具体应用，可能需要停止特定服务或发送广播通知服务登出

        // 4. 通知相关组件
        // 可能需要发送本地Broadcast，让监听登出事件的组件做出响应

        // 5. 导航到登录界面
//        Intent intent = new Intent(context, LoginActivity.class);
//        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
//        context.startActivity(intent);


        // 6. 考虑安全措施
        // 可能包括清除HTTP缓存、撤销OAuth授权等
    }

    @Override
    public void autoLogin( LoginResultCallback callback) {
        //todo 实现自动登陆逻辑
    }


    private static ACManager instance;


    public static ACManager getInstance(Context context) {
        if (instance == null) {
            synchronized (ACManager.class) {
                if (instance == null) {
                    instance = new ACManager(context);
                }
            }
        }
        return instance;
    }

}
