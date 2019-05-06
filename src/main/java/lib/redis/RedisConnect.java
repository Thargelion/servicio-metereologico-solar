package lib.redis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.Jedis;
import redis.embedded.RedisServer;

import java.io.IOException;

public class RedisConnect {
    Logger logger = LoggerFactory.getLogger(RedisConnect.class);
    RedisServer redisServer;

    public RedisConnect() {
        try {
            this.redisServer = new RedisServer(6380);
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }
    }

    public void startRedis() {
        try {
            redisServer.start();
        } catch (Exception e) {
            logger.error("Error al levantar redis", e);
        }
    }

    public void stopRedis() {
        try {
            redisServer.stop();
        } catch (Exception e) {
            logger.error("Error al levantar redis", e);
        }
    }
}
