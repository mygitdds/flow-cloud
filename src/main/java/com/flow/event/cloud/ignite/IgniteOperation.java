package com.flow.event.cloud.ignite;

import org.apache.ignite.Ignite;
public class IgniteOperation {
    private Ignite ignite;

    public void builder() {
        //判断是否测试环境，测试环境，可以替换
        createCache();

    }

    public Ignite getIgnite() {
        return ignite;
    }

    //初始化能操作的表
    public void createCache() {
        for (IgniteTableConf tableConf : IgniteTableConf.values()) {
            tableConf.getEntry().registerCache(ignite, tableConf.getTableName());
        }
    }

}
