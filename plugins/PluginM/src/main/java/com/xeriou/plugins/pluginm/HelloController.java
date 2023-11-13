package com.xeriou.plugins.pluginm;

import com.xeriou.api.IGreetService;
import com.xeriou.api.IHelloController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController implements IHelloController {

    @Autowired
    IGreetService greetService;

    @Override
    @GetMapping("/hello")
    public String sayHello() {


        return "This is PluginM. " + greetService.sayHello();
    }
}
