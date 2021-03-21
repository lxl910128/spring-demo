package com.example.spring.demo.service.controller;

import com.example.spring.demo.base.RequestVO;
import com.example.spring.demo.service.PluginChain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Phoenix Luo
 * @version 2021/3/21
 **/
@RestController
public class TestController {
    @Autowired
    private PluginChain pluginChain;
    
    @PostMapping("/test")
    public String test(@RequestBody RequestVO request) {
        return pluginChain.handler(request);
    }
}
