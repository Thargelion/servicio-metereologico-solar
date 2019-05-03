package lib;

import app.config.SettingsEnum;
import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

public class MongoConnect {

    private MongoClient mongoClient;

    public MongoConnect() {
        CodecRegistry pojoCodecRegistry = fromRegistries(
                MongoClientSettings.getDefaultCodecRegistry(),
                fromProviders(PojoCodecProvider.builder().automatic(true).build())
        );
        ConnectionString connectionString = new ConnectionString(
                String.format("mongodb+srv://%s:%s@%s/test?retryWrites=true",
                        SettingsEnum.MONGO_USER.variable,
                        SettingsEnum.MONGO_PASSWORD.variable,
                        SettingsEnum.MONGO_SRV.variable
                )
        );
        MongoClientSettings mongoClientSettings = MongoClientSettings.builder()
                .applyConnectionString(connectionString)
                .codecRegistry(pojoCodecRegistry)
                .build();
        mongoClient = MongoClients.create(mongoClientSettings);
    }

    public MongoClient getMongoClient() {
        return mongoClient;
    }
}
