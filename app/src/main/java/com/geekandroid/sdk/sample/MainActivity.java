package com.geekandroid.sdk.sample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import com.jakewharton.rxbinding.view.RxView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //权限框架
        bindClick(R.id.rxpermissions,new RxPermissionsSampleFragment());
        //
        bindClick(R.id.common_net,new CommonSampleFragment());



    }




  public void jumpIntent(Fragment fragment){
      ContentActivity.showFragment = fragment;
      Intent intent = new Intent(this,ContentActivity.class);
      startActivity(intent);
  }

    public void bindClick(int resId,Fragment fragment){
        RxView.clicks(findViewById(resId)).subscribe(v->{
            jumpIntent(fragment);
        });
    }
}
