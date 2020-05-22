package pl.app.mongodb;

import com.mongodb.client.MongoCollection;
import org.bson.Document;

import java.util.Scanner;

import static com.mongodb.client.model.Filters.eq;

public class DeleteMongoDB {

    MongoCollection<Document> deleteDataById(MongoCollection<Document> collection) {
        System.out.println("Podaj id rekordu który chcesz usunąć");
        Scanner scanner = new Scanner(System.in);
        String id = scanner.nextLine();

        collection.deleteOne(eq("_id", Long.parseLong(id)));
        return collection;
    }
}
