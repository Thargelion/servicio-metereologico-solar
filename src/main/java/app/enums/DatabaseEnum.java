package app.enums;

import app.config.SettingsEnum;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoDatabase;
import lib.mongo.MongoConnect;

public enum DatabaseEnum {
    instance;
    DatabaseEnum() {
    }
    public MongoDatabase mongoDatabase(){
        MongoConnect mongoConnect = new MongoConnect();
        MongoClient mongoClient = mongoConnect.getMongoClient();
        return mongoClient.getDatabase(SettingsEnum.MONGO_DATABASE.variable);
    }
}
