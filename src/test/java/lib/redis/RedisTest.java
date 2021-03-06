package lib.redis;

import app.enums.DatabaseEnum;
import org.junit.jupiter.api.Test;
import redis.clients.jedis.Jedis;
import testutils.DbTestBase;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RedisTest extends DbTestBase {
    void redis() {
        Jedis jedis = DatabaseEnum.instance.jedisDatabase();
        jedis.set("test", "Obi Juan Que No Vi");
        String test = jedis.get("test");
        assertEquals("Obi Juan Que No Vi", test);
    }
}
