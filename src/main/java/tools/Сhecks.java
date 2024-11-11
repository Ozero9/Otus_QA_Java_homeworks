package tools;
import animals.Animal;
import data.AnimalData;
import java.util.Scanner;

public class Сhecks extends Animal {
    public static AnimalData askForAnimalType(Scanner scanner) { //Обработка типов животных
        String input = null;
        AnimalData animalData = null;
        while (animalData == null) {
            System.out.println("Введите тип животного (duck/dog/cat):");
            input = scanner.nextLine();
            animalData = AnimalData.fromString(input);
            if (animalData == null) {
                System.out.println("Такого животного не существует, попробуйте еще раз.");
            }
        }
        return AnimalData.fromString(input);
    }
}
