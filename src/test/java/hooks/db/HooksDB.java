package hooks.db;

import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import utilities.ConfigReader;
import utilities.DBUtils;

public class HooksDB {

    @BeforeAll
    public void initDB(){
        DBUtils.createConnection();
    }

    @AfterAll
    public void close(){
        DBUtils.destroy();
    }
}
