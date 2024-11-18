package objects;

import data.AnimalData;
import factory.AnimalFactory;
import java.util.InputMismatchException;
import java.util.Scanner;
import static java.lang.String.valueOf;
import static tools.Сhecks.askForAnimalType;

public class AnimalForm extends Animal {


    public static Animal setAnimalClass(Scanner scanner) {
        AnimalFactory animalFactory = new AnimalFactory(); //Создание экземпляра Animal
        AnimalData animalType = askForAnimalType(scanner); //Проверка типа животного
        Animal animal = animalFactory.create(animalType);
        animal.setType(valueOf(animalType)); //Установка типа животного для экземпляра Animal
        return animal;
    }

    public static void setValidatedAnimal(Scanner scanner, Animal animal) {
        System.out.println("Укажите имя");
        animal.setName(scanner.nextLine());
        try {
            while (animal.getAge() == null) {
                System.out.println("Укажите возраст. Возраст может быть в промежутке 0-10 лет");
                animal.setAge(scanner.nextInt());
                if (animal.getAge() == null) {
                    System.out.println("Ошибка! Возраст должен быть в промежутке 0-10 лет");
                }
            }
        } catch (
                InputMismatchException e) {
            System.out.println("Ошибка! Введите корректное целое число");
            scanner.nextLine();
        }
        try {
            while (animal.getWeight() == null) {
                System.out.println("Укажите вес. Вес должен быть больше 0");
                animal.setWeight(scanner.nextInt());
                if (animal.getWeight() == null) {
                    System.out.println("Ошибка! Вес должен быть больше 0");
                }
            }
        } catch (InputMismatchException e) {
            System.out.println("Ошибка! Введите корректное целое число");
            scanner.next();
        }
        scanner.nextLine();
        System.out.println("Укажите цвет");
        animal.setColor(scanner.nextLine());
    }
}
