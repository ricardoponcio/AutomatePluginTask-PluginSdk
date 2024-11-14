package dev.poncio.AutomatePluginTask.PluginSdk.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PluginTaskProgress {

    private Double progress;
    private String executionLog;

}