package com.allstate.textscan;


import javax.inject.Inject;

public class TextScanViewModel {

    @Inject BlacklistApiClient blacklistApiClient;

    TextScanViewModel() {
        Injector.getInjector().inject(this);
    }

    
}
