package app.clima;

import app.services.CrudService;
import app.enums.DatabaseEnum;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.conversions.Bson;

import static com.mongodb.client.model.Filters.eq;


public class ClimaDao  {

    MongoDatabase mongoDatabase = DatabaseEnum.instance.mongoDatabase();
    MongoCollection<Clima> mongoCollection;

    public ClimaDao(CrudService crudService) {
        mongoCollection = mongoDatabase.getCollection("clima", Clima.class); // parametrizar
    }

    Clima read(Integer id) {
        return new Clima(1, "lluvia");
    }
    void save(Clima clima) {
        Bson filtro = eq("dia", clima.getDia());
        Clima climaOld = mongoCollection.find(filtro).first();
        if (climaOld == null) {
            mongoCollection.insertOne(clima);
        } else {
            mongoCollection.replaceOne(filtro, clima);
        }
    }

}
