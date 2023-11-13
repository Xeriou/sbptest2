package com.xeriou.plugins.pluginm;

import com.xeriou.api.IGreetService;
import org.springframework.stereotype.Service;


@Service
public class GreetingService implements IGreetService {
    @Override
    public String sayHello() {
        return "Hello from PluginM";
    }
}
