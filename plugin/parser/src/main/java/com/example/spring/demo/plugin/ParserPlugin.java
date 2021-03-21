package com.example.spring.demo.plugin;

import com.example.spring.demo.base.Plugin;
import com.example.spring.demo.base.PluginEnum;

import java.util.Map;

/**
 * @author Phoenix Luo
 * @version 2021/3/21
 **/
public class ParserPlugin implements Plugin {
    @Override
    public String execute(String data, Map<String, String> configMap) {
        StringBuffer ret = new StringBuffer(data)
                .append("=>")
                .append("执行Parser插件;")
                .append("配置：");
        configMap.forEach((x, y) -> {
            ret.append(x).append("->").append(y);
        });
        return ret.toString();
    }
    
    @Override
    public boolean checkConfig(Map<String, String> configMap) {
        return !configMap.isEmpty();
    }
    
    @Override
    public String getName() {
        return PluginEnum.PARSER.name();
    }
}
