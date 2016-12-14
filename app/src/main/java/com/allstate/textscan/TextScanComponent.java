package com.allstate.textscan;


import javax.inject.Singleton;

import dagger.Component;
import retrofit2.Retrofit;

@Singleton
@Component(modules = TextScanModule.class)
public interface TextScanComponent {
    void inject(SmsReceiver smsReceiver);

    void inject(TextScanViewModel textScanViewModel);

    Retrofit retrofit();
    BlacklistApiClient blacklistApiClient();
}
