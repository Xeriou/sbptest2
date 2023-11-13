package com.xeriou.plugins.pluginx;

import com.xeriou.api.IGreetService;
import org.springframework.stereotype.Service;


@Service
public class GreetingService implements IGreetService {
    @Override
    public String sayHello() {
        return "來自 PluginX 的訊息~";
    }
}
