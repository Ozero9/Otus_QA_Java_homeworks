package db;

import java.sql.ResultSet;

public interface iDBConnect {
    void execute(String sqlRequest);
    ResultSet executeQuery(String sqlRequest);
}
