# PluginSDK

## Overview

PluginSDK provides the base abstractions and domain model for building plugins compatible with the Automate Plugin Task Engine. It enables developers to create plugins that can be dynamically loaded, executed synchronously or asynchronously, and report progress and results.

---

## Features

- Abstract base class for plugin implementation
- Strongly-typed domain model for parameters, execution plans, and outputs
- Support for synchronous and asynchronous plugin execution
- Progress reporting for long-running tasks
- Maven-based build and dependency management

---

## Implementing a Plugin

### 1. Extend `AbstractPluginTask`

Create your plugin by extending [`dev.poncio.AutomatePluginTask.PluginSdk.v1.implementation.AbstractPluginTask`](src/main/java/dev/poncio/AutomatePluginTask/PluginSdk/v1/implementation/AbstractPluginTask.java).

#### Required methods

1. `String getPluginName()`  
   The name of the plugin.
2. `String getPluginDescription()`  
   A short description of the plugin.
3. `List<PluginExecutionPlanEnum> getAvailableExecutionPlans()`  
   Supported execution plans (`SYNC`, `ASYNC`, or `ASYNC_WITH_PROGRESS`).
4. `List<PluginTaskInputParameterPrototype> getInputParametersPrototype()`  
   Input parameter definitions.
5. `List<PluginTaskBaseParameterPrototype> getBaseParametersPrototype()`  
   Base parameter definitions.

#### Optional methods

6. `PluginTaskOutput run(List<PluginTaskBaseParameterPrototype> baseParameters, List<PluginTaskInputParameter> inputParameters)`  
   Synchronous execution.
7. `Callable<PluginTaskOutput> runAsync(List<PluginTaskBaseParameterPrototype> baseParameters, List<PluginTaskInputParameter> inputParameters)`  
   Asynchronous execution.
8. `Callable<PluginTaskOutput> runAsync(List<PluginTaskBaseParameterPrototype> baseParameters, List<PluginTaskInputParameter> inputParameters, Consumer<PluginTaskProgress> progressConsumer)`  
   Asynchronous execution with progress updates.

---

## Domain Model

- [`PluginTaskInputParameterPrototype`](src/main/java/dev/poncio/AutomatePluginTask/PluginSdk/v1/domain/PluginTaskInputParameterPrototype.java): Defines input parameter metadata.
- [`PluginTaskBaseParameterPrototype`](src/main/java/dev/poncio/AutomatePluginTask/PluginSdk/v1/domain/PluginTaskBaseParameterPrototype.java): Defines base parameter metadata.
- [`PluginTaskInputParameter`](src/main/java/dev/poncio/AutomatePluginTask/PluginSdk/v1/domain/PluginTaskInputParameter.java): Actual input parameter for execution.
- [`PluginTaskBaseParameter`](src/main/java/dev/poncio/AutomatePluginTask/PluginSdk/v1/domain/PluginTaskBaseParameter.java): Actual base parameter for execution.
- [`PluginTaskOutput`](src/main/java/dev/poncio/AutomatePluginTask/PluginSdk/v1/domain/PluginTaskOutput.java): Result of plugin execution.
- [`PluginTaskProgress`](src/main/java/dev/poncio/AutomatePluginTask/PluginSdk/v1/domain/PluginTaskProgress.java): Progress update for async execution.

---

## Constants

- [`ParameterTypeEnum`](src/main/java/dev/poncio/AutomatePluginTask/PluginSdk/v1/constants/ParameterTypeEnum.java):  
  - `STRING` - Textual values  
  - `INTEGER` - Numeric values

- [`PluginExecutionPlanEnum`](src/main/java/dev/poncio/AutomatePluginTask/PluginSdk/v1/constants/PluginExecutionPlanEnum.java):  
  - `SYNC` - Synchronous execution  
  - `ASYNC` - Asynchronous execution  
  - `ASYNC_WITH_PROGRESS` - Asynchronous with progress callback

---

## How to Create a Plugin

1. **Create a Maven project** and add the dependency:

    ```xml
    <dependency>
        <groupId>dev.poncio.AutomatePluginTask</groupId>
        <artifactId>PluginSdk</artifactId>
    </dependency>
    ```

2. **Implement your plugin** by extending `AbstractPluginTask` and implementing the required methods.

3. **Configure the Maven JAR plugin** to set your main class:

    ```xml
    <build>
        <plugins>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-jar-plugin</artifactId>
                <version>3.2.0</version>
                <configuration>
                    <archive>
                        <manifest>
                            <mainClass>your.package.YourPluginMainClass</mainClass>
                        </manifest>
                    </archive>
                </configuration>
            </plugin>
        </plugins>
    </build>
    ```

4. **Build your plugin JAR** with Maven. The resulting JAR can be loaded by the Plugin Engine.

---

## Example

See [SampleHelloPlugin/README.md](https://github.com/ricardoponcio/AutomatePluginTask-SampleHelloPlugin) for a working example.  
See [Main Repository](https://github.com/ricardoponcio/AutomatePluginTask)

---

## License

MIT

---

## Contact

For questions, contact:  
E-mail: **ricardo@poncio.dev**  
Telegram: **@rponcio**
