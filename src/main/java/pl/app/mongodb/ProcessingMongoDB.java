package pl.app.mongodb;

import com.mongodb.client.MongoCollection;
import org.bson.Document;

public class ProcessingMongoDB {

    MongoCollection<Document> sortData(MongoCollection<Document> collection) {
        for (Document doc : collection.find().sort(new Document("_id", Long.parseLong("-1")))) {
            System.out.println(doc.toJson());
        }

        return collection;
    }

}
