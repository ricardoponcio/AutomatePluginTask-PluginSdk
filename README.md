# PluginSDK
## An Automate Plugin Task module

### Implementations

#### AbstractPluginTask

Main abstract class that will be used by the engine to run the plugin.  
Must be extended by the main class in the plugin with the right returns.

The required methods are:

1. *String getPluginName()*  
The name of the plugin
2. *String getPluginDescription()*  
A short description of the plugin
3. *List<PluginExecutionPlanEnum> getAvailableExecutionPlans()*  
The list of available execution plans (SYNC, ASYNC or ASYNC WITH PROGRESS)
4. *List<PluginTaskInputParameterPrototype> getInputParametersPrototype()*  
The list of the parameters prototype required to run the plugin execution
5. *List<PluginTaskBaseParameterPrototype> getBaseParametersPrototype()*  
The list of the base parameters prototype required to run the plugin execution

The optional methods are:

6. *PluginTaskOutput run(List<PluginTaskBaseParameterPrototype> baseParameters, List<PluginTaskInputParameter> inputParameters)*  
   The main sync plugin execution that will receive the input/base parameters and return a detailed output after process the data
1. *Callable<PluginTaskOutput> runAsync(List<PluginTaskBaseParameterPrototype> baseParameters, List<PluginTaskInputParameter> inputParameters)*  
Asynchronous method to be executed by the engine, with the input/base parameters. It should also return a detailed output.
2. *Callable<PluginTaskOutput> runAsync(List<PluginTaskBaseParameterPrototype> baseParameters, List<PluginTaskInputParameter> inputParameters, Consumer<PluginTaskProgress> progressConsumer)*
Same as previous, but there is a consumer to process de partial update and improve user experience

### Domain

#### PluginTaskInputParameterPrototype

The prototype of the parameter needed to the plugin execution. Needs to be filled with:
1. String *name*    
Name of parameter, will be used to identify the parameter, must be unique
2. String *description*    
Parameter description, that will be displayed in the web page
3. boolean *secret*  
If secret, the value of an execution will be not stored in database
4. boolean *required*    
If the value must be required at execution time
5. ParameterTypeEnum *type*    
Pre defined parameter type

#### PluginTaskBaseParameterPrototype

The prototype of the base parameter needed to the plugin execution. Needs to be filled with:
1. String *name*  
   Name of parameter, will be used to identify the parameter, must be unique
2. String *description*  
   Parameter description, that will be displayed in the web page
3. boolean *secret*  
   If secret, the value of an execution will be not stored in database
4. boolean *required*    
      If the value must be required at execution time
5. ParameterTypeEnum *type*    
   Pre defined parameter type

#### PluginTaskInputParameter

The parameter itself passed to the plugin execution. Needs to be filled with:
1. String *name*  
Name of parameter, will be used to identify the parameter, must be unique
2. ParameterTypeEnum *type*  
Pre defined parameter type
3. Object *value*  
The value of parameter

#### PluginTaskBaseParameter

The base parameter configured previously to be sent on every invoke. Needs to be filled with:
1. String *name*  
   Name of parameter, will be used to identify the parameter, must be unique
2. ParameterTypeEnum *type*  
   Pre defined parameter type
3. Object *value*  
   The value of parameter

#### PluginTaskOutput

The result of an execution returned by plugin execution. Needs to be filled with:
1. boolean *success*  
Boolean that indicate the success of operation
2. Integer *code*  
Numeric code of execution result
3. String *message*  
The final message of execution
4. List<String> *executionLogs*  
List of messages to be persisted, it will help the user to understand better the execution process

#### PluginTaskProgress

The progress used as partial update of an execution. Needs to be filled with:
1. Double *progress*  
Only showed in the interface, to help user understand better the progress
2. String *executionLog*  
It will be logged in the database to post analysis

### Constants

#### ParameterTypeEnum

The possible type of the parameters. At the moment the options are:
1. *STRING*  
Textual values
2. *INTEGER*  
Numeric values

#### PluginExecutionPlanEnum

The possible type of the executions plans available. At the moment the options are:
1. *SYNC*  
Sync call
2. *ASYNC*  
Async call
3. *ASYNC_WITH_PROGRESS*  
Async with progress callback


## The plugin creation

Create a base maven project, and add the dependency in the pom file:
```xml

<dependencies>
    <dependency>
        <groupId>dev.poncio.AutomatePluginTask</groupId>
        <artifactId>PluginSdk</artifactId>
    </dependency>
</dependencies>
```

Then, it should be created a main class that extends the `AbstractPluginTask` abstract class.  
After it remember to declare the maven jar plugin passing the package and name of the main class:

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
                        <mainClass>package.MainClass</mainClass>
                    </manifest>
                </archive>
            </configuration>
        </plugin>
    </plugins>
</build>
```

Use the maven to build the JAR file to be loaded by the Plugin Engine.
