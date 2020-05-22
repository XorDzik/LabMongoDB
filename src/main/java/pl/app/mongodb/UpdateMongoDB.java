package pl.app.mongodb;

import com.mongodb.client.MongoCollection;
import org.bson.Document;

import java.util.Scanner;

import static com.mongodb.client.model.Filters.*;

public class UpdateMongoDB {
    MongoCollection<Document> updateData(MongoCollection<Document> collection) {
        System.out.println("Podaj id rekordu który chcesz zaktualizować");
        Scanner scanner = new Scanner(System.in);
        String id = scanner.nextLine();

        CreatePoliceMan createPoliceMan = new CreatePoliceMan();
        collection.updateOne(eq("_id", Long.parseLong(id)),
                new Document("$set", createPoliceMan.create(Long.parseLong(id))));

        return collection;
    }
}
