package com.allstate.textscan;


import android.app.Application;

public class TextScanApplication  extends Application{

    @Override
    public void onCreate() {
        super.onCreate();

        TextScanComponent mComponent = DaggerTextScanComponent.builder()
                .textScanModule(new TextScanModule())
                .build();
        Injector.setComponent(mComponent);
    }
}
