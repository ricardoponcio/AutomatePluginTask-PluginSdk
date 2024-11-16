package dev.poncio.AutomatePluginTask.PluginSdk.v1.exceptions;

public class UnknownSdkVersionException extends RuntimeException {

    public UnknownSdkVersionException() {
        super("Was not possible retrieve PluginSDK version");
    }

}
