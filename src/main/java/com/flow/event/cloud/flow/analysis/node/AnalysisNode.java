package com.flow.event.cloud.flow.analysis.node;
import com.flow.event.cloud.flow.analysis.example.FlowProject;
import com.flow.event.cloud.storage.IgniteEntry;
import org.apache.ignite.Ignite;
import org.apache.ignite.IgniteCache;
import org.apache.ignite.cache.query.annotations.QuerySqlField;
import org.apache.ignite.configuration.CacheConfiguration;
import org.apache.log4j.Logger;

/**
 * @Classname AnalysisNode
 * @Description DDS
 * @Date 2021/9/8 14:07
 * @Created by a9674
 * 解析node
 */
public class AnalysisNode  extends IgniteEntry {
    @QuerySqlField(index = true)
    private long id;
    @QuerySqlField
    private long projectId;
    @QuerySqlField
    private int type;
    @QuerySqlField
    private String eventName;
    @QuerySqlField
    private String left;
    @QuerySqlField
    private String top;
    @QuerySqlField
    private String ico;
    @QuerySqlField
    private String responseData;
    @QuerySqlField
    private String requestData;


    private IgniteCache<Long, FlowProject> caches;

    private static Logger log = Logger.getLogger(AnalysisNode.class.getClass());

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

}
