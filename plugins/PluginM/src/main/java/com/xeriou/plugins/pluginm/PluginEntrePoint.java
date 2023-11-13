package com.xeriou.plugins.pluginm;

import org.laxture.sbp.SpringBootPlugin;
import org.laxture.sbp.spring.boot.SpringBootstrap;
import org.pf4j.PluginWrapper;

public class PluginEntrePoint extends SpringBootPlugin {
    public static PluginEntrePoint INSTANCE;

    public PluginEntrePoint(PluginWrapper wrapper) {
        super(wrapper);
        INSTANCE = this;
    }

    @Override
    protected SpringBootstrap createSpringBootstrap() {
        return new SpringBootstrap(this, PluginMApplication.class);
    }

}
