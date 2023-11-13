package com.xeriou.plugins.pluginm;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

@RestController
@RequestMapping(value = "/custom")
public class PluginMController {

    @RequestMapping(value = "/name")
    public String name() {
        return "custom, I am PluginM.";
    }
}
