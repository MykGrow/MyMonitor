package mykgrow.plugins.database;


import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.MongoException;
import com.mongodb.ServerApi;
import com.mongodb.ServerApiVersion;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;
import mykgrow.application.RandomDataGenerator;
import mykgrow.domain.entities.GrowingPreset;
import mykgrow.domain.entities.MushroomSpecies;
import org.bson.Document;

import java.util.Formattable;
import java.util.Lit;

public class MongoClientConnectionExample {
    public static void main(String[] args) {
        // Replace these values with your actual MongoDB connection details
        String databaseName = "MykGrow";
        String collectionName = "Presets";

        // Construct the connection string
        String connectionString = "mongodb+srv://mykgrow:mykgrow@cluster0.ljmudqt.mongodb.net/?retryWrites=true&w=majority&appName=Cluster0";

        // Connect to the MongoDB server
        try (MongoClient mongoClient = MongoClients.create(connectionString)) {
            // Get a handle to the database
            MongoDatabase database = mongoClient.getDatabase(databaseName);

            // Get a handle to the collection
            MongoCollection<Document> collection = database.getCollection(collectionName);

            // Insert dummy data
           List<MushroomSpecies> mushroomSpeciesList = RandomDataGenerator.generateRandomMushroomSpecies(5, 3);
           // add preset of each mushroom species to the collection
            for (MushroomSpecies species : mushroomSpeciesList) {
                Document document = new Document("name", species.getName())
                        .append("description", species.getDescription());
                collection.insertOne(document);
            }
            System.out.println("Dummy data saved successfully.");

        } catch (MongoException e) {
            System.err.println("MongoDB connection error: " + e.getMessage());
        }
    }
}
