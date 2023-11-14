package com.xeriou.robotapp;

import com.xeriou.api.LoadPageExtension;
import org.pf4j.PluginManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

import javax.annotation.PostConstruct;
import java.io.File;
import java.net.URL;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

@ConditionalOnProperty(name = "spring.sbp.enabled", havingValue = "true")
@Configuration
public class P4JHook {

    @Lazy
    @Autowired
    private PluginManager pluginManager;

    @PostConstruct
    public void init() {
        pluginManager.getPluginsRoots().forEach(p -> {
            System.out.println("Plugin root: " + p.toAbsolutePath());
        });
    }


}
