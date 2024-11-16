package dev.poncio.AutomatePluginTask.PluginSdk.v1.utils;

import dev.poncio.AutomatePluginTask.PluginSdk.v1.exceptions.UnknownSdkVersionException;
import org.apache.maven.model.Model;
import org.apache.maven.model.io.xpp3.MavenXpp3Reader;
import org.codehaus.plexus.util.xml.pull.XmlPullParserException;

import java.io.FileReader;
import java.io.IOException;

public class PluginSdkInformation {

    public static String getPluginSdkVersion() {
        try {
            MavenXpp3Reader reader = new MavenXpp3Reader();
            Model model = reader.read(new FileReader("pom.xml"));
            return model.getVersion();
        } catch (XmlPullParserException | IOException e) {
            throw new UnknownSdkVersionException();
        }
    }

}
