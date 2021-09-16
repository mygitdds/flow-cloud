package com.flow.event.cloud.storage;
import org.apache.ignite.Ignite;

/**
 * 所有操作数据库的父类
 */
public class IgniteEntry {
    private String key;

    public void registerCache(Ignite ignite, String name){
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
