package com.allstate.textscan;


import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TextScanViewModel {

    private BlacklistApiClient blacklistApiClient;
    private Listener listener;

    @Inject TextScanViewModel(BlacklistApiClient blacklistApiClient) {
        this.blacklistApiClient = blacklistApiClient;
    }

    void register(Listener listener) {
        this.listener = listener;
    }

    void authorizePhoneNumber(String phoneNumber) {
        blacklistApiClient.getNumberAuthorization(phoneNumber).enqueue(new Callback<PhoneNumberAuthorization>() {
            @Override
            public void onResponse(Call<PhoneNumberAuthorization> call, Response<PhoneNumberAuthorization> response) {
                System.out.println(response.body().message);
                listener.phoneAuthorizationComplete(response.body().message);
            }

            @Override
            public void onFailure(Call<PhoneNumberAuthorization> call, Throwable t) {
                System.out.println(t.getMessage());
            }
        });
    }

    interface Listener {
        void phoneAuthorizationComplete(String message);
    }
}
