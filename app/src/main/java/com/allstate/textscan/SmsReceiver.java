package com.allstate.textscan;


import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.provider.Telephony;
import android.telephony.SmsMessage;
import android.telephony.TelephonyManager;
import android.widget.Toast;

import javax.inject.Inject;

public class SmsReceiver extends BroadcastReceiver{

    @Inject BlacklistApiClient blacklistApiClient;

    @Override
    public void onReceive(Context context, Intent intent) {
        Injector.getInjector().inject(this);

        if(intent.getAction().equals(Telephony.Sms.Intents.SMS_RECEIVED_ACTION)) {
            for (SmsMessage smsMessage : Telephony.Sms.Intents.getMessagesFromIntent(intent)) {
                String sender = smsMessage.getDisplayOriginatingAddress();
                String messageBody = smsMessage.getMessageBody();

                Toast toast = Toast.makeText(context, sender, Toast.LENGTH_LONG);
                toast.show();

                blacklistApiClient.getNumberAuthorization(sender);
            }
        }
    }
}
