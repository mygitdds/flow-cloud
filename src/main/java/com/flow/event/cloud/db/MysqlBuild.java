package com.flow.event.cloud.db;
import io.vertx.core.Vertx;
import io.vertx.mysqlclient.MySQLConnectOptions;
import io.vertx.mysqlclient.MySQLPool;
import io.vertx.sqlclient.PoolOptions;

public class MysqlBuild {

    private MySQLPool client;
    private VertxDbConfig vertxDbConfig;
    private Vertx vertx;

    public MysqlBuild(Vertx vertx){
        this.vertx = vertx;
    }

    public void build(){
        MySQLConnectOptions connectOptions = new MySQLConnectOptions()
                .setPort(vertxDbConfig.port)
                .setHost(vertxDbConfig.host)
                .setDatabase(vertxDbConfig.database)
                .setUser(vertxDbConfig.username)
                .setPassword(vertxDbConfig.password);

        PoolOptions poolOptions = new PoolOptions()
                .setMaxSize(5);
        this.client = MySQLPool.pool(this.vertx,connectOptions, poolOptions);
    }

    public MySQLPool getClient(){
        return this.client;
    }
}
