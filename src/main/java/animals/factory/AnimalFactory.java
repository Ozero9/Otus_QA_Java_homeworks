package animals.factory;
import animals.Animal;
import animals.birds.Duck;
import animals.data.AnimalData;
import animals.pets.Cat;
import animals.pets.Dog;
import java.util.Scanner;

public class AnimalFactory extends Animal {

    public Animal create(AnimalData animalData) {

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        AnimalData typevalue = AnimalData.fromString(input);

        switch(typevalue){
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
}
