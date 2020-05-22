package pl.app.mongodb;

import org.bson.Document;
import java.util.Scanner;

public class CreatePoliceMan {

    Document create(Long id) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Podaj nazwisko policjanta");
        String surname = scanner.nextLine();

        System.out.println("Podaj imię policjanta");
        String name = scanner.nextLine();

        System.out.println("Podaj wiek policjanta");
        String age = scanner.nextLine();

        System.out.println("Podaj stopień policjanta");
        String degree = scanner.nextLine();

        return new Document("_id", id)
                .append(PoliceMan.SURNAME.toString(), surname)
                .append(PoliceMan.NAME.toString(), name)
                .append(PoliceMan.AGE.toString(), Integer.parseInt(age))
                .append(PoliceMan.DEGREE.toString(), degree);
    }
}
