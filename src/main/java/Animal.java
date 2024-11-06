import java.util.ArrayList;

public class Animal {
    private String name;
    private Integer age;
    private Integer weight;
    private String color;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        if(age >= 0&&age <= 10) {
            this.age = age;
        } else {
            System.out.println("Ошибка! Возраст не может быть отрицательным числом или больше 10!");
        }
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        if (weight >= 0) {
            this.weight = weight;
        } else {
            System.out.println("Ошибка! Вес не может быть отрицательным числом!");
        }
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public static void Say() {
        System.out.println("Я говорю");
    }

    public void Go () {
        System.out.println("Я иду");
    }
    public void Drink () {
        System.out.println("Я пью");
    }
    public void Eat () {
        System.out.println("Я ем");
    }

    public String TypeYear() {
        if (age < 2) {
            return "год";
        } else {
            if (age < 5) {
                return "года";
            } else {
                return "лет";
            }
        }

    }

    @Override
    public String toString() {
        return "Привет! меня зовут "+name+", мне "+age+" "+TypeYear()+", я вешу - "+weight+" кг, мой цвет - "+color;
    }

    static ArrayList<Animal> animals = new ArrayList<Animal>();

}
