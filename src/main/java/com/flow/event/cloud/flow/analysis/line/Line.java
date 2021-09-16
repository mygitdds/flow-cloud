package com.flow.event.cloud.flow.analysis.line;

import org.apache.ignite.cache.query.annotations.QuerySqlField;

/**
 * @Classname Line
 * @Description DDS
 * @Date 2021/9/13 18:22
 * @Created by a9674
 * 连线的实体类--与ignite交互所用
 */
public class Line {
    @QuerySqlField(index = true)
    private long id;
    @QuerySqlField
    private long projectId;
    @QuerySqlField
    private long from;
    @QuerySqlField
    private long start;

}
