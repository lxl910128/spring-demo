package com.example.spring.demo.service;

import com.example.spring.demo.base.Plugin;
import com.example.spring.demo.base.PluginConfig;
import com.example.spring.demo.base.RequestVO;

import java.util.Map;

/**
 * @author Phoenix Luo
 * @version 2021/3/21
 **/
public class PluginChain {
    private Map<String, Plugin> plugins;
    
    public PluginChain(Map<String, Plugin> plugins) {
        this.plugins = plugins;
    }
    
    public String handler(RequestVO requestVO) {
        String data = requestVO.getData();
        // 根据配置 依次执行插件
        for (PluginConfig pluginConfig : requestVO.getConfigList()) {
            if (plugins.containsKey(pluginConfig.getName())) {
                Plugin plugin = plugins.get(pluginConfig.getName());
                if (plugin.checkConfig(pluginConfig.getConfigMap())) {
                    data = plugin.execute(data, pluginConfig.getConfigMap());
                } else {
                    throw new RuntimeException("插件" + pluginConfig.getName() + "配置错误");
                }
            } else {
                throw new RuntimeException("未找到名为" + pluginConfig.getName() + "的插件");
            }
        }
        return data;
    }
}
