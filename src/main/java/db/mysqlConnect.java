package db;

import settings.Settings;

import java.sql.*;
import java.util.Map;

public class mysqlConnect implements iDBConnect {
    private static Connection connection = null;
    private static Statement statement = null;

    private void open() {
        Settings confReader = new Settings();
        Map<String, String> confData = confReader.getSettings();
        try {
            if (connection == null) {
                connection = DriverManager.getConnection(
                        String.format("%s/%s", confData.get("url"), confData.get("name")),
                        confData.get("username"),
                        confData.get("password"));
            }
            if (statement == null) {
                statement = connection.createStatement();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private void close() {
        try {
            if(connection != null){
                connection.close();
                connection=null;
            }
            if(statement !=null) {
                statement.close();
                statement=null;

            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void execute(String sqlRequest) {
        this.open();
        try {
            statement.execute(sqlRequest);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public ResultSet executeQuery(String sqlRequest) {
        this.open();
        try {
            return statement.executeQuery(sqlRequest);
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }
}
