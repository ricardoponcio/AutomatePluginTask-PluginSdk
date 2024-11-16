package dev.poncio.AutomatePluginTask.PluginSdk.v1.domain;

import dev.poncio.AutomatePluginTask.PluginSdk.v1.constants.ParameterTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PluginTaskInputParameter {

    private String name;
    private ParameterTypeEnum type;
    private Object value;

}