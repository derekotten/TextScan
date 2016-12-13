package com.allstate.textscan;


public enum Injector {

    INSTANCE;

    private static TextScanComponent component;

    public static void setComponent(TextScanComponent component) {
        Injector.component = component;
    }

    public static TextScanComponent getInjector() {
        return component;
    }

    public static void clearComponent() {
        component = null;
    }
}
