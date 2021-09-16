package com.flow.event.cloud.storage;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.ignite.Ignite;
import org.apache.ignite.IgniteCache;
import org.apache.ignite.cache.query.FieldsQueryCursor;
import org.apache.ignite.cache.query.SqlFieldsQuery;
import java.util.List;

/**
 * sql的基本操作增删改查
 */
public class SqlOperation {
    private Ignite ignite;

    public SqlOperation(Ignite ignite) {
        this.ignite = ignite;
    }

    //新增
    public Boolean insertOrUpdateOrDelete(ParamModel model) {
        SqlFieldsQuery query = new SqlFieldsQuery(model.getSql());
        List<Object> param = model.getJsonArray().getList();
        if (!CollectionUtils.isEmpty(param)) {
            query.setArgs(param.toArray());
        }
        System.out.println("来新增了");
        query.setSchema("PUBLIC");
        IgniteCache<Long, IgniteEntry> cache = ignite.cache(model.getDatabase());
        try {
            cache.query(query).getAll();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    //查询
    public JSONObject select(ParamModel model) {
       SqlFieldsQuery query = new SqlFieldsQuery(model.getSql());
        List<Object> param = model.getJsonArray().getList();
        if (!CollectionUtils.isEmpty(param)) {
            query.setArgs(param.toArray());
        }
        IgniteCache<Long, IgniteEntry> cache = ignite.cache(model.getDatabase());
        FieldsQueryCursor<List<?>> cursor = cache.query(query);
        List<List<?>> result = cursor.getAll();

        if (!CollectionUtils.isEmpty(result)) {
            String json = JSON.toJSONString(result);
            System.out.println(json);
            return JSON.parseObject(json);
        }
        return null;
    }

}
