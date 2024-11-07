import animals.Animal;
import animals.data.AnimalData;
import animals.data.Command;
import animals.factory.AnimalFactory;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ArrayList<Animal> animals = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;
        while (!exit) {
            System.out.println("Доступные команды add/list/exit");
            String input = scanner.nextLine().trim();
            Command typevalue = Command.fromString(input);
            if (typevalue == null) {
                System.out.println("Вы не ввели комманду");
                continue;

            }
            switch (typevalue) {
                case ADD:
                    System.out.println("Вы ввели команду add");
                    AnimalFactory animalFactory = new AnimalFactory();
                    AnimalData animalType = animalFactory.askForAnimalType(scanner);
                    if (animalType == null) {
                        System.out.println("Ошибка! Неверный тип животного. Пожалуйста, выберите duck, dog или cat.");
                        continue;}
                    Animal animal = animalFactory.create(animalType);
                    System.out.println("Укажите имя");
                    animal.setName(scanner.nextLine());
                    System.out.println("Укажите возраст. Возраст может быть в промежутке 0-10 лет");
                    try {
                    animal.setAge(scanner.nextInt());
                    } catch (InputMismatchException e) {
                        System.out.println("Ошибка! Введите корректное целое число");
                        scanner.next();
                    }
                    if (animal.getAge() == null) {
                        System.out.println("Ошибка! Возраст должен быть в промежутке 0-10 лет");
                        continue;
                    }
                        System.out.println("Укажите вес");
                    try {
                    animal.setWeight(scanner.nextInt());
                    } catch (InputMismatchException e) {
                        System.out.println("Ошибка! Введите корректное целое число");
                        scanner.next();
                    }
                    scanner.nextLine();
                    if (animal.getWeight() == null) {
                        System.out.println("Ошибка! Вес должен быть больше 0");
                        continue;
                    }
                    System.out.println("Укажите цвет");
                    animal.setColor(scanner.nextLine());
                    animal.Say();
                    animals.add(animal);
                    break;
                case LIST:
                    System.out.println("Вы ввели команду list");
                    System.out.println(animals);
                    if (animals.size()==0) {
                        System.out.println("Вы еще не создали ни одного животного");
                    }
                    break;
                case EXIT:
                    System.out.println("Вы ввели команду exit");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Вы ввели несуществующую команду");
            }
        }
        scanner.close();
    }

}
