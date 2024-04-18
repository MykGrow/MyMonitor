package mykgrow.plugins.database;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.MongoException;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import mykgrow.domain.entities.GrowingPreset;
import mykgrow.domain.repositories.SaveGrowingPresetInterface;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

public class DatabaseClient implements SaveGrowingPresetInterface {

    private final String databaseName;
    private final String collectionName;
    private final ConnectionString connectionString;
    private final MongoClient mongoClient;

    public DatabaseClient(String databaseName, String collectionName, String connectionString) {
        this.databaseName = databaseName;
        this.collectionName = collectionName;
        this.connectionString = new ConnectionString(connectionString);

        // Setup
        CodecRegistry pojoCodecRegistry = fromProviders(PojoCodecProvider.builder().automatic(true).build());
        CodecRegistry codecRegistry = fromRegistries(MongoClientSettings.getDefaultCodecRegistry(), pojoCodecRegistry);
        MongoClientSettings clientSettings = MongoClientSettings.builder()
                .applyConnectionString(this.connectionString)
                .codecRegistry(codecRegistry)
                .build();
        this.mongoClient = MongoClients.create(clientSettings);
    }

    @Override
    public void saveGrowingPreset(GrowingPreset preset) {
        try {
            MongoDatabase db = mongoClient.getDatabase(databaseName);
            MongoCollection<GrowingPreset> presets = db.getCollection(collectionName, GrowingPreset.class);
            presets.insertOne(preset);
            System.out.println("Dummy data saved successfully.");
        } catch (MongoException e) {
            System.err.println("MongoDB connection error: " + e.getMessage());
        }
    }

    public void close() {
        mongoClient.close();
    }
}

