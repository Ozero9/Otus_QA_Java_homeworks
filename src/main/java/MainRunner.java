import data.Command;
import objects.Animal;
import objects.AnimalForm;
import table.AnimalTable;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;


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
                      Animal animal = AnimalForm.setAnimalClass(scanner); //Создание экземпляра Animal
                    AnimalForm.setValidatedAnimal(scanner,animal); //Заполнение параметров животного: возраст, вес и т.д.
                    animals.add(animal);
                    animalTable.write(animal);
                    break;
                case EDIT:
                    if(animals.size()==0){
                        System.out.println("Нет животных для редактирования");
                        continue;
                    }
                    Animal animalEdit = new Animal();
                    boolean exit=false;
                        while (!exit) {
                            try {
                            System.out.println("Укажите ID животного");
                            animalEdit.setId(Integer.valueOf(scanner.nextInt()));
                            ResultSet rs = animalTable.selectId(animalEdit);
                            if (!rs.next()) {
                                System.out.println("Нет животного с таким ID");
                                continue;
                            }
                        }catch (InputMismatchException e) {
                                System.out.println("Ошибка! Введите корректное целое число");
                                scanner.next();
                                }
                            scanner.nextLine();
                            AnimalForm.setValidatedAnimal(scanner, animalEdit); //Редактирование параметров животного: возраст, вес и т.д.
                            animalTable.edit(animalEdit);
                            exit=true;
                    }
                    break;
                case LIST:
                    System.out.println("Вы ввели команду list \n");
                    for (Animal i:animals){
                        System.out.println(i+"\n");}
                    if (animals.size() == 0) {
                        System.out.println("Вы еще не создали ни одного животного");
                        continue;
                    }
                    ResultSet rs = animalTable.selectall();
                    animalTable.print(rs);
                    System.out.println("Фильтр по типу животного: \n");
                    Animal animalList = AnimalForm.setAnimalClass(scanner);
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