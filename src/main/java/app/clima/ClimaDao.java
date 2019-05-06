package app.clima;

import api.types.TypesEnum;
import app.enums.DatabaseEnum;
import app.enums.TypesConverterEnum;
import com.google.gson.Gson;
import com.mongodb.BasicDBObject;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.ReplaceOptions;
import lib.mongo.ReplaceOptionsEnum;
import lib.redis.RedisConnect;
import org.bson.BsonDocument;
import org.bson.conversions.Bson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.Jedis;

import java.util.ArrayList;
import java.util.List;

import static com.mongodb.client.model.Filters.eq;


public class ClimaDao {

    MongoDatabase mongoDatabase = DatabaseEnum.instance.mongoDatabase();
    Jedis jedis = DatabaseEnum.instance.jedisDatabase();
    MongoCollection<Clima> mongoCollection;
    Logger logger = LoggerFactory.getLogger(ClimaDao.class);
    RedisConnect redisConnect = DatabaseEnum.instance.redisConnect();

    public ClimaDao() {
        mongoCollection = mongoDatabase.getCollection("climas", Clima.class);
    }

    Clima read(Integer id) {
        return mongoCollection.find(eq("dia", id)).first();
    }

    public FindIterable<Clima> filter(Bson filtro) {
        return mongoCollection.find(filtro);
    }

    public Clima max() {
        return mongoCollection.find(eq("clima", "lluvia")).sort(new BasicDBObject("intensidad", -1)).first();
    }

    public Iterable<Clima> filter() {
        return mongoCollection.find();
    }

    void cache(Clima clima) {
        Gson gson = TypesConverterEnum.instance.getGson();
        jedis.lpush("climas", gson.toJson(clima));
    }

    void deleteCache() {
        jedis.del("climas");
    }

    void storeCache() {
        long size = jedis.llen("climas");
        int begin = 0;
        int end = 9;
        int step = 10;
        do {
            logger.info(String.format("Empieza: %s", begin));
            logger.info(String.format("Termina: %s", end));
            saveRangeCache(jedis.lrange("climas", begin, end));
            begin = end;
            end = end + step;
        } while (end < size);
        logger.info("Cache almacenado !");
    }

    void saveRangeCache(List<String> climaCache) {
        Gson gson = TypesConverterEnum.instance.getGson();
        List<Clima> climas = new ArrayList<>();
        for (String clima: climaCache) {
            logger.info(String.format("Clima %s", clima));
            climas.add(gson.fromJson(clima, Clima.class));
        }
        mongoCollection.insertMany(climas);
    }

    void save(Clima clima) {
        Bson filtro = eq("dia", clima.getDia());
        ReplaceOptions replaceOptions = ReplaceOptionsEnum.UPSERT.getReplaceOptions();
        mongoCollection.replaceOne(filtro, clima, replaceOptions);
    }

    MongoCollection<Clima> all() {
        return mongoCollection;
    }

    void create(Clima clima) {
        mongoCollection.insertOne(clima);
    }
}

