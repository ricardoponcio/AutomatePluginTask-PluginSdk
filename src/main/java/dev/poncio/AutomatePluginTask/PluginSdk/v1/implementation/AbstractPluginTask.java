package dev.poncio.AutomatePluginTask.PluginSdk.v1.implementation;

import dev.poncio.AutomatePluginTask.PluginSdk.v1.utils.PluginSdkInformation;

public abstract class AbstractPluginTask implements IPluginTask {

    @Override
    public final String getPluginSdkVersion() {
        return PluginSdkInformation.getPluginSdkVersion();
    }

}
