package com.flow.event.cloud.storage;
import io.vertx.core.json.JsonArray;

public class ParamModel {
    public ParamModel(String sql, JsonArray jsonArray, String requestId, String database){
        this.sql = sql;
        this.jsonArray = jsonArray;
        this.requestId = requestId;
        this.database = database;
    }

    private String sql;
    private JsonArray jsonArray;
    private String requestId;
    private String database;

    public String getSql() {
        return sql;
    }

    public void setSql(String sql) {
        this.sql = sql;
    }

    public JsonArray getJsonArray() {
        return jsonArray;
    }

    public void setJsonArray(JsonArray jsonArray) {
        this.jsonArray = jsonArray;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getDatabase() {
        return database;
    }

    public void setDatabase(String database) {
        this.database = database;
    }
}
