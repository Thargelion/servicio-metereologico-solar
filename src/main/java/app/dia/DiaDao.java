package app.dia;

import api.types.TypesEnum;
import app.enums.DatabaseEnum;
import app.enums.TypesConverterEnum;
import app.planeta.Planeta;
import com.google.gson.Gson;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.bson.conversions.Bson;

import static com.mongodb.client.model.Filters.and;
import static com.mongodb.client.model.Filters.eq;

public class DiaDao {
    MongoDatabase mongoDatabase = DatabaseEnum.instance.mongoDatabase();
    MongoCollection<Dia> mongoCollection;

    public DiaDao() {
        mongoCollection = mongoDatabase.getCollection("dias", Dia.class);
    }

    public void create(Dia dia) {
        mongoCollection.insertOne(dia);
    }

    public Iterable<Dia> filter(Bson filter) {
        return mongoCollection.find(filter, Dia.class);
    }

    public Planeta findPlaneta(int numero, String nombrePlaneta) {
        return mongoCollection.find(and(eq("numero", numero), eq("planeta.nombre", nombrePlaneta))).first().getPlaneta();
    }

    public Dia read(Integer id) {
        return mongoCollection.find(eq("numero", id), Dia.class).first();
    }
}
