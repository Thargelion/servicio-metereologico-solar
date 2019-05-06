package app.clima;

import app.enums.DatabaseEnum;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.ReplaceOptions;
import lib.mongo.ReplaceOptionsEnum;
import org.bson.conversions.Bson;

import static com.mongodb.client.model.Filters.eq;


public class ClimaDao {

    MongoDatabase mongoDatabase = DatabaseEnum.instance.mongoDatabase();
    MongoCollection<Clima> mongoCollection;

    public ClimaDao() {
        mongoCollection = mongoDatabase.getCollection("climas", Clima.class);
    }

    Clima read(Integer id) {
        return mongoCollection.find(eq("dia", id)).first();
    }

    void save(Clima clima) {
        Bson filtro = eq("dia", clima.getDia());
        ReplaceOptions replaceOptions = ReplaceOptionsEnum.UPSERT.getReplaceOptions();
        mongoCollection.replaceOne(filtro, clima, replaceOptions);
    }

    void create(Clima clima) {
        mongoCollection.insertOne(clima);
    }
}

