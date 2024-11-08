package animals.factory;
import animals.Animal;
import animals.birds.Duck;
import animals.data.AnimalData;
import animals.pets.Cat;
import animals.pets.Dog;
import java.util.Scanner;

public class AnimalFactory {

    public Animal create(AnimalData animalData) {

        switch(animalData){
            case DUCK: {
                System.out.println("Вы выбрали Duck");
                return new Duck();
            }
            case DOG:{
                System.out.println("Вы выбрали Dog");
                return new Dog();
            }
            case CAT:{
                System.out.println("Вы выбрали Cat");
                return new Cat();
            }
        }
        return null;
    }

    public AnimalData askForAnimalType(Scanner scanner) {
        System.out.println("Введите тип животного (duck/dog/cat):");
        String input = scanner.nextLine();
        return AnimalData.fromString(input);
    }
}
