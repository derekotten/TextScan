package com.allstate.textscan;


import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.provider.Telephony;
import android.telephony.SmsMessage;
import android.widget.Toast;

import java.io.IOException;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SmsReceiver extends BroadcastReceiver{

    @Inject BlacklistApiClient blacklistApiClient;
    @Inject TextScanViewModel textScanViewModel;

    @Override
    public void onReceive(Context context, Intent intent) {
        Injector.getInjector().inject(this);

        if(intent.getAction().equals(Telephony.Sms.Intents.SMS_RECEIVED_ACTION)) {
            for (SmsMessage smsMessage : Telephony.Sms.Intents.getMessagesFromIntent(intent)) {
                String sender = smsMessage.getDisplayOriginatingAddress();
                String messageBody = smsMessage.getMessageBody();

                textScanViewModel.authorizePhoneNumber(sender);
            }
        }
    }
}
