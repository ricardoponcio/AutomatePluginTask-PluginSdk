package dev.poncio.AutomatePluginTask.PluginSdk.v1.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PluginTaskOutput {

    private boolean success;
    private Integer code;
    private String message;
    private List<String> executionLogs;

}
