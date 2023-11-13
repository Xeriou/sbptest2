package com.xeriou.plugins.pluginx;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PluginXPageController {
    @GetMapping("/pluginx")
    public String index() {
        return "pluginx";
    }
}
