package app.enums;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoDatabase;
import lib.MongoConnect;

public enum DatabaseEnum {
    instance;
    private DatabaseEnum() {

    }
    public MongoDatabase mongoDatabase(){
        MongoConnect mongoConnect = new MongoConnect();
        MongoClient mongoClient = mongoConnect.getMongoClient();
        return mongoClient.getDatabase("vulcano"); // Todo Parametrizar
    }
}
