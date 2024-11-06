import java.util.Scanner;

public class CommandApp {
    public static void typeCommand() {
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
                    PetsApp.typePets();
                    break;
                case LIST:
                    System.out.println("Вы ввели команду list");
                    System.out.println(Animal.animals.toString());
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
