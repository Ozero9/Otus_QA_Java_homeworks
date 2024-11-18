package animals;


import data.AnimalData;
import factory.AnimalFactory;

import java.util.Scanner;

public abstract class Animal {
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

            if (age >= 1 && age <= 10) {
                this.age = age;
            } else {
                this.age = null;
            }
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        if (weight > 0) {
            this.weight = weight;
        } else {
            this.weight = null;
        }
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void say() {
        System.out.println("Я говорю");
    }

    public void go () {
        System.out.println("Я иду");
    }
    public void drink () {
        System.out.println("Я пью");
    }
    public void eat () {
        System.out.println("Я ем");
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
        return "Привет! меня зовут "+name+", мне "+age+" "+typeYear()+", я вешу - "+weight+" кг, мой цвет - "+color;
    }

        }

