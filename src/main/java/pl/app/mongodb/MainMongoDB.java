package pl.app.mongodb;
import static com.mongodb.client.model.Filters.and;
import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Filters.exists;
import static com.mongodb.client.model.Filters.or;
import static com.mongodb.client.model.Projections.include;

import java.util.Scanner;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class MainMongoDB {
	public static void main(String[] args) {

		String user = "student01";
		String password = "student01";
		String host = "localhost";
		int port = 27017;
		String database = "database01";

		String clientURI = "mongodb://" + user + ":" + password + "@" + host + ":" + port + "/" + database;
		MongoClientURI uri = new MongoClientURI(clientURI);

		MongoClient mongoClient = new MongoClient(uri);
		MongoDatabase db = mongoClient.getDatabase(database);
		db.getCollection("policy").drop();

		MongoCollection<Document> collection = db.getCollection("policy");

		AddMongoDB addMongoDB = new AddMongoDB();
		UpdateMongoDB updateMongoDB = new UpdateMongoDB();
		DeleteMongoDB deleteMongoDB = new DeleteMongoDB();
		GetMongoDB getMongoDB = new GetMongoDB();
		ProcessingMongoDB processingMongoDB = new ProcessingMongoDB();

		System.out.println("Aplikacja ma za zadanie pokazać działanie składu MongoDB");
		System.out.println("Temat: Policja");

		for (;;) {
			System.out.println("1 -> Dodaj policjanta");
			System.out.println("2 -> Zaktualizuj informacje o policjancie");
			System.out.println("3 -> Usuń policjanta po id");
			System.out.println("4 -> Znajdź wszystkich policjantów");
			System.out.println("5 -> Znajdź policjantów po id");
			System.out.println("6 -> Znajdź policjantów danego stopnia");
			System.out.println("7 -> Posortuj policjantów po id malejąco");
			System.out.println("8 -> Zakończ program");

			Scanner scanner = new Scanner(System.in);
			String choice = scanner.nextLine();

			if (choice.equals("1"))
				collection = addMongoDB.addData(collection);

			if (choice.equals("2"))
				collection = updateMongoDB.updateData(collection);

			if (choice.equals("3"))
				collection = deleteMongoDB.deleteDataById(collection);

			if (choice.equals("4"))
				getMongoDB.findAll(collection);

			if (choice.equals("5"))
				getMongoDB.findById(collection);

			if (choice.equals("6"))
				getMongoDB.findByDegree(collection);

			if (choice.equals("7"))
				collection = processingMongoDB.sortData(collection);

			if (choice.equals("8"))
				break;
		}

		mongoClient.close();
	}
}