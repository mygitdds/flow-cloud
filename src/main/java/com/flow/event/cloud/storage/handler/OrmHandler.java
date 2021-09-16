package com.flow.event.cloud.storage.handler;
import com.flow.event.cloud.storage.SqlOperation;
import io.vertx.core.Vertx;
import io.vertx.ext.web.Router;

/**
 * 开放出去给其他服务调用进行db操作
 */
public class OrmHandler {
    private Router router;
    private Vertx vertx;
    private SqlOperation sqlOperation;

    public void init(Router router, Vertx vertx, SqlOperation sqlOperation) {
        this.router = router;
        this.vertx = vertx;
        this.sqlOperation = sqlOperation;
        this.update();
        this.select();
    }

    public void update() {

    }

    public void select() {

    }
}
