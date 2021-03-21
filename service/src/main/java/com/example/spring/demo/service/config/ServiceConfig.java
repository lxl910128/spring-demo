package com.example.spring.demo.service.config;

import com.example.spring.demo.base.Plugin;
import com.example.spring.demo.service.PluginChain;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author Phoenix Luo
 * @version 2021/3/21
 **/
@Configuration
public class ServiceConfig {
    
    @Bean
    public PluginChain pluginChain(final ObjectProvider<List<Plugin>> plugins) {
        // 从容器中拿所有插件，构建 执行链 PluginChain
        List<Plugin> pluginList = plugins.getIfAvailable(Collections::emptyList);
        Map<String, Plugin> pluginMap = pluginList.stream().collect(Collectors.toMap(Plugin::getName, Function.identity()));
        return new PluginChain(pluginMap);
    }
}
