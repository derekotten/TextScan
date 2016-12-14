package com.allstate.textscan;


import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface BlacklistApiClient {

    @GET("/blacklist/{phoneNumber}")
    Call<PhoneNumberAuthorization> getNumberAuthorization(@Path("phoneNumber") String phoneNumber);
}
