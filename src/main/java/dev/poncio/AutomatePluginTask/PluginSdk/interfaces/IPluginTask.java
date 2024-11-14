package dev.poncio.AutomatePluginTask.PluginSdk.interfaces;

import dev.poncio.AutomatePluginTask.PluginSdk.domain.PluginTaskInputParameter;
import dev.poncio.AutomatePluginTask.PluginSdk.domain.PluginTaskInputParameterPrototype;
import dev.poncio.AutomatePluginTask.PluginSdk.domain.PluginTaskOutput;
import dev.poncio.AutomatePluginTask.PluginSdk.domain.PluginTaskProgress;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.function.Consumer;

public interface IPluginTask {

    String getPluginName();

    String getPluginDescription();

    List<PluginTaskInputParameterPrototype> getInputParametersPrototype();

    default Callable<PluginTaskOutput> runAsync(List<PluginTaskInputParameter> inputParameters) {
        return new Callable<PluginTaskOutput>() {
            @Override
            public PluginTaskOutput call() throws Exception {
                return run(inputParameters);
            }
        };
    }

    default Callable<PluginTaskOutput> runAsync(List<PluginTaskInputParameter> inputParameters, Consumer<PluginTaskProgress> progressConsumer) {
        return runAsync(inputParameters);
    }

    PluginTaskOutput run(List<PluginTaskInputParameter> inputParameters);

}
