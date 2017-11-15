package com.example.ixzus.ainject;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.ixzus.ainject.compoent.ApiServer;
import com.example.ixzus.ainject.compoent.UserManager;
import com.example.ixzus.ainject.compoent.inject.DaggerUserCompoent;
import com.example.ixzus.ainject.compoent.inject.UserModule;

import javax.inject.Inject;
import javax.inject.Named;

public class MainActivity extends AppCompatActivity {

//    @Named("TypeA")
//    @Inject
//    UserManager userManagerA;
//
//    @Named("TypeB")
//    @Inject
//    UserManager userManagerB;
//
//    @Named("TypeAll")
//    @Inject
//    UserManager userManagerAll;

    @Inject
    UserManager userManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        DaggerUserCompoent.create().inject(this);

//        DaggerUserCompoent.builder().userModule(new UserModule(this))
//                .build()
//                .inject(this);
//
//        userManagerA.registerA();
//        userManagerB.registerB();
//        userManagerAll.registerAll();
        DaggerUserCompoent.create().inject(this);
        userManager.registerAll();

    }
}
