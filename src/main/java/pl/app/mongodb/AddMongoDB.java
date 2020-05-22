package pl.app.mongodb;

import com.mongodb.client.MongoCollection;
import org.bson.Document;

import java.util.Random;


class AddMongoDB {
    final private static Random r = new Random(System.currentTimeMillis());

    MongoCollection<Document> addData(MongoCollection<Document> collection) {
        Long id = (long) Math.abs(r.nextInt());

        CreatePoliceMan createPoliceMan = new CreatePoliceMan();
        collection.insertOne(createPoliceMan.create(id));
        return collection;
    }
}
