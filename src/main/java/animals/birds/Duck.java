package animals.birds;
import animals.Animal;

public class Duck extends Animal implements Flying {

    public Duck() {
        super();
    }

    @Override
    public void say() {
        System.out.println("Кря");
    }
    public void fly() {
        System.out.println("Я лечу");
    }

}
