
import animals.PetsApp;
import animals.data.AnimalData;
import animals.data.Command;
import animals.factory.AnimalFactory;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ArrayList<AnimalFactory> animals = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;
        while (!exit) {
            System.out.println("Доступные команды add/list/exit");
            String input = scanner.nextLine();
            Command typevalue = Command.fromString(input);
            if (typevalue == null) {
                System.out.println("Вы не ввели комманду");
                exit = true;

            }
            switch (typevalue) {
                case ADD:
                    System.out.println("Вы ввели команду add");
                    System.out.println("Доступные животные cat/dog/duck");
                    AnimalFactory animalFactory = new AnimalFactory();
                    PetsApp.typePets();
                    animals.add(animalFactory);
                    animalFactory.Say();
                    break;
                case LIST:
                    System.out.println("Вы ввели команду list");
                    System.out.println(animals);
                    break;
                case EXIT:
                    exit = true;
                    System.out.println("Вы ввели команду exit");
                    break;
                default:
                    System.out.println("Вы ввели несуществующую команду");
            }
        }
        scanner.close();
    }

}
