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
public class PluginTaskInputParameterPrototype {

    private String name;
    private String description;
    private boolean secret;
    private boolean required;
    private ParameterTypeEnum type;

}
