package dev.poncio.AutomatePluginTask.PluginSdk.domain;

import dev.poncio.AutomatePluginTask.PluginSdk.constants.ParameterTypeEnum;
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
    private ParameterTypeEnum type;

}
