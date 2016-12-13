package com.allstate.textscan;


import android.hardware.camera2.params.BlackLevelPattern;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class TextScanModule {

    @Provides static Retrofit provideRetrofit() {
        return new Retrofit.Builder()
                .baseUrl("http://localhost:8080")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    @Provides static BlacklistApiClient provideBlacklistApiClient(Retrofit retrofit) {
        return retrofit.create(BlacklistApiClient.class);
    }
}
