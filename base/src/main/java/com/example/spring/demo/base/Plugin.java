package com.example.spring.demo.base;

import java.util.Map;

/**
 * @author Phoenix Luo
 * @version 2021/3/21
 **/
public interface Plugin {
    /**
     * 执行插件
     *
     * @param data
     * @param configMap
     * @return
     */
    String execute(String data, Map<String, String> configMap);
    
    /**
     * 配置校验
     *
     * @param configMap
     * @return
     */
    boolean checkConfig(Map<String, String> configMap);
    
    /**
     * 插件名称
     *
     * @return
     */
    String getName();
}
