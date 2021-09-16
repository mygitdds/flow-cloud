package com.flow.event.cloud.ignite;

import com.flow.event.cloud.flow.analysis.example.FlowProject;
import com.flow.event.cloud.storage.IgniteEntry;

import java.util.ArrayList;
import java.util.List;

/**
 * 配置关于ignite相关的表
 */
public enum IgniteTableConf {
    GOODS("goods",new FlowProject(),"test");
    private String tableName;
    //对象
    private IgniteEntry entry;
    //table解释
    private String tableMsg;



    IgniteTableConf(String tableName, IgniteEntry entry, String tableMsg) {
        this.tableName = tableName;
        this.entry = entry;
        this.tableMsg = tableMsg;
    }

    //获取所有的表对象
    public static List<IgniteEntry> getObject(){
        IgniteTableConf[] igniteTableConfs = IgniteTableConf.values();
        List<IgniteEntry> igniteEntryList = new ArrayList<>(igniteTableConfs.length);
        for(IgniteTableConf conf :igniteTableConfs){
            igniteEntryList.add(conf.entry);
        }
        return igniteEntryList;
    }

    public String getTableName() {
        return tableName;
    }

    public IgniteEntry getEntry() {
        return entry;
    }

    public String getTableMsg() {
        return tableMsg;
    }
}
