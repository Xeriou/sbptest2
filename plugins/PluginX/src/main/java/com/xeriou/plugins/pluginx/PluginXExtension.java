package com.xeriou.plugins.pluginx;

import org.pf4j.Extension;
import org.pf4j.ExtensionPoint;
import org.pf4j.PluginWrapper;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@Extension
public class PluginXExtension implements ExtensionPoint {
    public List<URL> resources() {
        List<URL> resources = new ArrayList<>();
        try {
            PluginWrapper wrapper = PluginEntrePoint.INSTANCE.getWrapper();
            URL images = wrapper.getPluginClassLoader().getResource("public/templates");
            for (String file : new File(images.getPath()).list()) {
                URL resource = new File(images.getPath().concat(File.separator + file)).toURI().toURL();
                System.out.println("Add Resource ? " + resource);
                resources.add(resource);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return resources;
    }
}
