package animals.pets;
import animals.Animal;
public class Dog extends Animal {
    public Dog() {
        super();
    }

    @Override
    public void say() {
        System.out.println("Гав");
    }
}