package com.xeriou.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public interface IHelloController {

    @GetMapping("/hello")
    String sayHello();
}
