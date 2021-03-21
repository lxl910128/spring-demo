package com.example.spring.demo.base;

import lombok.Data;

import java.util.List;

/**
 * @author Phoenix Luo
 * @version 2021/3/21
 **/
@Data
public class RequestVO {
    private String data;
    private List<PluginConfig> configList;
}
