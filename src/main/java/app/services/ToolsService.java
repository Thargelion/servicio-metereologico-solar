package app.services;

import app.enums.CrudServiceEnum;
import app.enums.DatabaseEnum;
import app.planeta.PlanetaService;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class ToolsService {

    MongoDatabase mongoDatabase = DatabaseEnum.instance.mongoDatabase();
    PlanetaService planetaService = (PlanetaService)CrudServiceEnum.PLANETA_SERVICE.getCrudService();

    public void resetAll() {
        MongoCollection dias = mongoDatabase.getCollection("dias");
        MongoCollection climas = mongoDatabase.getCollection("climas");
        dias.drop();
        climas.drop();
        planetaService.resetPlanets();
    }

    public void drop(MongoCollection collection) {
        collection.drop();
    }
}
