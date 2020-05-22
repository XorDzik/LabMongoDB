package pl.app.mongodb;
import com.mongodb.client.MongoCollection;
import org.bson.Document;

import java.util.Scanner;

import static com.mongodb.client.model.Filters.*;

public class GetMongoDB {

    void findAll(MongoCollection<Document> collection) {
        System.out.println("Wszyscy policjanci w składzie: ");
        for (Document doc : collection.find())
            System.out.println(doc.toJson());
    }

    void findById(MongoCollection<Document> collection) {
        System.out.println("Podaj id policjanta");
        Scanner scanner = new Scanner(System.in);
        String id = scanner.nextLine();

        System.out.println("Element o id = " + id);
        for (Document doc : collection.find(and(eq("_id", Long.parseLong(id))))) {
            System.out.println(doc.toJson());
        }
    }

    void findByDegree(MongoCollection<Document> collection) {
        System.out.println("Podaj stopień policjanta");
        Scanner scanner = new Scanner(System.in);
        String degree = scanner.nextLine();

        for (Document doc : collection.find(or(eq(PoliceMan.DEGREE.toString(), degree)))) {
            System.out.println(doc.toJson());
        }

    }
}
