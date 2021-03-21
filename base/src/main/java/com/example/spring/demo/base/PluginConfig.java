package com.example.spring.demo.base;

import lombok.Data;

import java.util.Map;

/**
 * @author Phoenix Luo
 * @version 2021/3/21
 **/
@Data
public class PluginConfig {
    private String name;
    private Map<String, String> configMap;
}
