package com.allstate.textscan;


import android.hardware.camera2.params.BlackLevelPattern;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class TextScanModule {

    @Provides static Retrofit provideRetrofit() {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BASIC);

        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build();

        return new Retrofit.Builder()
                .baseUrl("http://10.0.2.2:8080/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();
    }

    @Provides static BlacklistApiClient provideBlacklistApiClient(Retrofit retrofit) {
        return retrofit.create(BlacklistApiClient.class);
    }

    @Provides static TextScanViewModel provideTextScanViewModel() {
        return new TextScanViewModel();
    }
}
