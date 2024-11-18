import javax.xml.transform.Result;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class Main {


    public static void main(String[] args) throws IOException, SQLException {

        //Загрузум конфигурации для бд
        Properties properties = new Properties();
        InputStream  input = ClassLoader.getSystemResourceAsStream("SQLSettings.properties");
        properties.load(input);

        //Создание подключения к бд
        String url = properties.getProperty("url");
        String username = properties.getProperty("username");
        String password = properties .getProperty("password");

        try  (Connection conn = DriverManager.getConnection(url,username,password)){
            //Создание запроса
            Statement  stmt= conn.createStatement();
            String query = "SELECT * FROM animal";

            //Выполнение
            ResultSet rs = stmt.executeQuery(query);

            //Вывод заголовка на экран
            System.out.printf("%-10s %-18s %-12s %-5s %-10s %-4s%n", "Color", "Name", "Weight", "ID", "Type", "Age");
            System.out.println("-----------------------------------------------------------------");

            //Вывод данных по запросу
            while(rs.next()){
                System.out.printf("%-10s %-20s %-10s %-5d %-11s %-15d%n",
                        rs.getString("color"),
                        rs.getString("name"),
                        rs.getString("weight"),
                        rs.getInt("id"),
                        rs.getString("type"),
                        rs.getInt("age"));
            }
            //Закроем ресурсы
            rs.close();
            conn.close();
        }

    }

}

