package com.flow.event.cloud.flow.analysis.example;

import com.flow.event.cloud.storage.IgniteEntry;
import org.apache.ignite.Ignite;
import org.apache.ignite.IgniteCache;
import org.apache.ignite.cache.query.annotations.QuerySqlField;
import org.apache.ignite.configuration.CacheConfiguration;
import org.apache.log4j.Logger;

/**
 * @Classname FlowProjectIgniteEntity
 * @Description DDS
 * @Date 2021/9/13 13:56
 * @Created by a9674
 */
public class FlowProject extends IgniteEntry {
    private static Logger log = Logger.getLogger(FlowProject.class.getClass());

    @QuerySqlField(index = true)
    private long id;
    @QuerySqlField
    private String name;
    @QuerySqlField
    private String moduleId;

    private IgniteCache<Long, FlowProject> caches;

    public void registerCache(Ignite ignite, String tableName){
        CacheConfiguration<Long, FlowProject> cacheCfg = new CacheConfiguration<Long, FlowProject>();
        cacheCfg.setName(tableName);
        cacheCfg.setIndexedTypes(Long.class, FlowProject.class);
        IgniteCache<Long, FlowProject> cache = ignite.getOrCreateCache(cacheCfg);
        if(cache ==null){
            this.caches = cache;
            log.info("注册成功的cache是FlowProject");
        }
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModuleId() {
        return moduleId;
    }

    public void setModuleId(String moduleId) {
        this.moduleId = moduleId;
    }
}
