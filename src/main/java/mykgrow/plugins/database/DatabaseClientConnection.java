package mykgrow.plugins.database;

import com.mongodb.MongoException;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import mykgrow.domain.entities.GrowingPreset;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

public class DatabaseClientConnection {
    private String connectionString;
    private String databaseName;
    private String collectionName;

    public DatabaseClientConnection(String connectionString, String databaseName, String collectionName) {
        this.connectionString = connectionString;
        this.databaseName = databaseName;
        this.collectionName = collectionName;
    }

    public void savePreset(GrowingPreset preset) {
        // Save the preset object to MongoDB
        //datastore.save(preset);
    }

    public List<GrowingPreset> getAllGrowingPresets() {
        List<GrowingPreset> presetList = new ArrayList<>();
        try (MongoClient mongoClient = MongoClients.create(connectionString)) {
            MongoDatabase database = mongoClient.getDatabase(databaseName);
            MongoCollection<Document> collection = database.getCollection(collectionName);

            for (Document doc : collection.find()) {
                //GrowingPreset preset = new GrowingPreset();
                // Populate the GrowingPreset object from the retrieved document
                //presetList.add(preset);
            }
        } catch (MongoException e) {
            System.err.println("MongoDB connection error: " + e.getMessage());
        }
        return presetList;
    }
}

