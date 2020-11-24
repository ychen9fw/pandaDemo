package com.ychen9.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.app.NotificationManager;
import android.os.Bundle;
import android.util.Log;

import com.clevertap.android.sdk.CleverTapAPI;
import com.huawei.hms.aaid.HmsInstanceId;
import com.huawei.hms.common.ApiException;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    public String token;

    CleverTapAPI cleverTapAPI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cleverTapAPI = CleverTapAPI.getDefaultInstance(getApplicationContext());
        addPushProfile();
        CleverTapAPI.createNotificationChannel(getApplicationContext(),"huawei","huawei",
                "Test Huawei Channel Description", NotificationManager.IMPORTANCE_MAX,true);
        cleverTapAPI.pushEvent("EthanChen's Huawei Event");
        HashMap<String, Object> profileUpdate = new HashMap<String, Object>();
        profileUpdate.put("MSG-push", true);
        profileUpdate.put("Email", "ethancehnyujunijoasd@126.com");
        profileUpdate.put("Identity", 123456789);
        profileUpdate.put("Name", "EthanCCChen");
        cleverTapAPI.pushProfile(profileUpdate);
        getHmsToken();

    }


    public void getHmsToken() {
        new Thread(){
            @Override
            public void run() {
                String appId = "102409109";
                try {
                    token = HmsInstanceId.getInstance(MainActivity.this).getToken(appId, "HCM");
                    Log.i("pushdemo","get hms token : "+token);
                    CleverTapAPI.getDefaultInstance(getApplicationContext()).pushHuaweiRegistrationId(token,true);
                    Log.i("pushdemo", "pushHuawei registration ID");
                } catch (ApiException e) {
                    e.printStackTrace();
                    Log.i("pushdemo","get error : " + e);
                }
            }
        }.start();
    }



    public void addPushProfile() {
        HashMap<String, Object> profileUpdate = new HashMap<String, Object>();
//Update pre-defined profile properties
        profileUpdate.put("Name", "Ethan chen");
        profileUpdate.put("Email", "ethanchen@gmail.com");
//Update custom profile properties
        profileUpdate.put("age", "22222");
        profileUpdate.put("Favorite Food", "baozi");

        cleverTapAPI.pushProfile(profileUpdate);

    }

}
