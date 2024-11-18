package factory;
import animal.birds.Duck;
import animal.pets.Cat;
import animal.pets.Dog;
import data.AnimalData;
import objects.Animal;

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
}
