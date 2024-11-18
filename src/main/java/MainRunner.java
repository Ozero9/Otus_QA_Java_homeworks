import data.AnimalData;
import data.Command;
import factory.AnimalFactory;
import objects.Animal;
import table.AnimalTable;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import static java.lang.String.valueOf;
import static tools.Сhecks.askForAnimalType;

public class MainRunner {

    public static void main(String[] args) throws IOException, SQLException {
        ArrayList<Animal> animals = new ArrayList<>();
        AnimalTable animalTable = new AnimalTable();
        List<String> columnsAnimalTable = new ArrayList<>();
        columnsAnimalTable.add("id INT AUTO_INCREMENT PRIMARY KEY");
        columnsAnimalTable.add("color VARCHAR(20)");
        columnsAnimalTable.add("name VARCHAR(20)");
        columnsAnimalTable.add("weight INT");
        columnsAnimalTable.add("type VARCHAR(20)");
        columnsAnimalTable.add("age INT");
        animalTable.create(columnsAnimalTable);
        Scanner scanner = new Scanner(System.in);
        Command typevalue = null;
        while (true) {
            System.out.println("Доступные команды add/edit/list/exit");
            String input = scanner.nextLine().trim();
            typevalue = Command.fromString(input);
            if (typevalue == null) {
                System.out.println("Ошибка! Такой команды не существует");
                continue;
            }
            switch (typevalue) {
                case ADD:
                    System.out.println("Вы ввели команду add");
                    AnimalFactory animalFactory = new AnimalFactory(); //Создание экземпляра Animal
                    AnimalData animalType = askForAnimalType(scanner); //Проверка типа животного
                    Animal animal = animalFactory.create(animalType);
                    animal.setType(valueOf(animalType)); //Установка типа животного для экземпляра Animal
                    System.out.println("Укажите имя");
                    animal.setName(scanner.nextLine());
                    try {
                        while (animal.getAge() == null) {
                            System.out.println("Укажите возраст. Возраст может быть в промежутке 0-10 лет");
                            animal.setAge(scanner.nextInt());
                            if(animal.getAge() == null) {
                                System.out.println("Ошибка! Возраст должен быть в промежутке 0-10 лет");
                            }
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("Ошибка! Введите корректное целое число");
                        scanner.nextLine();
                        continue;
                    }
                    try {
                        while (animal.getWeight() == null) {
                            System.out.println("Укажите вес. Вес должен быть больше 0");
                            animal.setWeight(scanner.nextInt());
                            if(animal.getWeight() == null) {
                                System.out.println("Ошибка! Вес должен быть больше 0");
                            }
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("Ошибка! Введите корректное целое число");
                        scanner.next();
                    }
                    scanner.nextLine();
                    System.out.println("Укажите цвет");
                    animal.setColor(scanner.nextLine());
                    animals.add(animal);
                    animalTable.write(animal);
                    break;
                case EDIT:
                    if(animals.size()==0){
                        System.out.println("Нет животных для редактирвоания");
                        continue;
                    }
                    Animal animalEdit = new Animal();
                        while (animalEdit.getId() == null) {
                            try {
                            System.out.println("Укажите ID животного");
                            animalEdit.setId(Integer.valueOf(scanner.nextInt()));
                            if (valueOf(animalEdit.getId()) == null) {
                                System.out.println("Нет животного с таким ID");
                                continue;
                            }
                        }catch (InputMismatchException e) {
                                System.out.println("Ошибка! Введите корректное целое число");
                                scanner.nextLine();
                                continue;}
                            ////Блок редактирвоания параметров
                            scanner.nextLine();
                            System.out.println("Укажите имя");
                            animalEdit.setName(scanner.nextLine());
                            System.out.println(animalEdit.getName());
                            try {
                                while (animalEdit.getAge() == null) {
                                    System.out.println("Укажите возраст. Возраст может быть в промежутке 0-10 лет");
                                    animalEdit.setAge(scanner.nextInt());
                                    if(animalEdit.getAge() == null) {
                                        System.out.println("Ошибка! Возраст должен быть в промежутке 0-10 лет");
                                    }
                                }
                            } catch (InputMismatchException e) {
                                System.out.println("Ошибка! Введите корректное целое число");
                                scanner.nextLine();
                                continue;
                            }
                            try {
                                while (animalEdit.getWeight() == null) {
                                    System.out.println("Укажите вес. Вес должен быть больше 0");
                                    animalEdit.setWeight(scanner.nextInt());
                                    if(animalEdit.getWeight() == null) {
                                        System.out.println("Ошибка! Вес должен быть больше 0");
                                    }
                                }
                            } catch (InputMismatchException e) {
                                System.out.println("Ошибка! Введите корректное целое число");
                                scanner.next();
                            }
                            scanner.nextLine();
                            System.out.println("Укажите цвет");
                            animalEdit.setColor(scanner.nextLine());
                            animalTable.edit(animalEdit);
                            ///Конец блока редактирвоаняи параметров
                    }
                    break;
                case LIST:
                    System.out.println("Вы ввели команду list");
                    System.out.println(animals);
                    if (animals.size() == 0) {
                        System.out.println("Вы еще не создали ни одного животного");
                    }
                    ResultSet rs = animalTable.selectall();
                    animalTable.print(rs);
                    System.out.println("Фильтр по типу животного:");
                    AnimalData listAnimalType = askForAnimalType(scanner);
                    AnimalFactory listAnimalFactory = new AnimalFactory();
                    Animal animalList = listAnimalFactory.create(listAnimalType);
                    animalList.setType(valueOf(listAnimalType));
                    System.out.println(animalList.getType());
                    rs = animalTable.selectFilter(animalList);
                    animalTable.print(rs);
                    break;
                case EXIT:
                    System.out.println("Вы ввели команду exit");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Вы ввели несуществующую команду");
            }
        }
    }
}