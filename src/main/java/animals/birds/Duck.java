package animals.birds;
import animals.Animal;

public class Duck extends Animal implements Flying {

    public Duck() {
        super();
    }

    //@Override
    public static void Say() {
        System.out.println("Кря");
    }
    public void Fly() {
        System.out.println("Я лечу");
    }

}
