package animals.pets;
import animals.Animal;

public class Cat extends Animal {

    public Cat() {
        super();
    }

    @Override
   public void say() {
       System.out.println("Мяу");
   }
}
