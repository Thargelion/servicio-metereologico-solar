package app.enums;

import app.config.SettingsEnum;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoDatabase;
import lib.mongo.MongoConnect;
import lib.redis.RedisConnect;
import redis.clients.jedis.Jedis;

public enum DatabaseEnum {
    instance;
    DatabaseEnum() {
    }
    public MongoDatabase mongoDatabase(){
        MongoConnect mongoConnect = new MongoConnect();
        MongoClient mongoClient = mongoConnect.getMongoClient();
        return mongoClient.getDatabase(SettingsEnum.MONGO_DATABASE.variable);
    }
    public Jedis jedisDatabase() {
        return new Jedis("localhost", 6380);
    }

    public RedisConnect redisConnect() {
        return new RedisConnect();
    }
}
