import java.util.Scanner;

public class PetsApp {
    public static void typePets() {
        System.out.println("Доступные животные cat/dog/duck");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Pets typevalue = Pets.fromString(input);

        switch (typevalue) {
            case CAT:
                System.out.println("Вы выбрали cat");
                Cat.Say();
                break;
            case DOG:
                System.out.println("Вы выбрали Dog");
                Dog.Say();
                break;
            case DUCK:
                System.out.println("Вы выбрали Duck");
                Duck.Say();
                break;
            default:
                System.out.println("Вы ввели несуществующую команду");
        }

        Animal animal = new Animal();
        System.out.println("Укажите имя");
        animal.setName(scanner.nextLine());
        System.out.println("Укажите возраст. Возраст может быть не больше 10");
        animal.setAge(scanner.nextInt());
        System.out.println("Укажите вес");
        animal.setWeight(scanner.nextInt());
        System.out.println("Укажите цвет");
        animal.setColor(scanner.next());
        Animal.animals.add(animal);
    }

}