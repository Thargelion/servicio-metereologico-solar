package app.dia;

import api.types.TypesEnum;
import app.enums.DatabaseEnum;
import app.enums.TypesConverterEnum;
import com.google.gson.Gson;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class DiaDao {
    MongoDatabase mongoDatabase = DatabaseEnum.instance.mongoDatabase();
    MongoCollection<Dia> mongoCollection;

    public DiaDao() {
        mongoCollection = mongoDatabase.getCollection("dias", Dia.class);
    }

    public void create(Dia dia) {
        mongoCollection.insertOne(dia);
    }
}
