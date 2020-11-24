package com.ychen9.demo;


import android.util.Log;

import com.huawei.hms.push.HmsMessageService;

public class HmsPushService extends HmsMessageService {

    private static final String TAG = "pushdemo";
    @Override
    public void onNewToken(String token) {
        super.onNewToken(token);
        Log.i(TAG, "receive token:" + token);

    }


}
