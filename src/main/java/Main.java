import animals.Animal;
import data.AnimalData;
import data.Command;
import factory.AnimalFactory;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import static tools.Сhecks.askForAnimalType;

public class Main {

    public static void main(String[] args) {
        ArrayList<Animal> animals = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        Command typevalue = null;
        while (true) {
            System.out.println("Доступные команды add/list/exit");
            String input = scanner.nextLine().trim();
            typevalue = Command.fromString(input);
            if (typevalue == null) {
                System.out.println("Ошибка! Такой команды не существует");
                continue;
            }
            switch (typevalue) {
                case ADD:
                    System.out.println("Вы ввели команду add");
                    AnimalFactory animalFactory = new AnimalFactory();
                    AnimalData animalType = askForAnimalType(scanner);
                    Animal animal = animalFactory.create(animalType);
                    System.out.println("Укажите имя");
                    animal.setName(scanner.nextLine());
                        while (animal.getAge() == null) {
                            System.out.println("Укажите возраст. Возраст может быть в промежутке 1-10 лет");
                            try {
                            animal.setAge(scanner.nextInt());
                            if(animal.getAge() == null) {
                                System.out.println("Ошибка! Возраст должен быть в промежутке 1-10 лет");
                            }
                        } catch (InputMismatchException e) {
                                System.out.println("Ошибка! Введите корректное целое число");
                                scanner.nextLine();
                            }
                    }
                        while (animal.getWeight() == null) {
                            System.out.println("Укажите вес. Вес должен быть больше 0");
                            try {
                                animal.setWeight(scanner.nextInt());
                            if(animal.getWeight() == null) {
                                System.out.println("Ошибка! Вес должен быть больше 0");
                            }
                        }catch (InputMismatchException e) {
                                System.out.println("Ошибка! Введите корректное целое число");
                                scanner.next();
                    }
                    }
                    System.out.println("Укажите цвет");
                    scanner.nextLine();
                    animal.setColor(scanner.nextLine());
                    animals.add(animal);
                    animal.say();
                    break;
                case LIST:
                    System.out.println("Вы ввели команду list \n");
                    for (Animal i:animals){
                    System.out.println(i+"\n");}
                    if (animals.size() == 0) {
                        System.out.println("Вы еще не создали ни одного животного \n");
                    }
                    break;
                case EXIT:
                    System.out.println("Вы ввели команду exit");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Вы ввели несуществующую команду");
            }
        }
    }
}
