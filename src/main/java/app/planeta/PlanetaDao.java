package app.planetas;

import app.clima.Clima;
import app.enums.DatabaseEnum;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.ReplaceOptions;
import lib.mongo.ReplaceOptionsEnum;
import org.bson.conversions.Bson;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import static com.mongodb.client.model.Filters.eq;

public class PlanetaDao {
    MongoDatabase mongoDatabase = DatabaseEnum.instance.mongoDatabase();
    MongoCollection<Planeta> mongoCollection;

    public PlanetaDao() {
        mongoCollection = mongoDatabase.getCollection("planeta", Planeta.class);
    }

    public List<Planeta> list() {
        ArrayList<Planeta> resultado = new ArrayList<>();
        FindIterable<Planeta> planetas = mongoCollection.find(Planeta.class);
        planetas.forEach((Consumer<Planeta>) resultado::add);
        return resultado;
    }

    public Iterable<Planeta> filtrar(Bson filtro) {
        return mongoCollection.find(filtro);
    }

    public Iterable<Planeta> find() {
        return mongoCollection.find(Planeta.class);
    }

    public Planeta read(String nombre) {
        return mongoCollection.find(eq("nombre", nombre)).first();
    }

    public void save(Planeta planeta) {
        Bson filtro = eq("nombre", planeta.getNombre());
        ReplaceOptions replaceOptions = ReplaceOptionsEnum.UPSERT.getReplaceOptions();
        mongoCollection.replaceOne(filtro, planeta, replaceOptions);
    }

    public void create(Planeta planeta) {
        validatePlaneta(planeta);
        mongoCollection.insertOne(planeta);
    }

    private void validatePlaneta(Planeta planeta) {
        if (planeta.getNombre() == null) {
            throw new IllegalArgumentException("El nombre no puede estar vacío");
        }
    }
}
