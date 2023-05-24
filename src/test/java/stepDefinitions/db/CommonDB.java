package stepDefinitions.db;

import io.cucumber.java.en.Given;
import org.junit.Assert;
import utilities.DBUtils;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CommonDB {

    ResultSet resultSet;
    @Given("Establishes connection with database")
    public void establishes_connection_with_database() {

        String query="SELECT t1.driver_name\n" +
                "FROM (\n" +
                "    SELECT id, driver_name, \n" +
                "\t\tROW_NUMBER() OVER (ORDER BY manufacture_year ASC) AS rn\n" +
                "    FROM heallife_hospitaltraining.vehicles\n" +
                ") AS t1\n" +
                "JOIN (\n" +
                "    SELECT id, ROW_NUMBER() OVER (ORDER BY created_at ASC) AS rn\n" +
                "    FROM heallife_hospitaltraining.vehicles\n" +
                ") AS t2 ON t1.id = t2.id AND t1.rn = t2.rn;";
        try {
           resultSet= DBUtils.getStatement().executeQuery(query);
            resultSet.absolute(0);
            Assert.assertEquals("team108",resultSet.toString());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
}
