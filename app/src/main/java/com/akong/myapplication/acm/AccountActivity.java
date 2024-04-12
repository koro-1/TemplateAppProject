package com.akong.myapplication.acm;

import androidx.recyclerview.widget.ItemTouchHelper;

import com.akong.acmanager.acm.AbstractAccountActivity;
import com.akong.myapplication.MainActivity;
import com.akong.myapplication.ui.login.LoginActivity;


public class AccountActivity extends AbstractAccountActivity<ACManager,AccountAdapter> {


    @Override
    protected ACManager initManger() {
        ACManager instance = ACManager.getInstance(this);
        return instance;
    }

    @Override
    protected AccountAdapter initAdapter() {
        AccountAdapter adapter = new AccountAdapter(0,instance);
        return adapter;
    }

    @Override
    protected void setTargetActivity() {
        super.Main= MainActivity.class;
        super.Register= LoginActivity.class;
        super.Login= LoginActivity.class;
    }
    @Override
    protected ItemTouchHelper.Callback initTouchHelperCallback() {
        ItemTouchHelper.Callback callback = new AccountTouchHelperCallback(adapter);
        return callback;
    }

}