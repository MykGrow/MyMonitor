package mykgrow.plugins.database;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.MongoException;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import mykgrow.domain.entities.GrowingPreset;
import mykgrow.domain.entities.GrowthPeriod;
import mykgrow.domain.repositories.HandleGrowingPresetInterface;
import mykgrow.domain.valueObjects.AirflowCondition;
import mykgrow.domain.valueObjects.HumidityCondition;
import mykgrow.domain.valueObjects.LightCondition;
import mykgrow.domain.valueObjects.TemperatureCondition;
import org.bson.Document;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

public class DatabaseClient implements HandleGrowingPresetInterface {

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

    @Override
    public List<GrowingPreset> loadAllGrowingPresets() {
        try {
            MongoDatabase db = mongoClient.getDatabase(databaseName);
            MongoCollection<Document> presets = db.getCollection(collectionName);

            List<GrowingPreset> growingPresets = new ArrayList<>();
            for (Document doc : presets.find()) {
                GrowingPreset preset = new GrowingPreset();
                preset.setId(doc.getObjectId("_id"));
                preset.setName(doc.getString("name"));
                preset.setGrowthPeriods(new ArrayList<>());
                for (Document growthPeriodDoc : (List<Document>) doc.get("growthPeriods")) {
                    GrowthPeriod growthPeriod = new GrowthPeriod();
                    growthPeriod.setName(growthPeriodDoc.getString("name"));
                    growthPeriod.setDescription(growthPeriodDoc.getString("PeriodDescription"));
                    growthPeriod.setDurationInDays(growthPeriodDoc.getInteger("PeriodDuration"));
                    // AirflowCondition
                    Document airflowConditionDoc = (Document) growthPeriodDoc.get("AirflowCondition");
                    AirflowCondition airflowCondition = new AirflowCondition(airflowConditionDoc.getDouble("AirExchangesPerHour"));
                    growthPeriod.setAirflowCondition(airflowCondition);
                    // HumidityCondition
                    Document humidityConditionDoc = (Document) growthPeriodDoc.get("HumidityCondition");
                    HumidityCondition humidityCondition = new HumidityCondition(humidityConditionDoc.getDouble("LowerThreshold"), humidityConditionDoc.getDouble("UpperThreshold"));
                    growthPeriod.setHumidityCondition(humidityCondition);
                    // LightCondition
                    //Document lightConditionDoc = (Document) growthPeriodDoc.get("LightCondition");
                    //LightCondition lightCondition = new LightCondition(lightConditionDoc.getInteger("LightLevel"), lightConditionDoc.getDate("StartTime"), lightConditionDoc.getDate("EndTime"));
                    // TemeratureCondition
                    Document temperatureConditionDoc = (Document) growthPeriodDoc.get("TemperatureCondition");
                    TemperatureCondition temperatureCondition = new TemperatureCondition(temperatureConditionDoc.getDouble("LowerThreshold"), temperatureConditionDoc.getDouble("UpperThreshold"));
                    growthPeriod.setTemperatureCondition(temperatureCondition);
                    preset.getGrowthPeriods().add(growthPeriod);
                }
                growingPresets.add(preset);
            }
            return growingPresets;
        } catch (MongoException e) {
            System.err.println("MongoDB connection error: " + e.getMessage());
            return null;
        }
    }

    @Override
    public void deleteGrowingPreset(GrowingPreset preset) {
        try {
            MongoDatabase db = mongoClient.getDatabase(databaseName);
            MongoCollection<GrowingPreset> presets = db.getCollection(collectionName, GrowingPreset.class);
            presets.deleteOne(new Document("_id", preset.getId()));
            System.out.println("Preset deleted successfully.");
        } catch (MongoException e) {
            System.err.println("MongoDB connection error: " + e.getMessage());
        }
    }

    public void close() {
        mongoClient.close();
    }


}

