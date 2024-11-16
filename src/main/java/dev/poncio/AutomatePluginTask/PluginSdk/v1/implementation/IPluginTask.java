package dev.poncio.AutomatePluginTask.PluginSdk.v1.implementation;

import dev.poncio.AutomatePluginTask.PluginSdk.v1.constants.PluginExecutionPlanEnum;
import dev.poncio.AutomatePluginTask.PluginSdk.v1.domain.*;
import dev.poncio.AutomatePluginTask.PluginSdk.v1.exceptions.GenericExecutionException;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.function.Consumer;

interface IPluginTask {

    String getPluginName();

    String getPluginDescription();

    List<PluginExecutionPlanEnum> getAvailableExecutionPlans();

    List<PluginTaskInputParameterPrototype> getInputParametersPrototype();

    List<PluginTaskBaseParameterPrototype> getBaseParametersPrototype();

    String getPluginSdkVersion();

    default Callable<PluginTaskOutput> runAsync(List<PluginTaskBaseParameter> baseInputParameters, List<PluginTaskInputParameter> inputParameters) {
        throw new GenericExecutionException("Method not implemented");
    }

    default Callable<PluginTaskOutput> runAsync(List<PluginTaskBaseParameter> baseInputParameters, List<PluginTaskInputParameter> inputParameters, Consumer<PluginTaskProgress> progressConsumer) {
        throw new GenericExecutionException("Method not implemented");
    }

    default PluginTaskOutput run(List<PluginTaskBaseParameter> baseInputParameters, List<PluginTaskInputParameter> inputParameters) {
        throw new GenericExecutionException("Method not implemented");
    }

}
