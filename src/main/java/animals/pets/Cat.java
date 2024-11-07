package animals.pets;
import animals.Animal;

public class Cat extends Animal {

    public Cat() {
        super();
    }

    @Override
   public void Say() {
       System.out.println("Мяу");
   }
}
