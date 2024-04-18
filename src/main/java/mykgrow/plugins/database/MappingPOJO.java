package mykgrow.plugins.database;


import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.MongoException;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.FindOneAndReplaceOptions;
import com.mongodb.client.model.ReturnDocument;
import mykgrow.application.RandomDataGenerator;
import mykgrow.domain.entities.GrowingPreset;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
import org.bson.conversions.Bson;

import java.util.ArrayList;
import java.util.List;

import static com.mongodb.client.model.Filters.eq;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

public class MappingPOJO {

    public static void main(String[] args) {

        String databaseName = "MykGrow";
        String collectionName = "Presets";
        String conString = "mongodb+srv://mykgrow:mykgrow@cluster0.ljmudqt.mongodb.net/?retryWrites=true&w=majority&appName=Cluster0";
        ConnectionString connectionString = new ConnectionString(conString);

        // Settings
        CodecRegistry pojoCodecRegistry = fromProviders(PojoCodecProvider.builder().automatic(true).build());
        CodecRegistry codecRegistry = fromRegistries(MongoClientSettings.getDefaultCodecRegistry(), pojoCodecRegistry);
        MongoClientSettings clientSettings = MongoClientSettings.builder()
                .applyConnectionString(connectionString)
                .codecRegistry(codecRegistry)
                .build();

        try (MongoClient mongoClient = MongoClients.create(clientSettings)) {
            MongoDatabase db = mongoClient.getDatabase(databaseName);
            MongoCollection<GrowingPreset> presets = db.getCollection(collectionName, GrowingPreset.class);

            RandomDataGenerator.generateRandomMushroomSpecies(5, 3).forEach(species -> {
                GrowingPreset preset = species.getRecommendedConditions();
                presets.insertOne(preset);
            });
            System.out.println("Dummy data saved successfully.");
        } catch (MongoException e) {
            System.err.println("MongoDB connection error: " + e.getMessage());
        }
    }
}
