package objects;

public class Animal implements ObjectDB {
    private String type,name,color;
    private Integer id,weight,age;

    public Animal(Integer id, String name, String color, Integer weight, Integer age){
        this.id = id;
        this.color = color;
        this.name = name;
        this.weight = weight;
        this.age = age;
    }

    public Animal(String name, String color, Integer weight, Integer age, String type) {
        this.color = color;
        this.name = name;
        this.weight = weight;
        this.type = type;
        this.age = age;
    }

    public Animal(String type) {
        this.type = type;
    }



    public String getType(){
        return type;
    }

    public Integer getId() {
        return id;
    }

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
        if (age >= 0 && age <= 10) {
            this.age = age;
        } else {
            this.age = Integer.parseInt(null);
        }
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        if (weight > 0) {
            this.weight = weight;
        } else {
            this.weight = Integer.parseInt(null);
        }
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setId(Integer id) {
        if (id >= 0) {
            this.id = id;
        } else {
            this.id = null;
        }
    }

    public String typeYear() {
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
        return "Привет! меня зовут "+name+", мой тип "+type+ " мне "+age+" "+typeYear()+", я вешу - "+weight+" кг, мой цвет - "+color;
    }

    public Animal() {
        this.id = id;
        this.name = name;
        this.color = color;
        this.weight = weight;
        this.age = age;
    }

    public Animal(String type, String name, String color, Integer weight, Integer age) {
        this.type = type;
        this.name = name;
        this.color = color;
        this.weight = weight;
        this.age = age;
    }

}

