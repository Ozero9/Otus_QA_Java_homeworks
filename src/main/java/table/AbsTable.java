package table;

import db.iDBConnect;
import db.mysqlConnect;
import objects.Animal;
import java.sql.ResultSet;
import java.util.List;

public abstract class AbsTable implements iTable{
    protected iDBConnect dbConnector = null;
    private String tableName = "";

    public AbsTable(String tableName) {
        dbConnector = new mysqlConnect();
        this.tableName = tableName;
    }

    @Override
    public void create(List<String> columns) {
        delete();
        dbConnector.execute(String.format("CREATE TABLE %s (%s);", tableName, String.join(",", columns)));
    }

    @Override
    public void delete() {
        dbConnector.execute(String.format("drop table if exists %s;",this.tableName));
    }

    public ResultSet selectall() {
        return dbConnector.executeQuery(String.format("SELECT * FROM %s;",this.tableName));
    }

}
